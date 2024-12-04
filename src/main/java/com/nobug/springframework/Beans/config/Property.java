package com.nobug.springframework.Beans.config;

public class Property {
	private String propertyName;
	private Object propertyValue;
	public Property(String name, Object value) {
		this.propertyName = name;
		this.propertyValue = value;
	}
	public String getName() {
		return propertyName;
	}
	public void setName(String name) {
		this.propertyName = name;
	}
	public Object getValue() {
		return propertyValue;
	}
	public void setValue(String value) {
		this.propertyValue = value;
	}
}
