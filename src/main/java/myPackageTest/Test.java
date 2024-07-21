package myPackageTest;

import myPackageDb.MyDB;
import myPackageServlet.LoginManager;
import myPackageUtil.Utils;

public class Test {
	public static void main(String[] args) {
		
		new MyDB().connect();

		/*boolean result = new Utils().isNumeric("234");
		System.out.println(result);*/
		
	//	new LoginManager().save("Raj Rai", "", "", "rajrai", "rajrai@123", "user");
	}
}