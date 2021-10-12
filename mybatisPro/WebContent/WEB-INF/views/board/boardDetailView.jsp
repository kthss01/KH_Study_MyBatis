<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="outer">
		<br>
		<h1 align="center">게시판 상세보기</h1>
		
		<table align="center" class="tableArea">
			<tr>
				<td width="100">글번호</td>
				<td><b>${ b.boardNo }</b>
			</tr>
			<tr>
				<td>제목</td>
				<td><b>${ b.boardTitle }</b></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><b>${ b.boardWriter }</b></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><b>${ b.count }</b></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><b>${ b.createDate }</b></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><p style="height:100px;"><b>${ b.boardContent }</b></p></td>
			</tr>
		</table>
		
		<br>
		
		<table align="center" class="tableArea">
		
		</table>
		
		
		<br><br>
	</div>
</body>
</html>