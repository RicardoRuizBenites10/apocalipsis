/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.ColorDiseno;

/**
 *
 * @author SISTEMAS
 */
public interface IColorDisenoService extends IEntidadService<ColorDiseno> {
    public ColorDiseno llColorDiseno(String property, String operator, Object value);
}
