<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="OneDayOneCommit.do">
ID:<input type="text" name="url">
   <input type="submit" value="검색">
</form>
						<div>
					<c:forEach items="${countlist }" var="pvo">
						${pvo }
						</c:forEach>
					<c:forEach items="${datelist }" var="ppvo">
						${ppvo }
						</c:forEach>
						</div>
</body>
</html>