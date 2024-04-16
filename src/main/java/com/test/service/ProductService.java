package com.test.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import com.test.dao.ProductDao;
import com.test.model.Product;

public class ProductService {

	private List<Product> products = new ArrayList<Product>();
	private ProductDao dao = new ProductDao();
	public List<Product> fetchAll() {
		/*
		 * products.add(new Product(100, "Laptop", "Portable Device")); products.add(new
		 * Product(101, "Washing Machine", "Useful Device")); products.add(new
		 * Product(102, "Refrigerator", "Useful Device"));
		 */
		
		return dao.fetchAll();
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public void create(Product product) {
		products.add(product);
		
	}

	public void update(Product product) {

		for (Product item : products) {
			if(item.getId() == product.getId()) {
				products.remove(item);
				products.add(product);
			}
				
		}
	}
	
	public Product fetchBy(long id) {
        for (Product product :  fetchAll()) {
             if (id == product.getId()) {
                return product;
             }
         }
        System.out.println("Resource not found with Id :: " + id); 
         return null;
     }

	
}
