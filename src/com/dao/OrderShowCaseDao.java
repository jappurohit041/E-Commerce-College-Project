package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.OrderShowCaseBean;
import com.util.JDBCConnectionOrcale;

public class OrderShowCaseDao {
public static ArrayList<OrderShowCaseBean> getAllOrderDetail(){
	ArrayList<OrderShowCaseBean> list = new ArrayList<OrderShowCaseBean>();
	try(Connection con = JDBCConnectionOrcale.connectionMethod();
		PreparedStatement psmt = con.prepareStatement("select os.orderid,orderdetailed.ORIGINALPRICE,os.userid,address,paymenttype,orderdetailed.productid,productname,productdescription,price,amount,orderdetailed.qty,orderdate,deliverystatus,deliverydate from orderdetails os join orderdetailed on orderdetailed.orderid = os.orderid join productdetails on productdetails.productid=orderdetailed.productid order by orderdate desc");
		ResultSet set = psmt.executeQuery();
			){
		while(set.next()) {
			OrderShowCaseBean order = new OrderShowCaseBean();
			order.setOrderID(set.getInt("orderid"));
			order.setUserID(set.getInt("userid"));
			order.setAddress(set.getString("address"));
			order.setPaymentType(set.getInt("paymenttype"));
			order.setProductID(set.getInt("productid"));
			order.setProductName(set.getString("productname"));
			order.setProductDescription(set.getString("productdescription"));
			order.setPrice(set.getFloat("price"));
			order.setAmount(set.getFloat("amount"));
			order.setQuantity(set.getInt("qty"));
			order.setOrderDate(set.getString("orderdate").substring(0,10));
			order.setDeliveryStatus(set.getInt("deliverystatus"));
			order.setDeliveryDate(set.getString("deliverydate").substring(0,10));
			order.setOrignalPrice(set.getFloat("ORIGINALPRICE"));
			
			list.add(order);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("In get All order detail");
	}
	return list;
}
public static ArrayList<OrderShowCaseBean> getAllOrderDetailByUserID(int userID){
	ArrayList<OrderShowCaseBean> list = new ArrayList<OrderShowCaseBean>();
	try(Connection con = JDBCConnectionOrcale.connectionMethod();
		PreparedStatement psmt = con.prepareStatement("select os.orderid,orderdetailed.ORIGINALPRICE,imagepath,os.userid,address,paymenttype,orderdetailed.productid,productname,productdescription,price,amount,orderdetailed.qty,orderdate,deliverystatus,deliverydate from orderdetails os join orderdetailed on orderdetailed.orderid = os.orderid join productdetails on productdetails.productid=orderdetailed.productid where os.userid = ? order by orderdate desc");
			){
		psmt.setInt(1, userID);
		ResultSet set = psmt.executeQuery();
		while(set.next()) {
			OrderShowCaseBean order = new OrderShowCaseBean();
			order.setOrderID(set.getInt("orderid"));
			order.setUserID(set.getInt("userid"));
			order.setAddress(set.getString("address"));
			order.setPaymentType(set.getInt("paymenttype"));
			order.setProductID(set.getInt("productid"));
			order.setProductName(set.getString("productname"));
			order.setProductDescription(set.getString("productdescription"));
			order.setPrice(set.getFloat("price"));
			order.setAmount(set.getFloat("amount"));
			order.setQuantity(set.getInt("qty"));
			order.setImagePath(set.getString("imagePath"));
			order.setOrderDate(set.getString("orderdate").substring(0,10));
			order.setDeliveryStatus(set.getInt("deliverystatus"));
			order.setDeliveryDate(set.getString("deliverydate").substring(0,10));
			order.setOrignalPrice(set.getFloat("ORIGINALPRICE"));
			
			list.add(order);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("In get All order detail");
	}
	return list;
}
}
