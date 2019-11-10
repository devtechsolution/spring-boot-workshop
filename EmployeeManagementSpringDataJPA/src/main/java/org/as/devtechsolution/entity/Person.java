package org.as.devtechsolution.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Aditya
 *
 */
@Entity
@Table(name="person_table")
@NamedQueries(value = { 
		@NamedQuery(name = "Person.getByLastName", 
				query = "SELECT p FROM Person p WHERE p.lastName=?1"),
		@NamedQuery(name = "Person.getByFirstNameAndEmail", 
		query = "SELECT p FROM Person p WHERE p.firstName=?1 AND email=?2")
		
})
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="person_id")
	private int id;
	@Column(name="first_name", length=60, nullable=false)
	private String firstName;
	@Column(name="last_name", length=60, nullable=false)
	private String lastName;
	@Column(name="email", unique=true)
	private String email;
	@Column(name="creation_date")
	private Date creationDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", creationDate=" + creationDate + "]";
	}
	
	
	
	

}
