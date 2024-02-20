package com.project.main.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Transaction")
public class Transaction {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID")
    private int transactionID;

    @Column(name = "TransactionDate", nullable = false)
    private Date transactionDate;

    @Column(name = "TransactionStatus", nullable = false)
    private String transactionStatus;

    @Column(name = "TotalAmount", nullable = false)
    private double totalAmount;

    @OneToOne
    private Cart cart;

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", transactionDate=" + transactionDate
				+ ", transactionStatus=" + transactionStatus + ", totalAmount=" + totalAmount + ", cart=" + cart + "]";
	}
    
	
    // Getters and setters
}