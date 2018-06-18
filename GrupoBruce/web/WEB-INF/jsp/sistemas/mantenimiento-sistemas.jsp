<%-- 
    Document   : mantenimiento-sistemas
    Created on : 10/05/2018, 10:12:47 AM
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

                <div class="col-md-3 left_col">
                    <%@include file="./../../WEB-INF/template/menu-left.jspf" %>
                </div>
                <div class="top_nav">
                    <%@include file="./../../WEB-INF/template/menu-top.jspf" %>
                </div>
                <div class="right_col" role="main">
                    <!-- PANEL DE AREA --> 
                    <div id="panel-area" class="modal fade" data-backdrop="static" role="dialog">    
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close hidden" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                                    <h5 class="modal-title" id="titleArea">REGISTRO DE ÁREA</h5>
                                </div>
                                <div class="modal-body">
                                    <%@include file="./../../WEB-INF/jspf/FrmArea.jspf" %>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                    </div> 
                    <!-- PANEL DE SUBAREA --> 
                    <div id="panel-subarea" class="modal fade" data-backdrop="static" role="dialog">    
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close hidden" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                                    <h5 class="modal-title" id="titleSubarea">REGISTRO DE SUBAREA</h5>
                                </div>
                                <div class="modal-body">
                                    <%@include file="./../../WEB-INF/jspf/FrmSubarea.jspf" %>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                    </div> 
                    <!-- PANEL DE CARGO --> 
                    <div id="panel-cargo" class="modal fade" data-backdrop="static" role="dialog">    
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close hidden" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                                    <h5 class="modal-title" id="titleCargo">REGISTRO DE CARGO</h5>
                                </div>
                                <div class="modal-body">
                                    <%@include file="./../../WEB-INF/jspf/FrmCargo.jspf" %>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                    </div> 
                    <!-- -->        
                    <div class="">
                        <div class="page-title">
                            <div class="title_left">
                                <h4>Mantenimientos</h4>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Configuración del sistema</h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                                <ul class="dropdown-menu" role="menu">
                                                    <li><a href="#">Nuevo</a>
                                                    </li>
                                                    <li><a href="#">Settings 2</a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                                            </li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <a class="btn btn-app">
                                            <i class="fa fa-list-ul"></i> Menus
                                        </a>
                                        <a class="btn btn-app">
                                            <i class="fa fa-list-ul"></i> Submenus
                                        </a>
                                        <a class="btn btn-app">
                                            <span class="badge bg-green">211</span>
                                            <i class="fa fa-link"></i> Repositorios
                                        </a>
                                        <a class="btn btn-app">
                                            <i class="fa fa-cog"></i> Generales
                                        </a>
                                        <a class="btn btn-app">
                                            <i class="fa fa-table"></i> Tablas BD
                                        </a>
                                    </div>
                                </div>
                                
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Mantenimiento basicos</h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                                <ul class="dropdown-menu" role="menu">
                                                    <li><a href="#">Nuevo</a></li>
                                                    <li><a href="#">Settings 2</a></li>
                                                </ul>
                                            </li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <a class="btn btn-app">
                                            <i class="fa fa-th-large"></i> Tipologia
                                        </a>
                                    </div>
                                </div>
                            </div>    
                            
                            <div class="col-md-6">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Control de acceso al sistema </h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                            </li>
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                                <ul class="dropdown-menu" role="menu">
                                                    <li><a href="#">Settings 1</a>
                                                    </li>
                                                    <li><a href="#">Settings 2</a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                                            </li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <a class="btn btn-app">
                                            <i class="fa fa-lock"></i> Accesos
                                        </a>
                                        <a class="btn btn-app">
                                            <span class="badge bg-green">211</span>
                                            <i class="fa fa-users"></i> Usuarios
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <script>
                        $(document).ready(function () {

                        });
                    </script>
                    <%@include file="./../../WEB-INF/template/footer-intranet.jspf" %>
                </div>
            </div>

        </div>

    </body>
</html>

