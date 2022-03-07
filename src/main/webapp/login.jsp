<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - Adson CRUD-Web</title>

<link rel="stylesheet" href="css/global.css" />

</head>
<body>


	<div class="container">

		<form method="post" class="form">

			<h1>Login do Sistema</h1>



			<div class="campo">
				<label for="login">Login:</label> <input type="text" id="login"
					name="login" maxlength="15" />
			</div>

			<div class="senha">
				<label for="senha">Senha:</label> <input type="password" id="senha"
					name="senha" maxlength="15" />
			</div>

			<div class="logar">
				<input type="submit" value="Logar" />
				
			</div>
			
			<div class="campo">
			<a href="">Esqueci a Senha</a>
			</div>
		</form>

	</div>

</body>
</html>