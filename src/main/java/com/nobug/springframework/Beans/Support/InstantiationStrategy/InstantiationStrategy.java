package com.nobug.springframework.Beans.Support.InstantiationStrategy;

import com.nobug.springframework.Beans.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
	Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws Exception;
}
