<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
 crossorigin="anonymous">
</head>
<body>

	<di class="container mt-4 col-lg-4">	
		<di class=" card col-sm-10">
			<di class=" card-body ">
				<form class="form-sing" action="Validar" method="POST">
					<div class="form group text-center">
					<h3>LOGIN</h3>
					
					<h3>Bienvenidos</h3>
				  	</div>
				  	<div class="form group">
				  	<label>Usuario</label>
				  	<input type="text" name="txtuser" class="form-control">
				  	</div>
				  	<div class="form group">
				  	<label>Password</label>
				  	<input type="password" name="txtpass" class="form-control">
				  	
				  	</div>
				  	<input type="submit" name="accion" value="Ingresar" class="btn btn primary btn-b">
				
				
				</form>
			
			</di>
		
		</di>
	
	</di>

	
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
</body>
</html>