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
					<th>��ȣ</th>
					<th>����</th>
					<th>����</th>
					<th>�ۼ���</th>
					<th>�ۼ���</th>
					<th>��ȸ��</th>
				</tr>			
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>����1</td>
					<td>����1</td>
					<td>�ۼ���1</td>
					<td>2022-09-15</td>
					<td>1</td>
				</tr>
				<tr>
					<td>2</td>
					<td>����2</td>
					<td>����2</td>
					<td>�ۼ���2</td>
					<td>2022-09-25</td>
					<td>2</td>
				</tr>
				
			</tbody>
		</table>
	</div>
	<c:import url="../common/footer.jsp"></c:import>
</body>
</html>