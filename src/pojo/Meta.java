package pojo;

public class Meta {
	
	private String sender;
	private String sender_id_expiry;
	private String sender_id_number;
	private String sender_date_of_birth;
	private String sender_id_type;
	private String sender_city;
	private String beneficiary_address;
	private String beneficiary_id_number;
	private Boolean is_cash_pickup;
	private String transfer_purpose;
	private String routecode;
	
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSender_id_expiry() {
		return sender_id_expiry;
	}
	public void setSender_id_expiry(String sender_id_expiry) {
		this.sender_id_expiry = sender_id_expiry;
	}
	public String getSender_id_number() {
		return sender_id_number;
	}
	public void setSender_id_number(String sender_id_number) {
		this.sender_id_number = sender_id_number;
	}
	public String getSender_date_of_birth() {
		return sender_date_of_birth;
	}
	public void setSender_date_of_birth(String sender_date_of_birth) {
		this.sender_date_of_birth = sender_date_of_birth;
	}
	public String getSender_id_type() {
		return sender_id_type;
	}
	public void setSender_id_type(String sender_id_type) {
		this.sender_id_type = sender_id_type;
	}
	
	
	public String getSender_city() {
		return sender_id_type;
	}
	public void setSender_city(String sender_city) {
		this.sender_city = sender_city;
	}
	
	public String getBeneficiary_address() {
		return beneficiary_address;
	}
	public void setBeneficiary_address(String beneficiary_address) {
		this.beneficiary_address = beneficiary_address;
	}
	public String getBeneficiary_id_number() {
		return beneficiary_id_number;
	}
	public void setBeneficiary_id_number(String beneficiary_id_number) {
		this.beneficiary_id_number = beneficiary_id_number;
	}
	public Boolean getIs_cash_pickup() {
		return is_cash_pickup;
	}
	public void setIs_cash_pickup(Boolean is_cash_pickup) {
		this.is_cash_pickup = is_cash_pickup;
	}
	public String getTransfer_purpose() {
		return transfer_purpose;
	}
	public void setTransfer_purpose(String transfer_purpose) {
		this.transfer_purpose = transfer_purpose;
	}
	public String getRoutecode() {
		return routecode;
	}
	public void setRoutecode(String routecode) {
		this.routecode = routecode;
	}

}
