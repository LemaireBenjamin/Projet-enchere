<%@ page language="java"
 contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Erreur</title>
</head>
<body>
	
	<h1>Page Erreur</h1>
	
	
	<p>
		<%= exception.getMessage() %>
	</p>
</body>
</html>