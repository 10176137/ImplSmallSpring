import com.nobug.springframework.Beans.Support.DefaultListableBeanFactory;
import com.nobug.springframework.Beans.config.BeanDefinition;
import com.nobug.springframework.Beans.config.BeanReference;
import com.nobug.springframework.Beans.config.Properties;
import com.nobug.springframework.Beans.config.Property;

import java.lang.reflect.InvocationTargetException;

public class beanstest {
	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		BeanDefinition beanDefinition = new BeanDefinition(Person.class);
		factory.registerBeanDefinition("person", beanDefinition);
		Person person = (Person)factory.getBean("person", "马保国", 114);
		Properties propertyValues = new Properties();
		propertyValues.addProperty(new Property("name", "10001"));
		propertyValues.addProperty(new Property("person", new BeanReference("person")));
		BeanDefinition beanDefinition2 = new BeanDefinition(Person2.class, propertyValues);
		factory.registerBeanDefinition("person2", beanDefinition2);
		System.out.println(person);
		person.age=114514;
		person.name="马保国";
		Person2 person2 = (Person2)factory.getBean("person2");
		System.out.println(person2);
	}
}

class Person {
	public String name;
	public Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Person() {
		name = "蔡徐坤";
		age = 180;
	}

	@Override
	public String toString() {
		return name + ":" + age;
	}
}
class Person2 {
	public String name;
	public Integer age;
	public Person person;
	public Person2() {
	}
}