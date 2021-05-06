<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Register</h1>
	<div class="jumbotron">
	<p><form:errors path="user.*"/></p>
	<form:form method="POST" action="/register" modelAttribute="user">
	  <div class="form-row">
	  <div class="form-group col-md-6">
	      <form:label path="firstname" for="inputEmail4">First Name</form:label>
	      <form:input  path="firstname" class="form-control" id="inputEmail4"/>
	    </div>
	    <div class="form-group col-md-6">
	       <form:label path="lastname" for="inputEmail4">Last Name</form:label>
	      <form:input  path="lastname" class="form-control" id="inputEmail4"/>
	    </div>
	    <div class="form-group col-md-6">
	      <form:label path="email" for="inputEmail4">Email</form:label>
	      <form:input  type="email" path="email" class="form-control" id="inputEmail4"/>
	      <form:errors path="duplicate"/>
	    </div>
	    
	    <div class="form-group col-md-6">
	      <form:label path="password" for="inputEmail4">password</form:label>
	      <form:input type="password" path="password" class="form-control" id="inputEmail4"/>
	      <form:errors path="password"></form:errors>
	    </div>
	    <div class="form-group col-md-6">
	      <form:label path="passwordConfirmation" for="inputEmail4">Confirm Password</form:label>
	      <form:input type="password" path="passwordConfirmation" class="form-control" id="inputEmail4"/>
	      <form:errors path="passwordConfirmation"></form:errors>
	    </div>
	    <div class="form-row">
	    <div class="form-group col-md-6">
	      <form:label path="location" for="inputEmail4">Location</form:label>
	      <form:input  path="location" class="form-control" id="inputEmail4"/>
	    </div>
	    <div class="form-group col-md-4">
	      <form:label path="state" for="inputState">State</form:label>
	      <form:select path="state" id="inputState" class="form-control">
	        <option value="CA" >CA</option>
	         <option value="TX" >TX</option>
	         <option value="NY" >NY</option>
	      </form:select>
	    </div>
	    
	  </div>
	</div>
	  <button type="submit" class="btn btn-primary">Sign in</button>
	  
	</form:form>  
</div>	  
<hr/>
<h1>Login</h1>
<form action="/login" method="POST">
	<div class="jumbotron">
	<p><c:out value="${error }"></c:out></p>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Email address</label>
	    <input type="email" name = "email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Password</label>
	    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
	  </div>
	  <div class="form-group form-check">
	    <input type="checkbox" class="form-check-input" id="exampleCheck1">
	    <label class="form-check-label" for="exampleCheck1">Check me out</label>
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</div>
	
</form>
</body>
</html>