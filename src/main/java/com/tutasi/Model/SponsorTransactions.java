package com.tutasi.Model;



import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SponsorTransactions {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
	private Integer sponsorId;
	private Integer sponsoredAmount;
	private LocalDateTime transactiontime;

	
	public Integer getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}
	public Integer getSponsoredAmount() {
		return sponsoredAmount;
	}
	public void setSponsoredAmount(Integer sponsoredAmount) {
		this.sponsoredAmount = sponsoredAmount;
	}
	public LocalDateTime getTransactiontime() {
		return transactiontime;
	}
	public void setTransactiontime(LocalDateTime transactiontime) {
		this.transactiontime = transactiontime;
	}

}
