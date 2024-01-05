package com.inm429.ecommerce.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inm429.ecommerce.Model.Product;
import com.inm429.ecommerce.Service.ProductService;
import com.inm429.ecommerce.Service.UploadImageService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;
	
	@Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
	
	@Autowired
	private UploadImageService uploadImageService;

	@GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
    	 List<Product> products = productService.getProducts();
         return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable String productId) {
        Optional<Product> product = productService.getProductById(productId);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String productName) {
        List<Product> products = productService.getProductsByName(productName);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/type/{productType}")
    public ResponseEntity<List<Product>> getProductsByType(@PathVariable String productType) {
        List<Product> products = productService.getProductsByType(productType);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/type-and-name")
    public ResponseEntity<List<Product>> getProductsByTypeAndName(
            @RequestParam String productType,
            @RequestParam String productName) {
        List<Product> products = productService.getProductsByTypeAndName(productType, productName);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    	product.setProductImage("https://storage.cloud.google.com/inm429-ecommerce-storage-bucket/"+product.getProductImage());
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}/update-image")
    public ResponseEntity<Void> updateProductImage(
            @PathVariable String productId,
            @RequestParam String productImage) throws FileNotFoundException, IOException {
        productService.updateProductImage(productId, productImage);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{productId}/update-details")
    public ResponseEntity<Product> updateProductDetails(
            @PathVariable String productId,
            @RequestBody ProductUpdateRequest request) throws FileNotFoundException, IOException {
        productService.updateProductDetails(productId, request.getProductName(), request.getProductQuantity(),
                                            request.getProductPrice(), request.getProductType(),
                                            request.getProductImage(), request.getProductDescription());
        return new ResponseEntity<Product>(new Product(productId, request.getProductName(), request.getProductQuantity(),
                request.getProductPrice(), request.getProductType(),
                request.getProductImage(), request.getProductDescription()), HttpStatus.OK);
    }
    
    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
        	uploadImageService.uploadFile(file);
            return ResponseEntity.ok("File uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload file: " + e.getMessage());
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable String productId) {
        productService.deleteProductById(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
