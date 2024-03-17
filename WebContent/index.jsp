<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
</head>
<body>
    <h1>User Form</h1> <!-- user -->
    <c:if test="${exitingUser.gender == 'Male' || exitingUser.gender == 'Female'}">
     <c:set var="gend" value="${exitingUser.gender}"/>  
   		<form action="update" method="post">
	        <label for="name">Name:</label>
	        <input type="text" id="name" name="name" value="${exitingUser.name}" required><br><br>
	        
	        <label for="address">Address:</label>
	        <input type="text" id="address" name="address" value="${exitingUser.address}" required><br><br>
	        
	        <label for="phone_number">Phone Number:</label>
	        <input type="text" id="phone_number" name="phone_number" value="${exitingUser.phone_number}" required><br><br>
	        
	        <label for="gender">Gender:</label>
	        <!-- <select id="gender" name="gender" required>
	            <option value="Male">Male</option>
	            <option value="Female">Female</option>
	        </select><br><br> -->
	        <label for="gender">Male</label>
		        <input type="radio" id="gender" name="gender" value="Male"<c:if test="${fn:contains(gend, 'Male')}"><c:out value="checked"/></c:if>  >
	        <label for="gender">Female</label>
	            <input type="radio"id="gender" name="gender" value="Female"  <c:if test="${fn:contains(gend, 'Female')}"><c:out value="checked"/></c:if>><br><br>
	         
	        <input type="submit" value="Submit">
    	</form>
	</c:if> 
	
	<c:if test="${exitingUser.gender != 'Male' && exitingUser.gender != 'Female'}"> 
   		<form action="insert" method="post">
	        <label for="name">Name:</label>
	        <input type="text" id="name" name="name" required><br><br>
	        
	        <label for="address">Address:</label>
	        <input type="text" id="address" name="address" required><br><br>
	        
	        <label for="phone_number">Phone Number:</label>
	        <input type="text" id="phone_number" name="phone_number" required><br><br>
	        
	        <label for="gender">Gender:</label>
	        <!-- <select id="gender" name="gender" required>
	            <option value="Male">Male</option>
	            <option value="Female">Female</option>
	        </select><br><br> -->
	        <label for="gender">Male</label>
	        <input type="radio" value="Male" id="gender" name="gender" required>
	        <label for="gender">Female</label>
	         <input type="radio" value="Female" id="gender" name="gender" required><br><br>
	         
	        <input type="submit" value="Submit">
    	</form>
	</c:if> 
	
    
    
    
</body>
</html>
