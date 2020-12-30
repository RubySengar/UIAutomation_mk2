package Locators;

public class IRCTC_Locators {
	
	static String loginlink 		= "LOGIN";
	static String username  		= "//input[@id='userId']";
	static String password 			= "//div/input[@id='pwd']";
	static String signinbtn         = "//button[contains(text(),'SIGN IN')]";
	
	public static String loginlink() {
		System.out.println("Entered in Locators");
		return loginlink;
	}
	
	public static String userName() {
		return username;
	}
	
	public static String passWord() {
		return password;
	}
	
	public static String signInBtn() {
		return signinbtn;
	}

}

