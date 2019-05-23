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

    <title>회원정보 상세보기</title> 
  </head>
  <body>
	<table class="table">
		<tbody>
			<tr>
				<th>아이디</th>
				<td>${memberInfo.usrid}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${memberInfo.usrname}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${memberInfo.usremail}</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
<!-- 					<select name="usrgenger" class="form-control"> -->
<%-- 						<option value="M" ${memberInfo.usrgender eq 'M' ? 'selected="selected"' : ''}>남성</option> --%>
<%-- 						<option value="W" ${memberInfo.usrgender eq 'W' ? 'selected="selected"' : ''}>여성</option> --%>
<!-- 					</select> -->
					${memberInfo.usrgender eq 'M' ? '남자' : '여자'}
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>${memberInfo.usrage}</td>
			</tr>
			<tr>
				<th>가입일</th>
				<td>${memberInfo.upddt}</td>
			</tr>
			<tr>
				<th colspan="3">
					<c:url var="backList" value="/member/memberList.do"/>
					<a href="${backList}">목록</a>
					<c:url var="updateUrl" value="/member/memberUpdateFront.do">
						<c:param name="seqNo" value="${memberInfo.seqno}"/>
					</c:url>
					<a href="${updateUrl}">수정</a>
					
					<c:url var="deleteUrl" value="/member/memberDeleteProc.do">
						<c:param name="seqNo" value="${memberInfo.seqno}"/>
					</c:url>
					<a href="${deleteUrl}">삭제</a>
				</th>
			</tr>
		</tbody>
	</table>
  </body>
</html>