package com.car;


import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;


public class Car implements Comparable<Car>{

    private int id;
    private String license;
    private String year;
    private String carType; 
    private String model;   
	private String make;    
	private String miles;
    private String color;
    private String bodyType;  
    private String oldPriceStr;
    
    private String discountStr;
    
    private String newPriceStr; 
    
    
    private Double oldPrice;
     
    private double discount;
    
    private Double newPrice; 
    private String deliveredDate;     
	private String  boughtDate;
    private String  soldDate; 
    
    private boolean isSold;  
    private boolean isdiscounted;
    
    
    private double minPrice;
   
    private double maxPrice;
    private String report;
    
    private User user;
    private loginUser loginUser;
    
    
    public Car() {}
	

    public String toString() {
    	
    	return this.carType + "_" + this.license +"_"+ this.make+ "_" + this.bodyType+ "_" + this.color+  "_" +this.year +  "_" + this.miles+  "_" +
    	this.oldPrice +  "_" + this.discount + "_"+ this.newPrice +  "_"+  this.boughtDate + " %"; 
	}
      
 public String print1() {
    	
    	return this.carType+"_"+ this.license+"_"+ this.make+ "_" + this.bodyType+ "_" + this.color+  "_" +this.year +  "_" + this.miles+  "_" + 
    	 this.oldPriceStr + "_" + this.discountStr + "_"+ this.newPriceStr +  "_"+  this.boughtDate +  "_"+ this.user +" %"; 
	}
 
 public String print2() {
	 	
	 	return this.loginUser.toString() ;
		}  

	public double getMinPrice() {
		return minPrice;
	}


	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}


	public double getMaxPrice() {
		return maxPrice;
	}


	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}


	public String getOldPriceStr() {
		return oldPriceStr;
	}


	public void setOldPriceStr(String oldPriceStr) {
		this.oldPriceStr = oldPriceStr;
	}


	public String getDiscountStr() {
		return discountStr;
	}


	public void setDiscountStr(String discountStr) {
		this.discountStr = discountStr;
	}


	public String getNewPriceStr() {
		return newPriceStr;
	}


	public void setNewPriceStr(String newPriceStr) {
		this.newPriceStr = newPriceStr;
	}


	public Double getOldPrice() {
		return oldPrice;
	}


	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}


	public Double getNewPrice() {
		return newPrice;
	}


	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}


	
	public boolean isIsdiscounted() {
		return isdiscounted;
	}


	public void setIsdiscounted(boolean isdiscounted) {
		this.isdiscounted = isdiscounted;
	}


	public String getLicense() {
		return license;
	}


	public void setLicense(String license) {
		this.license = license;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getDeliveredDate() {
		return deliveredDate;
	}


	public void setDeliveredDate(String deliveredDate) {
		this.deliveredDate = deliveredDate;
	}


	public String getBoughtDate() {
		return boughtDate;
	}


	public void setBoughtDate(String boughtDate) {
		this.boughtDate = boughtDate;
	}


	public String getSoldDate() {
		return soldDate;
	}


	public void setSoldDate(String soldDate) {
		this.soldDate = soldDate;
	}


    public String getMiles() {
		return miles;
	}

	public void setMiles(String miles) {
		this.miles = miles;
	}
	private String image;
    
  
   
    public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
      
   
	public String getCarType() {
		return carType;
	}


	public void setCarType(String carType) {
		this.carType = carType;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isSold() {
		return isSold;
	}
	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}
	
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	public String getReport() {
		return report;
	}


	public void setReport(String report) {
		this.report = report;
	}
	

public loginUser getLoginUser() {
		return loginUser;
	}


	public void setLoginUser(loginUser loginUser) {
		this.loginUser = loginUser;
	}


@Override
public int compareTo(Car o) {
	return o.user.getSoldDate().compareTo (this.user.getSoldDate());
}
}
