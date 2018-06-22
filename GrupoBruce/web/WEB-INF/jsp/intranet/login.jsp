<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/fonts/css/font-awesome.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/css/custom.css?1.0.2"/>">
    </head>
    <body style="background: #fafafa;">
        <div class="">
            <div id="wrapper">
                <div id="login" class="animate form">
                    <section class="login_content">
                        <form:form commandName="usuario" action="validate.htm" method="POST" cssClass="FrmLogin">
                            <h1>Iniciar Sesión</h1>
                            <form:errors path="usu" cssStyle="color:red;" element="div" />
                            <div class="form-group has-feedback">
                                <form:input path="usu" placeholder="Ingrese su usuario" cssClass="form-control has-feedback-left"/>
                                <span class="fa fa-user form-control-feedback left" aria-hidden="true"> </span>
                            </div>
                            <form:errors path="clave" cssStyle="color:red;" element="div" />
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
