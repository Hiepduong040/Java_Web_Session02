
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Register Account</h4>
<form action="account" method="post">
    <div>
        <label for="username">Username</label>
        <input type="text" name="username" id="username" />
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" />
    </div>
    <div>
        <label for="fullName">Họ Tên</label>
        <input type="text" name="fullName" id="fullName" />
    </div>
    <div>
        <label for="age">Age</label>
        <input type="number" name="age" id="age" />
    </div>
    <div>
        <label for="address">Address</label>
        <input type="text" name="address" id="address" />
    </div>

    <input type="submit" value="REGISTER" />

</form>
</body>
</html>