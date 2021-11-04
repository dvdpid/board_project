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
						<th colspan="3" style="background-color: #eeeeee; text-align: center;">비밀번호 수정</th>						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">현재 비밀번호</td>
						<td style="width: 20%;"><input id="nowPwd" type="password"></td>
						<td>
							<span class="guide ok">비밀번호가 일치합니다.</span>
							<span class="guide error">비밀번호가 일치하지 않습니다.</span>
							<input type="hidden" id="pwdCHK" value="0">
						</td>
					</tr>
					<tr>
						<td style="width: 20%;">새 비밀번호</td>
						<td style="width: 20%;"><input id="newPwd" type="password"></td>
						<td>
						</td>
					</tr>
					<tr>
						<td style="width: 20%;">새 비밀번호 확인</td>
						<td style="width: 20%;"><input id="chkPwd" type="password"></td>
						<td>
							<span class="guide2 ok">비밀번호가 일치합니다.</span>
							<span class="guide2 error">비밀번호가 일치하지 않습니다.</span>
							<input type="hidden" id="pwdCHK2" value="0">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" id="pwdBtn" value="변경" style="width: 100px;" >
						</td>
					</tr>
				</tbody>
			</table>
			<form>
				<input type="hidden" id="uNo" value="${loginUser.USER_NO}">
			</form>
	</div>
	<c:import url="../common/footer.jsp"></c:import>
	 <script type="text/javascript" src="/js/nav/nav.js" ></script>
	 <script type="text/javascript" src="/js/user/pwdChk.js"></script>
</body>
</html>