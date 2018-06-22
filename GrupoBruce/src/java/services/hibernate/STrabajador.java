/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.hibernate;

import dao.dto.hibernate.Trabajador;
import factory.hibernate.FactoryDAO;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class STrabajador {

    private Trabajador trabajador;
    private List<Trabajador> LTrabajador;

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public List<Trabajador> getLTrabajador() {
        return LTrabajador;
    }

    public boolean listarTrabajadores(){
        boolean rpta;
        LTrabajador = FactoryDAO.getInstance().getTrabajadorDAO().findAll();
        rpta = LTrabajador.size()>0;
        return rpta;
    }
}
