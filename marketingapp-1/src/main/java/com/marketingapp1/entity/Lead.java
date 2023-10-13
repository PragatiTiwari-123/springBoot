package com.marketingapp1.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "leads")
public class Lead {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
       private long id;
	   
//	   when the field name (firstName)(camel case) and column name (first_name)(Snake case)
//	   is not matching then use annotation @Column
	   //nullable means you cannot keep first name null
	   //unique: you cannot repeat same email which is registered
	   
	   @NotNull
	   @Size(min = 2, message = "Name should be atleast 2 character")
	   @Column(name = "first_name", nullable = false, length = 45)
	   private String firstName;//first_name
       
	   @NotNull
	   @Size(min = 2, message = "Name should be atleast 2 character")
	   @Column(name = "last_name", nullable = false, length = 45)
	   private String lastName;//last_name
     
	   @Email
	   @Column(name = "email", nullable = false, length = 128,unique = true)
	   private String email;//email
	   
	   @Pattern(regexp = "\\d{10}", message = "Invalid phone number. It must me 10 digit")
	   @Column(name = "mobile", nullable = false, length = 10, unique = true)
	   private String mobile;//mobile

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	    
}
