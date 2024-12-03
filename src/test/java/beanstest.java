import com.nobug.springframework.Beans.Support.DefaultListableBeanFactory;
import com.nobug.springframework.Beans.config.BeanDefinition;

import java.lang.reflect.InvocationTargetException;

public class beanstest {
	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		BeanDefinition beanDefinition = new BeanDefinition(Person.class);
		factory.registerBeanDefinition("person", beanDefinition);
		Person person = (Person)factory.getBean("person");
		System.out.println(person);
		person.age=114514;
		person.name="马保国";
		Person person2 = (Person)factory.getBean("person");
		System.out.println(person2);
	}
}

class Person {
	public String name;
	public int age;

	public Person(String name, int age) {
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