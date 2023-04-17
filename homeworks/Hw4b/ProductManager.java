package com.godoro.hw4b;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {

	private Connection connection;

	public ProductManager(Connection connection) {
		this.connection = connection;
	}

	public boolean insert(Product product) {
		String sql = """
				insert into product(productName, salesPrice) values(?, ?)
				""";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, product.getProductName());
			statement.setString(2, Double.toString(product.getSalesPrice()));
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		String sql = """
				update product
				set productName=?, salesPrice=?
				where productId=?
				""";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, product.getProductName());
			statement.setString(2, Double.toString(product.getSalesPrice()));
			statement.setString(3, Long.toString(product.getProductId()));
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(long productId) {
		String sql = """
				delete from product
				where productId=?
				""";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, Long.toString(productId));
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Product find(long productId) {
		String sql = """
				select * from product
				where productId=?
				""";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, productId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Long productID = resultSet.getLong("productId");
				String productName = resultSet.getString("productName");
				Double salesPrice = resultSet.getDouble("salesPrice");
				return new Product(productID, productName, salesPrice);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Product> findAll() {
		List<Product> products = new ArrayList<>();

		String sql = """
				select * from product
				""";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Long productID = resultSet.getLong("productId");
				String productName = resultSet.getString("productName");
				Double salesPrice = resultSet.getDouble("salesPrice");
				products.add(new Product(productID, productName, salesPrice));
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
