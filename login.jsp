<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body style="background-color:#ab0430;">
		<div align="center">
			<h1>CWU Login Form</h1>
			<form action="Login_info_Check" method="post">
				<table style="with: 100%">
					<tr>
						<td>Username</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" /></td>
					</tr>
				</table>
				<input type="submit" value="Login" />
			</form>
			<br>
			<img src="Campus.jpeg" width=400 height=500>
		</div>
	</body>
</html>