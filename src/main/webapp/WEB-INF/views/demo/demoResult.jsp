<%@page import="com.bs.spring.demo.model.vo.DemoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% DemoVO demoVO = (DemoVO)request.getAttribute("demo"); %>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

<section id="content">
	<table class="table" id="tbl-dev">
		<tr>
			<td scope="col">이름</td>
			<td scope="col">나이</td>
			<td scope="col">이메일</td>
			<td>성별</td>
			<td>개발가능언어</td>
		</tr>
		<tr>
			<td>${demoVO.devName }</td>
			<td>${demoVO.devAge }</td>
			<td>${demoVO.devEmail }</td>
			<td><%-- demoVO.getDevName() --%></td>
			<td><%-- demoVO.getDevAge() --%></td>
			<td><%-- demoVO.getDevEmail() --%></td>
			<td><%-- demoVO.getDevGender() --%></td>
			<td><%-- demoVO.getDevLang() --%></td>
		</tr>
	</table>
</section>



<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>