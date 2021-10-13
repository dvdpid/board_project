<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="/css/board/boardList.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <c:import url="../common/header.jsp"></c:import>
   <c:import url="../nav/nav.jsp"></c:import>
   
   
   <!-- 게시판 -->
   <div class="container">
      <h2>게시판</h2><br>
      <input type="hidden" id="loginUser" value="${loginUser}">
      <table border="1" class="table table-hover">
         <thead>
            <tr>
               <th>번호</th>
               <th style="width: 500px;">제목</th>
               <th>작성자</th>
               <th>작성일</th>
               <th>조회수</th>
            </tr>         
         </thead>
         <tbody>
         <c:forEach var="b" items="${bList}">
            <tr class="bDetail" onclick="location.href='/boardDetail.bo?BOARD_NO='+ ${b.BOARD_NO} + '&nowPage=' + ${paging.nowPage}">
               <td>${b.BOARD_ROW}</td>
               <td id="td_title" nowrap="nowrap">${b.BOARD_TITLE}</td>
               <c:if test="${!empty b.BOARD_WRITER}">
	               <td>${b.BOARD_WRITER}</td>
               </c:if>
               <c:if test="${empty b.BOARD_WRITER}">
	               <td>비회원</td>
               </c:if>
               <td>${b.BOARD_DATE}</td>
               <td>${b.BOARD_COUNT}</td>
            </tr>
         </c:forEach>
         </tbody>
      </table>
      <hr>
      <!-- 페이징 처리 -->
      <div style="display: block; text-align: center;">      
         <c:if test="${paging.startPage != 1}">
            <a href="/?nowPage=${paging.startPage - 1}&cntPerPage=${paging.cntPerPage}">&lt;</a>
         </c:if>
         <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
            <c:choose>
               <c:when test="${p == paging.nowPage}">
                  <b>${p }</b>
               </c:when>
               <c:when test="${p != paging.nowPage}">
                  <a href="/?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a>
               </c:when>
            </c:choose>
         </c:forEach>
         <c:if test="${paging.endPage != paging.lastPage}">
            <a href="/?nowPage=${paging.endPage+1}&cntPerPage=${paging.cntPerPage}">&gt;</a>
         </c:if>
      </div>
      <c:if test="${ !empty loginUser}">
      	<a class="btn btn-default pull-right" id="InsertBoard">글쓰기</a>
      </c:if>
      <c:if test="${ empty loginUser}">
      	<a class="btn btn-default pull-right" id="InsertBoard">비회원 글쓰기</a>
      </c:if>
   </div>
   <c:import url="../common/footer.jsp"></c:import>
   <script type="text/javascript" src="/js/board/board.js"></script>
   <script type="text/javascript" src="js/nav/nav.js" ></script>
   <script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
</body>
</html>