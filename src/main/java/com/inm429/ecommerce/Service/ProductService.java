package com.inm429.ecommerce.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inm429.ecommerce.Model.Product;
import com.inm429.ecommerce.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UploadImageService uploadImageService;
	
	public List<Product> getProducts() {
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

    public void updateProductImage(String productId, String productImage) throws FileNotFoundException, IOException {
    	File file = new File(productImage);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(), "image", new FileInputStream(file));
        uploadImageService.uploadFile(multipartFile);
        String imageUrl = "https://storage.cloud.google.com/inm429-ecommerce-bucket/"+file.getName();
        productRepository.updateProductImage(productId, imageUrl);
    }

    public void updateProductDetails(String productId, String productName, int productQuantity,
                                     int productPrice, String productType, String productImage,
                                     String productDescription) throws FileNotFoundException, IOException {
    	File file = new File(productImage);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(), "image", new FileInputStream(file));
        uploadImageService.uploadFile(multipartFile);
        String imageUrl = "https://storage.cloud.google.com/inm429-ecommerce-bucket/"+file.getName();
        productRepository.updateProductDetails(productId, productName, productQuantity, productPrice,
                                                productType, imageUrl, productDescription);
    }

    public void deleteProductById(String productId) {
        productRepository.deleteByProductId(productId);
    }

}
