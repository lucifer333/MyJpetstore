<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
    <stripes:form
        beanclass="com.langtaojin.myjpetstore.web.actions.AccountActionBean"
        focus="">        
        <p>Please enter your username and password</p>
        <p>
            Username:<stripes:text name="username" value="j2ee"/><br/>
            Password:<stripes:password name="password" value="j2ee"/>
        </p>
        <stripes:submit name="signon" value="Login"/>
    </stripes:form>
    Need a user name and password? 
    <stripes:link
        beanclass="com.langtaojin.myjpetstore.web.actions.AccountActionBean"
        event="newAccountForm">
        Register Now!
    </stripes:link>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>