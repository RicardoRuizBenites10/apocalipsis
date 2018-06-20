/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import static util.Constante.*;

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
        listaPalabras.addAll(Arrays.asList(texto.split(delimitador)));
        return listaPalabras;
    }

    public static Gson getGSON() {
        GsonBuilder gbuilder = new GsonBuilder();
//        gbuilder.registerTypeAdapter(PackedJsonTypeAdapterFactory.class, new PackedJsonTypeAdapterFactory());
        gbuilder.registerTypeAdapter(Date.class, new BidirectionalDateSerializer());
        gbuilder.registerTypeAdapter(byte[].class, new BidirectionalByteSerializer());
        return gbuilder.create();
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

        if (nomAvatar != null && Metodo.CheckFile(Constante.DIRECTORY_AVATAR, codAvatar, nomAvatar.split("[.]")[1])) {
            byte[] bytes = Metodo.OpenFile(Constante.DIRECTORY_AVATAR, codAvatar, nomAvatar.split("[.]")[1]);
            nomAvatar = nomAvatar + ";" + "data:image/" + nomAvatar.split("[.]")[1] + ";" + "base64," + Base64.getEncoder().encodeToString(bytes);
            usuario.getTrabajador().getPersona().setnomAvatar(nomAvatar);
        }

        return "JJJJJOOOODEEER!!!!";
    }
}
