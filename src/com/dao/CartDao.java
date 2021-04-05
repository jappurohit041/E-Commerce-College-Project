package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.CartDetailBean;
import com.util.JDBCConnectionOrcale;

public class CartDao {
	public static int getCurrentValue() {
		int currentValue=-1;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select cartid from cartDetails order by cartid desc fetch first 1 rows only");
			ResultSet set = psmt.executeQuery();){
			while(set.next()) {
				currentValue = set.getInt("cartID");
			}
			if(currentValue==-1) {
				currentValue=0;
			}
		}catch(Exception e) {
			System.out.println("In get current value of cart Detail");
			e.printStackTrace();
		}
		return currentValue;
	}
	
	public static int insertCart(CartDetailBean cart) {
		int flag = 0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("insert into cartdetails(cartid, userid, productid, price,qty) values(?,?,?,?,?)");
				){
			psmt.setInt(1, cart.getCartID());
			psmt.setInt(2, cart.getUserID());
			psmt.setInt(3, cart.getProductID());
			psmt.setFloat(4, cart.getPrice());
			psmt.setInt(5, cart.getQuantity());
			int row = psmt.executeUpdate();
			if(row==1) {
				flag =1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("In add insert Cart");
		}
		
		return flag;
	}
	public static boolean toCheckIfProductExistOrNot(int productID, int userID) {
		boolean flag =false;
		int count = 0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("select count(*) c from cartDetails where productid = ? and userID = ?");
				){
			psmt.setInt(1, productID);
			psmt.setInt(2, userID);
			ResultSet set = psmt.executeQuery();
			while(set.next()) {
				count  = set.getInt("c");
				System.out.println(count);
			}
			if(count!=0) {
				flag = true; 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("To check if product exist or not");
		}
		return flag;
	}
	public static int getCartIDForParticularUserAndProduct(int productID, int userID) {
		int flag =0;
		int count = 0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("select qty from cartDetails where productid = ? and userID = ?");
				){
			psmt.setInt(1, productID);
			psmt.setInt(2, userID);
			ResultSet set = psmt.executeQuery();
			while(set.next()) {
				count  = set.getInt("qty");
				System.out.println(count);
				flag= count;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("To check if product exist or not");
		}
		return flag;
	}


	public static int updateQuantity(int productID, int userID, float offerPrice) {
		int flag = 0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			Connection con1 = JDBCConnectionOrcale.connectionMethod();	
				PreparedStatement psmt = con.prepareStatement("update cartdetails set qty = qty+1, price = ?*? where userid=? and productid=?");
				){
			psmt.setInt(1, getCartIDForParticularUserAndProduct(productID,userID)+1);
			psmt.setFloat(2, offerPrice);
			psmt.setInt(3,userID);
			psmt.setInt(4, productID);
			int row = psmt.executeUpdate();
			if(row==1) {
				flag =1;
			}
		}
		catch(SQLException e) {
			if(e.getErrorCode()==20110) {
				flag=-1;
			}
			e.printStackTrace();
			System.out.println("In update insert Cart");
		}
		return flag;
	}
	public static ArrayList<CartDetailBean> getListOfCart(int userID){
		ArrayList<CartDetailBean> list = new ArrayList<CartDetailBean>();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
	PreparedStatement psmt = con.prepareStatement("select cartid,price,productdetails.productid,categorydetails.categoryname,subcategorydetails.subcategoryname,originalprice,offerprice,productname,companyname,qty,offertill,productdetails.imagepath,productdescription from cartdetails join productdetails on  cartdetails.productid = productdetails.productid join categoryDetails on categorydetails.categoryid=productdetails.categoryid join subcategorydetails on subcategorydetails.subcategoryid=productdetails.subcategoryid where userid=? order by cartid");){
				psmt.setInt(1, userID);
		ResultSet set = psmt.executeQuery();
		while(set.next()) {
			CartDetailBean cart = new CartDetailBean();
			cart.setCartID(set.getInt("cartid"));
			cart.setPrice(set.getFloat("price"));
			cart.setProductID(set.getInt("productid"));
			cart.setCategoryName(set.getString("categoryName"));
			cart.setSubCategryName(set.getString("subcategoryName"));
			cart.setOrignalPrice(set.getFloat("originalprice"));
			cart.setOfferPrice(set.getFloat("offerprice"));
			cart.setProductName(set.getString("productname"));
			cart.setCompanyName(set.getString("companyname"));
			cart.setQuantity(set.getInt("qty"));
			cart.setOfferTill(set.getString("offerTill"));
			cart.setImgPath(set.getString("imagepath"));
			cart.setProductDescription(set.getString("productdescription"));
			list.add(cart);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("In get List of cart");
	}
		return list;
	}
	public static void main(String[] args) {
		System.out.println(getListOfCart(1).get(0).getCartID());
	}

	public static boolean deleteFromCart(int cartID, int userID) {
		boolean flag = false;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt= con.prepareStatement("delete from cartdetails where userid=? and cartid=?");){
				psmt.setInt(1, userID);
				psmt.setInt(2, cartID);
				int count = psmt.executeUpdate();
				if(count==1) {
					flag = true;
				}
		}
		catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("In delete from cart");
		}
		return flag;
	}

	public static int decreaseQuantity(int productID, int userID, float offerPrice) {
		int flag = 0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			Connection con1 = JDBCConnectionOrcale.connectionMethod();	
				PreparedStatement psmt = con.prepareStatement("update cartdetails set qty = qty-1, price = ?*? where userid=? and productid=?");
				){
			psmt.setInt(1, getCartIDForParticularUserAndProduct(productID,userID)-1);
			psmt.setFloat(2, offerPrice);
			psmt.setInt(3,userID);
			psmt.setInt(4, productID);
			int row = psmt.executeUpdate();
			if(row==1) {
				flag =1;
			}
		}
		catch(SQLException e) {
			if(e.getErrorCode()==20110) {
				flag=-1;
			}
			e.printStackTrace();
			System.out.println("In update insert Cart");
		}
		
		return flag;
	}

	public static ArrayList<CartDetailBean> getListOfCartByCartID(int cartID, int userID) {
		ArrayList<CartDetailBean> list = new ArrayList<CartDetailBean>();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
	PreparedStatement psmt = con.prepareStatement("select cartid,price,productdetails.productid,categorydetails.categoryname,subcategorydetails.subcategoryname,originalprice,offerprice,productname,companyname,qty,offertill,productdetails.imagepath,productdescription from cartdetails join productdetails on  cartdetails.productid = productdetails.productid join categoryDetails on categorydetails.categoryid=productdetails.categoryid join subcategorydetails on subcategorydetails.subcategoryid=productdetails.subcategoryid where userid=? and cartid = ?");){
				psmt.setInt(1, userID);
				psmt.setInt(2, cartID);
		ResultSet set = psmt.executeQuery();
		while(set.next()) {
			CartDetailBean cart = new CartDetailBean();
			cart.setCartID(set.getInt("cartid"));
			cart.setPrice(set.getFloat("price"));
			cart.setProductID(set.getInt("productid"));
			cart.setCategoryName(set.getString("categoryName"));
			cart.setSubCategryName(set.getString("subcategoryName"));
			cart.setOrignalPrice(set.getFloat("originalprice"));
			cart.setOfferPrice(set.getFloat("offerprice"));
			cart.setProductName(set.getString("productname"));
			cart.setCompanyName(set.getString("companyname"));
			cart.setQuantity(set.getInt("qty"));
			cart.setOfferTill(set.getString("offerTill"));
			cart.setImgPath(set.getString("imagepath"));
			cart.setProductDescription(set.getString("productdescription"));
			list.add(cart);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("In get List of cart by cart id");
	}
		return list;
	}
	public static CartDetailBean getListOfCartByCartIDAndUserID(int cartID, int userID) {
		CartDetailBean cart = new CartDetailBean();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
	PreparedStatement psmt = con.prepareStatement("select cartid,price,productdetails.productid,categorydetails.categoryname,subcategorydetails.subcategoryname,originalprice,offerprice,productname,companyname,qty,offertill,productdetails.imagepath,productdescription from cartdetails join productdetails on  cartdetails.productid = productdetails.productid join categoryDetails on categorydetails.categoryid=productdetails.categoryid join subcategorydetails on subcategorydetails.subcategoryid=productdetails.subcategoryid where userid=? and cartid = ?");){
				psmt.setInt(1, userID);
				psmt.setInt(2, cartID);
		ResultSet set = psmt.executeQuery();
		while(set.next()) {
			cart.setCartID(set.getInt("cartid"));
			cart.setPrice(set.getFloat("price"));
			cart.setProductID(set.getInt("productid"));
			cart.setCategoryName(set.getString("categoryName"));
			cart.setSubCategryName(set.getString("subcategoryName"));
			cart.setOrignalPrice(set.getFloat("originalprice"));
			cart.setOfferPrice(set.getFloat("offerprice"));
			cart.setProductName(set.getString("productname"));
			cart.setCompanyName(set.getString("companyname"));
			cart.setQuantity(set.getInt("qty"));
			cart.setOfferTill(set.getString("offerTill"));
			cart.setImgPath(set.getString("imagepath"));
			cart.setProductDescription(set.getString("productdescription"));
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("In get List of cart by cart id");
	}
		return cart;
	}
}