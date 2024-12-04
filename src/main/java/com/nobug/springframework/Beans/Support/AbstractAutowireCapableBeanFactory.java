package com.nobug.springframework.Beans.Support;

import com.nobug.springframework.Beans.Support.InstantiationStrategy.Impl.JdkDynamicProxy;
import com.nobug.springframework.Beans.Support.InstantiationStrategy.InstantiationStrategy;
import com.nobug.springframework.Beans.config.BeanDefinition;
import com.nobug.springframework.Beans.config.BeanReference;
import com.nobug.springframework.Beans.config.Properties;
import com.nobug.springframework.Beans.config.Property;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeansFactory {
	InstantiationStrategy instantiationStrategy = new JdkDynamicProxy();

	// 调用实例化策略
	@Override
	protected abstract BeanDefinition getBeanDefinition(String beanName) throws RuntimeException;

	protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
		Class<?> beanClass = beanDefinition.getBeanClass();
		Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
		List<Object> list = Arrays.stream(declaredConstructors).map(constructor -> {
			if (args != null && constructor.getParameterTypes().length == args.length) {
				try {
					return instantiationStrategy.instantiate(beanDefinition, beanName, constructor, args);
				} catch (Exception e) {
					return null;
				}
			}
			else if(args == null){
				try {
					return instantiationStrategy.instantiate(beanDefinition, beanName, null, null);
				} catch (Exception e) {
					return null;
				}
			}
			return null;
		}).toList();
		return list.getFirst();
	}

	@Override
	protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws RuntimeException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
		Object beanInstance = createBeanInstance(beanDefinition, beanName, args);
		applyPropertyValues(beanName, beanInstance, beanDefinition);
		addSingleton(beanName, beanInstance);
		return beanInstance;
	}

	protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
		Properties property = beanDefinition.getProperties();
		if (property.getSize() > 0) {
			for (Property propertyValue : property.getPropertyValues()) {
				String name = propertyValue.getName();
				Object value = propertyValue.getValue();

				if (value.getClass().getName().equals(BeanReference.class.getName())) {
					// A 依赖 B，获取 B 的实例化
					BeanReference beanReference = (BeanReference) value;
					// 因为已经注册到BeanDefinition中了所以可以通过bean id
					value = getBean(beanReference.getBeanName());
				}
				// 属性填充
				Field declaredField = bean.getClass().getDeclaredField(name);
				declaredField.setAccessible(true);
				declaredField.set(bean, value);
			}
		}
	}
}
