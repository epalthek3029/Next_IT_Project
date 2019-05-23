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

    <title>회원정보 업데이트</title> 
  </head>
  <body>
	<form action="/member/memberUpdateProc.do" method="POST">
					<!-- hidden으로 바꿔 확인하고나서  -->
		<input type="text" name="seqNo" value="${memberInfo.seqno}">
		<table class="table">
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="usrid" class="form-control" value="${memberInfo.usrid}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="usrname" class="form-control" value="${memberInfo.usrname}"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="usremail" class="form-control" value="${memberInfo.usremail}"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<select name="usrgender" class="form-control">
							<option value="M" ${memberInfo.usrgender eq 'M' ? 'selected = "selected"' : ''}>남성</option>
							<option value="W" ${memberInfo.usrgender eq 'W' ? 'selected = "selected"' : ''}>여성</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="number" name="usrage" value="${memberInfo.usrage}"></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" value="변경"></th>
				</tr>
			</tbody>
		</table>
	</form>
          


  </body>
</html>