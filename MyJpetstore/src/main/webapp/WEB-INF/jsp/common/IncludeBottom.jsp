<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

</div>

<div id="Footer">

	<div id="PoweredBy">
	   &nbsp;<a href="www.langtaojin.com">www.langtaojin.com</a>
	</div>
	
	<div id="Banner">
	   <c:if test="${sessionScope.accountBean!=null && sessionScope.accountBean.authenticated}">
	       <c:if test="${sessionScope.accountBean.account.bannerOption}">
	           ${sessionScope.accountBean.account.bannerName}
	       </c:if>
	   </c:if>
	</div>
</div>	
</body>
</html>	
	
	