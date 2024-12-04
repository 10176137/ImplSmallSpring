package com.nobug.springframework.Beans.config;

public class BeanDefinition {

	//  这里存储的是Class类而不是实例对象，先保存Class，等需要的时候再创建
	private Class<?> beanClass;
	private Properties properties;

	public BeanDefinition(Class<?> beanClass) {
		this.beanClass = beanClass;
		this.properties = new Properties();
	}

	public BeanDefinition(Class<?> beanClass, Properties properties) {
		this.beanClass = beanClass;
		this.properties = properties != null ? properties : new Properties();
	}

	public Class<?> getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class<?> beanClass) {
		this.beanClass = beanClass;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}


}
