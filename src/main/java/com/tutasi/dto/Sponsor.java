package com.tutasi.dto;

public class Sponsor {
	
	private String sponsoredName;
	public String getSponsoredName() {
		return sponsoredName;
	}
	public void setSponsoredName(String sponsoredName) {
		this.sponsoredName = sponsoredName;
	}
	public Integer getSponsoredAmount() {
		return sponsoredAmount;
	}
	public void setSponsoredAmount(Integer sponsoredAmount) {
		this.sponsoredAmount = sponsoredAmount;
	}
	public Integer getGivenAmounttoVillage() {
		return givenAmounttoVillage;
	}
	public void setGivenAmounttoVillage(Integer givenAmounttoVillage) {
		this.givenAmounttoVillage = givenAmounttoVillage;
	}
	private Integer sponsoredAmount;
	private Integer givenAmounttoVillage;
	

}
