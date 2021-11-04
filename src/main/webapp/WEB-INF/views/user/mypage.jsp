<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="/css/board/boardList.css">
<link rel="stylesheet" href="/css/user/mypage.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <c:import url="../common/header.jsp"></c:import>
   <c:import url="../nav/nav.jsp"></c:import>
   
	<div class="container">
	<table id="tbl" border="1px;">
		<tr>
			<th colspan="2">개인정보</th>
		</tr>
		<tr>
			<td class="lTd">ID</td>
			<td>${u.USER_ID}</td>
		</tr>
		<tr>
			<td class="lTd">닉네임</td>
			<td>${u.USER_NICKNAME}</td>
		</tr>
		<tr>
			<td class="lTd">휴대전화</td>
			<c:if test="${empty u.USER_PHONE}">
				<td class="lTd">비어있음</td>
			</c:if>
			<c:if test="${!empty u.USER_PHONE}">
				<td class="lTd">${u.USER_PHONE}</td>
			</c:if>
		</tr>
	</table>
	<button>수정</button>
	<button>탈퇴</button>
		
	</div>
	<c:import url="../common/footer.jsp"></c:import>
	  <script type="text/javascript" src="/js/nav/nav.js" ></script>
</body>
</html>