package myPackageServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import myPackageDb.MyDB;
import myPackageUsers.User;
import myPackageUtil.Utils;

public class LoginManagerv2 extends MyDB {
	
	public boolean login(String strUser, String strPassword) {
		boolean result=false;
		String SQL="SELECT * FROM users WHERE loginName =? AND  loginPassword =?";
		User user = null;
		try {
			Connection conn = new MyDB().connect();
			PreparedStatement pstat = conn.prepareStatement(SQL);
			pstat.setString(1, strUser);
			pstat.setString(2, strPassword);
			ResultSet rs = pstat.executeQuery();			
			while(rs.next()) {
				user = new User(rs.getInt("uid"), rs.getString("fullname"), rs.getString("phone"), rs.getString("email"), rs.getString("loginName"), rs.getString("loginPassword"), rs.getString("userRole"));
				//System.out.println(rs.getInt("uid")+", "+rs.getString("fullname")+", "+rs.getString("phone")+", "+rs.getString("email")+", "+rs.getString("loginName")+", "+rs.getString("loginPassword")+", "+rs.getString("userRole"));
				return true;
			}
			rs.close();
			conn.close();	
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return result;
	}
	
	public User search(int uid) {
		String SQL="SELECT * FROM users WHERE uid="+uid+"";
		User user = null;
		try {
			Connection conn = new MyDB().connect();
			PreparedStatement pstat = conn.prepareStatement(SQL);
			ResultSet rs = pstat.executeQuery();			
			while(rs.next()) {
				user = new User(rs.getInt("uid"), rs.getString("fullname"), rs.getString("phone"), rs.getString("email"), rs.getString("loginName"), rs.getString("loginPassword"), rs.getString("userRole"));
				System.out.println(rs.getInt("uid")+", "+rs.getString("fullname")+", "+rs.getString("phone")+", "+rs.getString("email")+", "+rs.getString("loginName")+", "+rs.getString("loginPassword")+", "+rs.getString("userRole"));
			}
			conn.close();
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return user;
	}
	
	public List<User> search(String strSearch) {
		String SQL="SELECT * FROM users WHERE fullname='"+strSearch+"' OR email='"+strSearch+"' OR phone='"+strSearch+"' OR loginName='"+strSearch+"' OR loginPassword='"+strSearch+"' OR userRole='"+strSearch+"'";
		boolean result = new Utils().isNumeric(strSearch);
		if(result) {
			SQL="SELECT * FROM users WHERE uid="+strSearch;
		}
		List<User> users = null;
		try {
			Connection conn = new MyDB().connect();
			PreparedStatement pstat = conn.prepareStatement(SQL);
			ResultSet rs = pstat.executeQuery();
			users = new ArrayList<User>();
			
			while(rs.next()) {
				User user = new User(rs.getInt("uid"), rs.getString("fullname"), rs.getString("phone"), rs.getString("email"), rs.getString("loginName"), rs.getString("loginPassword"), rs.getString("userRole"));
				users.add(user);
				System.out.println(rs.getInt("uid")+", "+rs.getString("fullName")+", "+rs.getString("phone")+", "+rs.getString("email")+", "+rs.getString("loginName")+", "+rs.getString("loginPassword")+", "+rs.getString("userRole"));
			}
			conn.close();
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return users;
	}
	
	public boolean save( String fullname, String email, String phone, String loginName, String loginPassword, String userRole) {
	    boolean result = false;  
	    String SQL = "INSERT INTO users VALUES(?, ?, ?, ?, ?, ?, ?);";
	    try {
			Connection conn = new MyDB().connect();
	        PreparedStatement pstat = conn.prepareStatement(SQL);
	        pstat.setInt(1, 0);
	        pstat.setString(2, fullname);
	        pstat.setString(3, email);
	        pstat.setString(4, phone);
	        pstat.setString(5, loginName);
	        pstat.setString(6, loginPassword);
	        pstat.setString(7, userRole);
	        pstat.executeUpdate(); //Insert, update, delete
	        pstat.close();
	        conn.close();
	        System.out.println("Record inserted successfully");
	        result = true;
	    } catch(Exception ex) {
	        System.out.println("Error: " + ex.getMessage());
	        result = false;
	    }
	    return result;
	}
	
	public boolean update(int uid, String fullname, String email, String phone, String loginName, String loginPassword, String userRole) {
	    boolean result = false;   
	    String SQL = "UPDATE users SET fullname=?, email=?, phone=?, loginName=?, loginPassword=?, userRole=? WHERE uid=?"; // corrected SQL statement	    
	    try {
			Connection conn = new MyDB().connect();
	        PreparedStatement pstat = conn.prepareStatement(SQL);        
	        pstat.setString(1, fullname);
	        pstat.setString(2, email);
	        pstat.setString(3, phone);
	        pstat.setString(4, loginName);
	        pstat.setString(5, loginPassword);
	        pstat.setString(6, userRole);
	        pstat.setInt(7, uid);
	        
	        int rowsUpdated = pstat.executeUpdate(); // Insert, update, delete
	        if (rowsUpdated > 0) {
	            System.out.println("Record updated successfully");
	            result = true;
	        } else {
	            System.out.println("Failed to update record");
	            result = false;
	        }
	        
	        pstat.close();
	        conn.close();
	    } catch (Exception ex) {
	        System.out.println("Error: " + ex.getMessage());
	        result = false;
	    }
	    
	    return result;
	}
	
		public boolean delete(int uid) {
			boolean result=false;
			String SQL="delete from users WHERE uid=?;";
			try{
				
				Connection conn = new MyDB().connect();
				PreparedStatement pstat = conn.prepareStatement(SQL);
				pstat.setInt(1, uid);
				pstat.executeUpdate(); //Insert, update, delete
				pstat.close();
				System.out.println("Record delete successfully");
				result=true;
			}
			catch(Exception ex) {
				System.out.println("Error1 : "+ex.getMessage());
				result=false;
			}
			return result;
		}
	}