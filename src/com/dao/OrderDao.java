package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				order.setQuantity(set.getInt("quantity"));
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
	public static void main(String[] args) {
		ArrayList<OrderDetailBean> list = getAllOrders();
		for(OrderDetailBean l : list) {
			System.out.println(l.getOrderID());
		}
	}
}
