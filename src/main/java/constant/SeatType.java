package constant;

public enum SeatType {
	HARD_SEAT ("Hard seat"),
	SOFT_SEAT ("Soft seat"),
	SOFT_SEAT_AIR_CONDITIONER ("Soft seat with air conditioner"),
	HARD_BED ("Hard bed"),
	SOFT_BED ("Soft bed"),
	SOFT_BED_AIR_CONDITIONER  ("Soft bed with air conditioner")
	;
	
	private String seatType;
	
	private SeatType (String seatType) {
		this.seatType = seatType;
	}
	
    public String getValue() {
        return seatType;
	} 
}
