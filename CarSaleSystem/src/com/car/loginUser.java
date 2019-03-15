package com.car;

public class loginUser {
	 private String userName;
	    private  String password;  
	    private  String userEmail;
	    
	    public String print2()  {
	     	
	     	return this.userName + "_"+  this.password + "_"+ 
	         this.userEmail+ "%";
	    	}
	    
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		} 
	    
}
