package com.godoro.hw3b;

import java.util.Scanner;

public class ProductScan {

	Scanner scan;

	public ProductScan() {
		scan = new Scanner(System.in);
	}

	public Product scan() {
		Product product = new Product();
		System.out.println("Product nesnesinin fieldlarını giriniz.");
		System.out.println("productId(long):");
		product.setProductId(scan.nextLong());

		System.out.println("productName(String):");
		product.setProductName(scan.next());

		System.out.println("salesPrice(double):");
		product.setSalesPrice(scan.nextDouble());

		scan.close();

		return product;
	}
}
