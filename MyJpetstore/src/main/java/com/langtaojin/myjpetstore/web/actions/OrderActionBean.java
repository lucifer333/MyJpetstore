package com.langtaojin.myjpetstore.web.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.langtaojin.myjpetstore.domain.Order;
import com.langtaojin.myjpetstore.service.OrderService;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SessionScope;
import net.sourceforge.stripes.integration.spring.SpringBean;

@SessionScope
public class OrderActionBean extends AbstractActionBean{

	private static final long serialVersionUID = 6712170238891870413L;
	
	private static final String CONFIRM_ORDER="/WEB-INF/jsp/order/ConfirmOrder.jsp";
	private static final String LIST_ORDERS="/WEB-INF/jsp/order/ListOrders.jsp";
	private static final String NEW_ORDER = "/WEB-INF/jsp/order/NewOrderForm.jsp";
	private static final String SHIPPING = "/WEB-INF/jsp/order/ShippingForm.jsp";
	private static final String VIEW_ORDER = "/WEB-INF/jsp/order/ViewOrder.jsp";
	
	private static final List<String> CARD_TYPE_LIST;
	
	@SpringBean
	private transient OrderService orderService;
	
	private Order order=new Order();
	private boolean shippingAddressRequired;
	private boolean confirmed;
	private List<Order> orderList;
	
	static{
		List<String> cardList=new ArrayList<String>();
		cardList.add("Visa");
		cardList.add("MasterCard");
		cardList.add("American Express");
		CARD_TYPE_LIST=Collections.unmodifiableList(cardList);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public boolean isShippingAddressRequired() {
		return shippingAddressRequired;
	}

	public void setShippingAddressRequired(boolean shippingAddressRequired) {
		this.shippingAddressRequired = shippingAddressRequired;
	}

	public List<String> getCreditCardTypes(){
		return CARD_TYPE_LIST;
	}
	
	public Resolution listOrders(){
		HttpSession session=context.getRequest().getSession();
		AccountActionBean accountActionBean=(AccountActionBean) session.getAttribute("/actions/Account.action");
		orderList=orderService.getOrdersByUsername(accountActionBean.getUsername());
		return new ForwardResolution(LIST_ORDERS);
	}
	
	public Resolution newOrderForm() {
		HttpSession session=context.getRequest().getSession();
		AccountActionBean accountActionBean=(AccountActionBean) session.getAttribute("/actions/Account.action");		
		CartActionBean cartActionBean=(CartActionBean) session.getAttribute("/actions/Cart.action");
		
		clear();
		if(accountActionBean==null || !accountActionBean.isAuthenticated()){
			setMessage("You must sign on before attempting to check out.  Please sign on and try checking out again.");
			return new ForwardResolution(AccountActionBean.class);
		}else if(cartActionBean!=null){
			order.initOrder(accountActionBean.getAccount(), cartActionBean.getCart());
			return new ForwardResolution(NEW_ORDER);
		}else{
			setMessage("An order could not created because a cart could not be found");
			return new ForwardResolution(ERROR);
		}		
	}
	
	public Resolution newOrder() {
		HttpSession session=context.getRequest().getSession();
		
		if(shippingAddressRequired){
			shippingAddressRequired=false;
			return new ForwardResolution(SHIPPING);
		}else if(!isConfirmed()){
			 return new ForwardResolution(CONFIRM_ORDER);
		}else if(getOrder()!=null){
			orderService.insertOrder(order);
			
			CartActionBean cartActionBean=(CartActionBean) session.getAttribute("/actions/Cart.action");
			cartActionBean.clear();
			
			setMessage("Thank you, your order has been submitted.");
			return new ForwardResolution(VIEW_ORDER);
		}else{
		    setMessage("An error occurred processing your order (order was null).");
		    return new ForwardResolution(ERROR);
		}
	}
	
	public Resolution viewOrder() {
		HttpSession session=context.getRequest().getSession();
		
		AccountActionBean accountActionBean=(AccountActionBean) session.getAttribute("/actions/Account.action");
		
		order=orderService.getOrder(order.getOrderId());
		
		if(accountActionBean.getAccount().getUsername().equals(order.getUsername())){
			return new ForwardResolution(VIEW_ORDER);
		}else{
			order=null;
			setMessage("You may only view your own orders");
			return new ForwardResolution(ERROR);
		}
	}
	
	public void clear() {
		order=new Order();
		shippingAddressRequired=false;
		confirmed=false;
		orderList=null;
	}
		
}
