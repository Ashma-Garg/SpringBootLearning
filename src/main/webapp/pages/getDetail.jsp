<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Address</th>
			</tr>
		</thead>
		<tbody>
		<tr>
			<td>${detail.first_name }</td>
			<td>${detail.last_name }</td>
			<td>${detail.address }</td>
			</tr>
		</tbody>
	</table>
	
</body>
</html>