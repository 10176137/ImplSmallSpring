package com.nobug.springframework.Beans.Support;

import com.nobug.springframework.Beans.config.BeanDefinition;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractBeansFactory extends DefaultSingletonBeanRegistry implements BeansFactory {

	@Override
	public Object getBean(String name) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
		// 获取bean单利，没有就注册
		Object bean = getSingleton(name);
		if (bean != null) {
			return bean;
		}

		BeanDefinition beanDefinition = getBeanDefinition(name);
		return createBean(name, beanDefinition, null);
	}

	@Override
	public Object getBean(String name, Object...args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
		Object bean = getSingleton(name);
		if (bean != null) {
			return bean;
		}

		BeanDefinition beanDefinition = getBeanDefinition(name);
		return createBean(name, beanDefinition, args);
	}

	protected abstract BeanDefinition getBeanDefinition(String beanName) throws RuntimeException;

	protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] objects) throws RuntimeException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException;
}
