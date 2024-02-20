package com.project.main.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
    private int addressID;
    
    @Column(name = "detail", nullable = false)
    private String detail;

    @Column(name = "PostalCode", nullable = false)
    private String postalCode;

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Address [addressID=" + addressID + ", detail=" + detail + ", postalCode=" + postalCode + "]";
	}
	
    // Getters and setters
}