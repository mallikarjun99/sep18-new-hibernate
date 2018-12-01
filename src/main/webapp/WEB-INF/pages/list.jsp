<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<head>
    <title>Login Page</title>
</head>
<body>

<div class="container">
    <table class="table table-hover table-bordered table-responsive">
        <thead>
        <tr>
            <th>id</th>
            <th>User</th>
            <th>Password</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="userDetails" items="${list}">
            <tr>
                <td>${userDetails.id}</td>
                <td>${userDetails.username}</td>
                <td>${userDetails.password}</td>
                <td>
                    <a href="/userDetails/edit/${userDetails.id}">Edit</a><br/>
                    <a href="/userDetails/delete/${userDetails.id}">Delete</a><br/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div>
    <%-- <a href="${pageContext.request.contextPath}/team/list.html">Team List</a>--%>
    <a href="/userDetails/add.html">Add Team</a>
</div>
</body>
</html>
