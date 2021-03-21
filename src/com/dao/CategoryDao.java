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
}
