<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <%@ include file = "layout.jsp" %>
    
   
    


 <c:forEach items="${reservationsList}" var="r">
 <input   name="idevent" value="${r.idEvenenemnt}" >   
							      <input  name="total" value="${r.prixReservation}" > 
							    <h1>${r.idEvenenemnt}</h1>   
							      <h1>${r.prixReservation}</h1>    
							      					
								</c:forEach>
	
	
</body>
</html>