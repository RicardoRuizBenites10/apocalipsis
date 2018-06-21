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
                                Gestión de vacaciones
                            </h4>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="x_panel">
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#lista-vacaciones"><i class="fa fa-list-alt"></i> Vacaciones asignadas </a></li>
                        </ul>
                        <div class="clearfix"></div>
                        <div class="tab-content">
                            <!-- PANEL DE VACACION -->
                            <div id="panel-vacacion" class="modal fade" data-backdrop="static" role="dialog">    
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close hidden" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                                            <h5 class="modal-title" id="titleTrabajador">REGISTRO DE VACACIÓN</h5>
                                        </div>
                                        <div class="modal-body">
                                            <%@include file="../jspf/FrmVacacion.jspf" %>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>     
                            <!-- PANEL HISTORIAL VACACION -->
                            <div id="panel-vacacion-historial" class="modal fade" data-backdrop="static" role="dialog">    
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                                            <h5 class="modal-title" id="titleTrabajador">HISTORIAL DE VACACIONES</h5>
                                        </div>
                                        <div class="modal-body">
                                            <%@include file="../jspf/FrmVacacionHistorial.jspf" %>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>        
                            <!-- TIPO DE CONSULTA -->
                            <div class="col-xs-12" style="margin-top: 20px; margin-bottom: 20px;">
                                <div class="col-xs-3">
                                    <div class="col-xs-12">
                                        <label>Situación :</label>
                                    </div>
                                    <div class="col-xs-6">
                                        <label>
                                            <input type="radio" id="optSituacionV1" value="1" name="optSituacionV"> Registrado 
                                        </label>
                                    </div>
                                    <div class="col-xs-6">
                                        <label>
                                            <input type="radio" checked id="optSituacionV2" value="0" name="optSituacionV"> Por registrar
                                        </label>
                                    </div> 
                                </div>
                                <div class="col-xs-3">
                                    <label for="periodoVacacion" >Periodo :</label>
                                    <select id="periodoVacacion" class="form-control" required>
                                        <option value=""> Seleccionar periodo  </option>
                                    </select>
                                </div>
                                <div class="col-xs-3">
                                    <a id="searchVacaciones" class="btn btn-app">
                                        <i class="fa fa-search"></i> Listar
                                    </a>
                                </div>
                            </div>
                            <!-- LISTA DE TRABAJADORES -->
                            <div id="lista-vacaciones" class="tab-pane fade in active" style="padding-top: 30px;">
                                
                            </div>
                        </div>
                    </div>
                    <script>
                        
                        $(document).ready(function () {
                            $("#searchVacaciones").click(function(){
                                if($("#periodoVacacion").val()===""){
                                    alert("Seleccionar periodo.");
                                }else{
                                    var situacion = $('input:radio[name=optSituacionV]:checked').val();
                                    cargarVacaciones(situacion,$("#periodoVacacion").val());
                                }
                            });
                        });
                    </script>                    
                
                    <%@include file="../../template/footer-intranet.jspf" %>
                </div>
            </div>
        </div>
        
    </body>
</html>