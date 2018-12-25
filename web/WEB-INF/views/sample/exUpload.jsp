<%--
  Created by IntelliJ IDEA.
  User: cjswo
  Date: 2018-12-26
  Time: 오전 2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">
    <div>
        <input type="file" name = "files">
    </div>
    <div>
        <input type="file" name = "files">
    </div>
    <div>
        <input type="file" name = "files">
    </div>
    <div>
        <input type="file" name = "files">
    </div>
    <div>
        <input type="file" name = "files">
    </div>
    <div>
        <input type="submit">
    </div>

</form>

</body>
</html>
