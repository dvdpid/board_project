<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<c:import url="../common/header.jsp"></c:import>
	<c:import url="../nav/nav.jsp"></c:import>
	
	<!-- 게시판 -->
	<div class="main">
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
				</tr>			
			</thead>
			<tbody>
			<c:forEach var="b" items="${bList }">
				<tr>
					<td>${b.BOARD_NO}</td>
					<td>${b.BOARD_TITLE}</td>
					<td>${b.BOARD_CONTENTS}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<c:import url="../common/footer.jsp"></c:import>
	<script type="text/javascript" src="js/nav/nav.js" ></script>
</body>
</html>