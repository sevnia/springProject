<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<section id="board-container" class="container">
	<h2>게시글 상세화면</h2>
	<table class="table table-striped table-hover">
		<tr>
			<th>번호</th>
			<th><input class="form-control" type="text" name="boardNo" value="${board.boardNo }" readonly="readonly"></th>
		</tr>
		<tr>
			<th>제목</th>
			<th><input type="text" name="boardTitle" value="${board.boardTitle }" class="form-control"></th>
		</tr>
		<tr>
			<th>작성자</th>
			<th><input type="text" name="boardWriter" value="${board.boardWriter }" class="form-control" readonly="readonly"></th>
		</tr>
		<tr>
			<th>내용</th>
			<th><textarea class="form-control">${board.boardContent }</textarea></th>
		</tr>
		<tr>
			<th>작성일</th>
			<th>${board.boardDate }</th>
		</tr>
		<tr>
			<th>조회수</th>
			<th>${board.boardReadCount }</th>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<button class="btn btn-outline-primary">수정하기</button>
				<button class="btn btn-outline-danger">삭제하기</button>
			</td>
		</tr>
	</table>
</section>
	
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>