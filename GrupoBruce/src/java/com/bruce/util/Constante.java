/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.util;

import com.google.gson.Gson;

/**
 *
 * @author SISTEMAS
 */
public class Constante {

    //Objeto JSON
    //public static Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
    //public static Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new BidirectionalDateSerializer()).create();
    public static Gson gson = Metodo.getGSON();
    
    //Situación
    public static final boolean SITUACION_ON = true;
    public static final boolean SITUACION_OFF = false;

    //Tipos de trabajadores
    public static final int TIPOTRABAJADOR_PRACTICANTE = 4;
    //Tipo de contrato
    public static final int TIPOCONTRATO_CONVENIO = 4;
    //Estado contrato
    public static final int ESTADOCONTRATO_VIGENTE = 1;
    public static final int ESTADOCONTRATO_RENOVADO = 2;
    public static final int ESTADOCONTRATO_TERMINADO = 3;
    public static final int ESTADOCONTRATO_CANCELADO = 4;
    //Forma de pago
    public static final int FORMAPAGO_EFECTIVO = 1;

    //Tipos de texto
    public static final int TEXT_ORACION = 1;
    public static final int TEXT_MINUSCULAS = 2;
    public static final int TEXT_PMAYUSCULA = 3;

    //Tamaño de archivos
    public static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    public static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    //Directorios para manejo de archivos
    public static final String DIRECTORY_AVATAR = "D:\\PRUEBA_AVATAR\\";
    public static final String DIRECTORY_CHAT = "D:\\CHAT\\";
    public static final String FPERFIL_DEFAULT = "./resources/img/img1.jpg";

    //Tipos de periodo
    public static final int TIPO_PERIODO_VACACION = 1;
    public static final int TIPO_PERIODO_PAGO = 2;

}
