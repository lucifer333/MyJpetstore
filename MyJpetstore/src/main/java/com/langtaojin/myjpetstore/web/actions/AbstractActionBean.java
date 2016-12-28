package com.langtaojin.myjpetstore.web.actions;

import java.io.Serializable;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.SimpleMessage;

public abstract class AbstractActionBean implements ActionBean,Serializable{

	private static final long serialVersionUID = -5448678365823623644L;
	
	protected static final String ERROR="/WEB-INF/jsp/common/Error.jsp";
	
	protected transient ActionBeanContext context;
	
	protected void setMessage(String value) {
		context.getMessages().add(new SimpleMessage(value));
	}

	@Override
	public void setContext(ActionBeanContext context) {
		this.context=context;
	}

	@Override
	public ActionBeanContext getContext() {
		return this.context;
	}
	
	
}
