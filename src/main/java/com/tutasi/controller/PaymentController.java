package com.tutasi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutasi.Model.SponsorData;
import com.tutasi.dto.AddingAmount;
import com.tutasi.dto.BalanceAmount;
import com.tutasi.dto.Sponsor;
import com.tutasi.exception.SponsorNotFoundException;
import com.tutasi.repository.SponsorRepository;
import com.tutasi.service.Sponsordataservice;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/ammavarigudi")
@RestController
public class PaymentController {

	@Autowired
	Sponsordataservice sponsordataservice;
	
	@Autowired
	SponsorRepository sponsorRepository;
	
	@Operation(summary = "Contribution to the Village")
	@PostMapping("/addsponsor")
	public String addSponsorAccount(@RequestBody Sponsor sponsorData) {
		return sponsordataservice.addSponsorData1(sponsorData);
	}
	
	@Operation(summary = "Sponsor Details")
	@GetMapping("/sponsordetails")
	public SponsorData sponsordetails(@RequestParam("name") String name) {
		sponsordataservice.validateUser(name);
		return sponsordataservice.getsponsordetails(name);
	}
	
	@Operation(summary = "Balance Amount of Sponsor")
	@GetMapping("/balanceamount")
	public BalanceAmount balanceAmount(@RequestParam("name") String name) {
		sponsordataservice.validateUser(name);
		BalanceAmount balanceamount = new BalanceAmount();
		SponsorData sponsorData = sponsordataservice.getsponsordetails(name);
		Integer balance = sponsorData.getPendingAmount();
		balanceamount.setBalanceAmount(balance);
		return balanceamount;
	}
	
	@Operation(summary = "Contributing Amount By the Sponsor")
	@PutMapping("/contributing")
	public ResponseEntity<SponsorData> addAmount(@RequestBody AddingAmount addMoney) {
		sponsordataservice.validateUser(addMoney.getSponsorName());
		SponsorData	updatedSponsor = sponsordataservice.admoney(addMoney);
		return ResponseEntity.ok(updatedSponsor);
	}
	
	
	@Operation(summary = "Get All Sponsors Details")
	@GetMapping("/getall")
	public List<SponsorData> getAll(){
		return sponsordataservice.getAllSponsors();
	}
}
