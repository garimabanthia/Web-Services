package com.npu.hotelBooking.domain;

public class CardInfo {
	
	private int cardNumber;
	private boolean cardType;
	private String expiryMonth;
	private String expiryYear;
	private int ccv;
	
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public boolean isCardType() {
		return cardType;
	}
	public void setCardType(boolean cardType) {
		this.cardType = cardType;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public int getCcv() {
		return ccv;
	}
	public void setCcv(int ccv) {
		this.ccv = ccv;
	}
	
}
