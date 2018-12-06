package constant;

import java.util.Date;


public class TicketInfo {
	private Date departDate;
	private String departStation;
	private String arriveStation;
	private String seatType;
	private int amount;
	
	public TicketInfo(Date departDate, String departStation, String arriveStation, String seatType, int amount) {
		this.departDate = departDate;
		this.departStation = departStation;
		this.arriveStation = arriveStation;
		this.seatType = seatType;
		this.amount = amount;
	}

	public Date getDepartDate() {
		return departDate;
	}
	
	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}
	
	public String getDepartStation() {
		return departStation;
	}
	
	public void setDepartStation(String departStation) {
		this.departStation = departStation;
	}
	
	public String getArriveStation() {
		return arriveStation;
	}
	
	public void setArriveStation(String arriveStation) {
		this.arriveStation = arriveStation;
	}
	
	public String getSeatType() {
		return seatType;
	}
	
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}




