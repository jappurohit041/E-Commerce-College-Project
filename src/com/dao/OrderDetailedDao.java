package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.OrderDetailedBean;
import com.util.JDBCConnectionOrcale;

public class OrderDetailedDao {

	public static int insertRecord(OrderDetailedBean order) {
		int flag =0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("insert into orderdetailed (orderid,userid,productid,price,qty,amount) values(?,?,?,?,?,?)");){
			psmt.setInt(1, order.getOrderID());
			psmt.setInt(2, order.getUserID());
			psmt.setInt(3, order.getProductID());
			psmt.setFloat(4, order.getPrice());
			psmt.setInt(5, order.getQuntity());
			psmt.setFloat(6, order.getTotalAmount());
			int count = psmt.executeUpdate();
			if(count==1) {
				flag=1;
			}
		}
		catch(SQLException e) {
			if(e.getErrorCode()==20001) {
				flag=-1;
			}
			e.printStackTrace();
			System.out.println("In orderdetaileddao");
		}
		return flag;
	}
//
}
