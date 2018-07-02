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
public class QuerySQL {
    
    //USUARIO
    public static final String USUARIO_VALIDA = "FROM Usuario WHERE usu = :usuario AND clave = :pass";
    
    //TRABAJADOR
    public static final String TRABAJADOR_ALL = "FROM Trabajador";
    public static final String TRABAJADOR_ALL_PERFORMANCE = "SELECT idTrabajador as codigo, persona.apPaterno + ' ' + persona.apMaterno + ' ' + persona.nombres as nombres, persona.telefono as telefono, persona.direccion as direccion, tipoTrabajador.descripcion as tipoTrabajador, estadoTrabajador.descripcion as estadoTrabajador FROM Trabajador";
    
    //VACACION
    public static final String VACACION_INSERT = "INSERT INTO VACACION(ID_TRABAJADOR,ID_PERIODO,FECHA_BASE,FECHA_LIMITE,FECHA_SALIDA,FECHA_RETORNO,DIAS_USADOS,DIAS_COMPRADOS) VALUES(?,?,?,?,?,?,?,?)";
    
    
}
