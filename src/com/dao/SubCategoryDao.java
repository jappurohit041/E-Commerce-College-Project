package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.SubCategoryDetailBean;
import com.util.JDBCConnectionOrcale;

public class SubCategoryDao {
	public static List<SubCategoryDetailBean> getSubCategoryByID(int id) {
		List<SubCategoryDetailBean> list= new ArrayList<SubCategoryDetailBean>();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt=con.prepareStatement("select * from subCategoryDetails where CATEGORYID = ?");
			)
		{
			psmt.setInt(1, id);
			ResultSet set = psmt.executeQuery();
			while(set.next()) {
				SubCategoryDetailBean subCategory = new SubCategoryDetailBean();
				subCategory.setSubCategoryID(set.getInt("SUBCATEGORYID"));
				subCategory.setCategoryID(set.getInt("CATEGORYID"));
				subCategory.setSubCategoryName(set.getString("SUBCATEGORYNAME"));
				subCategory.setIsActive(set.getInt("ISACTIVE"));
				list.add(subCategory);
			}
		}
		catch(Exception e) {
			System.out.println("In getSubCategorybyID");
			e.printStackTrace();
		}
		return list;
	}
	public static int getSubCategoryID() {
		int subCategoryID = 0;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select subcategoryID from subcategoryDetails order by subcategoryid desc fetch first 1 rows only");
			ResultSet set = psmt.executeQuery();
				)
		{
			while(set.next()) {
				subCategoryID=set.getInt("subCategoryID");
			}
		}
		catch(Exception e) {
			System.out.println("In get latest sub category ID");
		}
		return subCategoryID+1;
	}
	public static boolean insertSubCategory(SubCategoryDetailBean subCategory) {
		boolean flag = false;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("insert into subCategoryDetails(categoryID,isActive, subCategoryID, subCategoryName) values(?,?,?,?)");
				)
			
		{
			psmt.setInt(1, subCategory.getCategoryID());
			psmt.setInt(2, subCategory.getIsActive());
			psmt.setInt(3, subCategory.getSubCategoryID());
			psmt.setString(4, subCategory.getSubCategoryName());
			int count=psmt.executeUpdate();
			if(count == 1) {
				flag =true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insert sub category");
		}
		return flag;
	}
	public static ArrayList<SubCategoryDetailBean> getAllSubCategoryDetail(){
		ArrayList<SubCategoryDetailBean> list = new ArrayList<SubCategoryDetailBean>();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
			PreparedStatement psmt = con.prepareStatement("select subcategoryID, subcategoryName, "
					+ "categoryName, subcategoryDetails.isActive "
					+ "from subCategoryDetails join categoryDetails "
					+ "c on subcategoryDetails.categoryid=c.categoryid");
			ResultSet set = psmt.executeQuery();){
			while(set.next()) {
				SubCategoryDetailBean subCategory = new SubCategoryDetailBean();
				subCategory.setCategoryName(set.getString("categoryName"));
				subCategory.setIsActive(set.getInt("isActive"));
				subCategory.setSubCategoryName(set.getString("subCategoryName"));
				subCategory.setSubCategoryID(set.getInt("subCategoryID"));
				list.add(subCategory);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("In get All subcategoryDetail");
		}
		return list;
	}
	public static boolean makeSubCategoryDeActive(int subCategoryID) {
		boolean flag = false;
			
			try(
					Connection con = JDBCConnectionOrcale.connectionMethod();
					PreparedStatement psmt= con.prepareStatement("update subcategoryDetails set isActive = 0 where subcategoryID = ?")
					){
				psmt.setInt(1, subCategoryID);
				int num = psmt.executeUpdate();
				if(num==1) {
					flag = true;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Make Sub-Category De-Active");
			}
		return flag;
	}
	public static boolean makeSubCategoryActive(int subCategoryID) {

boolean flag = false;
		
		try(
				Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt= con.prepareStatement("update subcategoryDetails set isActive = 1 where subcategoryID = ?")
				){
			psmt.setInt(1, subCategoryID);
			int num = psmt.executeUpdate();
			if(num==1) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Make subCategory Active");
		}
	return flag;
	}
	public static boolean updateSubCategory(SubCategoryDetailBean subCategory) {
		boolean flag= false;
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("update subcategoryDetails set subcategoryName = ?, isActive = ?, categoryid= ? where subcategoryId = ?");
					){
				psmt.setString(1, subCategory.getSubCategoryName());
				psmt.setInt(2, subCategory.getIsActive());
				psmt.setInt(3, subCategory.getCategoryID());
				psmt.setInt(4, subCategory.getSubCategoryID());
				int count= psmt.executeUpdate();
				if(count==1) {
					flag=true;
				}
			}
			catch(Exception e) {
				System.out.println("Update Record of Sub-Category Detail");
				e.printStackTrace();
				
			}
		return flag;
	}
	public static SubCategoryDetailBean getSubCategory(int subCategoryID) {
		SubCategoryDetailBean subCategory = new SubCategoryDetailBean();
		try(Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt = con.prepareStatement("select * from subcategorydetails where subcategoryid=?");)
		{
			psmt.setInt(1, subCategoryID);
			ResultSet set = psmt.executeQuery();
			while(set.next()) {
				subCategory.setCategoryID(set.getInt("categoryID"));
				subCategory.setIsActive(set.getInt("isactive"));
				subCategory.setSubCategoryID(set.getInt("subCategoryID"));
				subCategory.setSubCategoryName(set.getString("subCategoryName"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Getting subCategory Details");
		}
		return subCategory;
	}
}
