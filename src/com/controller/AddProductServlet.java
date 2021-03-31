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

import com.bean.ProductDetailBean;
import com.dao.ProductDao;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet{
	private static final long serialVersionUID = 4433483402468979040L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isError = false;
		File f1;
		ProductDetailBean product = new ProductDetailBean();
		if(ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multipleParts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for(FileItem item : multipleParts) {
					if(item.isFormField()) {
						if(item.getFieldName().equals("inputOfferTillDate")) {
							if(item.getString().equals("")) {
								isError =true;
								request.setAttribute("productOfferTillError", "Please enter offer till date");
							}
							product.setOfferTill(item.getString().replaceAll("-", ""));
							System.out.println(product.getOfferTill());
						}
						if(item.getFieldName().equals("productName")) {
							if(item.getString().trim().length()==0 || item.getString().equals("")) {
								isError =true;
								request.setAttribute("productNameError", "Please enter valid name");
							}
							product.setProductName(item.getString());
						}
						if(item.getFieldName().equals("companyName")) {
							if(item.getString().trim().length()==0 || item.getString().equals("")) {
								isError =true;
								request.setAttribute("productCompanyNameError", "Please enter valid company name");
							}
							product.setCompanyName(item.getString());
						}
						if(item.getFieldName().equals("description")) {
							if(item.getString().trim().length()==0 || item.getString().equals("")) {
								isError =true;
								request.setAttribute("productDescriptionError", "Please enter valid description");
							}
							product.setProductDescription(item.getString());
						}
						if(item.getFieldName().equals("quantity")) {
							if(item.getString().contains("-") || item.getString().equals("")) {
								isError =true;
								request.setAttribute("productQuantityPriceError", "Please enter valid quantity");
							}
							else {
								product.setQuantity(Integer.parseInt(item.getString()));
							}
						}
						if(item.getFieldName().equals("originalPrice")) {
							if(item.getString().contains("-") || item.getString().equals("")) {
								isError =true;
								request.setAttribute("productOriginalPriceError", "Please enter valid price");
							}
							else {
								product.setOriginalPrice(Float.parseFloat(item.getString()));
							}
						}
						if(item.getFieldName().equals("offerPrice")) {
							if(item.getString().contains("-") || item.getString().equals("")) {
								isError =true;
								request.setAttribute("productOfferPriceError", "Please enter valid price");
							}
							else {
								product.setOfferPrice(Float.parseFloat(item.getString()));
							}
						}

						if(item.getFieldName().equals("inputProductStatus")) {
							if(item.getString().equals("-1")) {
								isError =true;
								request.setAttribute("productStatusError", "Please enter status of product");
							}
							else {
								product.setIsActive(Integer.parseInt(item.getString()));
							}
						}
						if(item.getFieldName().equals("category")) {
							System.out.println(item.getString()+"Category");
							
							if(item.getString().equals("-1")) {
								isError =true;
								request.setAttribute("productCategoryError", "Please enter category");
							}
							else {
								product.setCategoryId(Integer.parseInt(item.getString()));
							}
						}
						if(item.getFieldName().equals("subCategory")) {
							System.out.println(item.getString()+"SubCategory");
							if(item.getString().equals("-1")) {
								isError =true;
								request.setAttribute("productSubCategoryError", "Please enter subcategory");
							}
							else {
								System.out.println("SUbCategory Error"+item.getString());
								product.setSubCategoryId(Integer.parseInt(item.getString()));
							}
						}
					}
					else {
						File f=null;
						f1=new File("C:\\Users\\Jap Purohit\\eclipse-workspace\\ECollegeProject\\WebContent\\images\\product");
						System.out.println(item.getName());
						if((item.getName().endsWith(".jpg") || 
								item.getName().endsWith(".jpeg")|| 
									item.getName().endsWith(".png"))&& isError==false) {
								//New Category
								int num= ProductDao.getCurrentValue()+1;
								product.setProductId(ProductDao.getCurrentValue()+1);
								f=new File(f1,(ProductDao.getCurrentValue()+1)+".png");
								item.write(f);
								product.setImagePath("images\\product\\"+num+".png");
						}
						else {
							isError=true;
							request.setAttribute("productImagePathError", "Please add only .jpg or .png file.");
						}
					}
				}
				
				if(isError) {
					request.setAttribute("product",product);
					request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
				}
				else {
					int status = -1;
					status = ProductDao.insertRecord(product);
					if(status==0) {
					request.setAttribute("msg", "Added Product Successfully");
					}
					else {
						request.setAttribute("msg", "Some Error occured in Product Addition");	
					}
					request.getRequestDispatcher("ProductsDisplay.jsp").forward(request, response);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
}
