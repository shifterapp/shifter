


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Búa til vakt</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</head>
<body>
	<h1></h1>
	<h2>${errorMessage}</h2>
	 <form action = "/shiftInfo" method = "POST" >
		<div class="form-group">
		<label for = "shiftTitleInput">Titill:</label>
          <input type = "text" id="shiftTitleInput" name = "title" value = "${param.title}">
         </div>
         <div class="form-group">
         <label for = "dateInput">Dagsetning:</label>
          <input type = "date" id = "dateInput" name = "shiftDate" value ="${param.shiftDate}" />
         </div>
         <div class="form-group">
         <label for = "beginInput">Upphafstími:</label>
          <input type="time" id = "beginInput" name = "beginTime" value = "${param.beginTime}">
         </div>
         <div class="form-group">
         <label for = "endInput">Lokatími:</label>
          <input type="time" id = "endInput" name = "endTime" value = "${param.endTime}">
         </div>
         <div class="form-group">
         <label for ="howManyInput" >Fjöldi starfsmanna: </label>
         <input type="text" id = "howManyInput" name = "howMany" value = "${param.howMany}">
        </div>
        <div class="form-group">
        <label for = "shiftType">Tegund vaktar: </label>
         <select id="shiftType" name="shiftType">
  		 <option value="Gæsla" ${paramValues.employeeType.stream().anyMatch(v->v == 'Gæsla').get() ? 'selected' : ''} >Gæsla</option>
  		 <option value="Sjúkgragæsla" ${paramValues.employeeType.stream().anyMatch(v->v == 'Sjúkgragæsla').get() ? 'selected' : ''} >Sjúkragæsla</option>
  		 <option value="Barþjónn" ${paramValues.employeeType.stream().anyMatch(v->v == 'Barþjónn').get() ? 'selected' : ''} >Barþjónn</option>
  		 <option value="Miðasala" ${paramValues.employeeType.stream().anyMatch(v->v == 'Miðasala').get() ? 'selected' : ''} >Miðasala</option>
		</select>
		</div>
         <input type = "submit" class="btn btn-primary" value = "Submit" />
      </form>
     
</body>
</html>