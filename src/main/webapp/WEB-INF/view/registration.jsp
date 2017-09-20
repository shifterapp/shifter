


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hver er notandinn</title>
</head>
<body>
	<h1></h1>
	<h2>${errorMessage}</h2>
	 <form action = "/employeeInfo" method = "POST" ">
         Nafn: <input type = "text" name = "name">
         <br />
         Fæðingar ár: <input type="date" name = "date">
         <br />
         Email: <input type = "text" name = "email">
         <br />
         Starfstitill: <select id="employeeType" name="employeeType">
  		 <option value="Gæsla" ${paramValues.employeeType.stream().anyMatch(v->v == 'Gæsla').get() ? 'selected' : ''} >Gæsla</option>
  		 <option value="Sjúkgragæsla" ${paramValues.employeeType.stream().anyMatch(v->v == 'Sjúkgragæsla').get() ? 'selected' : ''} >Sjúkragæsla</option>
  		 <option value="Barþjónn" ${paramValues.employeeType.stream().anyMatch(v->v == 'Barþjónn').get() ? 'selected' : ''} >Barþjónn</option>
  		 <option value="Miðasala" ${paramValues.employeeType.stream().anyMatch(v->v == 'Miðasala').get() ? 'selected' : ''} >Miðasala</option>
		</select>
		<br/>
		Bolastærð: <select id="size" name="size">
  		 <option value="XS" ${paramValues.size.stream().anyMatch(v->v == 'XS').get() ? 'selected' : ''}>Extra Small</option>
  		 <option value="S" ${paramValues.size.stream().anyMatch(v->v == 'S').get() ? 'selected' : ''}>Small</option>
  		 <option value="M" ${paramValues.size.stream().anyMatch(v->v == 'M').get() ? 'selected' : ''}>Medium</option>
  		 <option value="L" ${paramValues.size.stream().anyMatch(v->v == 'L').get() ? 'selected' : ''}>Large</option>
  		 <option value="XL" ${paramValues.size.stream().anyMatch(v->v == 'XL').get() ? 'selected' : ''}>Extra Large</option>
  		 <option value="XXL" ${paramValues.size.stream().anyMatch(v->v == 'XXL').get() ? 'selected' : ''}>Extra Extra Large</option>
  		 <option value="XXXL" ${paramValues.size.stream().anyMatch(v->v == 'XXXL').get() ? 'selected' : ''}>Extra Extra Extra Large</option>
		</select>
		<br/>
         <input type = "submit" value = "Submit" />
      </form>
     
</body>
</html>