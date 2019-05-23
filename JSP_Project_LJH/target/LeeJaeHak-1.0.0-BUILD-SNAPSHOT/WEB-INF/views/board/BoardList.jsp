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

    <title>게시판 글 목록</title> 
  </head>
  <body>
	<table class="table">
		<thead>
			<tr>
				<td colspan="4" style="text-align: right;">
					<c:url var="insertUrl" value="/board/boardInsertForm.do"/>
					<a href="${insertUrl}" class="btn btn-default">등록</a>
				</td>
			</tr>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>조회수</td>
				<td>작성자</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="boardVo" items="${boardList}">
				<c:url var="viewUrl" value="/board/boardViewFront.do">
					<c:param name="seqNo" value="${BoardVo.seqno}"/>
				</c:url>
				
				<tr>
					<td>${BaordVo.num}</td>
					<td>
						<a href="${viewUrl}">${BaordVo.title}</a>
					</td>
					<td>${BaordVo.readcount}</td>
					<td>${BaordVo.reguser}</td>
					<td>${BaordVo.upddt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
          


  </body>
</html>