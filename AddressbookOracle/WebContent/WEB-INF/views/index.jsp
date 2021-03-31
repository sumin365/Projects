<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Addressbook Servlet</title>
</head>
<body>
     <h1>주소록 Servlet</h1>
      <h3>목록</h3>
     
      <form class="table-form">
          <input type="hidden" name="f" value="search">
          <span>검색어</span>
          <input type="text" name="q" value=""/>
          <input type="submit" value="검색"/>
      </form>
      
      <input type="hidden" name="f" value="delete">
      
       <table border=1>
      <thead>
			<tr>
				<th>이름</th>
				<th>휴대전화</th>
				<th>전화번호</th>
				<th>도구</th>
			</tr>
		</thead>
      
      
<c:forEach items="${ userList }" var="vo" varStatus="status">
	<tr>
	   <c:choose>
	
			<c:when test="${ status.count % 2 == 0 }">
			<tr style="background:lightgray">
			</c:when>
			<c:otherwise>
			<tr>
			</c:otherwise>
			
	  </c:choose>
	
			<td>${ vo.no }</td>
			<td>${ vo.name }</td>
			<td>${ vo.email }</td>
			<td>${ status.index }</td>
			<td>${ status.count }</td>
	</tr>
</c:forEach>

</table>	
		

     <p>
		<a href="<c:url value='/addressbook?action=registerform'/>">새 주소 추가</a>
	</p>


		
	
	
	
	
	
	

</body>
</html>