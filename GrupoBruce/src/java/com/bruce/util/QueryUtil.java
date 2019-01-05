/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.util;

/**
 *
 * @author SISTEMAS
 */
public class QueryUtil {

    //ACCESO
    public static final String ACCESO_ROL = "SELECT M.ID_MENU, :IDROL ID_ROL, ISNULL(A.FECHA_UPDATE,GETDATE()) FECHA_UPDATE, ISNULL(A.ACCEDER, 0) AS ACCEDER , M.DESCRIPCION text, M.LEAF, M.ID_SUPMENU idSupmenu, M.ICON_CLS iconCls, M.ACCION, ISNULL(M.PROCESO,0) PROCESO, ISNULL(M.COD_PROCESO,'') COD_PROCESO, ISNULL(M.COD_ETAPA,'') COD_ETAPA  FROM MENU M LEFT JOIN ACCESO A ON A.ID_MENU = M.ID_MENU AND A.ID_ROL=:IDROL";

    //USUARIO
    public static final String USUARIO_VALIDA = "FROM Usuario WHERE usu = :usuario AND clave = :pass";

    //TRABAJADOR
    public static final String TRABAJADOR_ALL = "FROM Trabajador";

    //VACACION
    public static final String VACACION_INSERT = "INSERT INTO VACACION(ID_TRABAJADOR,ID_PERIODO,FECHA_BASE,FECHA_LIMITE,FECHA_SALIDA,FECHA_RETORNO,DIAS_USADOS,DIAS_COMPRADOS) VALUES(?,?,?,?,?,?,?,?)";

    //ASIGNACION_DETALLE
    public static final String ASIGNACION_DETALLE_VALIDA = "SELECT EI.ID_TEQUIPO FROM ASIGNACION_DETALLE AD\n"
            + "INNER JOIN EQUIPO_INFORMATICO EI ON EI.ID_EINFORMATICO = AD.ID_EINFORMATICO \n"
            + "AND EI.ID_TEQUIPO = (SELECT EI2.ID_TEQUIPO FROM EQUIPO_INFORMATICO EI2 WHERE EI2.ID_EINFORMATICO=:IDEINFORMATICO)\n"
            + "WHERE AD.ASIGNADO = 1 AND AD.ID_AEQUIPO=:IDASIGNACION";
}
