package com.langtaojin.myjpetstore.web.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.langtaojin.myjpetstore.domain.Order;
import com.langtaojin.myjpetstore.service.OrderService;

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

	
	
	
}
