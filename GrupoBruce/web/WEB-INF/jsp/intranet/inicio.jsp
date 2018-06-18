<%-- 
    Document   : inicio
    Created on : 28/11/2017, 03:11:13 PM
    Author     : SISTEMAS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="./../../WEB-INF/template/meta-intranet.jspf" %>
    </head>
    <body class="nav-md">
        <div class="container body">
            
            <div class="main_container">
                
                <div class="top_nav">
                    <%@include file="./../../WEB-INF/template/menu-top.jspf" %>
                </div>
                
                <div class="col-md-3 left_col">
                    <%@include file="./../../WEB-INF/template/menu-left.jspf" %>
                </div>
                
                <div class="right_col" role="main">
                    <div class="page-title">
                        <div class="title_left">
                            <h3 class="tatan">
                                Mantenimiento de procesos
                            </h3>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    
                    <%@include file="./../../WEB-INF/template/footer-intranet.jspf" %>
                </div>
            </div>
        </div>
        
    </body>
</html>
