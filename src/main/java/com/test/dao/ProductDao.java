package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import com.test.dao.util.ConnectionUtil;
import com.test.model.*;

public class ProductDao {

	private static final Logger log;

	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
		log = Logger.getLogger(ConnectionUtil.class.getName());
	}

	public List<Product> fetchAll() {
		Connection conn;
		List<Product> products = new ArrayList();
		try {
			conn = ConnectionUtil.getConnection();
			log.info("Read data");
			PreparedStatement readStatement = conn.prepareStatement("SELECT * FROM dbo.product;");
			ResultSet resultSet = readStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getLong("id"));
				product.setDescription(resultSet.getString("description"));
				product.setName(resultSet.getString("name"));
				log.info("Data read from the database: " + product.toString());
				products.add(product);
			}
		} catch (Exception e) {
			log.info("Error occurred: " + e.getMessage());
		}

		return products;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	/*public void create(Product product) {
		products.add(product);

	}

	public void update(Product product) {

		for (Product item : products) {
			if (item.getId() == product.getId()) {
				products.remove(item);
				products.add(product);
			}

		}
	}*/

	public Product fetchBy(long id) {
		for (Product product : fetchAll()) {
			if (id == product.getId()) {
				return product;
			}
		}
		System.out.println("Resource not found with Id :: " + id);
		return null;
	}

}
