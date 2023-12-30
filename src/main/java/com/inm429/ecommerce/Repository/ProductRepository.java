package com.inm429.ecommerce.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inm429.ecommerce.Model.Product;

@Transactional
public interface ProductRepository extends CrudRepository<Product, String>{
    Optional<Product> findByProductId(String productId);
    List<Product> findAll();
    List<Product> findByProductNameContaining(String productName);
    List<Product> findByProductNameStartingWith(String productName);
    List<Product> findByProductType(String productType);
    List<Product> findByProductTypeAndProductName(String productType, String productName);
    Product save(Product product);
    @Modifying
    @Query("UPDATE Product p SET p.productImage = :productImage WHERE p.productId = :productId")
    int updateProductImage(@Param("productId") String productId, @Param("productImage") String productImage);
    List<Product> findByProductPriceGreaterThan(int price);
    List<Product> findByProductPriceLessThan(int price);
    List<Product> findByProductQuantityGreaterThan(int quantity);
    List<Product> findByProductDescriptionContaining(String keyword);
    void deleteByProductId(String productId);
    @Modifying
    @Query("UPDATE Product p SET p.productName = :productName, p.productQuantity = :productQuantity, " +
           "p.productPrice = :productPrice, p.productType = :productType, p.productImage = :productImage, " +
           "p.productDescription = :productDescription WHERE p.productId = :productId")
    int updateProductDetails(@Param("productId") String productId,
                             @Param("productName") String productName,
                             @Param("productQuantity") int productQuantity,
                             @Param("productPrice") int productPrice,
                             @Param("productType") String productType,
                             @Param("productImage") String productImage,
                             @Param("productDescription") String productDescription);
}
