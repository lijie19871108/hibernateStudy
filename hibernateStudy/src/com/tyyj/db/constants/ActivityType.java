package com.tyyj.db.constants;

public enum ActivityType {

	���� (0),
	����(1),
	��ͥ(2),
	���(3);
	
	private int value;
	
	ActivityType(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
}
