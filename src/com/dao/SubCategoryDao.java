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

}
