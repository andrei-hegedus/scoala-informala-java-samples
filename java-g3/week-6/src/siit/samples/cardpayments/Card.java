package siit.samples.cardpayments;

import java.util.Date;

public class Card {
	
	private String iban;
	private Date expirationDate;

	public Card(String iban, Date expirationDate) {
		this.iban = iban;
		this.expirationDate = expirationDate;
	}
	
	public String getIban() {
		return iban;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public boolean isValid(){
		return expirationDate.compareTo(new Date()) > 0;
	}

}
