package com.inm429.ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inm429.ecommerce.Model.Product;
import com.inm429.ecommerce.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getUser(String emailId) {
		return productRepository.findAll();
	}
	
    public Optional<Product> getProductById(String productId) {
        return productRepository.findByProductId(productId);
    }

    public List<Product> getProductsByName(String productName) {
        return productRepository.findByProductNameContaining(productName);
    }

    public List<Product> getProductsByType(String productType) {
        return productRepository.findByProductType(productType);
    }

    public List<Product> getProductsByTypeAndName(String productType, String productName) {
        return productRepository.findByProductTypeAndProductName(productType, productName);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void updateProductImage(String productId, String productImage) {
        productRepository.updateProductImage(productId, productImage);
    }

    public void updateProductDetails(String productId, String productName, int productQuantity,
                                     int productPrice, String productType, String productImage,
                                     String productDescription) {
        productRepository.updateProductDetails(productId, productName, productQuantity, productPrice,
                                                productType, productImage, productDescription);
    }

    public void deleteProductById(String productId) {
        productRepository.deleteByProductId(productId);
    }

}
