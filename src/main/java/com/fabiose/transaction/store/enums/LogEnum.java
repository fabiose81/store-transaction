package com.fabiose.transaction.store.enums;

public enum LogEnum {

	DEBUG("Debug"), ERROR("Error");

	private String value;

	LogEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
