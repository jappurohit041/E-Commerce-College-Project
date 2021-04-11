package com.bean;

public class CategoryDetailBean {
	private int isActive, categoryID;
	private String categoryName, imagePath,productNames,subCategoryNames;

	public String getProductNames() {
		return productNames;
	}

	public void setProductNames(String productNames) {
		this.productNames = productNames;
	}

	public String getSubCategoryNames() {
		return subCategoryNames;
	}

	public void setSubCategoryNames(String subCategoryNames) {
		this.subCategoryNames = subCategoryNames;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
