package com.car;


import java.util.Date;
import java.util.List;

public class User {
    
    
    private String firstname;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;     
    private String creditcard ;
    private Date soldDate ;

    public User() {
		// TODO Auto-generated constructor stub
	}
   
 public String toString() {
    	
    	return this.firstname + "_"+  this.lastName + "_"+ 
        this.email+ "_"+ 
        this.phoneNumber + "_"+ 
        this.address + "_"+ 
        this.creditcard + "_" +
        this.soldDate;
	}
          
  
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	public Date getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}

	
   
}