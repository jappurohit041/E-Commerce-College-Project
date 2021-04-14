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
import java.util.List;

import com.bean.CategoryDetailBean;
import com.util.JDBCConnectionOrcale;

public class CategoryDao {
	public static List<CategoryDetailBean> getAllCategory() {
		List<CategoryDetailBean> list= new ArrayList<CategoryDetailBean>();
		try (Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt=con.prepareStatement("select * from categoryDetails order by categoryID");
				ResultSet set = psmt.executeQuery();){
			while(set.next()) {
				CategoryDetailBean category= new CategoryDetailBean();
				category.setCategoryID(set.getInt("CATEGORYID"));
				category.setCategoryName(set.getString("CATEGORYNAME"));
				category.setIsActive(set.getInt("ISACTIVE"));
				category.setImagePath(set.getString("IMAGEPATH"));
				list.add(category);
			}
		}
		catch(Exception e) {
			System.out.println("In all get All Category");
			e.printStackTrace();
		}
		return list;
	}
	public static HashMap<Integer, String> getCategoryName(){
		HashMap<Integer, String> list = new HashMap<Integer, String>();
			try(Connection con = JDBCConnectionOrcale.connectionMethod();
					PreparedStatement psmt = con.prepareStatement("select categoryName, categoryID from categoryDetails");
					ResultSet set = psmt.executeQuery();
					){
				while(set.next()) {
					list.put(set.getInt("categoryID"), set.getString("categoryName"));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("In get Category Name");
			}
		return list;
	}
	public static int getCurrentValue() {
		int currentValue=0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select categoryID from categoryDetails order by categoryid desc fetch first 1 rows only");
			ResultSet set = psmt.executeQuery();){
			while(set.next()) {
				currentValue = set.getInt("categoryID");			
			}
		}catch(Exception e) {
			System.out.println("In get current value of Category Detail");
			e.printStackTrace();
		}
		return currentValue;
	}
	public static int insertRecord(CategoryDetailBean category) {
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt= con.prepareStatement("insert into categoryDetails(categoryName, isActive, imagePath,categoryID) values(?,?,?,?)");){
			int number = CategoryDao.getCurrentValue()+1;
			psmt.setInt(4, number);
			psmt.setString(1, category.getCategoryName());
			psmt.setInt(2, category.getIsActive());
			psmt.setString(3, category.getImagePath());
			psmt.executeUpdate();
			con.prepareStatement("commit;").execute();
		}
		catch(Exception e) {
			System.out.println("Insert Record of Category Detail");
			e.printStackTrace();
		}
		return 0;
	}
	public static int updateRecord(CategoryDetailBean category) {
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("update categoryDetails set categoryName = ?, isActive = ?, imagePath = ? where categoryId = ?");
				){
			psmt.setString(1, category.getCategoryName());
			psmt.setInt(2, category.getIsActive());
			psmt.setString(3, category.getImagePath());
			psmt.setInt(4, category.getCategoryID());
			psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("Update Record of Category Detail");
			e.printStackTrace();
			
		}
		return 0;
	}
	public static CategoryDetailBean getCategory(int categoryID) {
		CategoryDetailBean category = new CategoryDetailBean();
		try (Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt=con.prepareStatement("select * from categoryDetails where categoryID=?");
				){
				psmt.setInt(1, categoryID);
				ResultSet set = psmt.executeQuery();
				while(set.next()) {
					category.setCategoryID(set.getInt("CATEGORYID"));
					category.setCategoryName(set.getString("CATEGORYNAME"));
					category.setIsActive(set.getInt("ISACTIVE"));
					category.setImagePath(set.getString("IMAGEPATH"));
				}
		}
		catch(Exception e) {
			System.out.println("In get particular Category");
			e.printStackTrace();
		}
		return category;
	}
	public static boolean makeCategoryDeActive(int categoryID) {
		boolean flag = false;
		
		try(
				Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt= con.prepareStatement("update categoryDetails set isActive = 0 where categoryID = ?")
				){
			psmt.setInt(1, categoryID);
			int num = psmt.executeUpdate();
			if(num==1) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Make Category De-Active");
		}
	return flag;
	}
	public static boolean makeCategoryActive(int categoryID) {
boolean flag = false;
		
		try(
				Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt= con.prepareStatement("update categoryDetails set isActive = 1 where categoryID = ?")
				){
			psmt.setInt(1, categoryID);
			int num = psmt.executeUpdate();
			if(num==1) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Make Category Active");
		}
	return flag;
	}
	public static int applyDiscountByCategoryID(int categoryID, float percent,String offerTill) {
			int flag= 0;
			try(Connection con = JDBCConnectionOrcale.connectionMethod();
					CallableStatement csmt = con.prepareCall("call  offerByCategoryID(?,?,?)"); 
					){
				csmt.setInt(1, categoryID);
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
				System.out.println("In apply discount by categoryID");
			}
			return flag;
	}
	public static int[] topSellingCategory() {
		BigDecimal[] categoryID= new BigDecimal[2];
		int[] category = new int[2];
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			){
			CallableStatement csmt = con.prepareCall("begin ?:= topSellingCategory; end;");
			csmt.registerOutParameter(1, Types.ARRAY,"TOPSELLINGCATEGORYARRAY");
			csmt.executeQuery();
			
			Array array = (Array) csmt.getArray(1);
			categoryID = (BigDecimal[])array.getArray();
			for(int i =0;i<categoryID.length;i++) {
				category[i]=categoryID[i].intValue();
			}
		}catch(Exception e) {

			System.out.println("In top selling category");
			e.printStackTrace();
		}
		return category;
	}
	public static ArrayList<CategoryDetailBean> topSellingCategoryDetails(){
		ArrayList<CategoryDetailBean> list = new ArrayList<CategoryDetailBean>();
		int[] category = topSellingCategory();
		for(int i=0;i<category.length;i++) {
			CategoryDetailBean c=getCategoryDetailed(category[i]);
			list.add(c);
		}
		return list;
	}
	public static CategoryDetailBean getCategoryDetailed(int categoryID) {
		CategoryDetailBean c = new CategoryDetailBean();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select subcategorydetails.categoryid,categoryName,categorydetails.imagePath,listagg(distinct subcategoryname, ',') within group (order by subcategoryname) as names,listagg(distinct productdetails.productname, ',') as productnames from subcategorydetails join productdetails on productdetails.categoryid=subcategorydetails.categoryid join categoryDetails on categoryDetails.categoryid=subcategorydetails.categoryid where subcategorydetails.categoryid=? group by subcategorydetails.categoryid,categoryName,categorydetails.imagePath");
				){
			psmt.setInt(1, categoryID);
			ResultSet set= psmt.executeQuery();
			while(set.next()) {
				c.setCategoryID(set.getInt("categoryid"));
				c.setCategoryName(set.getString("categoryname"));
				c.setImagePath(set.getString("imagePath"));
				c.setSubCategoryNames(set.getString("names"));
				c.setProductNames(set.getString("productnames"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("In get  categoryDetail");
		}
		return c;
	}
	public static float[] categoryReport(int categoryID) {
		BigDecimal[] category= new BigDecimal[8];
		float[] categoryReport = new float[8];
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			){
			CallableStatement csmt = con.prepareCall("begin ?:= categoryReportFunction(?); end;");
			csmt.registerOutParameter(1, Types.ARRAY,"CATEGORYREPORT");
			csmt.setInt(2, categoryID);
			csmt.executeQuery();
			
			Array array = (Array) csmt.getArray(1);
			category = (BigDecimal[])array.getArray();
			for(int i =0;i<categoryReport.length;i++) {
				categoryReport[i]=category[i].floatValue();
			}
		}catch(SQLException e) {
			if(e.getErrorCode()==1403) {
				categoryReport[7]=-2;
			}

		}
		return categoryReport;
	}
	
	public static HashMap<String,Object> getCategoryReport(int categoryID){
		HashMap<String,Object> report = new HashMap<String,Object>();
		float[] categoryReport = CategoryDao.categoryReport(categoryID);
		if(categoryReport[7]!=-2) {
			report.put("thisMonthSale",categoryReport[0]);
			report.put("thisMonthDiscount", categoryReport[1]);
			report.put("totalSale", categoryReport[2]);
			report.put("totalDiscount", categoryReport[3]);
			report.put("topSalingProduct", ProductDao.getTopSellingProductByProductID((int)categoryReport[4]));
			report.put("leastSalingProduct", ProductDao.getTopSellingProductByProductID((int)categoryReport[5]));
			report.put("topSalingProductMonth", ProductDao.getTopSellingProductByProductIDForMonth((int)categoryReport[6]));
			report.put("leastSalingProductMonth", ProductDao.getTopSellingProductByProductIDForMonth((int)categoryReport[7]));
		}
		else {
			report.put("Error", true);
		}
		return report;
	}
	public static void main(String[] args) {
		float[] categoryReport = CategoryDao.categoryReport(5);
		if(categoryReport[7]!=-2) {
			for(int i=0;i<categoryReport.length;i++) {
				System.out.println("categoryReport : "+categoryReport[i]);
			}	
		}
		else {
			System.out.println("In main function error");
		}
		
	}
	
}
