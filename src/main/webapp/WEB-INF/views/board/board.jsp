<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../common/header.jsp"></c:import>
	<c:import url="../nav/nav.jsp"></c:import>
	
	<div class="main">
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>			
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>제목1</td>
					<td>내용1</td>
					<td>작성자1</td>
					<td>2022-09-15</td>
					<td>1</td>
				</tr>
				<tr>
					<td>2</td>
					<td>제목2</td>
					<td>내용2</td>
					<td>작성자2</td>
					<td>2022-09-25</td>
					<td>2</td>
				</tr>
				
			</tbody>
		</table>
	</div>
	<c:import url="../common/footer.jsp"></c:import>
</body>
</html>