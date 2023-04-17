package com.godoro.hw3a;

public class ProductConverter {
	public String format(Product product) {
		return product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice();
	}

	public Product parse(String line) {
		String[] tokens = line.split(" ");
		return new Product(Long.parseLong(tokens[0]), tokens[1], Double.parseDouble(tokens[2]));
	}
}
