package com.tyyj.db.Entities;
// Generated 2016-1-26 23:21:05 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TyyyjManor generated by hbm2java
 */
@Entity
@Table(name="tyyj_manor")
public class TyyjManor implements java.io.Serializable {

	@Id
	@Column(name="id",unique=true,length=50,nullable=false)
	@GenericGenerator(name="system-uuid",strategy="uuid.hex")
	@GeneratedValue(generator="system-uuid")
	private String id;
	
	@Column(name="name",length=100, nullable=false)
	private String name;
	
	@Column(name="address",length=200, nullable=false)
	private String address;
	
	@Column(name="contactWays",length=2, nullable=true)
	private String contactWays;
	
	@Column(name="contactor",length=20, nullable=true)
	private String contactor;
	
	@Column(name="status",length=2, nullable=false)
	private Integer status;

	public TyyjManor() {
	}

	public TyyjManor(String id) {
		this.id = id;
	}

	public TyyjManor(String id, String name, String address, String contactWays, String contactor, Integer status) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.contactWays = contactWays;
		this.contactor = contactor;
		this.status = status;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactWays() {
		return this.contactWays;
	}

	public void setContactWays(String contactWays) {
		this.contactWays = contactWays;
	}

	public String getContactor() {
		return this.contactor;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}