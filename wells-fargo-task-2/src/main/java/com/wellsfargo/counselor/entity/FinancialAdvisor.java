package com.wellsfargo.counselor.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class FinancialAdvisor {
	
	@Id
	@GeneratedValue
	@Column(name = "FinancialAdvisor_ID", nullable = false, unique = true)
	private long FinancialAdvisor_ID;
	//here the above column means specifying separate column as FA_id karke then nullable = false means no null values allowes
	// as well as unique = true means each FA has a unique identifier
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String phone;
	
	 @OneToMany(mappedBy = "financialAdvisor", cascade = CascadeType.ALL)
	    private List<Client> clients;
	 
	 @OneToMany(mappedBy = "financialAdvisor")
	    private Set<PortfolioClient> portfolioClients = new HashSet<>();
	 
	// Default constructor (required by JPA)
    protected FinancialAdvisor() {
    }
    
 // Constructor to initialize all instance variables
    public FinancialAdvisor(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    //Getter and setter for the properties of it 
    //here FA_ID has only getter & no setter cos 
	public long getFinancialAdvisor_ID() {
		return FinancialAdvisor_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Set<PortfolioClient> getPortfolioClients() {
        return portfolioClients;
    }
    
}
