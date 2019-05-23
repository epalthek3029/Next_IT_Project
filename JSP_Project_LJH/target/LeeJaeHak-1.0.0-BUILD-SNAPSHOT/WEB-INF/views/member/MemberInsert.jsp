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
    <meta name="description" content="JSP 개별 과제">
    <meta name="author" content="LeeJH">

    <title>회원가입</title> 
  </head>
  <body>
	
	<form action="/member/memberInsertProc.do" method="POST">
		<table class="table">
			<tbody>
          	<tr>
          		<th> 이름 </th>
          		<td colspan="2"> <input type="text" name="usrname" class="form-control"> </td>
          	</tr>
          	<tr>
          		<th> 아이디 </th>
          		<td> <input type="text" name="usrid" class="form-control"> </td>
          		<td> <input type="button" value="중복체크"> </td>
          	</tr>
          	<tr>
          		<th> 비밀번호 입력 </th>
          		<td colspan="2"> <input type="password" name="usrpwd" class="form-control"> </td>
          	</tr>
          	<tr>
          		<th> 비밀번호 확인 </th>
          		<td colspan="2"> <input type="password" name="usrpwd2" class="form-control"> </td>
          	</tr>
          	<tr>
          		<th> 이메일 </th>
          		<td colspan="2"> <input type="email" name="usremail" class="form-control"> </td>
          	</tr>
          	<tr>
          		<th> 성별 </th>
          		<td colspan="2"> 	
          			<select name="usrgender" class="form-control">
          				<option value="M">남</option>
          				<option value="W">여</option>
          			</select>
          		</td>
          	</tr>
          	<tr>
          		<th> 나이 </th>
          		<td colspan="2"> <input type="number" name="usrage" class="form-control"> </td>
          	</tr>
          	<tr>
          		<th colspan="3">
          			<button type="submit">가입하기</button>
          		</th>
          	</tr>
			</tbody>
		</table>
	</form>


  </body>
</html>