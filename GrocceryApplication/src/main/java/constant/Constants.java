package constant;

public class Constants {
	public static final String EXCELFILE = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataFile.xlsx";
	public static final String CONFIGFILE = System.getProperty("user.dir")+ "\\src\\main\\resources\\config.properties";

	public static final String VALIDCREDENTIALSERROR = "user was able to login with invalid credentials";
	public static final String INVALIDUSERNAMEANDVALIDPASSWORD = "user is able to login with invalid username and valid password";
	public static final String VALIDUSERNAMEANDINVALIDPASSWORD = "User is able to login with valid username and invalid password";
	public static final String VALIDCREDENTIALS = "User can login with valid credentials";

	public static final String LOGOUT = " User is able to successfully logout";

	public static final String ABLETOADDNEWUSER = "admin is able to add new user";
	public static final String ABLETOSEARCHTHENEWLYADDEDUSER = " Able To Search The Newly AddedUser";
	public static final String ABLETORESETTHEUSERLIST = "User list is not reset";
	
	public static final String ADDNEWNEWS = "able to create new news";
	public static final String SEARCHNEWNEWS = "able to search new news";
	public static final String RESETTHENEWS = "able to reset the news";

}
