package pojo;

import java.util.List;

public class F4B {
	
	private String account_number;
	private String account_bank;
	private String narration;
	private int    amount;
	private String reference;
	private String currency;
	private String beneficiary_name;
	private List<Meta>   meta;
	
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getAccount_bank() {
		return account_bank;
	}
	public void setAccount_bank(String account_bank) {
		this.account_bank = account_bank;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getBeneficiary_name() {
		return beneficiary_name;
	}
	public void setBeneficiary_name(String beneficiary_name) {
		this.beneficiary_name = beneficiary_name;
	}
	public List<Meta> getMeta() {
		return meta;
	}
	public void setMeta(List<Meta> meta) {
		this.meta = meta;
	}

}
