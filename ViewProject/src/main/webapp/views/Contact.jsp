<%-- 
    Document   : home.jsp
    Created on : Apr 1, 2021, 5:39:35 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style type="text/css">
* {
	margin: 0px;
}

header {
	height: 100px;
	background-color: orange;
}

header a {
	margin-left: 20px;
	font-size: 25px;
	font-weight: bolder;
	text-decoration: none;
}

section {
	height: 500px;
	background-color: graytext;
}

footer {
	height: 100px;
	background-color: orange;
}
</style>
</head>
<body>
	<header>
		<h1>Welcome in header part</h1>
		<a href="home">Home</a><a href="index">Index</a>
	</header>
	<section>
		<div style="width: 50%; float: left; border: 1px solid red;">
			<h1>Welcome in Contact us page</h1>
			<h2>Head Office</h2>
			<hr style="background-color: red; height: 3px;">

			<p>M6 First Floor Kanchan Sagar Near Industry House Palasia A.B
				Road Indore</p>


			<p>7805-063968</p>
			<hr style="background-color: red; height: 3px;">

			<h2>Branch Office</h2>

			<p>GH 43, Scheme No 54, Vijay Nagar, Indore - 452010, Near Of
				Perfect Bakery</p>


			<p>7805-063968</p>

		</div>


		<div
			style="width: 49%; float: left; height: 100%; border: 1px solid red;">
			<p>Welcome to contact page.</p>
			<marquee direction="up">
				<p>JAVA Training</p>
				<p>JAVA Training</p>
				<p>JAVA Training</p>
				<p>JAVA Training</p>
				<p>JAVA Training</p>
			</marquee>
		</div>


	</section>
	<footer>
		<h1>Welcome in footer part</h1>
	</footer>
</body>
</html>