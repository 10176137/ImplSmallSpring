package com.nobug.springframework.Beans.Support.InstantiationStrategy.Impl;

import com.nobug.springframework.Beans.Support.InstantiationStrategy.InstantiationStrategy;
import com.nobug.springframework.Beans.config.BeanDefinition;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class JdkDynamicProxy implements InstantiationStrategy {
	@Override
	public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws RuntimeException {
		Class clazz = beanDefinition.getBeanClass();
		try {
			if (null != ctor) {
				Constructor declaredConstructor = clazz.getDeclaredConstructor(ctor.getParameterTypes());
				declaredConstructor.setAccessible(true);
				return declaredConstructor.newInstance(args);
			} else {
				Constructor declaredConstructor = clazz.getDeclaredConstructor();
				declaredConstructor.setAccessible(true);
				return declaredConstructor.newInstance();
			}
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
		         InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
