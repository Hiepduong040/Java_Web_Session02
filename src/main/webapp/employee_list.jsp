
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>List Employee 2</h4>
<%-- hien thi du lieu: c1 --%>
<%--    <p>${employeeName}</p>--%>
<%--    <p>Age: ${age}</p>--%>
<%-- hien thi du lieu: c2: Scriptlet --%>
<%
    // viet code java
    String employeeName = (String) request.getAttribute("employeeName");
    out.print("Name: " + employeeName);
%>
</body>
</html>