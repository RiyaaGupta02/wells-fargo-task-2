package com.wellsfargo.counselor.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Portfolio {

	@Id
	@GeneratedValue
	@Column(name = "portfolio_id", nullable = false, unique = true)
	private Long portfolioId;
	//so here basically this portfolio_id is how the column in database i.e in mysql gonna be referred as 
	
	public String portfolioName;
	
	public String portfolioType;
	
	@ManyToOne
	@JoinColumn(name = "client_id", nullable =false)
	private Client client;
	//here unique = true nahi hai cos basically client id can be seen multiple times cos ek client can have multiple portfolios that hv unique ids
	//  It references the Client entity's primary key (Client_ID). The nullable = false ensures that this foreign key cannot be null.
	
	@OneToMany(mappedBy = "portfolio")
    private Set<PortfolioSecurity> portfolioSecurities = new HashSet<>();
	
	 @OneToMany(mappedBy = "portfolio")
	    private Set<PortfolioClient> portfolioClients = new HashSet<>();
	
	// Default constructor (required by JPA)
    protected Portfolio() {
    }
    
    //Constructor to initialize all instance variables
	public Portfolio(Long portfolioId, Client client, String portfolioName, String portfolioType) {
		super();
		this.portfolioId = portfolioId;
		this.client = client;
		this.portfolioName = portfolioName;
		this.portfolioType = portfolioType;
	}
	


	//getters ans setters
	public Long getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(Long portfolioId) {
		this.portfolioId = portfolioId;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public String getPortfolioType() {
		return portfolioType;
	}

	public void setPortfolioType(String portfolioType) {
		this.portfolioType = portfolioType;
	}
	
	public Set<PortfolioSecurity> getPortfolioSecurities() {
        return portfolioSecurities;
    }
    
	 public Set<PortfolioClient> getPortfolioClients() {
	        return portfolioClients;
	    }
	
}
