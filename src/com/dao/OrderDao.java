package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.OrderDetailBean;
import com.util.JDBCConnectionOrcale;

public class OrderDao {
	public static ArrayList<OrderDetailBean> getAllOrders() {
		ArrayList<OrderDetailBean> list = new ArrayList<OrderDetailBean>();
		try (Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con
						.prepareStatement("select * from orderDetails order by orderdate");
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
	public static void main(String[] args) {
		System.out.println(getCurrentValue());
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
}
