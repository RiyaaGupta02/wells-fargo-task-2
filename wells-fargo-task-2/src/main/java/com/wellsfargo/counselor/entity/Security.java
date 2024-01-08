package com.wellsfargo.counselor.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Security {

	@Id
    @GeneratedValue
    @Column(name = "security_id", nullable = false, unique = true)
    private Long Security_id;
	//hence this bcoms a primary key having unique id and not null

    @Column(nullable = false)
    private String Security_name;

    @Column(nullable = false)
    private String Security_type;

    @Column(name = "purchase_date", nullable = false)
    private String purchaseDate;

    @Column(name = "purchase_price", nullable = false)
    private double purchasePrice;

    @Column(nullable = false)
    private int quantity;
    
    @OneToMany(mappedBy = "security")
    private Set<PortfolioSecurity> portfolioSecurities = new HashSet<>();
    
    //default constructor
    protected Security() {
    	
    }

    //constructor to initialize the fields
	public Security(Long security_id, String security_name, String security_type, String purchaseDate,
			double purchasePrice, int quantity) {
		super();
		Security_id = security_id;
		Security_name = security_name;
		Security_type = security_type;
		this.purchaseDate = purchaseDate;
		this.purchasePrice = purchasePrice;
		this.quantity = quantity;
	}

	//generate getters and setters
	public Long getSecurity_id() {
		return Security_id;
	}

	public void setSecurity_id(Long security_id) {
		Security_id = security_id;
	}

	public String getSecurity_name() {
		return Security_name;
	}

	public void setSecurity_name(String security_name) {
		Security_name = security_name;
	}

	public String getSecurity_type() {
		return Security_type;
	}

	public void setSecurity_type(String security_type) {
		Security_type = security_type;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
   
	public Set<PortfolioSecurity> getPortfolioSecurities() {
        return portfolioSecurities;
    }
}
