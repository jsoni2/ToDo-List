
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="<c:url value="/css/table.css"/>" rel="stylesheet">
<title>TO-DO List</title>
</head>
<body>
	<p>To-Do List</p>
	<form action="AddTask" method="post">
		<table border="1">
			<tr>
				<th>Task</th>
				<th>Date</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${entries }" var="entry">
				<tr>
					<c:choose>
						<c:when test="${empty entry.status}">
							<td>${entry.task }</td>
							<td>${entry.date }</td>
							<td align="center"><a href="DoneTask?id=${entry.id }">X</a></td>
						</c:when>
					</c:choose>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="text" name="task" required /></td>
				<td colspan="2" align="center"><input type="submit" name="test"
					value="Add" /><br /></td>
			</tr>
		</table>
	</form>
	<p>Done List</p>
	<table border="1">
		<tr>
			<th>Task</th>
			<th>Date</th>
			<th>Status</th>
		</tr>
		<c:forEach items="${entries }" var="entry1">
			<tr>
				<c:choose>
					<c:when test="${not empty entry1.status}">
						<td>${entry1.task }</td>
						<td>${entry1.date }</td>
						<td>${entry1.status }</td>
					</c:when>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
</body>


</html>