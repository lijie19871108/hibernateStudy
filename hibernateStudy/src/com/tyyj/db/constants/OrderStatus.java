package com.tyyj.db.constants;

import javax.persistence.GeneratedValue;

public enum OrderStatus {

	������(1),
	�Ѹ���(2),
	������(3),
	�����(4);
	
	private int value;
	
	OrderStatus(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
