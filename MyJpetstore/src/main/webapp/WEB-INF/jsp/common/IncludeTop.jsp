<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="StyleSheet" href="../css/myjpetstore.css" type="text/css" 
    media="screen">
<meta name="generator"
    content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
<title>myjpetstore</title>
<meta content="text/html; charset=windows-1252"
    http-equiv="Content-Type" />
<meta http-equiv="Cache-Control" content="max-age=0" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="Pragma" content="no-cache" />
</head>

<body>
<div id="Header">
    
   <div id="Logo">
     <div id="LogoContent">
        <stripes:link  beanclass="com.langtaojin.myjpetstore.web.actions.CatalogActionBean">
            <img src="../images/logo-topbar.gif"/>
        </stripes:link>
     </div>
   </div>
   
   <div id="Menu">
     <div id="MenuContent">
         <stripes:link 
             beanclass="com.langtaojin.myjpetstore.web.actions.CartActionBean" 
             event="viewCart">
             <img align="middle" name="img_cart" src="../images/cart.gif"/>
         </stripes:link>
         <img align="middle" src="../images/separator.gif"/>
         <c:if test="${sessionScope.accountBean==null}">
             <stripes:link 
                 beanclass="com.langtaojin.myjpetstore.web.actions.AccountActionBean" 
                 event="signonForm">
                 Sign In 
             </stripes:link>
         </c:if>
         <c:if test="${sessionScope.accountBean!=null && !sessionScope.accountBean.authenticated}">
             <stripes:link 
                 beanclass="com.langtaojin.myjpetstore.web.actions.AccountActionBean" 
                 event="signonForm">
                 Sign In 
             </stripes:link>
         </c:if>
         <c:if test="${sessionScope.accountBean!=null && sessionScope.accountBean.authenticated}">
             <stripes:link
                 beanclass="com.langtaojin.myjpetstore.web.actions.AccountActionBean"
                 event="signoff">
                 Sign Out
             </stripes:link>
             <img align="middle" src="../images/separator.gif">
             <stripes:link
                 beanclass="com.langtaojin.myjpetstore.web.actions.AccountActionBean"
                 event="editAccountForm">
                 My Account
             </stripes:link>
         </c:if>
         <img align="middle" src="../images/separator.gif"/>
         <a href="../help.html">?</a>
      </div> 
   </div>
   
   <div id="Search">
        <div id="SearchContent">
            <stripes:form
                beanclass="com.langtaojin.myjpetstore.web.actions.CatalogActionBean">
                <stripes:text name="keyword" size="14"/>
                <stripes:submit name="searchProducts" value="Search"/>
            </stripes:form>
        </div>
   </div>
   
   <div id="QuickLinks">
        <stripes:link
            beanclass="com.langtaojin.myjpetstore.web.actions.CatalogActionBean"
            event="viewCategory">
            <stripes:param name="categoryId" value="FISH"/>
            <img src="../images/sm_fish.gif"/>
        </stripes:link>
        <img src="../images/separator.gif"/>
        <stripes:link
            beanclass="com.langtaojin.myjpetstore.web.actions.CatalogActionBean"
            event="viewCategory">
            <stripes:param name="categoryId" value="DOGS"/>
            <img src="../images/sm_dogs.gif"/>
        </stripes:link>
        <img src="../images/separator.gif"/>
        <stripes:link
            beanclass="com.langtaojin.myjpetstore.web.actions.CatalogActionBean"
            event="viewCategory">
            <stripes:param name="categoryId" value="REPTILES"/>
            <img src="../images/sm_reptiles.gif"/>
        </stripes:link>
        <img src="../images/separator.gif"/>
        <stripes:link
            beanclass="com.langtaojin.myjpetstore.web.actions.CatalogActionBean"
            event="viewCategory">
            <stripes:param name="categoryId" value="CATS"/>
            <img src="../images/sm_cats.gif"/>
        </stripes:link>
        <img src="../images/separator.gif"/>
        <stripes:link
            beanclass="com.langtaojin.myjpetstore.web.actions.CatalogActionBean"
            event="viewCategory">
            <stripes:param name="categoryId" value="BIRDS"/>
            <img src="../images/sm_birds.gif"/>
        </stripes:link>
   </div>
   
</div>

<div id="Content"><stripes:messages/>
