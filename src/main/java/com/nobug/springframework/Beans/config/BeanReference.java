package com.nobug.springframework.Beans.config;

public class BeanReference {
	private String beanName;
	public BeanReference(String beanName) {
		this.beanName = beanName;
	}
	public String getBeanName() {
		return beanName;
	}
}
