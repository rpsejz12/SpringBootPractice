<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="insert.do">
   <table border="1">
      <tr>
         <th>id</th><th>pw</th><th>email</th><th>delete</th><th>update</th>
      </tr>
      <c:forEach var="v" items="${datas}">
      <tr>
         <td>${v.id}</td><td>${v.pw}</td><td>${v.email}</td><td><a href="updateView.do">수정</a></td><td><a href="delete.do?id=${v.id}">삭제</a></td>
      </tr>
      </c:forEach>
      <tr>
         <td><input type="text" name="id"></td><td><input type="text" name="pw"></td><td><input type="text" name="email"></td><td colspan="2"><input type="submit" value="등록"></td>
      </tr>
   </table>
</form>

</body>
</html>