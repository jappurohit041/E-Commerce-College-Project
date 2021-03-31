package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.ProductDetailBean;
import com.util.JDBCConnectionOrcale;

public class ProductDao {
	
	public static ArrayList<ProductDetailBean>  getAllProduct() {
		ArrayList<ProductDetailBean> list = new ArrayList<ProductDetailBean>();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "select \r\n"
					+ "productid,categorydetails.categoryname,subcategorydetails.subcategoryname,originalprice,offerprice,productname,companyname,quantity,offertill,productdetails.imagepath,productdescription,productdetails.isactive \r\n"
					+ "from productdetails \r\n"
					+ "join categoryDetails on categorydetails.categoryid=productdetails.categoryid \r\n"
					+ "join subcategorydetails on subcategorydetails.subcategoryid=productdetails.subcategoryid");
			ResultSet set = psmt.executeQuery();)
		{
			while(set.next()) {
				ProductDetailBean prd = new ProductDetailBean();
				prd.setProductId(set.getInt("productid"));
				prd.setProductName(set.getString("PRODUCTNAME"));
				prd.setCategoryName(set.getString("CATEGORYNAME"));
				prd.setSubCategoryName(set.getString("SUBCATEGORYNAME"));
				prd.setOriginalPrice(set.getFloat("ORIGINALPRICE"));
				prd.setOfferPrice(set.getFloat("OFFERPRICE"));
				prd.setCompanyName(set.getString("companyname"));
				prd.setQuantity(set.getInt("quantity"));
				prd.setOfferTill(set.getString("offertill").substring(0,10));
				prd.setImagePath(set.getString("imagepath"));
				prd.setProductDescription(set.getString("PRODUCTDESCRIPTION"));
				prd.setIsActive(set.getInt("isactive"));
				list.add(prd);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Get All product product dao");
		}
		return list;
	}
	public static int getCurrentValue() {
		int currentValue=0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select productid from productDetails order by productid desc fetch first 1 rows only");
			ResultSet set = psmt.executeQuery();){
			while(set.next()) {
				currentValue = set.getInt("productid");			
			}
		}catch(Exception e) {
			System.out.println("In get current value of product Detail");
			e.printStackTrace();
		}
		return currentValue;
	}

	public static int insertRecord(ProductDetailBean product) {
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt= con.prepareStatement("insert into productDetails(productid,categoryid,subcategoryid,originalprice,offerprice,productname,companyname,quantity,offertill,imagepath,productdescription,isactive) values(?,?,?,?,?,?,?,?,to_date(?,'yyyymmdd'),?,?,?)");){
				psmt.setInt(1, product.getProductId());
				psmt.setInt(2, product.getCategoryId());
				psmt.setInt(3, product.getSubCategoryId());
				psmt.setFloat(4, product.getOriginalPrice());
				psmt.setFloat(5, product.getOfferPrice());
				psmt.setString(6, product.getProductName());
				psmt.setString(7, product.getCompanyName());
				psmt.setInt(8, product.getQuantity());
				psmt.setString(9, product.getOfferTill());
				psmt.setString(10, product.getImagePath());
				psmt.setString(11, product.getProductDescription());
				psmt.setInt(12, product.getIsActive());
				psmt.executeUpdate();
			}
			catch(Exception e) {
				System.out.println("Insert Record of Category Detail");
				e.printStackTrace();
			}
			return 0;
	}

	public static boolean makeProductDaoDeActive(int productID) {
		boolean flag =false;
		try(
				Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt= con.prepareStatement("update productDetails set isActive = 0 where productId = ?")
				){
			psmt.setInt(1, productID);
			int num = psmt.executeUpdate();
			if(num==1) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Make Product De-Active");
		}
		return flag;
	}
	public static boolean makeProductDaoActive(int productID) {
		boolean flag =false;
		try(
				Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt= con.prepareStatement("update productDetails set isActive = 1 where productId = ?")
				){
			psmt.setInt(1, productID);
			int num = psmt.executeUpdate();
			if(num==1) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Make Product Active");
		}
		return flag;
	}
	public static boolean deleteProductByID(int productID) {
		boolean flag = false;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("delete from productDetails where productid= ?");)
		{
			psmt.setInt(1, productID);
			int count = psmt.executeUpdate();
			if(count == 1) {
				flag= true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Delete Product By ID");
		}
		return flag;
	}
	public static ProductDetailBean getProductByID(int productID) {
		ProductDetailBean product = new ProductDetailBean();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("select * from productDetails where productId= ?");
				){
			psmt.setInt(1, productID);
			ResultSet set = psmt.executeQuery();
			while(set.next()) {
				product.setProductId(set.getInt("productid"));
				product.setCategoryId(set.getInt("categoryID"));
				product.setSubCategoryId(set.getInt("subcategoryid"));
				product.setOriginalPrice(set.getFloat("originalprice"));
				product.setOfferPrice(set.getFloat("offerprice"));
				product.setProductName(set.getString("productName"));
				product.setCompanyName(set.getString("companyName"));
				product.setQuantity(set.getInt("quantity"));
				product.setOfferTill(set.getString("offertill").substring(0,10));
				product.setImagePath(set.getString("imagepath"));
				product.setProductDescription(set.getString("productDescription"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Get product by id");
		}
		return product;
	}
	public static void main(String[] args) {
		ProductDetailBean p = getProductByID(1);
		System.out.println(p.getProductName());
		System.out.println(p.getOfferTill());
		System.out.println(p.getQuantity());
		System.out.println(p.getOfferPrice());
	}
}
