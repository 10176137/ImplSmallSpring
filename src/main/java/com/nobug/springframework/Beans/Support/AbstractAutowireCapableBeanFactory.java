package com.nobug.springframework.Beans.Support;

import com.nobug.springframework.Beans.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeansFactory {

	@Override
	protected abstract BeanDefinition getBeanDefinition(String beanName) throws RuntimeException;
	@Override
	protected Object createBean(String beanName, BeanDefinition beanDefinition) throws RuntimeException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		Constructor<?> declaredConstructor = beanDefinition.getBeanClass().getDeclaredConstructor();
		declaredConstructor.setAccessible(true);
		Object bean = declaredConstructor.newInstance();
		addSingleton(beanName, bean);
		return bean;
	}
}
