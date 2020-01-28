/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.ObraSeguimiento;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IObraSeguimientoService extends IEntidadService<ObraSeguimiento>{
    public void changeLObraSeguimiento(List<ObraSeguimiento> os);
    public void deleteLObraSeguimiento(List<ObraSeguimiento> os);
}
