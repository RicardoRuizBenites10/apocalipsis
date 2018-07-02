/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services;

import com.bruce.dao.to.Trabajador;
import com.bruce.dao.to.TrabajadorDTO;
import com.bruce.factory.FactoryDAO;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class STrabajador {

    private Trabajador trabajador;
    private List<Trabajador> LTrabajador;
    private List<TrabajadorDTO> LTrabajadorDTO;

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public List<Trabajador> getLTrabajador() {
        return LTrabajador;
    }

    public List<TrabajadorDTO> getLTrabajadorDTO() {
        return LTrabajadorDTO;
    }

    public boolean listarTrabajadores(){
        boolean rpta;
        LTrabajador = FactoryDAO.getInstance().getTrabajadorDAO().findAll();
        rpta = LTrabajador.size()>0;
        return rpta;
    }
    
    public boolean listarTrabajadoresPerformance(){
        boolean rpta;
        LTrabajadorDTO = FactoryDAO.getInstance().getTrabajadorDAO().getAllPerforms();
        rpta = LTrabajadorDTO.size()>0;
        return rpta;
    }
}
