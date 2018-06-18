//Imprimir parte pagina
function imprimir(id) {
    var objeto = document.getElementById(id);
    var ventana = window.open('', 'documento');
    ventana.document.write(objeto.innerHTML);
    var css = ventana.document.createElement("link");
    css.setAttribute("href", "../resources/css/bootstrap.css");
    css.setAttribute("rel", "stylesheet");
    css.setAttribute("type", "text/css");
    ventana.document.head.appendChild(css);
    ventana.document.close();
    ventana.print();
    ventana.close();
}
//calculo de fecha
function calcularFecha(fecha, tiempo, periodo) {
    var arr = fecha.split("/");
    var f = new Date(arr[2], arr[1] - 1, arr[0]);
    if (tiempo !== 0) {
        switch (periodo) {
            case "d": case "D":
                f.setDate(f.getDate() + tiempo);
                break;
            case "m": case "M":
                f.setMonth(f.getMonth() + tiempo);
                break
            default:
                f.setFullYear(f.getFullYear() + tiempo);
        }
        var arr2 = f.toLocaleDateString().split("/");
        return padStart(arr2[0], "0", 2) + "/" + padStart(arr2[1], "0", 2) + "/" + arr2[2];
    } else {
        return "";
    }
}
//Fecha actual del sistema
function FECHA_HOY() {
    var f = new Date();
    var arr2 = f.toLocaleDateString().split("/");
    return padStart(arr2[0], "0", 2) + "/" + padStart(arr2[1], "0", 2) + "/" + arr2[2];
}
//completar con algun caracter a la izquierda
function padStart(str, crct, max) {
    str = str.toString();
    return str.length < max ? padStart(crct + str, crct, max) : str;
}
//validar porfato fecha
function validarFormatoFecha(campo) {
      var RegExPattern = /^\d{1,2}\/\d{1,2}\/\d{2,4}$/;
      if ((campo.match(RegExPattern)) && (campo!=='')) {
            return true;
      } else {
            return false;
      }
}
//validar formato de fecha
function existeFecha(fecha,anioMin){
    var fechaf = fecha.split("/");
    var day = fechaf[0];
    var month = fechaf[1];
    var year = fechaf[2];
    if(year>anioMin){
        if(month>0 && month<13){
            var date = new Date(year,month,'0');
            if((day-0)>(date.getDate()-0)){
                return false;
            }
            return true;  
        }
        return false;
    }
    return false;       
}
//alerta de efectividad de operacion
function msgOperacion(responseText, selector) {
    var aSplit = responseText.split("|");
    if ($.trim(aSplit[0]) === "success") {
        alert("Operación exitosa.");
        if (selector !== undefined)
            selector.click();
    } else {
        alert("Operación insatisfactoria.");
    }
}

/*************************************************************************/
/************************** CARGA DE ELEMENTOS ***************************/
/*************************************************************************/
$(document).ready(function () {
    /** COMBO NACIONALIDAD **/
    $.post("../../CNacionalidad", {accion: "NacionalidadON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#nacionalidad").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMBO TIPO_DOCUMENTO **/
    $.post("../../CTipoDocumento", {accion: "TDocumentoON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#tipoDocumento").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMBO GENERO **/
    $.post("../../CGenero", {accion: "GeneroON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $(".genero").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMBO ECIVIL **/
    $.post("../../CECivil", {accion: "ECivilON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#ecivil").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMBO TIPO_ESTUDIO **/
    $.post("../../CTipoEstudio", {accion: "TEstudioON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#tEstudio").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMBO ESTADO_ESTUDIO **/
    $.post("../../CEstadoEstudio", {accion: "EEstudioON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#eEstudio").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMBO TIPO_TRABAJADOR **/
    $.post("../../CTipoTrabajador", {accion: "TTrabajadorON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#tipoTrabajador").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMBO ESTADO_TRABAJADOR **/
    $.post("../../CEstadoTrabajador", {accion: "ETrabajadorON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#estadoTrabajador").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMBO REGIMEN_PENSIONARIO **/
    $.post("../../CRegimenPensionario", {accion: "RPensionarioON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#regimenPensionario").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMBO ENTIDAD_FINANCIERA **/
    $.post("../../CEntidadFinanciera", {accion: "EFinancieraON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $(".banco").append($("<option>", {value: JSON.stringify(item), text: item.nombre}));
        });
    });
    /** COMBO FORMA_PAGO **/
    $.post("../../CFormaPago", {accion: "FPagoON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#formaPago").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMBO PERIOCIDAD **/
    $.post("../../CPeriocidad", {accion: "PeriocidadON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#periocidad").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMBO EMPRESA **/
    $.post("../../CEmpresa", {accion: "EmpresaON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#empresa").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMPO TIPO_CONTRATO **/
    $.post("../../CTipoContrato", {accion: "TContratoON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#tipoContrato").append($("<option>", {value: JSON.stringify(item), text: item.tipo}));
        });
    });
    /** COMBO ESTADO_CONTRATO **/
    $.post("../../CEstadoContrato", {accion: "EContratoON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#estadoContrato").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMBO TIEMPO_CONTRATO **/
    $.post("../../CTiempoContrato", {accion: "select_on"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#tiempoContrato").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
        });
    });
    /** COMBO AREA **/
    $.post("../../CArea", {accion: "AreaON"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#areaLabor,#areaSubarea,#areaCargo").append($("<option>", {value: JSON.stringify(item), text: item.nombre}));
        });
    });
    /** COMBO PERIODO_VACACION **/
    $.post("../../CPeriodo", {accion: "listByVacacion"}, function (responseText) {
        $.each(responseText, function (index, item) {
            $("#periodoVacacion").append($("<option>", {value: JSON.stringify(item), text: item.inicio + " - " + item.fin}));
        });
    });
    /** COMBO SUBAREA **/
    $("#areaLabor").change(function () {
        changeSubarea($(this));
    });
    /** COMBO CARGO **/
    $("#subareaLabor").change(function () {
        changeCargo();
    });
    /** COMBO SUCURSAL **/
    $('#empresa').change(function () {
        changeSucursal();
    });
    
});
function changeSubarea($selectorArea) {
    $('#subareaLabor').empty().prepend("<option value=''> Selecciona opción </option>");
    $('#cargoLabor').empty().prepend("<option value=''> Selecciona opción </option>");
    var area = $selectorArea.val();
    if (area !== "") {
        var val = JSON.parse(area);
        return $.post('../../CSubarea', {accion: "ByArea", idarea: val.id_area}, function (responseText) {
            $.each(responseText, function (index, item) {
                $("#subareaLabor").append($("<option>", {value: JSON.stringify(item), text: item.nombre}));
            });
        });
    }
}
function changeCargo() {
    $('#cargoLabor').empty().prepend("<option value=''> Selecciona opcióna </option>");
    var subarea = $('#subareaLabor').val();
    if (subarea !== "") {
        var val = JSON.parse(subarea);
        return $.post('../../CCargo', {accion: "BySubarea", idsubarea: val.id_subarea}, function (responseText) {
            $.each(responseText, function (index, item) {
                $("#cargoLabor").append($("<option>", {value: JSON.stringify(item), text: item.descripcion}));
            });
        });
    }
}
function changeSucursal() {
    $('#sucursal').empty().prepend("<option value=''> Selecciona opción </option>");
    var empresa = $('#empresa').val();
    if (empresa !== "") {
        var val = JSON.parse(empresa);
        return $.post('../../CSucursal', {accion: "ByEmpresa", idEmpresa: val.id_empresa}, function (responseText) {
            $.each(responseText, function (index, item) {
                $("#sucursal").append($("<option>", {value: JSON.stringify(item), text: item.direccion}));
            });
        });
    }
}
function changeHijos(dni_padre, cant_hijos) {
    var $tab_hijo = $(".table-hijo tbody");
    $("#cancelHijo").click();
    $tab_hijo.empty();
    var nroAdd = cant_hijos;
    return $.post("../../CHijo", {accion: "listPadre", padre: dni_padre}, function (responseText) {
        if (responseText !== null) {
            $.each(responseText, function (index, item) {
                nroAdd = nroAdd - 1;
                $tab_hijo.append($("<tr>").append(
                        "<td class='hidden'>" + JSON.stringify(item) + "</td>" +
                        "<td>" + item.dni_hijo + "</td>" +
                        "<td>" + item.nombres + "</td>" +
                        "<td>" + $("#institucion").val() + "</td>" +
                        "<td class='hidden'>" + JSON.stringify(item.genero) + "</td>" +
                        "<td>" + item.genero.descripcion + "</td>" +
                        "<td>" + '<button type="button" class="btn-hijo-edit btn btn-info btn-xs"><i class="fa fa-pencil"></i></button>\n\
                                <button type="button" class="btn-hijo-delete btn btn-danger btn-xs"><i class="fa fa-trash"></i></button>' + "</td>"));
            });
        }
        $("#addHijo").attr({disabled: nroAdd < 1});
        $("#addHijo span").text(nroAdd);
    });
}
function cargaContrato(c) {
    var $areaLabor = $("#areaLabor");
    $("#tipoContrato").val(JSON.stringify(c.tipoContrato));
    $("#estadoContrato").val(JSON.stringify(c.estadoContrato)).attr({enabled: "false"});
    $("#areaLabor").val(JSON.stringify(c.cargoContrato.cargo.subarea.area));
    changeSubarea($areaLabor).done(function () {
        $("#subareaLabor").val(JSON.stringify(c.cargoContrato.cargo.subarea));
        changeCargo().done(function () {
            $("#cargoLabor").val(JSON.stringify(c.cargoContrato.cargo)).data("idcargo", c.cargoContrato.id_ccontrato);
        });
    });
    $("#obsCargo").val(c.cargoContrato.observacion);
    $("#remuneracion").val(c.ultimaRemuneracion.monto).data("idremuneracion", c.ultimaRemuneracion.id_remuneracion);
}

/*************************************************************************/
/************************** GESTIÓN DE FORMULARIOS ***********************/
/*************************************************************************/

/****************** FORMULARIO ÁREA ******************/
$(document).ready(function(){
    $("#newArea").click(function(){
        $("#form-area").data({area:""});
        $("#titleArea").text("REGISTRO ÁREA");
        $("#btnGArea").val("insert");
    });
    $("#btnGArea").click(function(){
        var $form_area = $("#form-area");
        var accion = $(this).val();
        if($form_area.parsley().isValid()){
            var area={};
            if($form_area.data("area")!=="") area = JSON.parse($form_area.data("area"));
            area["nombre"] = $("#nomArea").val();
            area["situacion"]=$('input:radio[name=optEstadoArea]:checked').val()==="1";
            $.post("../../CArea",{accion:accion,area:JSON.stringify(area)},function(responseText){
                cargarArea();
                msgOperacion(responseText, $("#btnCArea"));
            });
        }
    });
    $("#btnCArea").click(function () {
        $(".close").click();
    });
});
function from_area(){
    var $tab_area = $(".table-area");
    $tab_area.on('click','.btn-area-edit',function(){
        var area = JSON.parse($(this).closest("tr").find("td").eq(0).html());
        $("#form-area").data({area:JSON.stringify(area)});
        $("#titleArea").text("EDITAR ÁREA");
        $("#btnGArea").val("update");
        $("#nomArea").val(area.nombre);
        if(area.situacion)$("#optEArea1").prop("checked",true);
        else $("#optEArea2").prop("checked",true);
    });
    $tab_area.on('click','.btn-area-delete',function(){
        var area = $(this).closest("tr").find("td").eq(0).html();
        $.post("../../CArea",{accion:"delete",area:area},function(responseText){
            cargarArea();
            msgOperacion(responseText, $("#btnCArea"));
        });
    });
}

/****************** FORMULARIO SUBAREA ******************/
$(document).ready(function(){
    $("#newSubarea").click(function(){
        $("#form-subarea").data({subarea:""});
        $("#titleSubarea").text("REGISTRO SUBAREA");
        $("#btnGSubarea").val("insert");
    });
    $("#btnGSubarea").click(function(){
        var $form_subarea = $("#form-subarea");
        var accion = $(this).val();
        if($form_subarea.parsley().isValid()){
            var subarea={};
            if($form_subarea.data("subarea")!=="") subarea = JSON.parse($form_subarea.data("subarea"));
            subarea["area"] = JSON.parse($("#areaSubarea").val());
            subarea["nombre"] = $("#nomSubarea").val();
            subarea["situacion"]=$('input:radio[name=optEstadoSubarea]:checked').val()==="1";
            $.post("../../CSubarea",{accion:accion,subarea:JSON.stringify(subarea)},function(responseText){
                cargarSubarea();
                msgOperacion(responseText, $("#btnCSubarea"));
            });
        }
    });
    $("#btnCSubarea").click(function () {
        $(".close").click();
    });
});
function from_subarea(){
    var $tab_subarea = $(".table-subarea");
    $tab_subarea.on('click','.btn-subarea-edit',function(){
        $("#titleSubarea").text("EDITAR SUBAREA");
        $("#btnGSubarea").val("update");
        var subarea = JSON.parse($(this).closest("tr").find("td").eq(0).html());
        $("#form-subarea").data({subarea:JSON.stringify(subarea)});
        $("#areaSubarea").val(JSON.stringify(subarea.area));
        $("#nomSubarea").val(subarea.nombre);
        if(subarea.situacion)$("#optESubarea1").prop("checked",true);
        else $("#optESubarea2").prop("checked",true);
    });
    $tab_subarea.on('click','.btn-subarea-delete',function(){
        var subarea = $(this).closest("tr").find("td").eq(0).html();
        $.post("../../CSubarea",{accion:"delete",subarea:subarea},function(responseText){
            cargarSubarea();
            msgOperacion(responseText, $("#btnCSubarea"));
        });
    });
}

/****************** FORMULARIO CARGO ******************/
$(document).ready(function(){
    $("#newCargo").click(function(){
        $("#form-cargo").data({cargo:""});
        $("#titleCargo").text("REGISTRO CARGO");
        $("#btnGCargo").val("insert");
    });
    $("#btnGCargo").click(function(){
        var $form_cargo = $("#form-cargo");
        var accion = $(this).val();
        if($form_cargo.parsley().isValid()){
            var cargo={};
            if($form_cargo.data("cargo")!=="") cargo = JSON.parse($form_cargo.data("cargo"));
            cargo["fecha"] = FECHA_HOY();
            cargo["subarea"] = JSON.parse($("#subareaCargo").val());
            cargo["descripcion"] = $("#nomCargo").val();
            cargo["situacion"]=$('input:radio[name=optEstadoCargo]:checked').val()==="1";
            $.post("../../CCargo",{accion:accion,cargo:JSON.stringify(cargo)},function(responseText){
                cargarCargo();
                msgOperacion(responseText, $("#btnCCargo"));
            });
        }
    });
    $("#btnCCargo").click(function () {
        $(".close").click();
    });
});
function from_Cargo(){
    var $tab_cargo = $("#tbl-cargo");
    /**** EDITAR CARGO ****/
    $tab_cargo.on("click",".btn-cargo-edit",function(){
        var  $areaCargo = $("#areaCargo") ;
        $("#titleCargo").html("EDITAR CARGO");
        $("#btnGCargo").val("update");
        var cargo = JSON.parse($(this).closest("tr").find("td").eq(0).html());
        $("#form-cargo").data({cargo:JSON.stringify(cargo)});
        
        $("#areaCargo").val(JSON.stringify(cargo.subarea.area));
        $.post("../../CSubarea", {accion: "ByArea",idarea:cargo.subarea.area.id_area}, function (responseText) {
            $.each(responseText, function (index, item) {
                $("#subareaCargo").append($("<option>", {value: JSON.stringify(item), text: item.nombre}));
            });
        }).done(function(){
            $("#subareaCargo").val(JSON.stringify(cargo.subarea));
        });
        
        $("#nomCargo").val(cargo.descripcion);
        if(cargo.situacion)$("#optECargo1").prop("checked",true);
        else $("#optECargo2").prop("checked",true);
    });
    /**** ELIMINA CARGO ****/
    $tab_cargo.on("click",".btn-cargo-delete",function(){
        var cargo = $(this).closest("tr").find("td").eq(0).html();
        $.post("../../CCargo",{accion:"delete",cargo:cargo},function(responseText){
            cargarCargo();
            msgOperacion(responseText, $("#btnCCargo"));
        });
    });
}

/****************** FORMULARIO LOGIN ******************/
$(document).ready(function(){
    var $usuario = $("#idUsu"), $password = $("#idPass"), $accion=$("#idLogin");
    
    $("#idUsu, #idPass").on('focus',function(){
        $("#msgRpta").html("");
    });
    //INICIO DE SESIÓN
    $('#form-login').on('submit', function (e) {
        e.preventDefault();
        var avatar_default = "../../resources/img/img1.jpg";
        var $uAvatar = $(".user-avatar"), $uNombres = $(".user-name") ;

        var usuario,redirect;
        $('#form-login').parsley().validate();
        if($(this).parsley().isValid()){
            var acc = $accion.val();
            var usu = $usuario.val();
            var pass = $password.val();
            $.post("../../CLogin",{accion:acc,txtUsuario:usu,txtPassword:pass},function(responseText){
                var aSplit = responseText.split("|");
                if( $.trim(aSplit[0]) === "error"){
                    $("#msgRpta").html(aSplit[1]);
                    $accion.focus();
                }else{
                    usuario = JSON.parse(aSplit[1]);
                    redirect = aSplit[2];
                }
            }).done(function(){
                $uNombres.html(usuario.trabajador.nombres);
                $(location).attr({href:redirect});
            });
        }
    });
    $usuario.focus();
    //CERRAR SESIÓN
    $(".logout").on("click",function(e){
        e.preventDefault();
        $.post("../../CLogin",{accion:"SALIR"},function(responseText){
            $(location).attr({href:responseText});
        });
    });
});

/****************** FORMULARIO TRABAJADOR ******************/
//$(document).ready(function () {
$(document).ready(function(){
    var $img_avatar = $("#img-avatar");
    /**** VALIDACIONES ****/
    $("#btnAddFormacion").click(function () {
        if ($("#tEstudio").val() !== "" && $("#eEstudio").val() !== "" && $("#institucion").val() !== "") {
            $("#tabEstudio").append($("<tr>").append(
                    "<td class='hidden'>" + $("#tEstudio").val() + "</td>" +
                    "<td>" + $("#tEstudio option:selected").text() + "</td>" +
                    "<td class='hidden'>" + $("#eEstudio").val() + "</td>" +
                    "<td>" + $("#eEstudio option:selected").text() + "</td>" +
                    "<td>" + $("#institucion").val() + "</td>" +
                    "<td>" + $("#descEstudios").val() + "</td>" +
                    "<td>" + '<button type="button" class="btn btn-danger btn-xs eliminalinea"><i class="fa fa-trash"></i></button>' + "</td>"));
            $("#tEstudio").val("");
            $("#eEstudio").val("");
            $("#institucion").val("");
            $("#descEstudios").val("");
        }else{
            alert("Completar los datos necesarios.");
        }
    });
    $("#tabEstudio").on('click', '.eliminalinea', function () {
        var numeroFilas = $("#tabEstudio tr").length;
        if (numeroFilas > 1) {
            $(this).closest('tr').addClass('hidden');
        }
    });
    $("#btnCancelar").click(function () {
        $('#tabEstudio tbody').empty();
        $("#divBCSueldo").addClass("hidden");
        $("#divNroCussp").addClass("hidden");
        $("#empresa").val("").change();
        $("#li-personal a").click();
        $(".close").click();
    });
    $("#regimenPensionario").change(function () {
        if ($(this).val() === "") {
            $("#divNroCussp").addClass("hidden");
        } else {
            var myJSON = JSON.parse($(this).val());
            if (myJSON.cuspp) {
                $("#divNroCussp").removeClass("hidden");
            } else {
                $("#divNroCussp").addClass("hidden");
            }
        }
    });
    $("#select-file").click(function(e){
        e.preventDefault();
        $("#btn-avatar").click();
    });
    $("#delete-file").click(function(e){
        e.preventDefault();
        $("#delete-file").addClass("hidden");
        $img_avatar.data({avatarB64:"",avatarNombre:""});
        $img_avatar.attr({src:"../../resources/img/default_avatar.jpg"});
    });
    $("#btn-avatar").change(function () {
        var avatar_name = $(this).val().split('\\').pop();
        var reader = new FileReader();
        reader.onload = function(e){
            $img_avatar.data({"avatarB64":e.target.result,"avatarNombre":avatar_name});
            $img_avatar.attr({src:e.target.result,title:avatar_name});
        };
        reader.readAsDataURL(this.files[0]);
        $("#delete-file").removeClass("hidden");
    });
    /**** INSERT TRABAJADOR ****/
    $("#newTrabajador").click(function () {
        $("#btnGTrabajador").val("insert");
        $("#titleTrabajador").text("REGISTRAR TRABAJADOR");
        $("#delete-file").click();
    });
    /**** GRABAR INFORMACION DE TRABAJADOR ****/
    $("#btnGTrabajador").click(function () {
        var accion = $(this).val();
        if ($('#form-trabajador').parsley().isValid() && $("#tabEstudio tbody tr").length > 0){
            var avatar = $("#img-avatar").data("avatarNombre");
            var avatarB64 = $("#img-avatar").data("avatarB64");
            var dni = $("#dni").val();
            var apaterno = $("#apaterno").val();
            var amaterno = $("#amaterno").val();
            var nombres = $("#nombres").val();
            var nacimiento = $("#nacimiento").val();
            var direccion = $("#direccion").val();
            var telefono = $("#telefono").val();
            var hijos = parseInt($("#hijos").val());
            var referencia = $("#referencia").val();
            var documento = JSON.parse($("#tipoDocumento").val());
            var genero = JSON.parse($("#genero").val());
            var ecivil = JSON.parse($("#ecivil").val());

            var asignacion = $("#hijos").val() > 0;
            var codigo = "";
            var pasaje = parseFloat($("#pasaje").val());
            var tipoTrabajador = JSON.parse($("#tipoTrabajador").val());
            var estadoTrabajador = JSON.parse($("#estadoTrabajador").val());
            var nacionalidad = JSON.parse($("#nacionalidad").val());
            var formaPago = JSON.parse($("#formaPago").val());
            var periocidad = JSON.parse($("#periocidad").val());
            var sucursal = JSON.parse($("#sucursal").val());

            var jsonEmploye = {"asignacion": asignacion, "codigo": codigo, "monto_pasaje": pasaje,
                "tipoTrabajador": tipoTrabajador, "estadoTrabajador": estadoTrabajador, "nacionalidad": nacionalidad,
                "formaPago": formaPago, "periocidad": periocidad, "sucursal": sucursal,
                "dni": dni, "ap_paterno": apaterno, "ap_materno": amaterno,
                "nombres": nombres, "nacimiento": nacimiento, "direccion": direccion, "telefono": telefono,
                "nro_hijos": hijos, "referencia": referencia, "tdocumento": documento, "sexo": genero, "ecivil": ecivil};

            var newdata = {};
            var formacionList = [], formacion;
            if (avatar !== "")
                newdata["foto"] = avatar;
            $('#tabEstudio tbody tr').each(function () {
                formacion = {"trabajador": jsonEmploye,
                    "id_formacion": parseInt(0),
                    "institucion": $(this).find("td").eq(4).html(),
                    "descripcion": $(this).find("td").eq(5).html(),
                    "tipoEstudio": JSON.parse($(this).find("td").eq(0).html()),
                    "estadoEstudio": JSON.parse($(this).find("td").eq(2).html())};
                formacionList.push(formacion);
            });
            if (formacionList.length > 0)
                newdata["formacion"] = formacionList;

            if ($("#regimenPensionario").val() !== "") {
                var regimenPensionario = JSON.parse($("#regimenPensionario").val());
                var nroCUSPP = $("#nroCUSPP").val();
                var afiliacion = {"trabajador": jsonEmploye, "regimenPensionario": regimenPensionario, "observacion": "FLUJO", "nro_cuspp": nroCUSPP};
                newdata["afiliacion"] = afiliacion;
            }
            if ($("#bancoCTS").val() !== "") {
                var bancoCTS = JSON.parse($("#bancoCTS").val());
                var cuentaCTS = $("#cuentaCTS").val();
                var ctaCTS = {"trabajador": jsonEmploye, "nro_cuenta": cuentaCTS, "entidadFinanciera": bancoCTS};
                newdata["cuentaCts"] = ctaCTS;
            }
            if ($("#bancoSueldo").val() !== "") {
                var bancoSueldo = JSON.parse($("#bancoSueldo").val());
                var cuentaSueldo = $("#cuentaSueldo").val();
                var ctaSueldo = {"trabajador": jsonEmploye, "nro_cuenta": cuentaSueldo, "entidadFinanciera": bancoSueldo};
                newdata["cuentaSueldo"] = ctaSueldo;
            }
            $.extend(true, jsonEmploye, newdata);
            
            $.post("../../CTrabajador",{accion:accion,avatarB64:avatarB64,employe:JSON.stringify(jsonEmploye)},function(responseText){
                cargarTrabajadores();
                msgOperacion(responseText, $("#btnCancelar"));
            });
        } else {
            alert("Hay campos que son necesario ser llenados.");
        }
    });
});
function from_trabajador(){
    var $tab_trabajador = $("#tbl-trabajador");
    var $img_avatar = $("#img-avatar");
    /**** EDIT TRABAJADOR ****/
    $tab_trabajador.on('click', '.btn-trabajador-edit', function () {
        $("#btnGTrabajador").val("edit");
        $("#titleTrabajador").text("EDITAR TRABAJADOR");
        $("#delete-file").click();

        var t = JSON.parse($(this).closest("tr").find("td").eq(0).html());
        var fotoB64;
        /** informacion personal **/
        $("#nacionalidad").val(JSON.stringify(t.nacionalidad));
        $("#tipoDocumento").val(JSON.stringify(t.tdocumento));
        if(t.foto!==""){
            fotoB64=(t.foto).split(";");
            $img_avatar.data({"avatarB64":fotoB64[1]+";"+fotoB64[2],"avatarNombre":fotoB64[0]});
            $img_avatar.attr({src:fotoB64[1]+";"+fotoB64[2], title:fotoB64[0]});
            $("#delete-file").removeClass("hidden");
        }
        $("#dni").val(t.dni);
        $("#apaterno").val(t.ap_paterno);
        $("#amaterno").val(t.ap_materno);
        $("#nombres").val(t.nombres);
        $("#genero").val(JSON.stringify(t.sexo));
        $("#nacimiento").val(t.nacimiento);
        $("#ecivil").val(JSON.stringify(t.ecivil));
        $("#hijos").val(t.nro_hijos);
        $("#telefono").val(t.telefono);
        $("#referencia").val(t.referencia);
        $("#direccion").val(t.direccion);

        /** formación laboral **/
        if (t.formacion.length > 0) {
            var $tabFormacion = $("#tabEstudio tbody");
            $tabFormacion.empty();
            $.each(t.formacion, function (index, item) {
                $tabFormacion.append($("<tr>").append(
                        "<td class='hidden'>" + JSON.stringify(item.tipoEstudio) + "</td>" +
                        "<td>" + item.tipoEstudio.descripcion + "</td>" +
                        "<td class='hidden'>" + JSON.stringify(item.estadoEstudio) + "</td>" +
                        "<td>" + item.estadoEstudio.descripcion + "</td>" +
                        "<td>" + item.institucion + "</td>" +
                        "<td>" + item.descripcion + "</td>" +
                        "<td>" + '<button type="button" class="btn btn-danger btn-xs eliminalinea"><i class="fa fa-trash"></i></button>' + "</td>"));
            });
        }

        /** datos laborales **/
        $("#tipoTrabajador").val(JSON.stringify(t.tipoTrabajador)).change();
        if (t.afiliacion !== undefined) {
            $("#regimenPensionario").val(JSON.stringify(t.afiliacion.regimenPensionario)).change();
            $("#nroCUSPP").val(t.afiliacion.nro_cuspp);
        }
        if (t.cuentaCts !== undefined) {
            $("#bancoCTS").val(JSON.stringify(t.cuentaCts.entidadFinanciera)).change();
            $("#cuentaCTS").val(t.cuentaCts.nro_cuenta);
        }
        $("#formaPago").val(JSON.stringify(t.formaPago)).change();
        $("#periocidad").val(JSON.stringify(t.periocidad)).change();
        $("#pasaje").val(t.monto_pasaje);
        if (t.cuentaSueldo !== undefined) {
            $("#bancoSueldo").val(JSON.stringify(t.cuentaSueldo.entidadFinanciera)).change();
            $("#cuentaSueldo").val(t.cuentaSueldo.nro_cuenta);
        }
        $("#estadoTrabajador").val(JSON.stringify(t.estadoTrabajador)).change();
        $("#empresa").val(JSON.stringify(t.sucursal.empresa)).change();

        changeSucursal().done(function () {
            $("#sucursal").val(JSON.stringify(t.sucursal));
        });
    });
    /**** HIJOS TRABAJADOR ****/
    $tab_trabajador.on('click', '.btn-trabajador-hijo', function () {
        var t = JSON.parse($(this).closest("tr").find("td").eq(0).html());
        $("#trabajador").val(JSON.stringify(t));
        $("#nomPadre").val(t.ap_paterno + " " + t.ap_materno + ", " + t.nombres);
        $("#nroHijos").val(t.nro_hijos);
        changeHijos(t.dni, t.nro_hijos);
    });
}
//});

/****************** FORMULARIO HIJO ******************/
$(document).ready(function () {
    var $formHijo = $("#form-hijo");
    var $tab_hijo = $(".table-hijo");
    $("#cancelHijo").click(function () {
        $formHijo[0].reset();
        $formHijo.addClass("hidden");
        $(this).addClass("hidden");
    });
    /**** INSERT HIJO ****/
    $("#addHijo").click(function () {
        $formHijo.removeClass();
        $("#saveHijo").val("insert_hijo");
        $("#cancelHijo").removeClass("hidden");
    });
    /**** EDIT HIJO ****/
    $tab_hijo.on("click", ".btn-hijo-edit", function () {
        $("#saveHijo").val("update_hijo");
        var hijo = JSON.parse($(this).closest("tr").find("td").eq(0).html());
        $("#dniHijo").val(hijo.dni_hijo).attr({title: hijo.id_hijo});
        $("#nacimientoHijo").val(hijo.nacimiento);
        $("#generoHijo").val(JSON.stringify(hijo.genero));
        $("#nombresHijo").val(hijo.nombres);
        $formHijo.removeClass("hidden");
    });
    /**** DELETE HIJO ****/
    $tab_hijo.on("click", ".btn-hijo-delete", function () {
        var padre = JSON.parse($("#trabajador").val());
        var h = $(this).closest("tr").find("td").eq(0).html();
        $.post("../../CHijo", {accion: "delete_hijo", hijo: h}, function (responseText) {
            var aSplit = responseText.split("|");
            if ($.trim(aSplit[0]) === "success") {
                alert("Operación exitosa.");
                changeHijos(padre.dni, padre.nro_hijos);
            } else {
                alert("No se pudo eliminar el registro.");
            }
        });
    });
    /**** GRABAR INFORMACION DE HIJO ****/
    $("#saveHijo").click(function () {
        var accion = $(this).val();
        var padre = JSON.parse($("#trabajador").val());
        if ($formHijo.parsley().isValid()) {
            var id_h = parseInt($("#dniHijo").attr("title"));
            var dni_h = $.trim($("#dniHijo").val());
            var nacimiento_h = $("#nacimientoHijo").val();
            var genero_h = JSON.parse($("#generoHijo").val());
            var nombres_h = $("#nombresHijo").val();
            var hijo = {"id_hijo": id_h, "dni_hijo": dni_h, "nacimiento": nacimiento_h, "nombres": nombres_h, "genero": genero_h, "trabajador": padre};
            $.post("../../CHijo", {accion: accion, hijo: JSON.stringify(hijo)}, function (responseText) {
                var aSplit = responseText.split("|");
                if ($.trim(aSplit[0]) === "success") {
                    alert("Operación exitos.");
                    changeHijos(padre.dni, padre.nro_hijos);
                } else {
                    alert("No se pudo llevar a cabo el registro");
                }
            });
        }
    });

});

/****************** FORMULARIO CONTRATO ******************/
//$(document).ready(function () {
$(document).ready(function(){
    /**** VALIDACIONES ****/
    $("#tiempoContrato").change(function () {
        var t = $(this).val();
        var fechaFin = t !== "" ? calcularFecha(calcularFecha($("#inicioContrato").val(), JSON.parse(t).nro_meses, "m"), -1, "d") : "";
        $("#finContrato").val(fechaFin);
    });
    $("#btnCContrato").click(function () {
        $(".close").click();
    });
    /**** GRABAR CONTRATO ****/
    $("#btnGContrato").click(function () {
        if ($("#form-contrato").parsley().isValid()) {
            var trabajador = JSON.parse($("#trabContrato").val());
            var id_contrato = parseInt($("#inicioContrato").data("idcontrato"));
            var fechaInicio = $("#inicioContrato").val();
            var fechaFin;
            var tipoContrato = JSON.parse($("#tipoContrato").val());
            var estadoContrato = JSON.parse($("#estadoContrato").val());
            var tiempoContrato = JSON.parse($("#tiempoContrato").val());
            var fechaHoy = FECHA_HOY();

            if (tiempoContrato.nro_meses === 0) {
                fechaFin = null;
            } else {
                fechaFin = $("#finContrato").val();
            }

            var dato = {};
            var contratoTrabajador = {"trabajador": trabajador, "id_contrato": id_contrato, "fechaInicio": fechaInicio, "fechaFin": fechaFin,
                "tipoContrato": tipoContrato, "estadoContrato": estadoContrato, "tiempoContrato": tiempoContrato};

            var id_remuneracion = parseInt($("#remuneracion").data("idremuneracion"));
            var monto = parseFloat($("#remuneracion").val());
            var ultimaRemuneracion = {"contratoTrabajador": contratoTrabajador, "id_remuneracion": id_remuneracion, "fecha": fechaHoy, "monto": monto};
            dato["ultimaRemuneracion"] = ultimaRemuneracion;

            if ($("#cargoLabor").val() !== "") {
                var obsCargo = $("#obsCargo").val();
                var id_ccontrato = parseInt($("#cargoLabor").data("idcargo"));
                var cargo = JSON.parse($("#cargoLabor").val());
                var cargoContrato = {"contratoTrabajador": contratoTrabajador, "id_ccontrato": id_ccontrato, "fecha": fechaHoy, "observacion": obsCargo, "cargo": cargo};
                dato["cargoContrato"] = cargoContrato;
            }

            $.extend(true, contratoTrabajador, dato);
            var accion = $("#btnGContrato").val();
            $.post("../../CContratoTrabajador", {accion: accion, contrato: JSON.stringify(contratoTrabajador)}, function (responseText) {
                cargarContratos();
                msgOperacion(responseText, $("#btnCContrato"));
            });
        }
    });
    
});
function from_contrato(){
    var CONTRATO_VIGENTE, CONTRATO_RENOVADO;
    $.post("../../CEstadoContrato", {accion: "EContratoID", idEContrato: 1}, function (responseText) {
        CONTRATO_VIGENTE = JSON.stringify(responseText);
    });
    $.post("../../CEstadoContrato", {accion: "EContratoID", idEContrato: 2}, function (responseText) {
        CONTRATO_RENOVADO = JSON.stringify(responseText);
    });

    var $tab_contrato = $("#tbl-contrato");
    /**** INSERT CONTRATO ****/
    $tab_contrato.on("click", ".btn-contrato-new", function () {
        $("#btnGContrato").val("insert_contrato");
        $("#titleFrmContrato").html("REGISTRAR CONTRATO");
        var t = JSON.parse($(this).closest("tr").find("td").eq(0).html());
        $("#trabContrato").val(JSON.stringify(t));
        $("#nomTContrato").val(t.ap_paterno + " " + t.ap_materno + ", " + t.nombres);
        $("#estadoContrato").val(CONTRATO_VIGENTE);
        $("#inicioContrato").data("idcontrato", 0);
        $("#cargoLabor").data("idcargo", 0);
        $("#remuneracion").data("idremuneracion", 0);
    });
    /**** RENUEVA CONTRATO ****/
    $tab_contrato.on("click", ".btn-contrato-renueva", function () {
        $("#btnGContrato").val("renueva_contrato");
        $("#titleFrmContrato").html("RENOVACIÓN DE CONTRATO");
        var t = JSON.parse($(this).closest("tr").find("td").eq(0).html());
        $("#trabContrato").val(JSON.stringify(t));
        $("#nomTContrato").val(t.ap_paterno + " " + t.ap_materno + ", " + t.nombres);
        var c = t.ultimoContrato;
        cargaContrato(c);
        $("#inicioContrato").val(calcularFecha(c.fechaFin, -1, "d")).data("idcontrato", c.id_contrato);
        $("#tiempoContrato").val("");
    });
    /**** EDIT CONTRATO ****/
    $tab_contrato.on("click", ".btn-contrato-editar", function () {
        $("#btnGContrato").val("update_contrato");
        $("#titleFrmContrato").html("MODIFICACIÓN DE ULTIMO CONTRATO");
        var t = JSON.parse($(this).closest("tr").find("td").eq(0).html());
        $("#trabContrato").val(JSON.stringify(t));
        $("#nomTContrato").val(t.ap_paterno + " " + t.ap_materno + ", " + t.nombres);
        var c = t.ultimoContrato;
        cargaContrato(c);
        $("#inicioContrato").val(c.fechaInicio).data("idcontrato", c.id_contrato);
        $("#tiempoContrato").val(JSON.stringify(c.tiempoContrato));
        $("#finContrato").val(c.fechaFin);
    });
    /**** HISTORIAL CONTRATO ****/
    $tab_contrato.on("click", ".btn-contrato-historial", function () {
        var $tabHistorial = $("#table-contrato-historial tbody");
        var t = JSON.parse($(this).closest("tr").find("td").eq(0).html());
        $("#trabContratoH").val(JSON.stringify(t));
        $("#nomTContratoH").val(t.ap_paterno + " " + t.ap_materno + ", " + t.nombres);
        $.post("../../CContratoTrabajador", {accion: "historial_contrato", idTrabajador: t.dni}, function (responseText) {
            $tabHistorial.empty();
            $.each(responseText, function (index, item) {
                var fin = item.fechaFin !== undefined ? item.fechaFin : "No tiene";
                $tabHistorial.append($("<tr>").append(
                        "<td>" + Number(index + 1) + "</td>" +
                        "<td >" + item.fechaInicio + "</td>" +
                        "<td>" + fin + "</td>" +
                        "<td>" + item.ultimaRemuneracion.monto + "</td>" +
                        "<td>" + item.tipoContrato.tipo + "</td>" +
                        "<td>" + item.estadoContrato.descripcion + "</td>"));
            });
        });
    });
}
//});

/****************** FORMULARIO VACACIONES ******************/
//$(document).ready(function(){
$(document).ready(function(){
    /**** VALIDACIONES ****/
    var $inicioV = $("#inicioV"), $finV = $("#finV"), $comprados = $("#compradosV");
    $("#optTiempoV1").click(function(){
        $("#diasComprados").addClass("hidden");
        $comprados.removeAttr("required min max").val(0);
    });
    $("#optTiempoV2").click(function(){
        $("#diasComprados").removeClass("hidden");
        $comprados.attr({min:"1",max:"30",required:"required"});
    });
    $("#inicioV , #compradosV, #optTiempoV1, #optTiempoV2").on('keyup click',function(){
        if(validarFormatoFecha($inicioV.val())){
            if(existeFecha($inicioV.val(),2000)){
                if($('input:radio[name=optTiempoV]:checked').val()==='P' && ($comprados.val()>0 && $comprados.val()<31)){
                    $finV.val(calcularFecha($inicioV.val(),parseInt($comprados.val()),"d"));
                }else{
                    $finV.val(calcularFecha($inicioV.val(),30,"d"));
                }   
            }else{
                $finV.val(""); 
            }
        }else{
            $finV.val("");
        }
    });
    $("#btnCVacacion").click(function(){
        $(".close").click();
        $("#diasComprados").addClass("hidden");
    });
    /**** GRABAR VACACION ****/
    $("#btnGVacacion").click(function(){
        if ($("#form-vacacion").parsley().isValid()) {
            var accion = $(this).val();
            var v = JSON.parse($("#form-vacacion").data("vacacion"));
            var trabajador = v.trabajador;
            var periodo = v.periodo;
            var fbase = v.fechaBase;
            var flimite = v.fechaLimite;
            var fsalida = $("#inicioV").val();
            var fretorno = $("#finV").val();
            var dcomprados = parseInt($("#compradosV").val());
            var dusados = 30 - dcomprados;
            
            var vacacion = {"trabajador":trabajador,"periodo":periodo,"fechaBase":fbase,"fechaLimite":flimite,
                            "fechaSalida":fsalida,"fechaRetorno":fretorno,"diasUsados":dusados,"diasComprados":dcomprados};
            $.post("../../CVacacion",{accion:accion,vacacion:JSON.stringify(vacacion)},function(responseText){
                msgOperacion(responseText, $("#btnCVacacion"));
                cargarVacaciones($("#situacionVacacion").val(),$("#periodoVacacion").val());
                $("#diasComprados").addClass("hidden");
            });
        }
    });
});
function from_vacacion(){
    var $tab_vacacion = $("#tbl-vacacion");
    //ASIGNAR VACACION
    $tab_vacacion.on('click','.btn-vacacion-asign',function(){
        $("#btnGVacacion").val("insert");
        $("#form-vacacion").data({vacacion:$(this).closest("tr").find("td").eq(0).html()});
        var tv = JSON.parse($(this).closest("tr").find("td").eq(0).html());
        $("#trabajadorV").val(tv.trabajador.ap_paterno+" "+tv.trabajador.ap_materno+" "+tv.trabajador.nombres).data({trabajador:JSON.stringify(tv.trabajador)});
        $("#periodoV").val(tv.periodo.inicio+"-"+tv.periodo.fin).data({periodo:JSON.stringify(tv.periodo)});
    });
    //HISTORIAL DE VACACIONES
    $tab_vacacion.on('click','.btn-vacacion-history',function(){
        var $tabHistorial = $("#table-vacacion-historial tbody");
        var v = JSON.parse($(this).closest("tr").find("td").eq(0).html());
        $("#trabajadorVacacionH").val(v.trabajador.ap_paterno+" "+v.trabajador.ap_materno+" "+v.trabajador.nombres).data({trabajador:JSON.stringify(v.trabajador)});
        $.post("../../CVacacion", {accion: "historial_vacacion", idTrabajador: v.trabajador.dni}, function (responseText) {
            $tabHistorial.empty();
            $.each(responseText, function (index, item) {
                $tabHistorial.append($("<tr>").append(
                        "<td>" + item.periodo.inicio+"-"+item.periodo.fin + "</td>" +
                        "<td >" + item.fechaBase + "</td>" +
                        "<td>" + item.fechaSalida + "</td>" +
                        "<td>" + item.fechaRetorno + "</td>" +
                        "<td>" + item.diasUsados + "</td>" +
                        "<td>" + item.diasComprados + "</td>"));
            });
        });
    });
}
//});