package com.langtaojin.myjpetstore.mapper;

import java.util.List;

import com.langtaojin.myjpetstore.domain.Product;

public interface ProductMapper {

	List<Product> getProductListByCategory(String categoryId);
	
	Product getProduct(String productId);
	
	List<Product> searchProductList(String keywords);
	
}
