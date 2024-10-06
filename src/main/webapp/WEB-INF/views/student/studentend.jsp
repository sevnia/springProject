<%@page import="com.bs.spring.student.controller.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

<table>
	<tr>
		<td>이름</td>
		<td>나이</td>
		<td>학년</td>
		<td>반</td>
		<td>학과</td>
	</tr>
	<tr>
		<td>${student.name }</td>
		<td>${student.age }</td>
		<td>${student.agec }</td>
		<td>${student.cl }</td>
		<td>${student.c }</td>
	</tr>
</table>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>