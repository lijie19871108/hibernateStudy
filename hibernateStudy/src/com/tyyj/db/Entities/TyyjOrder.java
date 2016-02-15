package com.tyyj.db.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.criteria.Order;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tyyj_order",catalog="",schema="tyyj")
public class TyyjOrder implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5149850973813633294L;
	@Id
	@Column(name="id",unique=true,length=50,nullable=false)
	@GenericGenerator(name="system-uuid",strategy="uuid.hex")
	@GeneratedValue(generator="system-uuid")
	private String id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="activity_id")
	private TyyjActivity activity;
	
	@Column(name="count", length=2, nullable=false)
	private int count;
	
	@Column(name="amount", length=8, nullable=false, columnDefinition="double(10,2) default '0.00'")
	private double amount;
	
	@Column(name="status", length = 2)
	private int status;
	
	@Column(name="join_ways", length=2)
	private int joinwway;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private TyyjUser buyer;
	
	public TyyjOrder(){}
	
	public TyyjOrder(String id){
		this.id = id;
	}
	public TyyjOrder(String id, TyyjActivity activity, int count, double amount, int status, int joinwway, TyyjUser user) {
		super();
		this.id = id;
		this.activity = activity;
		this.count = count;
		this.amount = amount;
		this.status = status;
		this.joinwway = joinwway;
		this.buyer = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TyyjActivity getActivity() {
		return activity;
	}

	public void setActivity(TyyjActivity activity) {
		this.activity = activity;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getJoinwway() {
		return joinwway;
	}

	public void setJoinwway(int joinwway) {
		this.joinwway = joinwway;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TyyjUser getBuyer() {
		return buyer;
	}

	public void setBuyer(TyyjUser buyer) {
		this.buyer = buyer;
	}
}
