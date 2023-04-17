package com.godoro.hw3a;

public class ConverterTest {
	public static void main(String[] args) {
		ProductConverter converter = new ProductConverter();
		Product product = new Product(1, "Telefon", 15.0);

		String formatted = converter.format(product);
		System.out.println(formatted);

		Product product2 = converter.parse(formatted);
		System.out.println(product2.getProductId() + " " + product2.getProductName() + " " + product2.getSalesPrice());
	}
}
