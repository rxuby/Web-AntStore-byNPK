package com.project.main.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CartItem")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartItemID")
    private int cartItemID;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "SubtotalPrice", nullable = false)
    private double subtotalPrice;

    
    @ManyToOne
    @JoinColumn(name = "CartID")
    private Cart cart;
    
    @ManyToOne
    @JoinColumn(name = "AntID")
    private Ant ant;
    // Getters and setters

	public int getCartItemID() {
		return cartItemID;
	}

	public void setCartItemID(int cartItemID) {
		this.cartItemID = cartItemID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubtotalPrice() {
		return subtotalPrice;
	}

	public void setSubtotalPrice(double subtotalPrice) {
		this.subtotalPrice = subtotalPrice;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Ant getAnt() {
		return ant;
	}

	public void setAnt(Ant ant) {
		this.ant = ant;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemID=" + cartItemID + ", quantity=" + quantity + ", subtotalPrice=" + subtotalPrice
				+ ", cart=" + cart + ", ant=" + ant + "]";
	}
    
}