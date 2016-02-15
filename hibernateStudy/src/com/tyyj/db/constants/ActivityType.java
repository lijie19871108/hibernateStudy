package com.tyyj.db.constants;

public enum ActivityType {

	组团 (0),
	个人(1),
	家庭(2),
	结对(3);
	
	private int value;
	
	ActivityType(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
}
