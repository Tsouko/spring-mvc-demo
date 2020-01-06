<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>


<link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
	
<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-exp.min.css">
<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<h3>Login</h3>
	
<div class="form-group">



   
	<form:form action="${pageContext.request.contextPath}/authUser" method="POST">
	
	

	
		<c:if test="${param.error != null}">
		<!-- 
					<p>Sorry! Invalid username/password!</p>
		 -->
			<p> <font color="red">Sorry! Invalid username/password!</font> </p>
			<p> <font color="red">If you are sure your entered credits are valid, you may be not allowed to make a job application form yet</font> </p>
			
		</c:if>


	 
	
			<label class="form-label">User Id</label> 
			<input type="text" name="username"/>
		
			<label class="form-label">Password</label> 
			<input type="password" name="password"/>
			<button class="btn" type="submit">Login</button>
			</div>
	</form:form>


	
</div>
</div>
<hr/>