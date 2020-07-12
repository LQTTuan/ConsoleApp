/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author thanhtuan
 */
public class CommonConnection {
    public static Connection conn = null;
     
    public static Connection GetConnection(String serverName, String database, String account, String password){
        try {
            String url = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(url);
            String svName = serverName;
            String dbName = "databaseName=" + database;
            String dbUrl  = svName + ";" + dbName;

            conn = DriverManager.getConnection(dbUrl,account,password);
        } catch (Exception ex) {
            System.err.println("Cannot connect to " + database);
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
