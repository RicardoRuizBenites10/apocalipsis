<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../template/meta-intranet.jspf" %>
        <script src="<c:url value="/resources/js/jquery.min.js"/> "></script>
        <script src="<c:url value="/resources/js/js.propio.js"/> "></script>
        <script src="<c:url value="/resources/js/parsley/parsley.min.js"/> "></script>
    </head>
    <body style="background: #fafafa;">
        <div class="">
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>

            <div id="wrapper">
                <div id="login" class="animate form">
                    <section class="login_content">
                        <!--
                        <form id="form-login" class="FrmLogin" data-parsley-validate>
                            <h1>Iniciar Sesión</h1>
                            <div class="form-group has-feedback">
                                <input id="idUsu" type="text" class="form-control has-feedback-left" name="txtUsuario" placeholder="Ingrese su usuario" required />
                                <span class="fa fa-user form-control-feedback left" aria-hidden="true"> </span>
                            </div>
                            <div class="form-group has-feedback">
                                <input id="idPass" type="password" class="form-control has-feedback-left" name="txtPassword" placeholder="Ingrese su clave" 
                                       data-parsley-minlength="8" data-parsley-minlength-message="La contraseña debe contener minimo 8 caracteres."
                                       data-parsley-maxlength="12" data-parsley-maxlength-message="La contraseña debe contener maximo 12 caracteres." required />
                                <span class="fa fa-unlock-alt form-control-feedback left" aria-hidden="true"> </span>
                            </div>
                            <div>
                                <input type="submit" id="idLogin" class="btn btn-sm btn-dark pull-right btn-validate" value="INGRESAR">
                                <div id="msgRpta" class="col-xs-12 pull-left" style="color:red;"></div>
                            </div>
                            <div class="clearfix"></div>
                            <div class="separator">
                                <div class="clearfix"></div>
                                <div>
                                 <h1><i class="fa fa-bus" style="font-size: 21px;"></i> Factoria Bruce</h1>   
                                </div>
                            </div>
                        </form>
                        -->
                        <form:form commandName="usuario" action="validaAcceso.htm" method="POST" cssClass="FrmLogin">
                            <h1>Iniciar Sesión</h1>
                            <div class="form-group has-feedback">
                                <form:input path="usu" placeholder="Ingrese su usuario" cssClass="form-control has-feedback-left"/>
                                <span class="fa fa-user form-control-feedback left" aria-hidden="true"> </span>
                            </div>
                            <div class="form-group has-feedback">
                                <form:password path="clave" placeholder="Ingrese su contraseña"  cssClass="form-control has-feedback-left" />
                                <span class="fa fa-key form-control-feedback left" aria-hidden="true"> </span>
                            </div>
                            <div>
                                <input type="submit" id="idLogin" class="btn btn-sm btn-dark pull-right btn-validate" value="INGRESAR">
                                <div id="msgRpta" class="col-xs-12 pull-left" style="color:red;"></div>
                            </div>
                            <div class="clearfix"></div>
                            <div class="separator">
                                <div class="clearfix"></div>
                                <div>
                                 <h1><i class="fa fa-bus" style="font-size: 21px;"></i> Factoria Bruce</h1>   
                                </div>
                            </div>
                        </form:form>
                    </section>
                </div>
            </div>
        </div>
    </body>
</html>
