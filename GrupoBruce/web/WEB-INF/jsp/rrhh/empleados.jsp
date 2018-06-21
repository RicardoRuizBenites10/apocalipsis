<%@page pageEncoding="UTF-8"%>
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
                    <div class="page-title">
                        <div class="title_left">
                            <h4>
                                Gestión de trabajadores
                            </h4>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="x_panel">
                        <ul class="nav nav-tabs">
                            <li><a style="cursor: pointer;" id="newTrabajador" data-toggle="modal" data-target="#panel-trabajador"><i class="fa fa-plus"></i> Nuevo Trabajador</a></li>
                            <li class="active"><a data-toggle="tab" href="#lista-empleados"><i class="fa fa-users"></i> Lista de Trabajadores </a></li>
                        </ul>
                        <div class="clearfix"></div>
                        <div class="tab-content">
                            <!-- PANEL DE TRABAJADOR -->
                            <div id="panel-trabajador" class="modal fade" data-backdrop="static" role="dialog">    
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close hidden" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                                            <h5 class="modal-title" id="titleTrabajador">REGISTRO DE TRABAJADOR</h5>
                                        </div>
                                        <div class="modal-body">
                                            <%@include file="../jspf/FrmTrabajador.jspf" %>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- PANEL DE HIJO TRABAJADOR -->
                            <div id="panel-hijos" class="modal fade" data-backdrop="static" role="dialog">    
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                                            <h5 class="modal-title" id="titleTrabajador">HIJOS TRABAJADOR</h5>
                                        </div>
                                        <div class="modal-body">
                                            <%@include file="../jspf/FrmHijo.jspf" %>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                            
                            <!-- LISTA DE TRABAJADORES -->
                            <div id="lista-empleados" class="tab-pane fade in active "  style="padding-top: 30px;">
                                
                            </div>
                        </div>
                    </div>
                    <script>
                        $(document).ready(function(){
                            cargarTrabajadores();
                        });
                    </script>
                
                    <%@include file="../../template/footer-intranet.jspf" %>
                </div>
            </div>
        </div>
        
    </body>
</html>