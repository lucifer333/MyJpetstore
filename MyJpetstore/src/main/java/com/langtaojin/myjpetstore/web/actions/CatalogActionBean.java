package com.langtaojin.myjpetstore.web.actions;

import java.util.List;

import com.langtaojin.myjpetstore.domain.Category;
import com.langtaojin.myjpetstore.domain.Item;
import com.langtaojin.myjpetstore.domain.Product;
import com.langtaojin.myjpetstore.service.CatalogService;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.SessionScope;
import net.sourceforge.stripes.integration.spring.SpringBean;

@SessionScope
public class CatalogActionBean extends AbstractActionBean{

	private static final long serialVersionUID = -7214893855938725226L;

	private static final String MAIN="/WEB-INF/jsp/catalog/Main.jsp";
	private static final String VIEW_CATEGORY="/WEB-INF/jsp/catalog/Category.jsp";
	private static final String VIEW_PRODUCTS="/WEB-INF/jsp/catalog/Product.jsp";
	private static final String VIEW_ITEM="/WEB-INF/jsp/catalog/Item.jsp";
	private static final String SEARCH_PRODUCTS="/WEB-INF/jsp/catalog/SearchProducts.jsp";
	
	@SpringBean
	private transient CatalogService catalogService;
	
	private String keyword;
	
	private String categoryId;
	private Category category;
	private List<Category> categoryList;
	
	private String productId;
	private Product product;
	private List<Product> productList;
	
	private String itemId;
	private Item item;
	private List<Item> itemList;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	@DefaultHandler
	public ForwardResolution viewMain(){
		return new ForwardResolution(MAIN);
	}
	
	public ForwardResolution viewCategory() {
		if(categoryId!=null){
			productList=catalogService.getProductListByCategory(categoryId);
			category=catalogService.getCategory(categoryId);
		}
		return new ForwardResolution(VIEW_CATEGORY);
	}
	
	public ForwardResolution viewProduct() {
		if(productId!=null){
			itemList=catalogService.getItemListByProduct(productId);
			product=catalogService.getProduct(productId);
		}
		return new ForwardResolution(VIEW_PRODUCTS);
	}
	
	public ForwardResolution viewItem() {
		item=catalogService.getItem(itemId);
		product=item.getProduct();
		return new ForwardResolution(VIEW_ITEM);
	}
	
	public ForwardResolution searchProducts() {
		if(keyword == null || keyword.length()<1){
			setMessage("Please enter a ketword to search for,then press the search button");
			return new ForwardResolution(ERROR);
		}else{
			productList=catalogService.searchProductList(keyword.toLowerCase());
			return new ForwardResolution(SEARCH_PRODUCTS);
		}
	}
	
	public void clear() {
		keyword=null;
		
		categoryId=null;
		category=null;
		categoryList=null;
		
		product=null;
		productId=null;
		productList=null;
		
		item=null;
		itemId=null;
		itemList=null;
	}
}
