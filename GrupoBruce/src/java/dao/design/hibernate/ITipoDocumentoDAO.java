/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design.hibernate;

import dao.dto.hibernate.TipoDocumento;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface ITipoDocumentoDAO extends IEntidadDAO<TipoDocumento>{
    public List<TipoDocumento> filterBySituacion(boolean situacion);
}
