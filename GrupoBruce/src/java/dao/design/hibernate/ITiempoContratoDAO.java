/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design.hibernate;

import dao.dto.hibernate.TiempoContrato;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface ITiempoContratoDAO extends IEntidadDAO<TiempoContrato>{
    public List<TiempoContrato> filterBySituacion(boolean situacion);
}
