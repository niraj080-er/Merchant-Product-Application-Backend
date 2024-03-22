package org.jsp.merchantproductapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.merchantproductapp.dto.Merchant;
import org.jsp.merchantproductapp.dto.Product;

public class ProductDao {

	EntityManagerFactory factroy = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factroy.createEntityManager();

	// Save_Product
	public Product saveProduct(Product product, int merchant_id) {
		Merchant merchant = manager.find(Merchant.class, merchant_id);
		EntityTransaction transaction = manager.getTransaction();
		if (merchant != null) {
			product.setMertchant(merchant);
			merchant.getProducts().add(product);
			manager.persist(product);
			transaction.begin();
			transaction.commit();
			return product;
		}
		return null;
	}

	// Update_Product
	public Product updateProduct(Product product) {
		Product dbProduct = manager.find(Product.class, product.getId());
		EntityTransaction transaction = manager.getTransaction();
		if (dbProduct != null) {
			dbProduct.setBrand(product.getBrand());
			dbProduct.setCategory(product.getCategory());
			dbProduct.setCost(product.getCost());
			dbProduct.setDescription(product.getDescription());
			dbProduct.setImg_url(product.getImg_url());
			dbProduct.setName(product.getName());
			transaction.begin();
			transaction.commit();
			return product;

		}
		return null;
	}

// Find_Product_By_Merchant_Id
	public List<Product> findProductByMerchantID(int id) {
		Query q = manager.createQuery("select m.products from Merchant m where m.id=?1");
		q.setParameter(1, id);
		return q.getResultList();
	}

// FindProduct by Category
	public List<Product> findByCategory(String category) {
		Query q = manager.createQuery("select p from Product p where p.category=?1");
		q.setParameter(1, category);
		return q.getResultList();
	}

// Find Product by Brand
	public List<Product> findByBrand(String brand) {
		Query q = manager.createQuery("select p from Product p where p.brand=?1");
		q.setParameter(1, brand);
		return q.getResultList();
	}

}
