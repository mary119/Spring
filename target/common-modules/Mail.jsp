<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="mail.do" method="post">
Reciever Mail ID:<input type="email" name="to"  placeholder="enter the emailId">
Subject :<input type="text" name="subject" placeholder="enter the subject">
Body: <input type="text" name="body" placeholder="enter your message">

<button type="submit">SEND</button>
</form>

</body>
</html>