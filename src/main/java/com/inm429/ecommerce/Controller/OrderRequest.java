package com.inm429.ecommerce.Controller;

public class OrderRequest {

    private boolean shipped;
    private int amount;
    private Long cartId;

    public OrderRequest() {
    }

    public OrderRequest(boolean shipped, int amount, Long cartId) {
        this.shipped = shipped;
        this.amount = amount;
        this.cartId = cartId;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}

