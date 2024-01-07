package com.inm429.ecommerce.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "shipped")
    private boolean shipped;

    @Column(name = "amount", nullable = false)
    private int amount;

    @ManyToOne(cascade = CascadeType.REMOVE)    
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", shipped=" + shipped + ", amount=" + amount + ", cart=" + cart + "]";
	}

	public Order() {
		super();
	}

	public Order(Long orderId, boolean shipped, int amount, Cart cart) {
		super();
		this.orderId = orderId;
		this.shipped = shipped;
		this.amount = amount;
		this.cart = cart;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

    
}

