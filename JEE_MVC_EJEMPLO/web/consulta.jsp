<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : consulta
    Created on : 18-08-2018, 23:23:38
    Author     : Cristopher
--%>
<%@page import="Modelo.Persona"%>
<%@page import="java.util.ArrayList"%>
<%
 ArrayList<Persona> persona = (ArrayList<Persona>) request.getSession().getAttribute("personas"); 
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mostrar todo</h1>
        
        <%
            for (int i = 0; i < persona.size(); i++) {
                    out.println("<p>Nombre: " +persona.get(i).getNombre()+"</p>");
                }
        %>
        
    <c:forEach var="personas" items="${sessionScope.personas}">
        <p>${personas.nombre}- rut: ${personas.rut}</p>
    </c:forEach>
        
    </body>
</html>
