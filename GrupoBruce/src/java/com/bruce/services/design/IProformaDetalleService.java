/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.ProformaDetalle;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IProformaDetalleService extends IEntidadService<ProformaDetalle>{
    public List<ProformaDetalle> getByFilterP(int start, int limit, String sort, String filter, String query);
    public void changeLProformaDetalle(List<ProformaDetalle> pd);
    public void deleteLProformaDetalle(List<ProformaDetalle> pd);
}
