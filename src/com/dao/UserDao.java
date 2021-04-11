package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

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
			System.out.println(e.getErrorCode());
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
	
	public static float getDiscountByUser(int userID) {
		float discountAmount=0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select sum(discountamount) from userdetails join orderdetails on orderdetails.userid=userdetails.userid where userdetails.userid = ?");
			){
			psmt.setInt(1,userID);
			ResultSet set = psmt.executeQuery();
			
			while(set.next()) {
				discountAmount = set.getFloat("sum(discountamount)");			
			}
		}catch(Exception e) {
			System.out.println("In get discount value of user Detail");
			e.printStackTrace();
		}
		return discountAmount;
	}
	public static float getTotalPurchaseOfUser(int userID) {
		float totalPurchase=0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select sum(finalamount) from userdetails join orderdetails on orderdetails.userid=userdetails.userid where userdetails.userid = ?");
			){
			psmt.setInt(1,userID);
			ResultSet set = psmt.executeQuery();
			
			while(set.next()) {
				totalPurchase = set.getFloat("sum(finalamount)");			
			}
		}catch(Exception e) {
			System.out.println("In get discount value of user Detail");
			e.printStackTrace();
		}
		return totalPurchase;
	}
	public static float getDiscountByUserForCurrentMonth(int userID) {
		float discountAmount=0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select sum(discountamount) from userdetails join orderdetails on orderdetails.userid=userdetails.userid where userdetails.userid = ? group by to_char(sysdate,'Month')");
			){
			psmt.setInt(1,userID);
			ResultSet set = psmt.executeQuery();
			
			while(set.next()) {
				discountAmount = set.getFloat("sum(discountamount)");			
			}
		}catch(Exception e) {
			System.out.println("In get discount value of user Detail");
			e.printStackTrace();
		}
		return discountAmount;
	}
	public static float getTotalPurchaseOfUserForCurrentMonth(int userID) {
		float totalPurchase=0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select sum(finalamount) from userdetails join orderdetails on orderdetails.userid=userdetails.userid where userdetails.userid = ? group by to_char(sysdate,'Month')");
			){
			psmt.setInt(1,userID);
			ResultSet set = psmt.executeQuery();
			
			while(set.next()) {
				totalPurchase = set.getFloat("sum(finalamount)");			
			}
		}catch(Exception e) {
			System.out.println("In get discount value of user Detail");
			e.printStackTrace();
		}
		return totalPurchase;
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
				user.setTotalDiscount(getDiscountByUser(user.getUserID()));
				user.setTotalPurchase(getTotalPurchaseOfUser(user.getUserID()));
				
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
				user.setTotalDiscount(getDiscountByUser(user.getUserID()));
				user.setTotalPurchase(getTotalPurchaseOfUser(user.getUserID()));
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("In get User By ID");
		}
		return user;
	}
	public static HashMap<Integer, String> getUserName(){
		HashMap<Integer, String> list = new HashMap<Integer, String>();
			try(Connection con = JDBCConnectionOrcale.connectionMethod();
					PreparedStatement psmt = con.prepareStatement("select concat(firstname,concat(' ',lastname)) name,userid from userdetails");
					ResultSet set = psmt.executeQuery();
					){
				while(set.next()) {
					list.put(set.getInt("userID"), set.getString("name"));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("In get user Name");
			}
		return list;
	}
	
	public static UserDetailBean getUserByIDForCurrentMonth(int userID) {
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
				user.setTotalDiscount(getDiscountByUserForCurrentMonth(user.getUserID()));
				user.setTotalPurchase(getTotalPurchaseOfUserForCurrentMonth(user.getUserID()));
				
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
	public static int updateBasicDetail(UserDetailBean user) {
		int flag= 0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("update userdetails set firstname= ?, lastname=?, emailid=?, dateofbirth=to_date(?,'yyyymmdd'), password=? where userid = ?");
			){
			psmt.setString(1, user.getFirstName());
			psmt.setString(2, user.getLastName());
			psmt.setString(3, user.getEmailID());
			psmt.setString(4, user.getDateOfBirth());
			psmt.setString(5, user.getPassWord());
			psmt.setInt(6, user.getUserID());
			int count = psmt.executeUpdate();
			if(count==1) {
				flag =1;
			}
			
		}
		catch(SQLException e) {
			if(e.getErrorCode()==20100) {
				flag=-1;
			}
			e.printStackTrace();
			System.out.println("In update basic detail");
		}
		return flag;
	}
	public static boolean updateAddressDetail(UserDetailBean user) {
		boolean flag = false;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("update userdetails set address=?,city=?,state=?,pincode=?,country=?,contactnumber=? where userid=?");
				){
			psmt.setString(1, user.getAddress());
			psmt.setString(2, user.getCity());
			psmt.setString(3, user.getState());
			psmt.setString(4, user.getPinCode());
			psmt.setString(5, user.getCountry());
			psmt.setLong(6, user.getPhoneNumber());
			psmt.setInt(7, user.getUserID());
			int count = psmt.executeUpdate();
			if(count==1) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("In Update Address Detail");
		}
		return flag;
	}
	public static boolean updateSecurityDetail(UserDetailBean user) {
		boolean flag = false;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("update userdetails set securityAnswer=?,securityQuestion=? where userid=?");
				){
			psmt.setString(1, user.getSecurityAnswer());
			psmt.setString(2, user.getSecurityQuestion());
			psmt.setInt(3, user.getUserID());
			int count = psmt.executeUpdate();
			if(count==1) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("In Update Security Detail");
		}
		return flag;
	}
	public static int recoverUser(String emailAddress) {
		int flag = 0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("select userid from userdetails where emailid='"+emailAddress+"'");
				ResultSet set = psmt.executeQuery();
				){
			System.out.println("Fetch size: "+set.getFetchSize());

				while(set.next()) {	
					flag = set.getInt("userid");
				}	
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Recover users");
		}
		return flag;
	}
	public static int randomUser() {
		int userID=0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				CallableStatement csmt = con.prepareCall("{? = call randomUser}");){
			 csmt.registerOutParameter(1, Types.INTEGER);
			csmt.execute();
			userID = csmt.getInt(1);
		}
		catch(SQLException e) {
			System.out.println("In generating random users");
		}
		return userID;
	}
	
	public static float totalSavingDoneByUser(int userID) {
		float saving=0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				CallableStatement csmt = con.prepareCall("{? = call totalSavingDoneByUser(?)}");){
			 csmt.registerOutParameter(1, Types.FLOAT);
			 csmt.setInt(2, userID);
			csmt.execute();
			saving = csmt.getFloat(1);
		}
		catch(SQLException e) {
			System.out.println("In total Saving Done by User");
		}
		return saving;
	}
	public static void main(String[] args) {
		System.out.println(totalSavingDoneByUser(1));
	}
}
