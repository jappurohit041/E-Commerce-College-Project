package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bean.CategoryDetailBean;
import com.dao.CategoryDao;


@WebServlet("/AddEditCategoryServlet")
public class AddEditCategoryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag= false;
		boolean isError = false;
		CategoryDetailBean category = new CategoryDetailBean();
		if(ServletFileUpload.isMultipartContent(request)) {
			try {
				File f1=null;
				List<FileItem> multipleParts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for(FileItem item : multipleParts) {
					if(item.isFormField()) {
						if(item.getFieldName().equals("categoryID")) {
							if(item.getString()==null) {
								flag = true;
							}
							else {
								category.setCategoryID(Integer.parseInt(item.getString()));
							}
						}
						
						if(item.getFieldName().equals("categoryName")) {
							category.setCategoryName(item.getString());
							if(item.getString()==null || item.getString().trim().length()==0) {
								isError = true;
								request.setAttribute("categoryNameError", "Please enter valid category name");
							}
						}
						
						if(item.getFieldName().equals("inputCategoryStatus")) {
							category.setIsActive(Integer.parseInt(item.getString()));
							if(item.getString().equals("-1")){
								isError=true;
								request.setAttribute("categoryStatusError", "Please enter category status");
							}
						}
					}
					else {
						File f=null;
						f1=new File("C:\\Users\\Jap Purohit\\eclipse-workspace\\ECollegeProject\\WebContent\\images\\category");
						if(item.getFieldName().endsWith(".jpg") || item.getFieldName().endsWith(".png")) {
							if(flag) {
								//New Category
								f=new File(f1,(CategoryDao.getCurrentValue()+1)+".png");
								item.write(f);
								category.setImagePath("images\\category\\"+(CategoryDao.getCurrentValue())+1+".png");
							}
							else {
								//Already Existing file
								f=new File(f1,category.getCategoryID()+".png");
								item.write(f);
								category.setImagePath("images\\category\\"+category.getCategoryID()+".png");
							}
						}
						else {
							isError=true;
							request.setAttribute("imageError", "Please add only .jpg or .png file.");
						}
					}
				}
				if(isError) {
					request.setAttribute("category", category);
					request.getRequestDispatcher("AddEditCategory.jsp").forward(request, response);
				}
				else {
					int status=-1;
					if(flag) {
						//Insert
						status = CategoryDao.insertRecord(category);
					}
					else {
						//Update
						status = CategoryDao.updateRecord(category);
					}
					if(status==0) {
						request.setAttribute("msg", "Updated Category Succefull");
						request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
					}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
