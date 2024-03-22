package org.jsp.merchantprductapp.controller;

import java.util.*;

import org.jsp.merchantproductapp.dao.ProductDao;
import org.jsp.merchantproductapp.dto.Product;


public class ProductController {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Add Product");
		System.out.println("2.Update product");
		System.out.println("3.Find Products By Merchant Id");
		System.out.println("4.Find Products By Brand");
		System.out.println("5.Find Products By Category");
		switch (sc.nextInt()) {
		case 1: {
			Product product = new Product();
			System.out.println("Enter the MerchantId to Add the product");
			int merchant_id=sc.nextInt();
			System.out.println("Enter the Product Name ");
			product.setName(sc.next());
			System.out.println("Enter the Product Brand Name ");
			product.setBrand(sc.next());
			System.out.println("Enter the Product Category ");
			product.setCategory(sc.next());
			System.out.println("Enter the Product Description ");
			product.setDescription(sc.next());
			System.out.println("Enter the Product Cost ");
			product.setCost(sc.nextDouble());
			System.out.println("Enter the Product IMG_URL ");
			product.setImg_url(sc.next());
			product=productDao.saveProduct(product, merchant_id);
			if(product != null) {
				System.out.println("Product added with Id:" + product.getId());
			}
			else
				System.err.println("cannot add product as Merchant Id is Invalid");
			break;
		}
		case 2:{
			Product product = new Product();
			System.out.println("Enter the ID");
			product.setId(sc.nextInt());
			System.out.println("Enter the Product Name ");
			product.setName(sc.next());
			System.out.println("Enter the Product Brand Name ");
			product.setBrand(sc.next());
			System.out.println("Enter the Product Category ");
			product.setCategory(sc.next());
			System.out.println("Enter the Product Description ");
			product.setDescription(sc.next());
			System.out.println("Enter the Product Cost ");
			product.setCost(sc.nextDouble());
			System.out.println("Enter the Product IMG_URL ");
			product.setImg_url(sc.next());
			product=productDao.updateProduct(product);
			if (product != null)
				System.out.println("Product  with Id:" + product.getId() + " updated");
			else
				System.err.println("cannot add product as Id is Invalid");
			break;
		}
		case 3:{
			System.out.println("Enter the Merchant id to find the Product ");
			int merchant_id=sc.nextInt();
			List<Product> products = productDao.findProductByMerchantID(merchant_id);
			if(products.isEmpty()) {
				System.err.println("Invalid Merchant Id or No Product Found for the Given Merchant ID");
			}else {
				for (Product product : products)
					System.out.println(product);
			}
			break;
		}
		case 4:{
			System.out.println("Enter the Brand Name to Find the Product");
			String brand=sc.next();
			List<Product> products=productDao.findByBrand(brand);
			if(products.isEmpty()) {
				System.out.println("Invalid Brand Name ");
			}else {
				for (Product product : products)
					System.out.println(product);
			}
			break;
		}
		case 5:{
			System.out.println("Enter the Category Name to find the Product");
			String category=sc.next();
			List<Product> products=productDao.findByCategory(category);
			if(products.isEmpty()) {
				System.out.println("Invalid Product category ");
			}else {
				for (Product product : products)
					System.out.println(product);
			}
			break;
			}
		}
		sc.close();
	}
}

