package myPackageDb;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyDB {
	private String DRIVER = "com.mysql.cj.jdbc.Driver";
	private String HOST="localhost";
	private int PORT =3306;
	private String DBNAME="dbLoginSys1";
	private String USER="root";
	private String PASSWORD="9828807288";
	String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME;	
	
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);//Loading Driver
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connect with database successfully");
		} catch (Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return conn;
	}
}