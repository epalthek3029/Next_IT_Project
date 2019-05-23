<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="개인 프로젝트 ...">
    <meta name="author" content="LeeJH">

    <title>로그인</title> 
  </head>
  <body>
	
	<c:if test="loginInfo != null">
		${loginInfo.usrid} <br>
		${loginInfo.usrname} 님 환영합니다~
	</c:if>
	
	<c:if test="${loginInfo eq null}">
	<form action="/session/sessionLoginProc.do" method="POST">
		<table class="table">
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="usrid"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="usrpwd"></td>
				</tr>
				<tr>
					<th>아이디/비밀번호 저장</th>
					<td><input type="checkbox" name="remember" value="idsave" ${idsave}></td>
				</tr>
				<tr>
					<th colspan="2">
						<button type="submit">로그인</button>
					</th>
				</tr>
			</tbody>		
		</table>
	</form>
	</c:if>
  </body>
</html>