<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/bootstrap/bootstrap.css">

</head>
<body>
	<c:import url="../common/header.jsp"></c:import>
	<c:import url="../nav/nav.jsp"></c:import>
	
	<!-- 게시판 -->
	<div class="container">
		<h2>게시판</h2><br>
		<table border="1" class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th id="th_title" width="500px;">&nbsp; 제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>			
			</thead>
			<tbody>
			<c:forEach var="b" items="${bList }">
				<tr>
					<td>${b.BOARD_NO}</td>
					<td id="td_title" nowrap="nowrap">${b.BOARD_TITLE}</td>
					<td>${b.BOARD_WRITER}</td>
					<td>${b.BOARD_DATE}</td>
					<td>${b.BOARD_COUNT}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<hr>
		<a class="btn btn-default pull-right">글쓰기</a>
		
	</div>
	<c:import url="../common/footer.jsp"></c:import>
	<script type="text/javascript" src="js/nav/nav.js" ></script>
	<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
</body>
</html>