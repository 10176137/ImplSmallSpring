package com.nobug.springframework.Beans.Support;

import java.lang.reflect.InvocationTargetException;

public interface BeansFactory {

	// 通过名字获取Bean实例
	Object getBean(String name) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
