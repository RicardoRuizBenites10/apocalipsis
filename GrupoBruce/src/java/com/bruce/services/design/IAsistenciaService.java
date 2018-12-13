/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Asistencia;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IAsistenciaService extends IEntidadService<Asistencia>{
    public List<Asistencia> insertList(List<Asistencia> list);
}
