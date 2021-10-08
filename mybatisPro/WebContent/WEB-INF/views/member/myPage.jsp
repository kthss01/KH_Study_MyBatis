<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#updateForm input[type=text], #insertForm input[type=password], #insertForm input[type=email]{
		width:200px;
		margin:5px;
	}
	#updateForm tr>td:nth-child(1){text-align:right;}
</style>
</head>
<body>
	
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="outer">
		<br>
		<h1 align="center">마이 페이지</h1>
		<br>
		
		<form id="updateForm" action="update.me" method="post">
			<table align="center">
				<tr>
					<td>* ID : </td>
					<td><input type="text" name="userId" value="${ loginUser.userId }" readonly></td>
				</tr>
				<tr>
					<td>* NAME : </td>
					<td><input type="text" name="userName" value="${ loginUser.userName }" required></td>
				</tr>
				<tr>
					<td>EMAIL : </td>
					<td><input type="email" name="email" value="${ loginUser.email }"></td>
				</tr>
				<tr>
					<td>BIRTHDAY : </td>
					<td><input type="text" name="birthday" placeholder="생년월일(6자리)" value="${ loginUser.birthday }"></td>
				</tr>
				<tr>
					<td>GENDER : </td>
					<td>
						<input type="radio" name="gender" value="M"> 남 
						<input type="radio" name="gender" value="F"> 여 
					</td>
				</tr>
				<tr>
					<td>PHONE : </td>
					<td><input type="text" name="phone" placeholder="(-포함)" value="${ loginUser.phone }"></td>
				</tr>
				<tr>
					<td>ADDRESS : </td>
					<td><input type="text" name="address" value="${ loginUser.address }"></td>
				</tr>
			</table>
			
			<br>
			<div class="btns" align="center">
				<button type="submit">수정</button>
				<button type="button" id="pwdUpdateBtn" onclick="updatePwd();">비밀번호 변경</button>
				<button type="button" id="deleteBtn" onclick="deleteMember();">삭제</button>
			</div>
		</form>
		<br><br>
	</div>
	
	
	<script>
		// Gender 처리
		$(function() {
			switch('${ loginUser.gender }') {
			case "M" : $("#updateForm input[type='radio']").eq(0).attr("checked", true); break;
			case "F" : $("#updateForm input[type='radio']").eq(1).attr("checked", true); break;
			}
		});
		
		// 비밀번호 변경
		function updatePwd() {
			window.open("updatePwdForm.me", "비밀번호 변경창","width=500, height=300");
		}
		
		// 멤버 삭제
		function deleteMember() {
			const pwd = prompt("현재 비밀번호 입력");
			if ("${ loginUser.userPwd }" === pwd) {
				const val = confirm("정말로 탈퇴하시겠습니까?");
				
				if (val) {
					$("#updateForm").attr("action", "delete.me");
					$("#updateForm").submit();
				} else {
					alert("취소하였습니다.");
				}
			} else {
				alert("비밀번호를 잘못 입력하였습니다.");
			}
		}
	</script>
</body>
</html>