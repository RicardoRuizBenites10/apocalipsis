/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import com.microsoft.sqlserver.jdbc.SQLServerConnectionPoolDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author SISTEMAS
 */
public class ConexionSQLAnterior {
    private SQLServerConnectionPoolDataSource pool = null;
    private Connection con=null;
    
    public ConexionSQLAnterior(){
        pool = new SQLServerConnectionPoolDataSource();
        pool.setServerName("ENGLOBASYSTEMS");//SERVIDOR // ENGLOBASYSTEMS
        pool.setDatabaseName("BDBRUCE");//FBPRUEBA // FBRUCE
        pool.setUser("sa");//sabruce //sa
        pool.setPassword("Nakamas");//Bruce123 //Nakamas
        pool.setPortNumber(1433);
    }
    
    public Connection getConexion(){
        try {
            con = pool.getConnection();
        } catch (SQLServerException e) {
            System.err.println("Error getConexion(): " + e.getMessage());
            close();
        }
        return con;
    }
    
    public void close() {
        try {
            if (con != null) {
                con.close();
            }
            con = null;
        } catch (SQLException e) {
            System.err.println("Error closeConexion(): " + e.getMessage());
        }
    }
}
