/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SISTEMAS
 */
public class ReverseQuery {

    private String query;
    private String select;
    private String from;
    private String entidad;
    private String iniEntidad;
    private Map<String, String> resultados = new HashMap<>();
    private String resultadosString;

    public ReverseQuery(String entidad, String iniEntidad) {
        this.entidad = entidad + "-";
        this.iniEntidad = iniEntidad + "-";
        this.select = "SELECT-";
        this.from = "FROM-";
    }
    
    public String getQuery(){
        return this.select + getResultadosString() + from + this.entidad + this.iniEntidad;
    }

    public String getResultadosString() {
        if(this.resultados.isEmpty()){
            this.resultadosString = "*";
        }else{
            this.resultadosString = "-";
        }
        return resultadosString;
    }
    
    public void addResult(String a, String b){
        this.resultados.put(a, b);
    }
    
}
