/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.util;

import com.bruce.dao.to.Asistencia;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import static com.bruce.util.Constante.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author RICARDO
 */
public class Metodo {

    //Inicial de cada palabra de un texto a mayuscula
    public static String FormatoTexto(String texto_original, int tipoFormato) {
        if (!texto_original.equalsIgnoreCase("")) {
            char[] caracteres = texto_original.toCharArray();
            switch (tipoFormato) {
                case TEXT_ORACION:
                    break;
                case TEXT_MINUSCULAS:
                    break;
                case TEXT_PMAYUSCULA:
                    caracteres[0] = Character.toUpperCase(caracteres[0]);
                    for (int i = 0; i < texto_original.length() - 1; i++) {
                        if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',') {
                            caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
                        } else {
                            caracteres[i + 1] = Character.toLowerCase(caracteres[i + 1]);
                        }
                    }
                    break;
                default:
                    break;
            }
            return new String(caracteres);
        } else {
            return texto_original;
        }

    }

    //Array de palabras de un texto separado por cadena
    public static List<String> getSplit(String texto, String delimitador) {
        List<String> listaPalabras = new ArrayList<>();
        listaPalabras.addAll(Arrays.asList(texto.split(Pattern.quote(delimitador))));
        return listaPalabras;
    }

    /*Abrir una imagen*/
    public static byte[] OpenFile(String directory, String nameFile, String extentionFile) {
        byte[] bytesImg = null;
        File archivo = new File(directory + nameFile.trim() + "." + extentionFile);
        BufferedInputStream entrada;
        try {
            entrada = new BufferedInputStream(new FileInputStream(archivo));
            Integer tam = ((Long) archivo.length()).intValue();
            bytesImg = new byte[tam];
            entrada.read(bytesImg);
            entrada.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return bytesImg;
    }

    /*Guardar imagen*/
    public static boolean SaveFile(String directory, String nameFile, String extentionFile, byte[] bytes) {
        boolean respuesta = false;
        BufferedOutputStream salida;
        try {
            File f = new File(directory + nameFile.trim() + "." + extentionFile);
            salida = new BufferedOutputStream(new FileOutputStream(f));
            salida.write(bytes);
            salida.close();
            respuesta = true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return respuesta;
    }

    public static boolean CheckFile(String directory, String nameFile, String extentionFile) {
        File f = new File(directory + nameFile.trim() + "." + extentionFile);
        return f.exists();
    }

    public static boolean RemoveFile(String directory, String nameFile, String extentionFile) {
        File f = new File(directory + nameFile.trim() + "." + extentionFile);
        return f.delete();
    }

    public static String getAvatarB64(String codAvatar, String nomAvatar) {
        if (nomAvatar != null && !nomAvatar.equalsIgnoreCase("") && Metodo.CheckFile(Constante.DIRECTORY_AVATAR, codAvatar, nomAvatar.split("[.]")[1])) {
            byte[] bytes = OpenFile(Constante.DIRECTORY_AVATAR, codAvatar, nomAvatar.split("[.]")[1]);
//            nomAvatar = nomAvatar + ";" + "data:image/" + nomAvatar.split("[.]")[1] + ";" + "base64," + Base64.getEncoder().encodeToString(bytes);
            nomAvatar = "data:image/" + nomAvatar.split("[.]")[1] + ";" + "base64," + Base64.getEncoder().encodeToString(bytes);
        } else {
            nomAvatar = Constante.FPERFIL_DEFAULT;
        }
        return nomAvatar;
    }
    
    public static List<Asistencia> Importar(File archivo) {
        
        Workbook wb;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"), formatoHora = new SimpleDateFormat("hh:mm:ss");
        List<Asistencia> lista = new ArrayList<>();
        String dni="", nombres="", fecha="", hora="";
                
        try {
            wb = WorkbookFactory.create(new FileInputStream(archivo));//CREAMOS UNA REPRESENTACIÓN DE HOJA EXCEL
            FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();//CREAMOS EVALUADOR DE FORMULAS
            Sheet hoja = wb.getSheetAt(0);//SELECCIONAMOS LA HOJA DE LA POSICIÓN -> 0 DEL LIBRO
            Row rowSelect;//OBJETO QUE PERMITIRA RECORRER UNA FILA
            Cell cellSelect;//OBJETO QUE PERMITE RECORRER UNA CELDA
            int nroFNN = hoja.getLastRowNum();//NÚMERO DE ULTIMA FILA NO VACIA
            int nroCFNN = 0;//NÚMERO DE LA ULTIMA COLUMNA NO VACIA DE UNA FILA
            int contFNN = 0;//CONTADOR DE FILA NO NULLA

            for (int ir = 0; ir <= nroFNN; ir++) {
                
                rowSelect = hoja.getRow(ir);
                if (rowSelect != null) {
                    contFNN++;
                    nroCFNN = rowSelect.getLastCellNum();
                    
//                    Object[] listaColumna = new Object[100];
                    
                    int indiceCTabla, nroOcultos = 0;
                    boolean oculto = false;
                    for (int ic = 0; ic < nroCFNN; ic++) {
                        indiceCTabla = ic;
                        cellSelect = rowSelect.getCell(ic);
                        if (contFNN == 1) {
                            if (cellSelect != null) {
                                if (hoja.isColumnHidden(cellSelect.getColumnIndex())) {// CABECERA CELL OCULTA
                                    System.out.println("fil[" + ir + "] col[" + ic + "]: Dato oculta");
                                } else {
                                    if (indiceCTabla == 3) {
                                        System.out.print("Fecha");
                                        System.out.print("Hora marcación");
                                        
//                                        modeloT.addColumn(" Fecha ");
//                                        modeloT.addColumn(" Hora marcación ");
                                    } else {
                                        System.out.print(cellSelect.getStringCellValue());
//                                        modeloT.addColumn(cellSelect.getStringCellValue());
                                    }
                                }
                            } else {
                                System.out.print(" Title " + ic);
//                                modeloT.addColumn("Title " + ic);
                            }
                        } else {
                            if (cellSelect != null) {
                                if (hoja.isColumnHidden(cellSelect.getColumnIndex())) {// CABECERA CELL OCULTA
                                    nroOcultos++;
                                    oculto = true;
                                } else {// COLUMNA VISIBLE
                                    if (oculto) {
                                        indiceCTabla = indiceCTabla - nroOcultos;
                                    } else {
                                        oculto = false;
                                    }
                                    switch (evaluator.evaluateInCell(cellSelect).getCellType()) {//EVALUA SI CELDA ES DE TIPO CELL_TYPE_FORMULA (SI NO LO ES, NO HACE NADA. SI LO ES, ETONCES FORMULA SE EVALUA Y SE REEMPLAZA EN VEZ DE LA FORMULA) LUEGO DEVUELVE EL TIPO DE CELDA 
                                        case Cell.CELL_TYPE_STRING:
                                            
                                            switch(indiceCTabla){
                                                case 1:
                                                    nombres = cellSelect.getStringCellValue();
                                                    break;
                                                case 2:
                                                    dni = cellSelect.getStringCellValue();
                                                    break;
                                                case 3:
                                                    fecha = (cellSelect.getStringCellValue()).substring(0, 10);
                                                    hora = (cellSelect.getStringCellValue()).substring(11);
                                                    break;
                                                default:
                                                    break;
                                            }
                                            
                                            
//                                            if (indiceCTabla == 3) {
//                                                listaColumna[indiceCTabla] = (cellSelect.getStringCellValue()).substring(0, 10);
//                                                listaColumna[indiceCTabla + 1] = (cellSelect.getStringCellValue()).substring(11);
//                                            } else {
//                                                listaColumna[indiceCTabla] = cellSelect.getStringCellValue();
//                                            }
                                            break;
                                        case Cell.CELL_TYPE_NUMERIC:
                                            if (DateUtil.isCellDateFormatted(cellSelect)) {
//                                                listaColumna[indiceCTabla] = formatoFecha.format(cellSelect.getDateCellValue());
                                            } else {
//                                                listaColumna[indiceCTabla] = (int) Math.round(cellSelect.getNumericCellValue());
                                            }
                                            break;
                                        case Cell.CELL_TYPE_BOOLEAN:
//                                            listaColumna[indiceCTabla] = cellSelect.getBooleanCellValue();
                                            break;
                                        case Cell.CELL_TYPE_BLANK:
//                                            listaColumna[indiceCTabla] = ""; //"BLANK";  CELDA QUE TUBO CONTENIDO Y LUEGO LO ELIMINAMOS
                                            break;
                                        case Cell.CELL_TYPE_ERROR:
//                                            listaColumna[indiceCTabla] = "ERROR";
                                            break;
                                    }
                                }
                            } else {
//                                listaColumna[indiceCTabla] = "";
                            }
                        }
                    }
                    if (contFNN > 1) {
                        lista.add(new Asistencia(dni, new Date(), hora, nombres));
//                        modeloT.addRow(listaColumna);
                    }
                }
            }
//            respuesta = "Carga exitosa";
        } catch (IOException | InvalidFormatException | EncryptedDocumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return lista;
    }
}
