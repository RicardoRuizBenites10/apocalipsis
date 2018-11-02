/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Archivo;
import com.bruce.util.Constante;
import com.bruce.util.Metodo;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author SISTEMAS
 */
@Controller
public class ArchivoController {

    @ResponseBody
    @RequestMapping(value = "/iiArchivo", method = RequestMethod.POST)
    public Map<String, Object> getByFilters(@RequestBody Archivo archivo) {

        Map<String, Object> map = new HashMap<>();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd hh:mm a");
        String name[] = archivo.getNombre().split("[.]");
        String newName = formatoFecha.format(new Date()).substring(0, 10).replace("/", "") + "." + name[name.length - 1];

        boolean rpta = false;
        if (archivo.getAfterB64().length() > 0) {
            byte[] fileArray = Base64.getDecoder().decode(archivo.getAfterB64()); //extraemos la parte que representa b64 y luego decodificamos a bytes[]
            rpta = Metodo.SaveFile(Constante.DIRECTORY_ASISTENCIA, newName, fileArray);
            archivo.setNombre(newName);
        }

        map.put("success", rpta);
        map.put("message", "Registro exitoso");
        map.put("data", archivo);
        return map;
    }

}
