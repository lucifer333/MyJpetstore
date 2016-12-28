package com.langtaojin.myjpetstore.mapper;

import java.util.List;

import com.langtaojin.myjpetstore.domain.Category;

public interface CategoryMapper {

	List<Category> getCategoryList();
	
	Category getCategory(String categoryId);
	
}
