<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="Welcome">
    <div id="WelcomeContent">
        <c:if test="${sessionScope.accountBean!=null && sessionScope.accountBean.authenticated}">
            Welcome ${sessionScope.accountBean.account.firstName}!
        </c:if>
    </div>
</div>

<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
            <stripes:link
                beanclass="com.langtaojin.myjpetstore.web.actions.CatalogActionBean"
                event="viewCategory">
                <stripes:param name="categoryId" value="FISH"/>
                <img src="../images/fish_icon.gif">
            </stripes:link><br/>Saltwater,Freshwather<br/>
            <stripes:link
                beanclass="com.langtaojin.myjpetstore.web.actions.CatalogActionBean"
                event="viewCategory">
                <stripes:param name="categoryId" value="DOGS"/>
                <img src="../images/dogs_icon.gif">
            </stripes:link><br/>Various Breeds<br/>
            <stripes:link
                beanclass="com.langtaojin.myjpetstore.web.actions.CatalogActionBean"
                event="viewCategory">
                <stripes:param name="categoryId" value="CATS"/>
                <img src="../images/cats_icon.gif">
            </stripes:link><br/>Various Breeds, Exotic Varieties <br/>
            <stripes:link
                beanclass="com.langtaojin.myjpetstore.web.actions.CatalogActionBean"
                event="viewCategory">
                <stripes:param name="categoryId" value="REPTILES"/>
                <img src="../images/reptiles_icon.gif">
            </stripes:link><br/>Lizards, Turtles, Snakes <br/>
            <stripes:link
                beanclass="com.langtaojin.myjpetstore.web.actions.CatalogActionBean"
                event="viewCategory">
                <stripes:param name="categoryId" value="BIRDS"/>
                <img src="../images/birds_icon.gif">
            </stripes:link><br/>Exotic Varieties<br/>
        </div>
    </div>
    
    <div id="MainImage">
    <div id="MainImageContent">
        <map name="estoremap">
            <area alt="Birds" coords="72,2,280,250"
                href="Catalog.action?viewCategory=&categoryId=BIRDS" shape="rect"/>
            <area alt="Fish" coords="2,180,72,250"
                href="Catalog.action?viewCategory=&categoryId=FISH" shape="rect"/>
            <area alt="Dogs" coords="60,250,130,320"
                href="Catalog.action?viewCategory=&categoryId=DOGS" shape="rect"/>
            <area alt="Reptiles" coords="140,270,210,340"
                href="Catalog.action?viewCategory=&categoryId=REPTILES" shape="rect"/>
            <area alt="Cats" coords="225,240,295,310"
                href="Catalog.action?viewCategory=&categoryId=CATS" shape="rect"/>
            <area alt="Birds" coords="280,180,350,250"
                href="Catalog.action?viewCategory=&categoryId=BIRDS" shape="rect"/>    
        </map>
        <img height="355" src="../images/splash.gif" align="middle"
            usemap="#estoremap" width="350"/>
    </div>
</div>

<div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>