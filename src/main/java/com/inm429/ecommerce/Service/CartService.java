package com.inm429.ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inm429.ecommerce.Model.Cart;
import com.inm429.ecommerce.Repository.CartRepository;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllItemsInCart() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getItemById(Long cartId) {
        return cartRepository.findById(cartId);
    }

    public Cart addItemToCart(Cart cartItem) {
        return cartRepository.save(cartItem);
    }
    
    public List<Cart> getItemsInCartByUserId(Long userId) {
        return cartRepository.findByUserUserId(userId);
    }

    public void updateCartItem(Long cartId, Cart updatedCartItem) {
        cartRepository.findById(cartId).ifPresent(cart -> {
            cart.setQuantity(updatedCartItem.getQuantity());
            cart.setUser(updatedCartItem.getUser());
            cart.setProduct(updatedCartItem.getProduct());
            cartRepository.save(cart);
        });
    }

    public void deleteCartItem(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}

