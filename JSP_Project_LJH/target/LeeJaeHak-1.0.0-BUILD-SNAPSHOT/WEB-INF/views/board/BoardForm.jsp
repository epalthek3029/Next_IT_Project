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

    <title>게시물 작성 페이지</title> 
  </head>
  <body>
	<form action="/board/boardInsertProc.do" method="get" enctype="multipart/form-data">
		<table class="table">
			<tbody>
				<tr>
					<th>게시판 종류</th>
					<td>
						<select name="servicetype">
							<option value="QnA">QnA</option>
							<option value="Post">Post</option>
							<option value="Notice">Notice</option>
						</select>
					</td>	
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="7" cols="30" name="contents"></textarea>
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="저장">
					</th>
				</tr>
			</tbody>
		</table>
	</form>
  </body>
</html>