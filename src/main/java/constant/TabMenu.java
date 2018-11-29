package constant;

public enum TabMenu {
	LOGIN ("Login"),
	LOGOUT ("Log out"),
	REGISTER ("Register"),
	CHANGE_PASSWORD ("Change password"),
	MY_TICKET ("My ticket"),
	BOOK_TICKET ("Book ticket"),
	;
	
	private String tab;
	
	private TabMenu(String tab) {
		// TODO Auto-generated constructor stub
		this.tab = tab;
	}
	
    public String getValue() {
        return tab;
    }
    public static void main(String[] args) {

		//whois.arin.net
        System.out.println(TabMenu.LOGIN.getValue());
        System.out.println("\n" + TabMenu.REGISTER.getValue());
    }
}