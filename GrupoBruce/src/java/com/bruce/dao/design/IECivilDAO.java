/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.Ecivil;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IECivilDAO extends IEntidadDAO<Ecivil>{
    public List<Ecivil> filterBySituacion(boolean situacion);
}
