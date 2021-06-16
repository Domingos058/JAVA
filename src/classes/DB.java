/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.sql.connection;

//import java.sql.*;
        /**
 *
 * @author IACM
 */
public class DB {
     private  String servername = "localhost";
    private  static String username = "root";
    private  static String dBname= "cdi";
    private  static int portNumber = 3306;
    private  static String password ="iacm";
    
    
    public static Connection getConnection()
    {
        Connection connection = null;
        MysqlDataSource datasourece = new MysqlDataSource();
        datasourece.setUser(username);
        datasourece.setDatabaseName(dBname);
        datasourece.setPortNumber(portNumber);
        datasourece.setPassword(password);
        
         try {
             connection = datasourece.getConnection();
                     
                     } catch (SQLException ex) {
             Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return connection;
    }
    
    
    
}
