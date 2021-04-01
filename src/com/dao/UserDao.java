package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.UserDetailBean;
import com.util.JDBCConnectionOrcale;

public class UserDao {

	public static int insertUser(UserDetailBean user) {
		int flag= 0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("insert into userDetails(firstname,lastname,emailid,password,address,userid,dateofbirth,city,state,pincode,country,contactnumber,roleid,isblock,securityquestion,securityanswer) values(?,?,?,?,?,?,to_date(?,'yyyymmdd'),?,?,?,?,?,?,?,?,?)");
				){
			psmt.setString(1, user.getFirstName());
			psmt.setString(2, user.getLastName());
			psmt.setString(3, user.getEmailID());
			psmt.setString(4, user.getPassWord());
			psmt.setString(5, user.getAddress());
			psmt.setInt(6, user.getUserID());
			psmt.setString(7, user.getDateOfBirth());
			psmt.setString(8, user.getCity());
			psmt.setString(9, user.getState());
			psmt.setString(10, user.getPinCode());
			psmt.setString(11, user.getCountry());
			psmt.setLong(12, user.getPhoneNumber());
			psmt.setInt(13, user.getRoleID());
			psmt.setInt(14, user.getIsBlock());
			psmt.setString(15, user.getSecurityQuestion());
			psmt.setString(16,user.getSecurityAnswer());
			int count = psmt.executeUpdate();
			if(count==1) {
				flag = 1;
			}
		}
		catch(SQLException e) {
			if(e.getErrorCode() == 20000) {
				flag = -1;
			}
			System.out.println("In insert user");
		}
		return flag;
	}
	public static int getCurrentValue() {
		int currentValue=0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select userid from userDetails order by userid desc fetch first 1 rows only");
			ResultSet set = psmt.executeQuery();){
			while(set.next()) {
				currentValue = set.getInt("userid");			
			}
		}catch(Exception e) {
			System.out.println("In get current value of user Detail");
			e.printStackTrace();
		}
		return currentValue;
	}
	
	public static ArrayList<UserDetailBean> getAllUser() {
		ArrayList<UserDetailBean> list = new ArrayList<UserDetailBean>();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("select * from userDetails order by userid");
				ResultSet set = psmt.executeQuery();
				){
			while(set.next()) {
				UserDetailBean user = new UserDetailBean();
				user.setFirstName(set.getString("firstname"));
				user.setLastName(set.getString("lastname"));
				user.setEmailID(set.getString("emailid"));
				user.setPassWord(set.getString("password"));
				user.setAddress(set.getString("address"));
				user.setUserID(set.getInt("userid"));
				user.setDateOfBirth(set.getString("dateofbirth").substring(0, 10));
				user.setCity(set.getString("city"));
				user.setState(set.getString("state"));
				user.setPinCode(set.getString("pincode"));
				user.setCountry(set.getString("country"));
				user.setPhoneNumber(set.getLong("contactnumber"));
				user.setRoleID(set.getInt("roleid"));
				user.setIsBlock(set.getInt("isblock"));
				user.setSecurityQuestion(set.getString("securityquestion"));
				user.setSecurityAnswer(set.getString("securityanswer"));
				list.add(user);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("In get all user display");
		}
		return list;
	}
	public static UserDetailBean getUserByID(int userID) {
		UserDetailBean user = new UserDetailBean();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("select * from userDetails where userid=? ");
				)
		{
			psmt.setInt(1, userID);
			ResultSet set = psmt.executeQuery();
			while(set.next()) {
				user.setFirstName(set.getString("firstname"));
				user.setLastName(set.getString("lastname"));
				user.setEmailID(set.getString("emailid"));
				user.setPassWord(set.getString("password"));
				user.setAddress(set.getString("address"));
				user.setUserID(set.getInt("userid"));
				user.setDateOfBirth(set.getString("dateofbirth").substring(0, 10));
				user.setCity(set.getString("city"));
				user.setState(set.getString("state"));
				user.setPinCode(set.getString("pincode"));
				user.setCountry(set.getString("country"));
				user.setPhoneNumber(set.getLong("contactnumber"));
				user.setRoleID(set.getInt("roleid"));
				user.setIsBlock(set.getInt("isblock"));
				user.setSecurityQuestion(set.getString("securityquestion"));
				user.setSecurityAnswer(set.getString("securityanswer"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("In get User By ID");
		}
		return user;
	}
	public static boolean deleteUser(int userID) {
		boolean flag=false;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("delete from userDetails where userid=? ");
				)
		{
			psmt.setInt(1, userID);
			int count = psmt.executeUpdate();
			if(count==1) {
				flag =true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("In get User By ID");
		}
		return flag;
	}
	public static boolean updateUserAdmin(UserDetailBean user) {
		boolean flag = false;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("update userDetails set roleid=?, isblock=? where userid=?")){
			psmt.setInt(1, user.getRoleID());
			psmt.setInt(2, user.getIsBlock());
			psmt.setInt(3, user.getUserID());
			int count = psmt.executeUpdate();
			if(count==1) {
				flag= true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("In update user admin");
		}
		return flag;
	}
	public static int getUserIDByEmailAndPassword(String email, String password) {
		int flag =-1;
		UserDetailBean user = new UserDetailBean();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select userid,emailid,password from userdetails");	
			ResultSet set = psmt.executeQuery()
				){
			while(set.next()) {
				user.setEmailID(set.getString("emailid"));
				user.setPassWord(set.getString("password"));
				if(user.getEmailID().equals(email) && user.getPassWord().equals(password)) {
					flag = set.getInt("userid");
					break;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("In getUserIDByEmailAndPassword");
		}
		return flag;
	}
	
}
