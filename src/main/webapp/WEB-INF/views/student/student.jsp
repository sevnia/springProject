<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

<section style="width: 1000px; height=auto; margin: 0 auto; margin: 30px;">
	<h2>전송 됨</h2>
	<form action="/spring/student/enrollstudent.do" action="post" autocomplete="off">
		<input type="text" class="name" name="name" placeholder="이름">
		<input type="text" class="age" name="age" placeholder="나이">
		<input type="text" class="agec" name="agec" placeholder="학년">
		<input type="text" class="cl" name="cl" placeholder="반">
		<input type="text" class="c" name="c" placeholder="학과">
		<button type="submit">저장</button>
	</form>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>