


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Skráning starfsmanns</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<c:url value="/resources/styles/registration.css" />">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css"
	rel="stylesheet">
</head>
<body>
	<div class="registration_wrapper">
		<h1 class="registration_header">Starfsmannaskráning</h1>
		<div
			class="${errorMessage.length() > 0 ? 'registration_errormessage' : ''}">${errorMessage}</div>
		<form action="/employeeInfo" method="POST">

			<div class="registration_input_wrapper">
				<label class="registration_icon" for="nameInput"><i
					class="icon-user"></i></label> <input type="text"
					class="registration_input" placeholder="Nafn" name="name"
					value="${param.name}">
			</div>

			<div class="registration_input_wrapper">
				<label class="registration_icon" for="emailInput"><i
					class="icon-envelope "></i></label> <input type="text"
					class="registration_input" placeholder="Netfang" name="email"
					value="${param.email}" />
			</div>

			<div class="registration_input_wrapper">
				<label class="registration_icon" for="birthdateInput"><i
					class="icon-calendar "></i></label> <input type="date"
					class="registration_input" placeholder="Fæðingardagur" onfocus="(this.type='date')" onblur="if(this.value==''){this.type='text'}"  name="date" 
					value="${param.date}">
			</div>

			<div class="registration_input_wrapper">
				<label class="registration_icon" for="employeeType"><i
					class="icon-briefcase "></i></label> <select class="registration_select"
					name="employeeType">
					<option value="" disabled selected>Starfstitill</option>
					<option value="Gæsla"
						${paramValues.employeeType.stream().anyMatch(v->v == 'Gæsla').get() ? 'selected' : ''}>Gæsla</option>
					<option value="Sjúkgragæsla"
						${paramValues.employeeType.stream().anyMatch(v->v == 'Sjúkgragæsla').get() ? 'selected' : ''}>Sjúkragæsla</option>
					<option value="Barþjónn"
						${paramValues.employeeType.stream().anyMatch(v->v == 'Barþjónn').get() ? 'selected' : ''}>Barþjónn</option>
					<option value="Miðasala"
						${paramValues.employeeType.stream().anyMatch(v->v == 'Miðasala').get() ? 'selected' : ''}>Miðasala</option>
				</select>
			</div>

			<div class="registration_input_wrapper">
				<label class="registration_icon" for="size"><i
					class="icon-pencil"></i></label> <select class="registration_select"
					name="size">
					<option value="" disabled selected>Stuttermabolastærð</option>
					<option value="XS"
						${paramValues.size.stream().anyMatch(v->v == 'XS').get() ? 'selected' : ''}>Extra Small</option>
					<option value="S"
						${paramValues.size.stream().anyMatch(v->v == 'S').get() ? 'selected' : ''}>Small</option>
					<option value="M"
						${paramValues.size.stream().anyMatch(v->v == 'M').get() ? 'selected' : ''}>Medium</option>
					<option value="L"
						${paramValues.size.stream().anyMatch(v->v == 'L').get() ? 'selected' : ''}>Large</option>
					<option value="XL"
						${paramValues.size.stream().anyMatch(v->v == 'XL').get() ? 'selected' : ''}>Extra Large</option>
					<option value="XXL"
						${paramValues.size.stream().anyMatch(v->v == 'XXL').get() ? 'selected' : ''}>Extra Extra Large</option>
					<option value="XXXL"
						${paramValues.size.stream().anyMatch(v->v == 'XXXL').get() ? 'selected' : ''}>Extra Extra Extra Large</option>
				</select>
			</div>

			<input type="submit" class="registration_button" value="Submit" />

		</form>
	</div>


</body>
</html>