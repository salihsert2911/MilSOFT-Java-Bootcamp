package com.godoro.hw3b;

public class Test {

	public static void main(String[] args) {
		ProductScan productScan = new ProductScan();
		ProductFormat productFormat = new ProductFormat();
		Product product = productScan.scan();

		productFormat.print(product);
	}

}
