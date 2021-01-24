<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">

<style> 
body {
  background-image: url("img_tree.gif"), url("paper.gif");
  background-repeat: no-repeat, repeat;
  background-color: #cccccc;
}
</style>
</head>
 <BODY background="commerce.gif"> 
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">E-Commerce</a>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item active"><a class="nav-link" href="Login.jsp">Login
					<span class="sr-only">(current)</span>
			</a></li>
		</ul>
</nav>

<h1>${msg }</h1>
<h1>${message }</h1>
<form action="landing.do"  method="post" onsubmit="return validate()">
<div class="container">
		<div class="container" style="margin-top: 50px">
		
<!-- 			<div class="card"> -->
<!-- 				<div class="card-body"> -->
					<div class="form-group row">
						<label for="firstName" class="col-sm-2 col-form-label text-light">First
							Name</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="firstname"
								placeholder="Enter First Name" id="firstname"> <span
								id="fname" class="text-danger "></span>
						</div>
					</div>
					<div class="form-group row">
						<label for="last name" class="col-sm-2 col-form-label text-light">Last
							Name</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="lastname"
								placeholder="Enter Last Name" id="lastname"> <span
								id="lname" class="text-danger "></span>
						</div>
					</div>
					<div class="form-group row">
						<label for="email" class="col-sm-2 col-form-label text-light">Email</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="email"
								placeholder="Enter valid Email" id="email"> <span
								id="email" class="text-danger "></span>
						</div>
					</div>

					<div class="form-group row">
						<label for="inputPassword" class="col-sm-2 mt-1 col-form-label text-light">Password</label>
						<div class="col-sm-4">
							<input type="password" class="form-control" name="password"
								placeholder="Enter password" id="password"> <span
								id="pwd" class="text-danger "></span>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword" class="col-sm-2 col-form-label text-light">Confirm
							Password</label>
						<div class="col-sm-4">
							<input type="password" class="form-control" name="confirmpassword"
								placeholder="Re-Enter Password" id="confirmpassword"> <span
								id="cpwd" class="text-danger "></span>
						</div>
					</div>




					<input type="submit" class="btn btn-primary" name="submit" 
						value="Register">
				</div>
				</div>

		<nav
			class="navbar fixed-bottom navbar-dark bg-dark justify-content-center">
			<a class="navbar-brand" href=#><small>@CopyRight 2021</small></a>
		</nav>
		
			
	<script type="text/javascript">
 		function validate() {  
 			var firstname = document.getElementById('firstname').value;  
  			var lastname = document.getElementById("lastname").value;  
             var email = document.getElementById("email").value;  
 			var password = document.getElementById("password").value;  
     		var confirmpassword = document.getElementById("confirmpassword").value;  
			
          	if (firstname == "" ) {  
  				document.getElementById('fname').innerHTML = "**please Fill the FirstName field"  
 				return false; 
 				}  

           if((firstname.length<=3) || (firstname.length>=15)){  
 				document.getElementById('fname').innerHTML = "**please Fill the firstName between 2 -20 characters"  
 					return false;
 			}  
 			if (lastname == "") {  
 				document.getElementById('lname').innerHTML = "**please Fill the LastName field" 
  				return false;  
 			}  
  			if((lastname.length<=3) || (lastname.length>=15)){  
  				document.getElementById('lname').innerHTML = "**please Fill the lastName between 2 -20 characters"  
  					return false;  
  			}  
  			if (email == "") {  
 				document.getElementById('emails').innerHTML = "**please Enter the valid Email "  
				return false;  
 			}  
  			if (password == "") {  
 				document.getElementById('pwd').innerHTML = "**please password is invalid"  
  				return false;  
  			}  
 			if((password.length<=8) || (password.length>=30)){ 
				document.getElementById('pwd').innerHTML = "**please Fill the password between 8 -30 characters" 
					return false;  
 					}  
 			if (password!=confirmpassword) {
 				document.getElementById('cpwd').innerHTML = "** passwords are not matching"  
 				return false; 
 			}  
				
 		}
 		
  	</script> 
  	</form> 
</body>

</html>