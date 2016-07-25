<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Oswald:700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="mystyle.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>President List</title>
</head>
<body>
	<div class="top-header">
		<!--  CSS here to make a top banner -->
		<h1>All of the Presidents</h1>
	
	</div>
	<div class="presCard">
		<!--  President card info will go here -->
		<div id="presPic">
			<img src="${selectPhoto.photo}">
		</div>

		<div id="presName">President number: ${selected.termNumber}<br/>
			${selected.firstName} ${selected.middleName} ${selected.lastName}<br />  <img
				id="sign" src="${selectSignature.signature}"><br />
			<div id="years">Term years: <br/>${selected.startYear}-${selected.endYear}<br /></div>

		</div>
		<label class="collapse" for="_1"> --Show Party--</label> <input
			id="_1" type="checkbox">
		<div id="party">
			Party: ${selected.party}
		</div>
		<br /> <label class="collapse" for="_3">--Show Vice-President--</label> <input
			id="_3" type="checkbox">
		<div id="vp">
			${selected.vp}
		</div>
		<br /> <label class="collapse" for="_2">--Show Trivia--</label> <input
			id="_2" type="checkbox">
		<div id="trivia">
			${selectedTri.trivia}
		</div>



	</div>
	<!-- End of president card -->
	<br>
	<div id="prevNext">
		<a href="PresServlet?term=${selected.termNumber-1}">Prev</a> <a
			href="PresServlet?term=${selected.termNumber+1}">Next</a><br>
	</div>
	<hr />

	<p id="q1">Want to see another president? Just give me a number!</p>
	<form action="PresServlet" method="GET">
		<input type="text" name="term" />
		<button>Go!</button>
	</form>
	<form action="index.html" method="GET">
		<div class="button medium-btn"><button>Home</button></div>
	</form>



</body>
</html>