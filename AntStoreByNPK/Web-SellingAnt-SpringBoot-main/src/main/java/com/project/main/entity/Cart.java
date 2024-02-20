package com.project.main.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartID")
    private int cartID;

    @Column(name = "TotalPrice", nullable = false)
    private double totalPrice;

    @Column(name = "CartStatus", nullable = false)
    private String cartStatus;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;
    
    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItem;

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	public double calculateTotalPrice() {
		double totalPrice = 0.0;
		for (CartItem item : cartItem) {
			totalPrice += item.getSubtotalPrice();
		}
		return totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", totalPrice=" + totalPrice + ", cartStatus=" + cartStatus + ", customer="
				+ customer + "]";
	}

    public List<Cart> orElse(Object object) {
        return null;
    }
    
}