package com.marketingapp.entity;
import javax.persistence.*;
@Entity
@Table(name = "leads")//means that table name in DB will be leads but the Entity class Lead.
public class Lead {//when you don't want this class name the you write Annotation @Table.
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;  
	  //when field name and the column name not matching then we use annotation @Column
	  @Column(name ="first_name", nullable = false, length = 45)
	  private String firstName;//first_name = in database column like this  
	  @Column(name ="last_name", nullable = false, length = 45)
	  private String lastName;//last_name = in database column like this	  
	  @Column(name ="email", nullable = false, length = 128, unique = true)
	  private String email;//email = in database column like this   
	  @Column(name ="mobile", nullable = false, length = 10, unique = true)
	  private long mobile;//mobile = in database column like this 
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}	  
}
