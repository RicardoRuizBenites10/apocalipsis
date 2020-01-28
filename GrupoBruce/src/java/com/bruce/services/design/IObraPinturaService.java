/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.ObraPintura;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IObraPinturaService extends IEntidadService<ObraPintura>{
    public void changeLObraPintura(List<ObraPintura> op);
    public void deleteLObraPintura(List<ObraPintura> op);
}
