<%@ page import="com.data.demo_java_web_session02" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
    DecimalFormat df = new DecimalFormat("#.##");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa sản phẩm</title>
</head>
<body>
<h2>Chỉnh sửa sản phẩm</h2>
<form action="products" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%= product.getId() %>">

    <label for="name">Tên sản phẩm:</label>
    <input type="text" id="name" name="name" value="<%= product.getName() %>" required><br><br>

    <label for="price">Giá:</label>
    <input type="number" id="price" name="price" step="0.01" value="<%= df.format(product.getPrice()) %>" required><br><br>

    <button type="submit">Cập nhật</button>
</form>
</body>
</html>