package com.tyyj.db.constants;

public enum ActivityStatus {

	未开始(1),
	进行中(2),
	已结束(3);
	
	private int value;
	
	private ActivityStatus(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
}
