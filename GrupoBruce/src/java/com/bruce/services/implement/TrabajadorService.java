/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITrabajadorDAO;
import com.bruce.dao.to.Trabajador;
import com.bruce.util.SortPage;
import com.bruce.services.design.ITrabajadorService;
import com.bruce.util.Constante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Service
public class TrabajadorService implements ITrabajadorService {

    @Autowired
    private ITrabajadorDAO dao;

    @Override
    @Transactional
    public void insert(Trabajador newTrabajador) {
        newTrabajador.setIdEtrabajador(Constante.TRABAJADOR_ESTADO_ACTIVO);
        dao.create(newTrabajador);
    }

    @Override
    @Transactional
    public void delete(Trabajador t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Trabajador find(Object id) {
        return dao.find(id);
    }

    @Override
    @Transactional
    public List<Trabajador> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public List<Trabajador> findPagination(int start, int limit, List<SortPage> sorts) {
        return dao.getTrabajadorsPagination(start, limit, sorts);
    }

    @Override
    @Transactional
    public int totalCount() {
        return dao.getTrabajadorCount();
    }

    @Override
    @Transactional
    public void update(Trabajador t) {
        dao.update(t);
    }
}
