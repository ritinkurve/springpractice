<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StudentForm</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
First Name : <form:input path="firstName" />
		<br>
		<br>
Last Name : <form:input path="lastName" />
		<br>
		<br>
		<form:select path="country">
			<form:options items="${student.countryOption}" />
			<%--
<form:option value="Brazil" label="Brazil"/>
<form:option value="India" label="India"/>
<form:option value="London" label="London"/>
<form:option value="Singapore" label="Singapore"/>
 --%>
		</form:select>
		<br>
		<br>
 Favorite Language 
 Java <form:radiobutton path="favoriteLangauge" value="Java" />
 C# <form:radiobutton path="favoriteLangauge" value="C#" />
 HTML <form:radiobutton path="favoriteLangauge" value="HTML" />
 Javascript <form:radiobutton path="favoriteLangauge" value="Javascript" />
		<br>
		<br>
Operating Systems :
		Mac OS <form:checkbox path="operatingSystem" value="MacOS"/>
		Linux <form:checkbox path="operatingSystem" value="Linux"/>
		Windows <form:checkbox path="operatingSystem" value="Windows"/>
		<br>
		<br>
		<input type="submit" value="submit">
	</form:form>
</body>
</html>