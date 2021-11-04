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
			<table id="table" class="table table-striped" style="text-align: center; margin-top:30px; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3" style="background-color: #eeeeee; text-align: center;">개인정보 수정</th>						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">회원 ID</td>
						<td style="width: 20%;">${loginUser.USER_ID}</td>
						<td></td>
					</tr>
					<tr>
						<td style="width: 20%;">닉네임</td>
						<td style="width: 20%;"><input type="text" id="nickname" value="${loginUser.USER_NICKNAME}"></td>
						<td>
							<span class="guide ok">사용가능한 닉네임 입니다.</span>
							<span class="guide ok2">현재 닉네임 입니다.</span>
							<span class="guide error">사용중인 닉네임 입니다.</span>
							<input type="hidden" id="nickCHK" value="1">
						</td>
					</tr>
					<tr>
						<td style="width: 20%;">휴대전화</td>
						<td style="width: 20%;"><input type="text" id="phone" value="${loginUser.USER_PHONE}"></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" id="updateBtn" value="변경" style="width: 100px;" >
							<input type="button" id="cancel" onclick="window.history.back()" value="취소" style="width: 100px;" >
						</td>
					</tr>
				</tbody>
			</table>
			* 현재 닉네임 그대로 사용하실려면 값을 변경하지 말아주세요.
			<form action="deleteUser">
				<input type="hidden" id="uNo" value="${loginUser.USER_NO}">
				<input type="hidden" id="nowNick" value="${loginUser.USER_NICKNAME}">
			</form>
			
			
		
		
	</div>
	<c:import url="../common/footer.jsp"></c:import>
	 <script type="text/javascript" src="/js/nav/nav.js" ></script>
	 <script type="text/javascript" src="/js/user/userUpdate.js"></script>
</body>
</html>