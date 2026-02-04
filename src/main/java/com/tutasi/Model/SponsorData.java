package com.tutasi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SponsorData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sponsorId;
	private String sponsorName;
	private Integer sponsoredAmount;
	private Integer givenAmount;
	private Integer pendingAmount;
	
	public Integer getPendingAmount() {
		return pendingAmount;
	}
	public void setPendingAmount(Integer pendingAmount) {
		this.pendingAmount = pendingAmount;
	}
	public Integer getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}
	public String getSponsorName() {
		return sponsorName;
	}
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}
	public Integer getSponsoredAmount() {
		return sponsoredAmount;
	}
	public void setSponsoredAmount(Integer sponsoredAmount) {
		this.sponsoredAmount = sponsoredAmount;
	}
	public Integer getGivenAmount() {
		return givenAmount;
	}
	public void setGivenAmount(Integer givenAmount) {
		this.givenAmount = givenAmount;
	}
	
	@Override
	public String toString() {
		return "SponsorData [sponsorId=" + sponsorId + ", sponsorName=" + sponsorName + ", sponsoredAmount="
				+ sponsoredAmount + ", givenAmount=" + givenAmount + ", pendingAmount=" + pendingAmount + "]";
	}
	

}
