package com.wellsfargo.counselor.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Client {
	
	@Id
	@GeneratedValue
	@Column(name = "ClientID", nullable = false, unique = true)
	private long ClientID;
	
	@Column(nullable = false)
	private String Client_name;
	
	@Column(nullable = false)
	private String Client_email;
	
	@Column(nullable = false)
	private String Client_phone;
	
	@ManyToOne
	@JoinColumn(name = "financial_advisor_id", nullable = false)
	private FinancialAdvisor financialAdvisor;
	//this refers to the entity i.e. FinancialAdvisor considering in it we have  primary key (FinancialAdvisor_ID)

	@OneToMany(mappedBy = "client")
    private Set<PortfolioClient> portfolioClients = new HashSet<>();
	
	protected Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Client(long clientID, String client_name, String client_email, String client_phone,
			FinancialAdvisor financialAdvisor) {
		super();
		ClientID = clientID;
		Client_name = client_name;
		Client_email = client_email;
		Client_phone = client_phone;
		this.financialAdvisor = financialAdvisor;
	}



	public long getClientID() {
		return ClientID;
	}

	public void setClientID(long clientID) {
		ClientID = clientID;
	}

	public String getClient_name() {
		return Client_name;
	}

	public void setClient_name(String client_name) {
		Client_name = client_name;
	}

	public String getClient_email() {
		return Client_email;
	}

	public void setClient_email(String client_email) {
		Client_email = client_email;
	}

	public String getClient_phone() {
		return Client_phone;
	}

	public void setClient_phone(String client_phone) {
		Client_phone = client_phone;
	}

	public FinancialAdvisor getFinancialAdvisor() {
		return financialAdvisor;
	}

	public void setFinancialAdvisor(FinancialAdvisor financialAdvisor) {
		this.financialAdvisor = financialAdvisor;
	}
	
	public Set<PortfolioClient> getPortfolioClients() {
        return portfolioClients;
    }
	//This establishes a bidirectional relationship where each PortfolioClient record links to a specific Portfolio and 
	// Client, and each Portfolio and Client can have multiple associated PortfolioClient records.
	//This example assumes that a FinancialAdvisor can have multiple clients, 
	// and each client belongs to one financial advisor.
	
}
