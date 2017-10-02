
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="is">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staðfesting á skráningu vaktar</title>
</head>
<body>

	<h1>Skráning vaktarinnar: ${shift.getTitle()} tókst.</h1>
	<h1>Skráðar upplýsingar</h1>
	<h3>Titill: ${shift.getTitle()}</h3>
	<h3>Dagsetning: ${shift.getDate()}</h3>
	<h3>Upphafstími: ${shift.getBeginTime()}</h3>
	<h3>Lokatími: ${shift.getEndTime()}</h3>
	<h3>Fjöldi starfsmanna: ${shift.getHowMany()}</h3>
	<h3>Tegund vaktar: ${shift.getType()}</h3>
</body>
</html>