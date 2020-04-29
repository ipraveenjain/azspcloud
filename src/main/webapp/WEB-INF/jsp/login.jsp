<html>

<script>
	function login() {
		document.getElementById("myForm").action = "login";
		document.getElementById("myForm").submit();
	}

	function register() {
		document.getElementById("myForm").action = "register";
		document.getElementById("myForm").submit();
	}
</script>
<head>
<title>First Web Application</title>
</head>

<body>
	<font color="red">${errorMessage}</font>
	<form method="post" id="myForm">

		<table align="center">
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td><button type="submit" onclick="login()">login</button></td>
				<td><button type="submit" onclick="register()">register
					</button></td>
			</tr>
		</table>
	</form>

</body>

</html>