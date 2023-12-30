package com.inm429.ecommerce.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@Column(name = "product_id")
	String productId;
	
	@Column(name = "product_name")
	String productName;
	
	@Column(name = "product_quantity")
	int productQuantity;
	
	@Column(name = "product_price")
	int productPrice;
	
	@Column(name = "product_type")
	String productType;
	
	@Column(name = "product_image")
	String productImage;
	
	@Column(name = "product_description")
	String productDescription;

	public Product() {
		super();
	}

	public Product(String productId, String productName, int productQuantity, int productPrice, String productType,
			String productImage, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productType = productType;
		this.productImage = productImage;
		this.productDescription = productDescription;
	}

	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", productPrice=" + productPrice + ", productType=" + productType
				+ ", productImage=" + productImage + ", productDescription=" + productDescription + "]";
	}



	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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
