<%-- 
    Document   : result
    Created on : 18/06/2018, 11:41:48 AM
    Author     : SISTEMAS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido ${usuario.getTrabajador().getPersona().getNombres()}</h1>
        <p>${usuario.getUsu()}</p>
        <p>${usuario.isAcceder()}</p>
        <p>${usuario.isEstado()}</p>
        <p>${usuario.getClave().toString()}</p>
    </body>
</html>
