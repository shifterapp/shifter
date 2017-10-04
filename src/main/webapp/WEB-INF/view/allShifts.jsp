<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>Allar Shifts</title>
</head>
<body>
		<h1>Shifts</h1>
    
     <c:choose>
        <c:when test="${not empty shifts}">
            <table class="shift">
                <thead>
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
            <h3>No employees</h3>
        </c:otherwise>
    </c:choose>       
</body>

</html>