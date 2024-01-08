package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "portfolio_client")
public class PortfolioClient {

	@Id
    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @Id
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    
    @ManyToOne
    @JoinColumn(name = "financial_advisor_id", nullable = false)
    private FinancialAdvisor financialAdvisor;

    @Id
    @GeneratedValue
    @Column(name = "portClient_id", nullable = false, unique = true)
    private Long Port_ClientId;

	public PortfolioClient(Long port_ClientId) {
		super();
		Port_ClientId = port_ClientId;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getPort_ClientId() {
		return Port_ClientId;
	}

	public void setPort_ClientId(Long port_ClientId) {
		Port_ClientId = port_ClientId;
	}
    
	  public FinancialAdvisor getFinancialAdvisor() {
	        return financialAdvisor;
	    }

	    public void setFinancialAdvisor(FinancialAdvisor financialAdvisor) {
	        this.financialAdvisor = financialAdvisor;
	    }
    
}
