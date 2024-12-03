package com.nobug.springframework.Beans.Support;

import com.nobug.springframework.Beans.config.BeanDefinition;

import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

	private Map<String, BeanDefinition> beanDefinitionMap = new LinkedHashMap<String, BeanDefinition>();
	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName, beanDefinition);
	}

	@Override
	protected BeanDefinition getBeanDefinition(String beanName) throws RuntimeException {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		return beanDefinition;
	}
}
