package com.langtaojin.myjpetstore.web.actions;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.langtaojin.myjpetstore.domain.Cart;
import com.langtaojin.myjpetstore.domain.CartItem;
import com.langtaojin.myjpetstore.domain.Item;
import com.langtaojin.myjpetstore.service.CatalogService;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SessionScope;
import net.sourceforge.stripes.integration.spring.SpringBean;

@SessionScope
public class CartActionBean extends AbstractActionBean{

	private static final long serialVersionUID = 2342275642989030438L;

	private static final String VIEW_CART="/WEB-INF/jsp/cart/Cart.jsp";
	private static final String CHECK_OUT="/WEB-INF/jsp/cart/Checkout.jsp";
	
	@SpringBean
	private transient CatalogService catalogService;
	
	private Cart cart=new Cart();
	private String workingItemId;
	
	public Cart getCart() {
		return cart;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public void setWorkingItemId(String workingItemId) {
		this.workingItemId = workingItemId;
	}
	
	public Resolution addItemToCart() {
		if(cart.containsItemId(workingItemId)){
			cart.incrementQuantityByItemId(workingItemId);
		}else{
			boolean isInStock=catalogService.isItemInStock(workingItemId);
			Item item=catalogService.getItem(workingItemId);
			cart.addItem(item, isInStock);
		}
		return new ForwardResolution(VIEW_CART);
	}
	
	public Resolution removeItemFromCart() {
		Item item=cart.removeItemById(workingItemId);
		
		if(item==null){
			setMessage("Attempted to remove null cartitem from cart.");
			return new ForwardResolution(ERROR);
		}else{
			return new ForwardResolution(VIEW_CART);
		}
	}
	
	public Resolution updateCartQuantities() {
		HttpServletRequest request=context.getRequest();
		
		Iterator<CartItem> cartItems=getCart().getAllCartItems();
		while (cartItems.hasNext()) {
			CartItem cartItem=cartItems.next();
			String itemId=cartItem.getItem().getItemId();
			try {
				int quantity=Integer.parseInt(request.getParameter(itemId));
				getCart().setQuantityByItemId(itemId, quantity);
				if(quantity<1){
					cartItems.remove();
				}
			} catch (Exception e) {
				//ignore parse exceptions on purpose
			}
		}
		return new ForwardResolution(VIEW_CART);
	}
	
	public ForwardResolution viewCart() {
		return new ForwardResolution(VIEW_CART);
	}
	
	public ForwardResolution checkOut() {
		return new ForwardResolution(CHECK_OUT);
	}
	
	public void clear() {
		workingItemId=null;
		cart=new Cart();
	}
	
}
