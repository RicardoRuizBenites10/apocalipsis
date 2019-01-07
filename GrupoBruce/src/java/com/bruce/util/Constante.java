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
public class Constante {

    //Tiempo ausencia
    public static final int AUSENCIA_TIEMPO_DIAS = 1;
    public static final int AUSENCIA_TIEMPO_HORAS = 2;
    //Estado contrato
    public static final int CONTRATO_ESTADO_VIGENTE = 1;
    public static final int CONTRATO_ESTADO_RENOVADO = 2;
    public static final int CONTRATO_ESTADO_TERMINADO = 3;
    public static final int CONTRATO_ESTADO_CANCELADO = 4;
    //Tipo de contrato
    public static final String CONTRATO_TIPO_CONVENIO = "00";
    public static final String CONTRATO_TIPO_INDETERMINADO = "01";
    public static final String CONTRATO_TIPO_INCREMENTO = "03";
    public static final String CONTRATO_TIPO_NECESIDAD = "04";
    //Directorios para manejo de archivos
    public static final String DIRECTORY_AVATAR = "D:\\PRUEBA_AVATAR\\";
    public static final String DIRECTORY_CHAT = "D:\\CHAT\\";
    public static final String DIRECTORY_ASISTENCIA = "D:\\ASISTENCIA\\";
    public static final String FPERFIL_DEFAULT = "./resources/img/guest.png";
    //Estados equipo
    public static final int EQUIPO_ESTADO_PORASIGNAR = 1;
    public static final int EQUIPO_ESTADO_ASIGNADO = 2;
    public static final int EQUIPO_ESTADO_ENMANTENIMIENTO = 3;
    public static final int EQUIPO_ESTADO_BAJA = 4;
    //Forma de pago
    public static final int FORMAPAGO_EFECTIVO = 1;
    //Estados de mantenimiento
    public static final String MANTENIMIENTO_ESTADO_REQUERIDO = "001";
    public static final String MANTENIMIENTO_ESTADO_ASIGNADO = "002";
    public static final String MANTENIMIENTO_ESTADO_ENPROCESO = "003";
    public static final String MANTENIMIENTO_ESTADO_TERMINADO = "004";
    public static final String MANTENIMIENTO_ESTADO_ENENTREGA = "005";
    public static final String MANTENIMIENTO_ESTADO_RECEPCIONADO = "006";
    //Tamaño de archivos
    public static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    public static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    //Tipos de texto
    public static final int TEXT_ORACION = 1;
    public static final int TEXT_MINUSCULAS = 2;
    public static final int TEXT_PMAYUSCULA = 3;
    //Situación
    public static final boolean SITUACION_ON = true;
    public static final boolean SITUACION_OFF = false;
    //Tipos de periodo
    public static final int TIPO_PERIODO_VACACION = 1;
    public static final int TIPO_PERIODO_PAGO = 2;
    //Estado trabajador
    public static final int TRABAJADOR_ESTADO_BAJA = 0;
    public static final int TRABAJADOR_ESTADO_ACTIVO = 1;
    public static final int TRABAJADOR_ESTADO_SINVINCULO = 2;
    //Tipos de trabajadores
    public static final int TRABAJADOR_TIPO_EJECUTIVO = 19;
    public static final int TRABAJADOR_TIPO_OBRERO = 20;
    public static final int TRABAJADOR_TIPO_EMPLEADO = 22;
    public static final int TRABAJADOR_TIPO_PRACTICANTE = 23;

}
