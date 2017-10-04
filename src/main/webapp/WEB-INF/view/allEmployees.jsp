<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>Allir starfsmenn</title>
</head>
<body>
		<h1>Employees</h1>
    
     <c:choose>
        <c:when test="${not empty employees}">
            <table class="employees">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Type</th>
                        <th>Size</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <c:forEach var ="Employee" items="${employees}">
                    <tr>
                        <td>${Employee.name} </td>
                        <td>${Employee.email} </td>
                        <td>${Employee.type} </td>
                        <td>${Employee.size} </td>
                        <td>${Employee.date} </td>                     
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