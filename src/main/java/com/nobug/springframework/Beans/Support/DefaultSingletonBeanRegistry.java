package com.nobug.springframework.Beans.Support;


import com.nobug.springframework.Beans.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry<T> implements SingletonBeanRegistry {

	// 将实例化的单例保存在一个Map中
	Map<String, Object> beanDefinitionMap;
	{
		beanDefinitionMap = new HashMap<String, Object>();
	}

	protected void addSingleton(String beanName, Object singletonObject) {
		beanDefinitionMap.put(beanName, singletonObject);
	}

	// 从Map中取出单例
	@Override
	public Object getSingleton(String beanName) {
		return beanDefinitionMap.get(beanName);
	}
}
