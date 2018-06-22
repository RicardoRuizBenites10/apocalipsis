/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import com.microsoft.sqlserver.jdbc.SQLServerConnectionPoolDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;

/**
 *
 * @author RICARDO
 */
public class ConexionSQL {

    private static final ConexionSQL INSTANCE_SQL = null;
    private static Connection con = null;

    private SQLServerConnectionPoolDataSource pool = null;

    private ConexionSQL() {
        pool = new SQLServerConnectionPoolDataSource();
        pool.setServerName("PC-SISTEMAS\\BRUCE");//SERVIDOR // ENGLOBASYSTEMS // PC-SISTEMAS\BRUCE
        pool.setDatabaseName("BDBRUCE");//FBPRUEBA // FBRUCE
        pool.setUser("sa");//sabruce //sa//sa
        pool.setPassword("anteromariano");//Bruce123 //Nakamas//anteromariano
        pool.setPortNumber(1433);
    }

    public static ConexionSQL getInstance() {
        return INSTANCE_SQL == null ? new ConexionSQL() : INSTANCE_SQL;
    }

    public Connection getConexion() {
        if (con == null) {
            try {
                con = pool.getConnection();
                System.out.println("Conexion exitosa.");
            } catch (SQLServerException e) {
                System.err.println("Error en getConexion(): " + e.getMessage());
            }
            return con;
        } else {
            return con;
        }
    }
}
