package com.foxcreations.springtest.app.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Empleado implements Serializable  {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer  id ;
	@Column
	private   String fullName;
	@Column
	private  String  funtion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="boss", nullable = true) 
	private  Empleado boss;
	
   

	public Empleado(Integer id, String fullName, String funtion, Empleado boss) {

		this.id = id;
		this.fullName = fullName;
		this.funtion = funtion;
		this.boss = boss; 
	} 
	  

	public Empleado() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFuntion() {
		return funtion;
	}

	public void setFuntion(String funtion) {
		this.funtion = funtion;
	}

	public Empleado getBoss() {
		return boss;
	}

	public void setBoss(Empleado boss) {
		this.boss = boss;
	}


	
	
	
}
