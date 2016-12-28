package com.langtaojin.myjpetstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.langtaojin.myjpetstore.domain.Category;
import com.langtaojin.myjpetstore.domain.Item;
import com.langtaojin.myjpetstore.domain.Product;
import com.langtaojin.myjpetstore.mapper.CategoryMapper;
import com.langtaojin.myjpetstore.mapper.ItemMapper;
import com.langtaojin.myjpetstore.mapper.ProductMapper;

public class CatalogService {

	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ProductMapper productMapper;
	
	public List<Category> getCategoryList() {
		return categoryMapper.getCategoryList();
	}
	
	public Category getCategory(String categoryId) {
		return categoryMapper.getCategory(categoryId);
	}
	
	public Product getProduct(String productId) {
		return productMapper.getProduct(productId);
	}
	
	public List<Product> getProductListByCategory(String categoryId) {
		return productMapper.getProductListByCategory(categoryId);
	}
	
	public List<Product> searchProductList(String keywords) {
		List<Product> products=new ArrayList<>();
		for(String keyword : keywords.split("\\s+")){
			products.addAll(productMapper.searchProductList("%"+keyword.toLowerCase()+"%"));
		}
		return products;
	}
	
	public List<Item> getItemListByProduct(String productId) {
		return itemMapper.getItemListByProduct(productId);
	}
	
	public Item getItem(String itemId) {
		return itemMapper.getItem(itemId);
	}
	
	public boolean isItemInStock(String itemId) {
		return itemMapper.getInventoryQuantity(itemId) > 0 ;
	}
	
}
