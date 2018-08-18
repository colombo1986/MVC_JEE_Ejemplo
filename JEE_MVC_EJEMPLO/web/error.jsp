<%-- 
    Document   : error
    Created on : 18-08-2018, 17:22:23
    Author     : Cristopher
--%>
<%
    String error = (String)request.getSession().getAttribute("error");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ha ocurrido un error : <%= error %> </h1>
    </body>
</html>
