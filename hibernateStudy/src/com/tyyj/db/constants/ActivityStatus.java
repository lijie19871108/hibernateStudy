package com.tyyj.db.constants;

public enum ActivityStatus {

	δ��ʼ(1),
	������(2),
	�ѽ���(3);
	
	private int value;
	
	private ActivityStatus(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
}
