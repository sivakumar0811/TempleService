package com.tutasi.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.tutasi.Model.SponsorData;
import com.tutasi.Model.SponsorTransactions;
import com.tutasi.dto.AddingAmount;
import com.tutasi.dto.Sponsor;
import com.tutasi.exception.SponsorNotFoundException;
import com.tutasi.repository.SponsorRepository;
import com.tutasi.repository.SponsorTransactionsRepository;

@Service
public class Sponsordataservice {
	
	 private static final Logger logger = LoggerFactory.getLogger(Sponsordataservice.class);
	 
	@Autowired
	SponsorRepository sponsorRepository;
	
	@Autowired
	SponsorTransactionsRepository sponsorTransactionsRepository;

	@Async
	public SponsorData addSponsorData(SponsorData sponsorData) {
		logger.info("Data Successfully Added :: " +sponsorData);
		return sponsorRepository.save(sponsorData);
	}

	public SponsorData getsponsordetails(String name) {
		SponsorData spr = sponsorRepository.findBySponsorName(name);
		return spr;
	}

	public SponsorData admoney(AddingAmount addmoney) {
		SponsorData sponsorData = getsponsordetails(addmoney.getSponsorName());
		Integer sponsorData1 = sponsorData.getGivenAmount();// 0
		Integer sponsorData2 = sponsorData.getPendingAmount();// 5000
		Integer amounttoadd = addmoney.getGivenAmount();

		if (amounttoadd <= 0) {
			throw new IllegalArgumentException("Amount to add must be positive");
		}

		int updatedGiven = sponsorData1 + amounttoadd;
		int updatedPending = sponsorData2 - amounttoadd;

		if (updatedPending < 0) {
			throw new IllegalStateException("Amount exceeds pending amount");
		}

		sponsorData.setGivenAmount(updatedGiven);
		sponsorData.setPendingAmount(updatedPending);

		SponsorData sd = sponsorRepository.save(sponsorData);
		SponsorTransactions st = new SponsorTransactions();
		st.setSponsorId(sponsorData.getSponsorId());
		st.setSponsoredAmount(addmoney.getGivenAmount());
		st.setTransactiontime(LocalDateTime.now());
		sponsorTransactionsRepository.save(st);
		return sd;

	}

	public List<SponsorData> getAllSponsors() {
		return sponsorRepository.findAll();
	}

	public String addSponsorData1(Sponsor sponsorData) {
		SponsorData spd = new SponsorData();
		spd.setSponsorName(sponsorData.getSponsoredName());
		spd.setGivenAmount(sponsorData.getGivenAmounttoVillage());
		spd.setSponsoredAmount(sponsorData.getSponsoredAmount());
		spd.setPendingAmount(sponsorData.getSponsoredAmount()-sponsorData.getGivenAmounttoVillage());
		addSponsorData(spd);
		return "SUCCESS";
	}
	
	public void validateUser(String userName) {
		SponsorData useData = sponsorRepository.findBySponsorName(userName);
		if (useData == null) {
			throw new SponsorNotFoundException("Sponsor '" + userName + "' not found");
		}
	}
}
