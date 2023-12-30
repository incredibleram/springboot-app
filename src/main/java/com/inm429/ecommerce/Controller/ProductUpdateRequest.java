package com.inm429.ecommerce.Controller;

public class ProductUpdateRequest {

    private String productName;
    private int productQuantity;
    private int productPrice;
    private String productType;
    private String productImage;
    private String productDescription;
    
	@Override
	public String toString() {
		return "ProductUpdateRequest [productName=" + productName + ", productQuantity=" + productQuantity
				+ ", productPrice=" + productPrice + ", productType=" + productType + ", productImage=" + productImage
				+ ", productDescription=" + productDescription + "]";
	}

	public ProductUpdateRequest(String productName, int productQuantity, int productPrice, String productType,
			String productImage, String productDescription) {
		super();
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productType = productType;
		this.productImage = productImage;
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
    
    
}