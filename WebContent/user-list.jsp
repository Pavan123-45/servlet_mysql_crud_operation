<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
    <h1>User List</h1>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Gender</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.address}</td>
                <td>${user.phone_number}</td>
                <td>${user.gender}</td>
                <td>
                    <a href="edit?phone_number=${user.phone_number}">Edit</a>
                    <a href="delete?phone_number=${user.phone_number}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="new">Add New User</a>
</body>
</html>