package Locators;

public class INDIANARMY_Locators {
	
	static String enterwebsitebtn  =  "//div/input[@id='btnSubmit']";
	static String loginlink        =  "//a[contains(text(),'Officers Entry')]";
	static String username         =  "//input[@id='ContentPlaceHolder1_UserLogin1_txtUserName']";
	static String password         =  "//input[@id='ContentPlaceHolder1_UserLogin1_txtPassword']";
	static String loginbtn         =  "(//input[@title='Login'])[1]";
	static String updatebtn        =  "//input[@id='ContentPlaceHolder1_UserProfile1_btnEdit']";
	
	public static String enterWebsiteBtn() {
		System.out.println("Entered in Locators");
		return enterwebsitebtn;
	}
	
	public static String loginLink() {
		return loginlink;
	}
	
	public static String userName() {
		return username;
	}
	
	public static String passWord() {
		return password;
	}
	
	public static String loginBtn() {
		return loginbtn;
	}
	
	public static String updateBtn() {
		return updatebtn;
	}

}
