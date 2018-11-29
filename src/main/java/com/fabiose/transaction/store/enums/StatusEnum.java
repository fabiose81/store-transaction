package com.fabiose.transaction.store.enums;

public enum StatusEnum {

	APROVED("Aproved"),CANCELED("Canceled"),REFUSED("Refused"),PROCESSING("Processing");
	
	private String value;
	
	StatusEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
