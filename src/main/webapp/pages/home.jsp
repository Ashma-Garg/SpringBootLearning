<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <style>
    #visible{
    	display:none;
    }
	</style>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
<form action="addAlien">
	<input type="text" name="id" id='id'/>
	<%-- name should be same as field name in table--%>
	<input type="text" name="first_name" id='first_name'/>
	<input type="text" name="last_name" id="last_name"/>
	<input type="text" name="address" id='addresss'/>
	<button type="submit">Submit</button>
</form>

<c:choose>
    <c:when test="${empty obj}">
        Add new Record
    </c:when>
    <c:otherwise>
        <h1>Welcome in ALien world. ${obj.first_name}, ${obj.last_name}, ${obj.address} added!</h1>
    </c:otherwise>
</c:choose>
	
    <c:forEach items="${alienRecord}" var="el">
    <div>      
        <a href="getDetails/${el.id}">${el.first_name}</a>
    </div>
	</c:forEach>
	
</body>
</html>