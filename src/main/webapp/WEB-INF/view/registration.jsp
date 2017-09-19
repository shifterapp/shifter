


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
         Aldur: <input type = "date" name = "date">
         <br />
         Email: <input type = "text" name = "email"/>
         <br />
         Starfstitill: <select id="employeeType" name="employeeType">
  		 <option value="Gæsla">Gæsla</option>
  		 <option value="Sjúkgragæsla">Sjúkragæsla</option>
  		 <option value="Barþjónn">Barþjónn</option>
  		 <option value="Miðasala">Miðasala</option>
		</select>
		<br/>
		Bolastærð: <select id="size" name="size">
  		 <option value="XS">Extra Small</option>
  		 <option value="S">Small</option>
  		 <option value="M">Medium</option>
  		 <option value="L">Large</option>
  		 <option value="XL">Extra Large</option>
  		 <option value="XXL">Extra Extra Large</option>
  		 <option value="XXXL">Extra Extra Extra Large</option>
		</select>
		<br/>
         <input type = "submit" value = "Submit" />
      </form>
     
</body>
</html>