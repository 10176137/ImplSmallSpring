package BeanReferenceTest;

import org.junit.Test;


public class beantest {
	@Test
	public void test(){
		String we= "111514";
		Object o = we;

		System.out.println(o.getClass().isAssignableFrom(String.class));
	}
}
