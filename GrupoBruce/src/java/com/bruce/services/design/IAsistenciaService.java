/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Asistencia;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IAsistenciaService extends IEntidadService<Asistencia>{
    public List<Asistencia> getByFilter(int start, int limit, List<FilterPage> filters);
    public int countByFilter(List<FilterPage> filters);
    public Asistencia lastByFilter(List<FilterPage> filters);
    public List<Asistencia> insertList(List<Asistencia> list);
}