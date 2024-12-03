package com.nobug.springframework.Beans.Support;

import com.nobug.springframework.Beans.config.BeanDefinition;

public interface BeanDefinitionRegistry {
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
