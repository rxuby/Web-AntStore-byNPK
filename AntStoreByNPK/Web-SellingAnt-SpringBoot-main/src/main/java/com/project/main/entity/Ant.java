package com.project.main.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Ant")
public class Ant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AntID")
    private int antID;

	@Column(name = "name", nullable = false)
	private String name;

    @Column(name = "WorkerCount", nullable = false)
    private int workerCount;

    @Column(name = "Species", nullable = false)
    private String species;

    @Column(name = "Price", nullable = false)
    private double price;

    @Column(name = "StockQuantity", nullable = false)
    private int stockQuantity;

	
	@Column(name = "Description", columnDefinition = "TEXT")
    private String description;
	
    @OneToMany(mappedBy = "ant")
    private List<CartItem> cartItem;
    // Getters and setters
	
	public int getAntID() {
		return antID;
	}
	
	public void setAntID(int antID) {
		this.antID = antID;
	}
	
	public int getWorkerCount() {
		return workerCount;
	}
	
	public void setWorkerCount(int workerCount) {
		this.workerCount = workerCount;
	}
	
	public String getSpecies() {
		return species;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getStockQuantity() {
		return stockQuantity;
	}
	
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Ant [antID=" + antID + ", workerCount=" + workerCount + ", species=" + species + ", price=" + price
				+ ", stockQuantity=" + stockQuantity + ", description=" + description +  "]";
	}
}
