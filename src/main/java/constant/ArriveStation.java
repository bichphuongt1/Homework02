package constant;

public enum ArriveStation {
	PHAN_THIET ("Phan Thiết"),
	NHA_TRANG ("Nha Trang"),
	DA_NANG ("Đà Nẵng"),
	HUE ("Huế"),
	QUANG_NGAI ("Quảng Ngãi"),
	SAI_GON ("Sài Gòn")
	;
	
	private String arriveStation;
	
	private ArriveStation (String arriveStation) {
		this.arriveStation = arriveStation;
	}
	
    public String getValue() {
        return arriveStation;
	}    
}