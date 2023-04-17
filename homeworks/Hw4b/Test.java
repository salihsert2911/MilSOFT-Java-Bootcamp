package com.godoro.hw4b;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost/godorodb";
			String user = "root";
			String password = "Hingal-291140";
			Connection connection = DriverManager.getConnection(url, user, password);

			ProductManager manager = new ProductManager(connection);

			Product product1 = new Product(1, "Cep telefonu", 10);
			Product product2 = new Product(2, "Televizyon", 20);
			Product product3 = new Product(3, "Araba", 50);

//			// insert test
//			manager.insert(product1);
//			manager.insert(product2);
//			manager.insert(product3);
//			
//			// update test
//			product1.setSalesPrice(45);
//			manager.update(product1);
//			product2.setSalesPrice(60);
//			manager.update(product2);

//			// delete test
//			manager.delete(2);

//			// find test
//			Product product = manager.find(1);
//			System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());

//			// findAll test
//			List<Product> products = manager.findAll();
//			for (Product product : products) {
//				System.out.println(
//						product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
