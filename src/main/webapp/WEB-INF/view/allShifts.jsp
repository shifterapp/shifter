<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>Allar Shifts</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</head>
<body>
		<h1>Shifts</h1>
    
     <c:choose>
        <c:when test="${not empty shifts}">
            <table class="shift table table-hover" >
                <thead class="thead-inverse">
                    <tr>
                        <th>Title</th>
                        <th>Type</th>
                        <th>Date</th>
                        <th>Begin Time</th>
                        <th>End Time</th>
                        <th>How Many</th>
                    </tr>
                </thead>
                <c:forEach var ="Shift" items="${shifts}">
                    <tr>
                        <td>${Shift.title} </td>
                        <td>${Shift.type} </td>
                        <td>${Shift.date} </td>
                        <td>${Shift.beginTime} </td>
                        <td>${Shift.endTime} </td>
                        <td>${Shift.howMany} </td>
                                           
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <h3>No shifts</h3>
        </c:otherwise>
    </c:choose>       
</body>

</html>