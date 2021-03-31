<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 Servlet</title>
</head>
<body>
	<h1>주소록 Servlet</h1>
	<h3>목록 </h3>
	<form action="<c:url value='/addressbook'/>">
		<input type="hidden" name="q" value="search">
		<span>검색어</span>
		<input type="text" name="f" id="keyword"/>
		<input type="submit" value="검색"/>
	</form>
	<input type="hidden" name="action" value="delete">
	
	<table border="1">
		<thead>
			<tr>
				<th>이름</th>
				<th>휴대전화</th>
				<th>전화번호</th>
				<th>도구</th>
			</tr>
		</thead>
		
		<tbody>
	
			<c:forEach items="${list }" var="vo" varStatus="status">
				<tr>
					<td>${vo.name }</td>
					<td>${vo.cell_phone }</td>
					<td>${vo.home_phone }</td>
					<td>
						<form action="<c:url value='/addressbook'/>" method="post">
							<input type="hidden" name="action" value="delete">
							<input type="hidden" name="id" value="${vo.id }"/><input type="submit" value="삭제"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		
		</tbody>
		
		
	</table>
	<p>
		<a href="<c:url value='/addressbook?action=registerform'/>">새 주소 추가</a>
	</p>
</body>
</html>