<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add patient dtls</h1>
	<form action="patient.do" method="post">
		<pre>
    Name:<input type="text" name="name" />
    Age:<input type="text" name="age" value="0" />
    MobileNum:<input type="text" name="mno" value="0" />
    Email:<input type="text" name="email" />
    Result YES:<input type="checkbox" value="yes" name="result"/> 
    NO:<input type="checkbox" value=" no" name="result" />
    States:<select name="state">
              <option>Select</option>
               <c:forEach items="${states}" var="s">
                 <option>${s}</option>
                </c:forEach>
            </select>
        
         </pre>       
		<input type="submit" value="Add" name="submit"> 
	</form>
</body>
</html>










