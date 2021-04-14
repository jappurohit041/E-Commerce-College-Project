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
					+ "join subcategorydetails on subcategorydetails.subcategoryid=productdetails.subcategoryid order by productid");
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
				PreparedStatement psmt = con.prepareStatement("select productid,productdetails.categoryid,productdetails.subcategoryid,categorydetails.categoryname,subcategorydetails.subcategoryname,originalprice,offerprice,productname,companyname,quantity,offertill,productdetails.imagepath,productdescription,productdetails.isactive from productdetails join categoryDetails on categorydetails.categoryid=productdetails.categoryid join subcategorydetails on subcategorydetails.subcategoryid=productdetails.subcategoryid where productdetails.productid = ?");
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
				product.setCategoryName(set.getString("CATEGORYNAME"));
				product.setSubCategoryName(set.getString("SUBCATEGORYNAME"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Get product by id");
		}
		return product;
	}
	public static ProductDetailBean getTopSellingProductByProductID(int productID) {
		ProductDetailBean product = new ProductDetailBean();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("select sum(amount),productdetails.productid,productdetails.categoryid,productdetails.subcategoryid,categorydetails.categoryname,subcategorydetails.subcategoryname,productdetails.originalprice,offerprice,productname,companyname,quantity,offertill,productdetails.imagepath,productdescription,productdetails.isactive,sum(qty) from orderdetailed join productdetails on productdetails.productid = orderdetailed.productid join categoryDetails on categorydetails.categoryid=productdetails.categoryid join subcategorydetails on subcategorydetails.subcategoryid=productdetails.subcategoryid where productdetails.productid = ? group by orderdetailed.productid,productdetails.productid,productdetails.categoryid,productdetails.subcategoryid,categorydetails.categoryname,subcategorydetails.subcategoryname,productdetails.originalprice,offerprice,productname,companyname,quantity,offertill,productdetails.imagepath,productdescription,productdetails.isactive");
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
				product.setTotalAmount(set.getFloat("SUM(AMOUNT)"));
				product.setSoldQuantity(set.getInt("sum(qty)"));
				product.setOfferTill(set.getString("offertill").substring(0,10));
				product.setImagePath(set.getString("imagepath"));
				product.setProductDescription(set.getString("productDescription"));
				product.setCategoryName(set.getString("CATEGORYNAME"));
				product.setSubCategoryName(set.getString("SUBCATEGORYNAME"));
				product.setIsActive(set.getInt("isactive"));
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Get product by id");
		}
		return product;
	}
	public static HashMap<Integer, String> getProductName(){
		HashMap<Integer, String> list = new HashMap<Integer, String>();
			try(Connection con = JDBCConnectionOrcale.connectionMethod();
					PreparedStatement psmt = con.prepareStatement("select productname,productid from productdetails");
					ResultSet set = psmt.executeQuery();
					){
				while(set.next()) {
					list.put(set.getInt("productid"), set.getString("productname"));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("In get product Name");
			}
		return list;
	}
	
	public static ProductDetailBean getTopSellingProductByProductIDForMonth(int productID) {
		ProductDetailBean product = new ProductDetailBean();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("select to_char(sysdate,'Month'),productdetails.productid,productdetails.categoryid,productdetails.subcategoryid,categorydetails.categoryname,subcategorydetails.subcategoryname,productdetails.originalprice,offerprice,productname,companyname,quantity,offertill,productdetails.imagepath,productdescription,productdetails.isactive,sum(qty),sum(amount) from orderdetailed join productdetails on productdetails.productid = orderdetailed.productid join categoryDetails on categorydetails.categoryid=productdetails.categoryid join subcategorydetails on subcategorydetails.subcategoryid=productdetails.subcategoryid where orderdetailed.productid=? group by orderdetailed.productid,productdetails.productid,productdetails.categoryid,productdetails.subcategoryid,categorydetails.categoryname,subcategorydetails.subcategoryname,productdetails.originalprice,offerprice,productname,companyname,quantity,offertill,productdetails.imagepath,productdescription,productdetails.isactive,to_char(sysdate,'Month')");
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
				product.setTotalAmount(set.getFloat("SUM(AMOUNT)"));
				product.setSoldQuantity(set.getInt("sum(qty)"));
				product.setOfferTill(set.getString("offertill").substring(0,10));
				product.setImagePath(set.getString("imagepath"));
				product.setProductDescription(set.getString("productDescription"));
				product.setCategoryName(set.getString("CATEGORYNAME"));
				product.setSubCategoryName(set.getString("SUBCATEGORYNAME"));
				product.setIsActive(set.getInt("isactive"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Get product by id");
		}
		return product;
	}

	public static ArrayList<ProductDetailBean> getProductByCategory(int categoryID) {
		ArrayList<ProductDetailBean> list = new ArrayList<ProductDetailBean>();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select productid,productdetails.categoryid,productdetails.subcategoryid,categorydetails.categoryname,subcategorydetails.subcategoryname,originalprice,offerprice,productname,companyname,quantity,offertill,productdetails.imagepath,productdescription,productdetails.isactive from productdetails join categoryDetails on categorydetails.categoryid=productdetails.categoryid join subcategorydetails on subcategorydetails.subcategoryid=productdetails.subcategoryid where productdetails.categoryid = ? and productdetails.isactive = 1 and productdetails.quantity > 0 order by productid");
			)
		{
			psmt.setInt(1, categoryID);
			ResultSet set = psmt.executeQuery();
			while(set.next()) {
				ProductDetailBean prd = new ProductDetailBean();
				prd.setProductId(set.getInt("productid"));
				prd.setCategoryId(set.getInt("categoryid"));
				prd.setSubCategoryId(set.getInt("subcategoryid"));
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
			System.out.println("Get product by category id product dao");
		}
		return list;
	}
	
	public static ArrayList<ProductDetailBean> getProductByCategoryAndSubCategory(int categoryID, int subcategoryID) {
		ArrayList<ProductDetailBean> list = new ArrayList<ProductDetailBean>();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select productid,productdetails.categoryid,productdetails.subcategoryid,categorydetails.categoryname,subcategorydetails.subcategoryname,originalprice,offerprice,productname,companyname,quantity,offertill,productdetails.imagepath,productdescription,productdetails.isactive from productdetails join categoryDetails on categorydetails.categoryid=productdetails.categoryid join subcategorydetails on subcategorydetails.subcategoryid=productdetails.subcategoryid where productdetails.categoryid = ? and productdetails.quantity > 0 and productdetails.isactive = 1 and productdetails.subcategoryid = ? order by productid");
			)
		{
			psmt.setInt(1, categoryID);
			psmt.setInt(2, subcategoryID);
			ResultSet set = psmt.executeQuery();
			while(set.next()) {
				ProductDetailBean prd = new ProductDetailBean();
				prd.setProductId(set.getInt("productid"));
				prd.setCategoryId(set.getInt("categoryid"));
				prd.setSubCategoryId(set.getInt("subcategoryid"));
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
			System.out.println("Get product by category id  and subcategory id dao");
		}
		return list;
	}
	public static ArrayList<ProductDetailBean> getProductByName(String name){
		ArrayList<ProductDetailBean> list = new ArrayList<ProductDetailBean>();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select productid,productdetails.categoryid,productdetails.subcategoryid,categorydetails.categoryname,subcategorydetails.subcategoryname,originalprice,offerprice,productname,companyname,quantity,offertill,productdetails.imagepath,productdescription,productdetails.isactive from productdetails join categoryDetails on categorydetails.categoryid=productdetails.categoryid join subcategorydetails on subcategorydetails.subcategoryid=productdetails.subcategoryid where upper(productname) like '%'||upper('"+name +"')||'%' order by productid");
					ResultSet set = psmt.executeQuery();
				)
		{

			while(set.next()) {
				ProductDetailBean prd = new ProductDetailBean();
				prd.setProductId(set.getInt("productid"));
				prd.setCategoryId(set.getInt("categoryid"));
				prd.setSubCategoryId(set.getInt("subcategoryid"));
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
			System.out.println("Get product by category id  and subcategory id dao");
		}
		return list;
	}
	public static int updateProductByID(ProductDetailBean product) {
		int flag = 0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("update productDetails set categoryid= ?,subcategoryid = ?,originalprice = ?,offerprice = ?,productname = ?,companyname = ?,quantity = ?,offertill = to_date(?,'yyyymmdd'),imagepath = ?,productdescription = ?,isactive = ? where productid= ?");){
			psmt.setInt(1, product.getCategoryId());
			psmt.setInt(2, product.getSubCategoryId());
			psmt.setFloat(3, product.getOriginalPrice());
			psmt.setFloat(4, product.getOfferPrice());
			psmt.setString(5, product.getProductName());
			psmt.setString(6, product.getCompanyName());
			psmt.setInt(7, product.getQuantity());
			psmt.setString(8, product.getOfferTill());
			psmt.setString(9, product.getImagePath());
			psmt.setString(10, product.getProductDescription());
			psmt.setInt(11, product.getIsActive());
			psmt.setInt(12, product.getProductId());
			int count = psmt.executeUpdate();
			if(count==1) {
				flag =1;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("In update Product By ID");
		}
		return flag;
	}
	public static HashMap<Integer,String> productIDAndQuestion(){
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("select productid, upper(productname) from productdetails where isactive=1");
				ResultSet set = psmt.executeQuery();
				){
			while(set.next()) {
				map.put(set.getInt("productid"), set.getString("upper(productname)"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("In get productid and question");
		}
		return map;
	}

	public static int applyDiscountByPrice(int productID, float percent,String offerTill) {
		int flag= 0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				CallableStatement csmt = con.prepareCall("call  offerByPrice(?,?,?)") 
				){
			csmt.setInt(1, productID);
			csmt.setFloat(2, percent);
			csmt.setString(3, offerTill);
			boolean flag1 = csmt.execute();
			if(!flag1) {
				flag=1;
			}
		}
		catch(SQLException e) {
			if(e.getErrorCode()==20200) {
				flag=-1;
			}
			//e.printStackTrace();
			System.out.println("In apply discount by price");
		}
		return flag;
	}
	public static int applyDiscountByPercent(int productID, float percent,String offerTill) {
		int flag= 0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				CallableStatement csmt = con.prepareCall("call  offerByPercentage(?,?,?)");
				){
			csmt.setInt(1, productID);
			csmt.setFloat(2, percent);
			csmt.setString(3, offerTill);
			boolean flag1 = csmt.execute();
			if(!flag1) {
				flag=1;
			}
		}
		catch(SQLException e) {
			if(e.getErrorCode()==20200) {
				flag=-1;
			}
			//e.printStackTrace();
			System.out.println("In apply discount by percentage");
		}
		return flag;
	}
	public static int[] topSellingProduct() {
		BigDecimal[] productID= new BigDecimal[5];
		int[] product = new int[5];
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			){
			CallableStatement csmt = con.prepareCall("begin ?:= topSellingProduct; end;");
			csmt.registerOutParameter(1, Types.ARRAY,"RETURNINGID");
			csmt.executeQuery();
			
			Array array = (Array) csmt.getArray(1);
			productID = (BigDecimal[])array.getArray();
			for(int i =0;i<productID.length;i++) {
				product[i]=productID[i].intValue();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	public static void resetPrice() {
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				CallableStatement csmt = con.prepareCall("{call  resetPrice}");)
		{
			csmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<ProductDetailBean> getTopSellingProducts(){
		ArrayList<ProductDetailBean> list = new ArrayList<ProductDetailBean>();
		int[] productID = topSellingProduct();
		for(int i =0 ; i<productID.length;i++) {
			ProductDetailBean product = getTopSellingProductByProductID(productID[i]);
			list.add(product);
		}
		return list;
	}
	public static int[] productReport() {
		BigDecimal[] productID= new BigDecimal[4];
		int[] product = new int[4];
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			){
			CallableStatement csmt = con.prepareCall("begin ?:= productReportFunction; end;");
			csmt.registerOutParameter(1, Types.ARRAY,"PRODUCTREPORT");
			csmt.executeQuery();
			
			Array array = (Array) csmt.getArray(1);
			productID = (BigDecimal[])array.getArray();

			for(int i =0;i<productID.length;i++) {
				product[i]=productID[i].intValue();
			}
			for(int i=0;i<product.length;i++) {
				System.out.println("i : "+product[i]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	public static ArrayList<ProductDetailBean> productReportMethod(){
		ArrayList<ProductDetailBean> list = new ArrayList<ProductDetailBean>();
		int[] productID = productReport();
		//System.out.println(productID.length);
		for(int i=0;i<productID.length;i++) {
			System.out.println("i : "+productID[i]);
		}
		for(int i =0 ; i<2;i++) {
			ProductDetailBean product = getTopSellingProductByProductID(productID[i]);
			list.add(product);
		}
		for(int i =2 ; i<productID.length;i++) {
			ProductDetailBean product = getTopSellingProductByProductIDForMonth(productID[i]);
			list.add(product);
		}
		return list;
	}
	public static void main(String[] args) {
		productReport();
	}
	
}
