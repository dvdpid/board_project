<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="/css/board/boardList.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <c:import url="../nav/nav.jsp"></c:import>
		<table border="1px;">
		<tr>
			<th colspan="2">개인정보 수정</th>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="text" readonly="readonly" value="${u.USER_ID}"></td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td><input type="text" value="${u.USER_NICKNAME}"></td>
		</tr>
		<tr>
			<td>휴대전화</td>
			<td><input type="text" value="${u.USER_PHONE}"></td>
		</tr>
	</table>
		<button>수정</button>
		<button>탈퇴</button>
</body>
</html>