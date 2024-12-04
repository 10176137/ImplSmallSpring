package com.nobug.springframework.Beans.Support;

import com.sun.jdi.connect.Connector;

import java.lang.reflect.InvocationTargetException;

public interface BeansFactory {

	// 通过名字获取Bean实例,无参构造
	Object getBean(String name) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException;
	// 有参构造
	Object getBean(String name, Object...args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException;
}
