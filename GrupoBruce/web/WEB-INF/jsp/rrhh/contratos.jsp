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
                                Gestión de contrato de trabajadores
                            </h4>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="x_panel">
                        <ul class="nav nav-tabs">
                            <li class=""></li>
                            <li class="active"><a data-toggle="tab" href="#lista-empleados"><i class="fa fa-list-alt"></i> Lista de contrato de trabajadores </a></li>
                        </ul>
                        <div class="clearfix"></div>
                        <div class="tab-content">
                            <!-- PANEL DE CONTRATO -->
                            <div id="panel-contrato" class="modal fade" data-backdrop="static" role="dialog">    
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close hidden" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                                            <h5 class="modal-title" id="titleFrmContrato">REGISTRO DE CONTRATO</h5>
                                        </div>
                                        <div class="modal-body">
                                            <%@include file="../jspf/FrmContrato.jspf" %>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- PANEL DETALLE CONTRATO -->
                            <div id="panel-contrato-historial" class="modal fade" data-backdrop="static" role="dialog">    
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                                            <h5 class="modal-title" id="titleFrmContratoH">HISTORIAL DE CONTRATOS</h5>
                                        </div>
                                        <div class="modal-body">
                                            <%@include file="../jspf/FrmContratoHistorial.jspf" %>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                            
                            <!-- LISTA DE CONTRATOS -->
                            <div id="lista-empleados" class="tab-pane fade in active " style="padding-top: 30px;">
                            </div>
                        </div>
                    </div>
                    <script>
                        $(document).ready(function(){
                            cargarContratos();
                        });
                    </script>
                    <%@include file="../../template/footer-intranet.jspf" %>
                </div>
            </div>
        </div>
        
    </body>
</html>
