<%-- 
    Document   : index
    Created on : 18-08-2018, 17:10:44
    Author     : Cristopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro</h1>
     <form action="registro.do" method="post">    
        <table>    
            <tr>
                <td>Rut</td>
                <td><input type="text" name="txtRut"></input></td>
            
            </tr>
            
                <tr>
                <td>Nombre</td>
                <td><input type="text" name="txtNombre"></input></td>
            
            </tr>
            
                <tr>
                <td>Edad</td>
                <td><input type="text" name="txtEdad"></input></td>
            </tr>
            
            <tr>
                <td><input type = "submit" value ="Registrar"/></td>
                
            </tr>
        </table>
         
         
</form>
    </body>
</html>
