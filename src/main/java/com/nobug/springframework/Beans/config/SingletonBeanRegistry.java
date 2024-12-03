package com.nobug.springframework.Beans.config;

public interface SingletonBeanRegistry {
	Object getSingleton(String beanName);
}
