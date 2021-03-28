package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.CategoryDetailBean;
import com.util.JDBCConnectionOrcale;

public class CategoryDao {
	public static List<CategoryDetailBean> getAllCategory() {
		List<CategoryDetailBean> list= new ArrayList<CategoryDetailBean>();
		try (Connection con = JDBCConnectionOrcale.connectionMethod();
				PreparedStatement psmt=con.prepareStatement("select * from categoryDetails");
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
}
