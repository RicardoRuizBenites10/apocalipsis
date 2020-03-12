/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Requerimiento;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IRequerimientoService extends IEntidadService<Requerimiento>{
    public void changeLRequerimiento(List<Requerimiento> rr);
    public void deleteLRequerimiento(List<Requerimiento> rr);
}
