<%-- 
    Document   : rrhh-mantenimiento
    Created on : 24/04/2018, 07:52:25 AM
    Author     : SISTEMAS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../template/meta-intranet.jspf" %>
    </head>
    <body class="nav-md">
        <div class="container body">

            <div class="main_container">

                <div class="col-md-3 left_col">
                    <%@include file="../../template/menu-left.jspf" %>
                </div>
                <div class="top_nav">
                    <%@include file="../../template/menu-top.jspf" %>
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
                                    <%@include file="../jspf/FrmArea.jspf" %>
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
                                    <%@include file="../jspf/FrmSubarea.jspf" %>
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
                                    <%@include file="../jspf/FrmCargo.jspf" %>
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
                                        <h2><i class="fa fa-sitemap"></i> Estructura Organizacional</h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                                <ul  id="myTab" class="dropdown-menu" role="tablist">
                                                    <li role="presentation" class=""><a href="#eo_areas" id="area-tab" role="tab" data-toggle="tab" aria-expanded="true">Área</a></li>
                                                    <li role="presentation" class=""><a href="#eo_subarea" role="tab" id="subarea-tab" data-toggle="tab"  aria-expanded="false">Subárea</a></li>
                                                    <li role="presentation" class=""><a href="#eo_cargos" role="tab" id="cargo-tab" data-toggle="tab" aria-expanded="false">Cargos</a></li>
                                                    <li role="presentation" class=""><a href="#eo_funciones" role="tab" id="funcion-tab" data-toggle="tab" aria-expanded="false">Funciones</a></li>
                                                </ul>
                                            </li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                                            </li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <div class="" role="tabpanel" data-example-id="togglable-tabs">
                                            <div id="myTabContent" class="tab-content">
                                                <div role="tabpanel" class="tab-pane fade " id="eo_areas" aria-labelledby="home-tab">
                                                    <a style="cursor: pointer;" id="newArea" class="btn btn-dark btn-xs" data-toggle="modal" data-target="#panel-area"><i class="fa fa-plus">&nbsp;</i> Nueva área</a>
                                                    <div id="leo_area"  style="padding-top: 10px;">
                                                    </div>
                                                </div>
                                                <div role="tabpanel" class="tab-pane fade" id="eo_subarea" aria-labelledby="profile-tab">
                                                    <a style="cursor: pointer;" id="newSubarea" class="btn btn-dark btn-xs" data-toggle="modal" data-target="#panel-subarea"><i class="fa fa-plus">&nbsp;</i> Nueva Subarea</a>                                                    
                                                    <div id="leo_subarea"  style="padding-top: 10px;">
                                                    </div>
                                                </div>
                                                <div role="tabpanel" class="tab-pane fade" id="eo_cargos" aria-labelledby="profile-tab">
                                                    <a style="cursor: pointer;" id="newCargo" class="btn btn-dark btn-xs" data-toggle="modal" data-target="#panel-cargo"><i class="fa fa-plus">&nbsp; </i> Nuevo Cargo</a>                                                    
                                                    <div id="leo_cargo"  style="padding-top: 10px;">
                                                    </div>
                                                </div>
                                                <div role="tabpanel" class="tab-pane fade" id="eo_funciones" aria-labelledby="profile-tab">
                                                
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                            
                            <div class="col-md-6">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2><i class="fa fa-bars"></i> Planilla de personal </h2>
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
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                    <script>
                        $(document).ready(function () {
                            $("#area-tab").click(function(){
                                cargarArea();
                            });
                            $("#subarea-tab").click(function(){
                                cargarSubarea();
                            });
                            $("#cargo-tab").click(function(){
                                cargarCargo();
                            });
                        });
                    </script>
                    <%@include file="../../template/footer-intranet.jspf" %>
                </div>
            </div>

        </div>

    </body>
</html>
