package com.dao;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

import com.bean.OrderDetailBean;
import com.util.JDBCConnectionOrcale;

public class OrderDao {
	public static ArrayList<OrderDetailBean> getAllOrders() {
		ArrayList<OrderDetailBean> list = new ArrayList<OrderDetailBean>();
		try (Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con
						.prepareStatement("select os.orderid,os.userid,address,paymenttype,orderdetailed.productid,productname,productdescription,price,amount,orderdetailed.qty,orderdate,deliverystatus,deliverydate from orderdetails os join orderdetailed on orderdetailed.productid = os.orderid join productdetails on productdetails.productid=orderdetailed.productid");
				ResultSet set = psmt.executeQuery();) {
			while (set.next()) {
				OrderDetailBean order = new OrderDetailBean();
				order.setOrderID(set.getInt("orderid"));
				order.setUserID(set.getInt("userid"));
				order.setAddress(set.getString("address"));
				order.setPaymentType(set.getInt("paymenttype"));
				order.setFinalAmount(set.getFloat("finalamount"));
				order.setTotalAmount(set.getFloat("totalamount"));
				order.setDiscountAmount(set.getFloat("discountamount"));
				order.setOrderDate(set.getString("orderdate").substring(0, 10));
				order.setDeliveryDate(set.getString("deliveryDate").substring(0, 10));
				order.setDeliveryStatus(set.getInt("deliverystatus"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Get all orders Method");
		}
		return list;
	}
	public static int getCurrentValue() {
		int currentValue=-1;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select orderid from orderDetails order by orderid desc fetch first 1 rows only");
			ResultSet set = psmt.executeQuery();){
			while(set.next()) {
				currentValue = set.getInt("orderid");
			}
			if(currentValue==-1) {
				currentValue=0;
			}
		}catch(Exception e) {
			System.out.println("In get current value of orderDetails");
			e.printStackTrace();
		}
		return currentValue;
	}

	public static int insertRecord(OrderDetailBean orderDetail) {
		int flag = 0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("insert into orderDetails(orderid,userid,address,paymenttype,finalamount,totalamount,discountamount,orderdate,deliverydate,deliverystatus) values(?,?,?,?,?,?,?,sysdate,sysdate+7,?)");
				){
			psmt.setInt(1, orderDetail.getOrderID());
			psmt.setInt(2, orderDetail.getUserID());
			psmt.setString(3, orderDetail.getAddress());
			psmt.setInt(4, orderDetail.getPaymentType());
			psmt.setFloat(5, orderDetail.getFinalAmount());
			psmt.setFloat(6,orderDetail.getTotalAmount());
			psmt.setFloat(7, orderDetail.getDiscountAmount());
			psmt.setInt(8,orderDetail.getDeliveryStatus());
			int count = psmt.executeUpdate();
			if(count==1) {
				flag=1;
			}
		}
		catch(SQLException e) {
			if(e.getErrorCode()==29000) {
				flag=-1;
			}
			e.printStackTrace();
			System.out.println("In insert record of orderdetail bean");
		}
		return flag;
		
	}
	public static void removeOrder(int orderID) {
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("delete from orderdetails where orderid=?");){	
			psmt.setInt(1, orderID);
			psmt.executeUpdate();}
			
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void updateRecord(float finalAmountForOrder, float finalAmount, float discountAmount, int orderID) {
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("update orderdetails set finalamount = ?, totalamount = ?, discountamount = ? where orderid=?");){	
			psmt.setFloat(1, finalAmountForOrder);
			psmt.setFloat(2, finalAmount);
			psmt.setFloat(3, discountAmount);
			psmt.setInt(4, orderID);
				psmt.executeUpdate();}
				
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	public static float totalSavingDoneByWebSite() {
		float saving=0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				CallableStatement csmt = con.prepareCall("{? = call totalSavingDoneByWebSite}");){
			 csmt.registerOutParameter(1, Types.FLOAT);
			csmt.execute();
			saving = csmt.getFloat(1);
		}
		catch(SQLException e) {
			System.out.println("In total Saving Done by website");
		}
		return saving;
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
			e.printStackTrace();
			System.out.println("In total Saving Done by user");
		}
		
		return saving;
	}
	
	public static void main(String[] args) {
		System.out.println(totalSavingDoneByUser(1));
	}
	public static float[] orderReport() {
		BigDecimal[] order= new BigDecimal[8];
		float[] orderReport = new float[8];
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			){
			CallableStatement csmt = con.prepareCall("begin ?:= orderReportFunction(); end;");
			csmt.registerOutParameter(1, Types.ARRAY,"ORDERREPORT");
			csmt.executeQuery();
			
			Array array = (Array) csmt.getArray(1);
			order = (BigDecimal[])array.getArray();
			for(int i =0;i<orderReport.length;i++) {
				orderReport[i]=order[i].floatValue();
			}
		}catch(SQLException e) {
			if(e.getErrorCode()==1403) {
				orderReport[7]=-2;
			}

		}
		return orderReport;
	}
	
	public static HashMap<String,Object> getOrderReport(){
		HashMap<String,Object> report = new HashMap<String,Object>();
		float[] orderReport = orderReport();
		if(orderReport[7]!=-2) {
			report.put("thisMonthSale",orderReport[0]);
			report.put("thisMonthDiscount", orderReport[1]);
			report.put("totalSale", orderReport[2]);
			report.put("totalDiscount", orderReport[3]);
			report.put("topBuyer", UserDao.getUserByID((int)orderReport[4]));
			report.put("LeastBuyer", UserDao.getUserByID((int)orderReport[5]));
			report.put("topBuyerOfMonth", UserDao.getUserByIDForCurrentMonth((int)orderReport[6]));
			report.put("leastBuyerOfMonth", UserDao.getUserByIDForCurrentMonth((int)orderReport[7]));
		}
		else {
			report.put("Error", true);
		}
		return report;
	}
	
}
