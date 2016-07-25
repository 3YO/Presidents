<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Oswald:700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="mystyle.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>President List</title>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.html">Presidents</a>
			</div>
		</div>
	</nav>
	<div class="container-fluid">
		<br>
		<br>
		<br>
		<br>
		<div class="jumbotron">
			<div class="text-center">

				<h1>${selected.firstName}${selected.middleName}
					${selected.lastName}<br> <small>President # <b>${selected.termNumber}</b></small>
				</h1>

				<br> <img src="${selectPhoto.photo}"> <br> <br>
				<img src="${selectSignature.signature}"><br />
				<p>
					Term years: <b>${selected.startYear} - ${selected.endYear}</b>
				</p>

				<p>
					Party: <b>${selected.party}</b>
				</p>
				<p>
					Vice-President:<b> ${selected.vp}</b>
				</p>
				<p class="lead">${selectedTri.trivia}</p>



				<!-- End of president card -->

			</div>
		</div>

		<div class="text-center">
			<a href="PresServlet?term=${selected.termNumber-1}">Prev</a> <a
				href="PresServlet?term=${selected.termNumber+1}">Next</a><br>
		</div>
		<br />
		<hr />

		<div class="jumbotron">

			<h3 class="text-center">Want to see another President ?? Just
				give me a number</h3>
			<div class="">
				<div class="text-center">

					<form class="form-inline" action="PresServlet" method="POST">
						<div class="form-group">
							<input class="form-control" type="text" name="term" />
							<button type="submit" class="btn btn-default">Go!</button>
						</div>

					</form>
				</div>
			</div>

		</div>



	</div>
</body>
</html>