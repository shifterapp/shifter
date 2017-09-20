
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="is">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Góðan daginn</title>
</head>
<body>

	<h1>Takk fyrir skráninguna ${employee.getName()}.</h1>
	<h1>Skráðar upplýsingar</h1>
	<h3>Nafn: ${employee.getName()}</h3>
	<h3>Fæðingardagur: ${employee.getDate()}</h3>
	<h3>Email: ${employee.getEmail()}</h3>
	<h3>Starfstitill: ${employee.getType()}</h3>
	<h3>Bolastærð: ${employee.getSize()}</h3>

</body>
</html>