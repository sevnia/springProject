<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<a href="${path }/board/boardList.do"><button>boardlist로 가기</button></a>
<section id="content">
	<h2>boardwriter.jsp</h2>
</section>
	
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>