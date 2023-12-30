package com.inm429.ecommerce.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inm429.ecommerce.Model.Cart;
import com.inm429.ecommerce.Service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllItemsInCart() {
        List<Cart> cartItems = cartService.getAllItemsInCart();
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getItemById(@PathVariable Long cartId) {
        Optional<Cart> cartItem = cartService.getItemById(cartId);
        return cartItem.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Cart>> getItemsInCartByUserId(@PathVariable Long userId) {
        List<Cart> cartItems = cartService.getItemsInCartByUserId(userId);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cart> addItemToCart(@RequestBody Cart cartItem) {
        Cart newCartItem = cartService.addItemToCart(cartItem);
        return new ResponseEntity<>(newCartItem, HttpStatus.CREATED);
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<Void> updateCartItem(@PathVariable Long cartId, @RequestBody Cart updatedCartItem) {
        cartService.updateCartItem(cartId, updatedCartItem);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long cartId) {
        cartService.deleteCartItem(cartId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
