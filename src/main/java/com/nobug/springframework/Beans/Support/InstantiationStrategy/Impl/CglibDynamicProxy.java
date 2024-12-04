package com.nobug.springframework.Beans.Support.InstantiationStrategy.Impl;

import com.nobug.springframework.Beans.Support.InstantiationStrategy.InstantiationStrategy;
import com.nobug.springframework.Beans.config.BeanDefinition;

import java.lang.reflect.Constructor;

public class CglibDynamicProxy implements InstantiationStrategy {
	@Override
	public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws Exception {
		return null;
	}
}
