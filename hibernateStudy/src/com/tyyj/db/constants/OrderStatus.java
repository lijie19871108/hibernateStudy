package com.tyyj.db.constants;

import javax.persistence.GeneratedValue;

public enum OrderStatus {

	已生成(1),
	已付款(2),
	已消费(3),
	已完成(4);
	
	private int value;
	
	OrderStatus(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
