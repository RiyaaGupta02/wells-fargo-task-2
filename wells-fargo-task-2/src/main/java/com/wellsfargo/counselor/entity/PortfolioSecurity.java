package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "portfolio_security")
public class PortfolioSecurity {

	@Id
    @GeneratedValue
    @Column(name = "portfoliosecurityID", nullable = false, unique = true)
    private Long Port_SecId;
	
	@ManyToOne
    @JoinColumn(name = "portfolioId", nullable = false)
    private Portfolio portfolio;
	//many portfolios can have one kind of security to them

	 @ManyToOne
	    @JoinColumn(name = "security_id")
	    private Security security;
	 
	public PortfolioSecurity(Long port_SecId, Portfolio portfolio, Security security) {
		super();
		Port_SecId = port_SecId;
		this.portfolio = portfolio;
		this.security = security;
	}

	public Long getPort_SecId() {
		return Port_SecId;
	}

	public void setPort_SecId(Long port_SecId) {
		Port_SecId = port_SecId;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}
	 
	
}
