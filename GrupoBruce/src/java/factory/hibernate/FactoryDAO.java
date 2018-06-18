/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory.hibernate;

import dao.design.hibernate.IUsuarioDAO;
import dao.implement.hibernate.UsuarioDAO;

/**
 *
 * @author SISTEMAS
 */
public class FactoryDAO {
    
    private FactoryDAO() {
    }
    
    public static FactoryDAO getInstance() {
        return FactoryDAOHolder.INSTANCE;
    }
    
    private static class FactoryDAOHolder {
        private static final FactoryDAO INSTANCE = new FactoryDAO();
    }
    
    public IUsuarioDAO getUsuarioDAO(){
        return new UsuarioDAO();
    }
    
}
