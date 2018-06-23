function cargarArea() {
    var table =
            '<table id="tbl-area" class="table-area table table-striped table-condensed responsive-utilities jambo_table">' +
            '<thead>' +
            '<tr class="headings">' +
            '<th class="hidden"></th>' +
            '<th>Nombre</th>' +
            '<th>Estado</th>' +
            '<th class=" no-link last"> <span>  Acciones  </span> </th>' +
            '</tr>' +
            '</thead>' +
            '<tbody>';

    $.post("../../CArea", {accion: "AreaAll"}, function (responseText) {
        if (responseText !== null) {
            $.each(responseText, function (index, item) {
                var spanEstado;
                if (item.situacion)
                    spanEstado = "ACTIVO";
                else
                    spanEstado = "INACTIVO";
                table = table +
                        '<tr class="odd pointer">' +
                        '<td class="hidden">' + JSON.stringify(item) + '</td>' +
                        '<td class=" a-left a-left">' + item.nombre + '</td>' +
                        '<td class="text-center">' +
                        '<span class="label ' + spanEstado + ' "> ' + spanEstado + '</span>' +
                        '</td>' +
                        '<td class=" a-center ">' +
                        '<a style="cursor: pointer;" class="btn-area-edit btn btn-info btn-xs"  data-toggle="modal" data-target="#panel-area" title="Editar"><i class="fa fa-pencil"></i></a>' +
                        '<a style="cursor: pointer;" class="btn-area-delete btn btn-danger btn-xs"  data-toggle="modal" data-target="" title="Eliminar"><i class="fa fa-trash"></i></a>';
                table = table + '</td> </tr>';
            });
        }
        table = table + '</tbody> </table>';
    }).done(function () {
        $("#leo_area").html(table);
        inicializaTabla($("#tbl-area"));
        from_area();
    });
}

function cargarSubarea() {
    var table =
            '<table id="tbl-subarea" class="table-subarea table table-striped table-condensed responsive-utilities jambo_table">' +
            '<thead>' +
            '<tr class="headings">' +
            '<th class="hidden"></th>' +
            '<th>Nombre área</th>' +
            '<th>Nombre subarea</th>' +
            '<th>Estado</th>' +
            '<th class=" no-link last"> <span>  Acciones  </span> </th>' +
            '</tr>' +
            '</thead>' +
            '<tbody>';

    $.post("../../CSubarea", {accion: "SubareaAll"}, function (responseText) {
        if (responseText !== null) {
            $.each(responseText, function (index, item) {
                var spanEstado;
                if (item.situacion)
                    spanEstado = "ACTIVO";
                else
                    spanEstado = "INACTIVO";
                table = table +
                        '<tr class="odd pointer">' +
                        '<td class="hidden">' + JSON.stringify(item) + '</td>' +
                        '<td class=" a-left a-left">' + item.area.nombre + '</td>' +
                        '<td class=" a-left a-left">' + item.nombre + '</td>' +
                        '<td class="text-center">' +
                        '<span class="label ' + spanEstado + ' "> ' + spanEstado + '</span>' +
                        '</td>' +
                        '<td class=" a-center ">' +
                        '<a style="cursor: pointer;" class="btn-subarea-edit btn btn-info btn-xs"  data-toggle="modal" data-target="#panel-subarea" title="Editar"><i class="fa fa-pencil"></i></a>' +
                        '<a style="cursor: pointer;" class="btn-subarea-delete btn btn-danger btn-xs"  data-toggle="modal" data-target="" title="Eliminar"><i class="fa fa-trash"></i></a>';
                table = table + '</td> </tr>';
            });
        }
        table = table + '</tbody> </table>';
    }).done(function () {
        $("#leo_subarea").html(table);
        inicializaTabla($("#tbl-subarea"));
        from_subarea();
    });
}

function cargarCargo() {
    var table =
            '<table id="tbl-cargo" class="table table-striped table-condensed responsive-utilities jambo_table">' +
            '<thead>' +
            '<tr class="headings">' +
            '<th class="hidden"></th>' +
            '<th>Nombre subarea</th>' +
            '<th>Nombre Cargo</th>' +
            '<th>Estado</th>' +
            '<th class=" no-link last"> <span>  Acciones  </span> </th>' +
            '</tr>' +
            '</thead>' +
            '<tbody>';

    $.post("../../CCargo", {accion: "CargoAll"}, function (responseText) {
        if (responseText !== null) {
            $.each(responseText, function (index, item) {
                var spanEstado;
                if (item.situacion)
                    spanEstado = "ACTIVO";
                else
                    spanEstado = "INACTIVO";
                table = table +
                        '<tr class="odd pointer">' +
                        '<td class="hidden">' + JSON.stringify(item) + '</td>' +
                        '<td class=" a-left a-left">' + item.subarea.nombre + '</td>' +
                        '<td class=" a-left a-left">' + item.descripcion + '</td>' +
                        '<td class="text-center">' +
                        '<span class="label ' + spanEstado + ' "> ' + spanEstado + '</span>' +
                        '</td>' +
                        '<td class=" a-center ">' +
                        '<a style="cursor: pointer;" class="btn-cargo-edit btn btn-info btn-xs"  data-toggle="modal" data-target="#panel-cargo" title="Editar"><i class="fa fa-pencil"></i></a>' +
                        '<a style="cursor: pointer;" class="btn-cargo-delete btn btn-danger btn-xs"  data-toggle="modal" data-target="" title="Eliminar"><i class="fa fa-trash"></i></a>';
                table = table + '</td> </tr>';
            });
        }
        table = table + '</tbody> </table>';
    }).done(function () {
        $("#leo_cargo").html(table);
        inicializaTabla($("#tbl-cargo"));
        from_Cargo();
    });
}

function cargarTrabajadores() {
    var table =
            '<table id="tbl-trabajador" class="table-trabajador table table-striped responsive-utilities jambo_table">' +
            '<thead>' +
            '<tr class="headings">' +
            '<th class="hidden"></th>' +
            '<th>DNI</th>' +
            '<th>Apellidos y Nombres</th>' +
            '<th>Teléfono</th>' +
            '<th>Dirección</th>' +
            '<th>Tipo</th>' +
            '<th>Estado</th>' +
            '<th class=" no-link last"> <span>  Acciones  </span> </th>' +
            '</tr>' +
            '</thead>' +
            '<tbody>';
    alert("cargarTrabajadores");
    var data = "";
    $.ajax({
        url: "trabajadores.htm",
        type: 'POST',
        dataType: 'json',
        success: function (responseText) {
            data = responseText.data;
            
            
//            if (data !== null) {
//                $.each(data, function (index, item) {
//                    table = table +
//                            '<tr class="odd pointer">' +
//                            '<td class="hidden">' + JSON.stringify(item) + '</td>' +
//                            '<td class=" ">' + item.dni + '</td>' +
//                            '<td class=" ">' + item.ap_paterno + ' ' + item.ap_materno + ' ' + item.nombres + '</td>' +
//                            '<td class="a-right a-right ">' + item.telefono + '</td>' +
//                            '<td class=" ">' + item.direccion + '</td>' +
//                            '<td class=" ">' + item.tipoTrabajador.descripcion + '</td>' +
//                            '<td class="text-center">' +
//                            '<span class="label ' + item.estadoTrabajador.descripcion + ' "> ' + item.estadoTrabajador.descripcion + '</span>' +
//                            '</td>' +
//                            '<td class=" a-center ">' +
//                            '<a style="cursor: pointer;" class="btn-trabajador-info btn btn-info btn-xs"  data-toggle="modal" data-target="#panel-info" title="Información"><i class="fa fa-info-circle"></i></a>' +
//                            '<a style="cursor: pointer;" class="btn-trabajador-edit btn btn-dark btn-xs"  data-toggle="modal" data-target="#panel-trabajador" title="Editar"><i class="fa fa-pencil"></i></a>';
//                    if (item.nro_hijos > 0) {
//                        table = table +
//                                '<a style="cursor: pointer;" class="btn-trabajador-hijo btn btn-primary btn-xs"  data-toggle="modal" data-target="#panel-hijos" title="Hijos"><i class="fa fa-child"></i></a>';
//                    }
//                    table = table + '</td> </tr>';
//                });
//            }
            table = table + '</tbody> </table>';

            $("#lista-empleados").html(table);
            inicializaTabla($("#tbl-trabajador"));
        }
    });

    alert("termino");
}

function cargarContratos() {
    var table =
            '<table id="tbl-contrato" class="table-contratos table table-striped responsive-utilities jambo_table">' +
            '<thead>' +
            '<tr class="headings">' +
            '<th class="hidden"></th>' +
            '<th>DNI</th>' +
            '<th>Apellidos y Nombres</th>' +
            '<th>Tipo</th>' +
            '<th>Inicio</th>' +
            '<th>Fin</th>' +
            '<th>Estado</th>' +
            '<th class=" no-link last"><span class="nobr">Acciones</span></th>' +
            '</tr>' +
            '</thead>' +
            '<tbody>';
    $.post("../../CTrabajador", {accion: "getAllEmployee"}, function (responseText) {
        var tipo = '', inicio = '', fin = '', estado = '', ultimo = false;
        if (responseText !== null) {
            $.each(responseText, function (index, item) {
                if (item.ultimoContrato !== null) {
                    tipo = item.ultimoContrato.tipoContrato.tipo;
                    inicio = item.ultimoContrato.fechaInicio;
                    fin = item.ultimoContrato.fechaFin !== undefined ? item.ultimoContrato.fechaFin : 'NO TIENE';
                    estado = item.ultimoContrato.estadoContrato.descripcion;
                    ultimo = true;
                }
                table = table +
                        '<tr class="odd pointer">' +
                        '<td class="hidden">' + JSON.stringify(item) + '</td>' +
                        '<td class=" ">' + item.dni + '</td>' +
                        '<td class=" ">' + item.ap_paterno + ' ' + item.ap_materno + ' ' + item.nombres + '</td>' +
                        '<td class="a-right a-right ">' + tipo + '</td>' +
                        '<td class=" ">' + inicio + '</td>' +
                        '<td class=" ">' + fin + '</td>' +
                        '<td class="text-center">';
                if (ultimo)
                    table = table + '<span class="label ' + estado + '">' + estado + '</span>';

                table = table + '</td>' +
                        '<td class=" a-center ">';
                if (ultimo) {
                    table = table +
                            '<a style="cursor: pointer;" class="btn-contrato-editar btn btn-dark btn-xs"  data-toggle="modal" data-target="#panel-contrato"><i class="fa fa-pencil" data-toggle="tooltip" data-placement="top" data-original-title="Editar"></i></a>' +
                            '<a style="cursor: pointer;" class="btn-contrato-renueva btn btn-warning btn-xs"  data-toggle="modal" data-target="#panel-contrato"><i class="fa fa-file-text-o" data-toggle="tooltip" data-placement="top" data-original-title="Renovar"></i></a>' +
                            '<a style="cursor: pointer;" class="btn-contrato-historial btn btn-info btn-xs"  data-toggle="modal" data-target="#panel-contrato-historial"><i class="fa fa-history" data-toggle="tooltip" data-placement="top" data-original-title="Historial"></i></a>';
                } else {
                    table = table +
                            '<a style="cursor: pointer;" class="btn-contrato-new btn btn-success btn-xs"  data-toggle="modal" data-target="#panel-contrato"><i class="fa fa-plus" data-toggle="tooltip" data-placement="top" data-original-title="Agregar contrato"></i></a>';
                }
                table = table + '</td></tr>';
            });
        }
        table = table + '</tbody></table>';
    }).done(function () {
        $("#lista-empleados").html(table);
        inicializaTabla($("#tbl-contrato"));
        from_contrato();
    });
}

function cargarVacaciones(situacion, periodo) {
    var jPeriodo = JSON.parse(periodo);
    var table =
            '<table id="tbl-vacacion" class="table-vacacion table table-striped responsive-utilities jambo_table">' +
            '<thead>' +
            '<tr class="headings">' +
            '<th class="hidden"></th>' +
            '<th>DNI</th>' +
            '<th>Apellidos y Nombres</th>' +
            '<th>F.Base</th>' +
            '<th>Periodo</th>' +
            '<th>Usados</th>' +
            '<th>Vendidos</th>' +
            '<th>F.Salida</th>' +
            '<th>F.Limite</th>' +
            '<th class=" no-link last"> <span>  Acciones  </span> </th>' +
            '</tr>' +
            '</thead>' +
            '<tbody>';
    var acc = "", btn = "";
    if (situacion === "0") {
        acc = "ListVacacionNA";
        btn = '<a style="cursor: pointer;" class="btn-vacacion-asign btn btn-success btn-xs"  data-toggle="modal" data-target="#panel-vacacion" title="Asignar vacación"><i class="fa fa-calendar"></i></a>';
    } else {
        acc = "ListVacacionYA";
        btn = '<a style="cursor: pointer;" class="btn-vacacion-history btn btn-info btn-xs" data-toggle="modal" data-target="#panel-vacacion-historial" title="Historico de vacaciones"><i class="fa fa-history"></i></a>';
    }
    $.post("../../CVacacion", {accion: acc, id_periodo: jPeriodo.id_periodo}, function (responseText) {
        if (responseText !== null) {
            $.each(responseText, function (index, item) {
                table = table +
                        '<tr class="odd pointer">' +
                        '<td class="hidden">' + JSON.stringify(item) + '</td>' +
                        '<td class=" ">' + item.trabajador.dni + '</td>' +
                        '<td class=" ">' + item.trabajador.ap_paterno + ' ' + item.trabajador.ap_materno + ' ' + item.trabajador.nombres + '</td>' +
                        '<td class="a-right a-right ">' + item.fechaBase + '</td>' +
                        '<td class=" ">' + item.periodo.inicio + "-" + item.periodo.fin + '</td>' +
                        '<td class=" ">' + item.diasUsados + '</td>' +
                        '<td class="text-center">' + item.diasComprados + '</td>' +
                        '<td class="text-center">' + (item.fechaSalida === undefined ? "Ninguno" : item.fechaSalida) + '</td>' +
                        '<td class="text-center">' + item.fechaLimite + '</td>' +
                        '<td class=" a-center ">' + btn;
                table = table + '</td> </tr>';
            });
        }
        table = table + '</tbody> </table>';
    }).done(function () {
        $("#lista-vacaciones").html(table);
        inicializaTabla($("#tbl-vacacion"));
        from_vacacion();
    });
}

function inicializaTabla($selector) {

    $('input.tableflat').iCheck({
        checkboxClass: 'icheckbox_flat-green',
        radioClass: 'iradio_flat-green'
    });

    var asInitVals = new Array();
    var oTable = $selector.dataTable({
        "oLanguage": {
            "sSearch": "Busqueda :"
        },
        "aoColumnDefs": [
            {
                'bSortable': false,
                'aTargets': [0]
            } //disables sorting for column one
        ],
        'iDisplayLength': 12,
        "sPaginationType": "full_numbers",
        "dom": 'T<"clear">lfrtip',
        "tableTools": {
            "sSwfPath": "<?php echo base_url('assets2/js/Datatables/tools/swf/copy_csv_xls_pdf.swf'); ?>"
        }
    });

//    $("tfoot input").keyup(function () {
//        /* Filter on the column based on the index of this element's parent <th> */
//        oTable.fnFilter(this.value, $("tfoot th").index($(this).parent()));
//    });
//    $("tfoot input").each(function (i) {
//        asInitVals[i] = this.value;
//    });
//    $("tfoot input").focus(function () {
//        if (this.className === "search_init") {
//            this.className = "";
//            this.value = "";
//        }
//    });
//    $("tfoot input").blur(function (i) {
//        if (this.value === "") {
//            this.className = "search_init";
//            this.value = asInitVals[$("tfoot input").index(this)];
//        }
//    });
}