/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Archivo;
import com.bruce.dao.to.Asistencia;
import com.bruce.util.Constante;
import com.bruce.util.Metodo;
import java.io.File;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<Asistencia> lista = new ArrayList<>();

        boolean rpta = false;
        if (archivo.getFileB64().length() > 0) {
            byte[] fileArray = Base64.getDecoder().decode(archivo.getFileB64().split(",")[1]); //extraemos la parte que representa b64 y luego decodificamos a bytes[]
            rpta = Metodo.SaveFile(Constante.DIRECTORY_ASISTENCIA, archivo.getNombre().split("[.]")[0], archivo.getExtension(), fileArray);
            if (rpta) {
                lista = Metodo.Importar(new File(Constante.DIRECTORY_ASISTENCIA + archivo.getNombre()));
            }
        }
        System.err.println("Respuesta: " + rpta);
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        map.put("total", 100);
        return map;
    }

}
