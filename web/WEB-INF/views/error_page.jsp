<%--
  Created by IntelliJ IDEA.
  User: cjswo
  Date: 2018-12-26
  Time: 오전 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" import="java.util.*"%>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<h4><c:out value="${exception.getMessage()}"></c:out></h4>
<ul>
    <c:forEach items="${exception.getStackTrace()}" var ="stack">
        <li><c:out value="${stack}"></c:out></li>
    </c:forEach>
</ul>

</body>
</html>
