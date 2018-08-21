package com.uhg.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestSpring {

	public static void main(String[] args) {
		Product product = new Product(10, "Mobile", 10000.0f);

		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		Product product2 = (Product) factory.getBean("product");
		System.out.println("Product Name :" + product.getProductName());
		System.out.println("Product Name :" + product2.getProductName());

		User user = (User) factory.getBean("user");
		System.out.println("UserName :" + user.getUserName());

	}

}
