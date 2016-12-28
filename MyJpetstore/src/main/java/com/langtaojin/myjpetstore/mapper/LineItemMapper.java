package com.langtaojin.myjpetstore.mapper;

import java.util.List;

import com.langtaojin.myjpetstore.domain.LineItem;

public interface LineItemMapper {

	List<LineItem> getLineItemsByOrderId(int orderId);
	
	void insertLineItem(LineItem lineItem);
	
}
