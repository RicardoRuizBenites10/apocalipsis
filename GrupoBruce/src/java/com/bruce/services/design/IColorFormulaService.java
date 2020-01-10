/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.ColorFormula;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IColorFormulaService extends IEntidadService<ColorFormula>{
    public void changeLColorFormula(List<ColorFormula> cf);
    public void deleteLColorFormula(List<ColorFormula> cf);
}
