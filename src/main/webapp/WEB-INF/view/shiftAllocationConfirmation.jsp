
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="is">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Skráning starfsmanns á vakt tókst</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</head>
<body>

	<h1>Skráning starfsmanns á vakt tókst!</h1>
	<h2>Upplýsingar um starfsmann:</h2>
	<p>
	Nafn: ${employee.getName()}<br>
	Fæðingardagur: ${employee.getDate()}<br>
	Email: ${employee.getEmail()}<br>
	Starfstitill: ${employee.getType()}<br></p>
	<h2>Upplýsingar um vakt:</h2>
	<p>Titill: ${shift.getTitle()}<br>
	Dagsetning: ${shift.getDate()}<br>
	Upphafstími: ${shift.getBeginTime()}<br>
	Lokatími: ${shift.getEndTime()}<br>
	Tegund vaktar: ${shift.getType()}</p>
</body>
</html>