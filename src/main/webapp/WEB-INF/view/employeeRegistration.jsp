


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hver er notandinn</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</head>
<body>
	<h1></h1>
	<h2>${errorMessage}</h2>
	 <form action = "/employeeInfo" method = "POST" >
	 <div class="form-group">
	 	 <label for = "nameInput">Nafn:</label>
         <input type = "text" id = "nameInput" name = "name" value = "${param.name}">
         </div>
         <div class="form-group">
         <label for = "birthdateInput">Fæðingar ár:</label>
          <input type= "date" id = "birthdateInput" name = "date" value = "${param.date}">
         </div>
         <div class="form-group">
         <label for = "emailInput">Email: </label>
         <input type = "text" id = "emailInput" name = "email" value ="${param.email}" />
         </div>
         <div class="form-group">
         <label for = "employeeType">Starfstitill: </label>
         <select id="employeeType" name="employeeType">
  		 <option value="Gæsla" ${paramValues.employeeType.stream().anyMatch(v->v == 'Gæsla').get() ? 'selected' : ''} >Gæsla</option>
  		 <option value="Sjúkgragæsla" ${paramValues.employeeType.stream().anyMatch(v->v == 'Sjúkgragæsla').get() ? 'selected' : ''} >Sjúkragæsla</option>
  		 <option value="Barþjónn" ${paramValues.employeeType.stream().anyMatch(v->v == 'Barþjónn').get() ? 'selected' : ''} >Barþjónn</option>
  		 <option value="Miðasala" ${paramValues.employeeType.stream().anyMatch(v->v == 'Miðasala').get() ? 'selected' : ''} >Miðasala</option>
		</select>
		</div>
		<div class="form-group">
		<label for = "size">Bolastærð:</label>		
		 <select id="size" name="size">
  		 <option value="XS" ${paramValues.size.stream().anyMatch(v->v == 'XS').get() ? 'selected' : ''}>Extra Small</option>
  		 <option value="S" ${paramValues.size.stream().anyMatch(v->v == 'S').get() ? 'selected' : ''}>Small</option>
  		 <option value="M" ${paramValues.size.stream().anyMatch(v->v == 'M').get() ? 'selected' : ''}>Medium</option>
  		 <option value="L" ${paramValues.size.stream().anyMatch(v->v == 'L').get() ? 'selected' : ''}>Large</option>
  		 <option value="XL" ${paramValues.size.stream().anyMatch(v->v == 'XL').get() ? 'selected' : ''}>Extra Large</option>
  		 <option value="XXL" ${paramValues.size.stream().anyMatch(v->v == 'XXL').get() ? 'selected' : ''}>Extra Extra Large</option>
  		 <option value="XXXL" ${paramValues.size.stream().anyMatch(v->v == 'XXXL').get() ? 'selected' : ''}>Extra Extra Extra Large</option>
		</select>
		</div>
		
         <input type = "submit" class="btn btn-primary" value = "Submit" />
         
      </form>
      
     
</body>
</html>