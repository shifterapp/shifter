


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Búa til vakt</title>
</head>
<body>
	<h1></h1>
	<h2>${errorMessage}</h2>
	 <form action = "/shiftInfo" method = "POST" >
         Titill: <input type = "text" name = "title" value = "${param.title}">
         <br />
         Dagsetning: <input type = "date" name = "shiftDate" value ="${param.shiftDate}" />
         <br />
         Upphafstími: <input type="time" name = "beginTime" value = "${param.beginTime}">
         <br />
         Lokatími: <input type="time" name = "endTime" value = "${param.endTime}">
         <br />
         Fjöldi starfsmanna: <input type="text" name = "howMany" value = "${param.howMany}">
         <br />
         Tegund vaktar: <select id="shiftType" name="shiftType">
  		 <option value="Gæsla" ${paramValues.employeeType.stream().anyMatch(v->v == 'Gæsla').get() ? 'selected' : ''} >Gæsla</option>
  		 <option value="Sjúkgragæsla" ${paramValues.employeeType.stream().anyMatch(v->v == 'Sjúkgragæsla').get() ? 'selected' : ''} >Sjúkragæsla</option>
  		 <option value="Barþjónn" ${paramValues.employeeType.stream().anyMatch(v->v == 'Barþjónn').get() ? 'selected' : ''} >Barþjónn</option>
  		 <option value="Miðasala" ${paramValues.employeeType.stream().anyMatch(v->v == 'Miðasala').get() ? 'selected' : ''} >Miðasala</option>
		</select>
		<br/>
         <input type = "submit" value = "Submit" />
      </form>
     
</body>
</html>