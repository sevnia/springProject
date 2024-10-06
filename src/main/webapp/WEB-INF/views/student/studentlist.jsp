<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<style>
	.boardheader {
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
</style>
<section id="board-container" class="container">
		<div class="boardheader ">
			<h4>총 ${boardCount}건의 게시물이 있습니다.</h4>
			<div>
				<button class="btn btn-outline-dark">글쓰기</button>
			</div>
		</div>
		<table class="table table-striped table-hover">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:if test="${not empty student }">
				<c:forEach var="student" items="${student}">
					<tr>
						<td>${student.studentId }</td>
						<td><a href="${path }/boardView.do?boardNo=${board.boardNo}">${student.studentPwd }</a></td>
						<td>${student.studentName }</td>
						<td>${student.schoolName }</td>
						<td>${student.studentGrade }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty student }">
				<tr>
					<td colspan="5">조회된 게시글이 없습니다.</td>
				</tr>
			</c:if>
		</table>
		<div id="pageBar">
			${pageBar1 }
		</div>
		
</section>
	
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>