package constant;

public enum DepartStation {
	SAI_GON ("Sài Gòn"),
	PHAN_THIET ("Phan Thiết"),
	NHA_TRANG ("Nha Trang"),
	DA_NANG ("Đà Nẵng"),
	HUE ("Huế"),
	QUANG_NGAI ("Quảng Ngãi")
	;
	
	private String departStation;
	
	private DepartStation (String departStation) {
		this.departStation = departStation;
	}
	
    public String getValue() {
        return departStation;
	}    
}