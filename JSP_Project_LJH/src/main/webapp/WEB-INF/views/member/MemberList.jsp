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

    <title>회원리스트</title> 
  </head>
  <body>
	
	<form id="searchVo" action="" method="get">
		<input type="hidden" name="curPage" value="${searchVo.curPage}">
		<table class="talbe">
			<tr>
				<th>검색 조건</th>
				<th>
					<select name="searchType">
						<option value="usr_id ${param.searchType eq 'usr_id' ? 'selected = "selected"' : ''}">아이디</option>
						<option value="usr_name ${param.searchType eq 'usr_name' ? 'selected = "selected"' : ''}">이름</option>
						<option value="usr_email ${param.searchType eq 'usr_email' ? 'selected = "selected"' : ''}">이메일</option>
					</select>
				</th>
				<th>검색어</th>
				<th><input type="text" name="searchText"></th>
				<th><button type="submit">검색</button></th>
			</tr>			
		</table>
	</form>
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>이메일</th>
				<th>성별</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="memberVo" items="${memberList}">
				<c:url var="viewUrl" value="/member/memberView.do">
					<c:param name="seqNo" value="${memberVo.seqno}"/>
				</c:url>			
				<tr>
					<td>${memberVo.num}</td>
					<td>${memberVo.usrname}</td>
					<td>
						<a href="${viewUrl}">	${memberVo.usrid}</a>
					</td>
					<td>${memberVo.usremail}</td>
					<td>${memberVo.usrgender}</td>
					<td>${memberVo.usrage}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
  </body>
</html>