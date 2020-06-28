/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hung1    
 */
public class DAO {
    public static Connection con;

    public DAO() {
        String dbUser = "root";
        String dbPassword = "1234";
        String dbName = "qlgiaivodichqg";
        int dbPort = 3306;
        String dbConnectURL = "jdbc:mysql://localhost:" + dbPort + "/" + dbName
                + "?autoReconnect=true&useSSL=false";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbConnectURL, dbUser, dbPassword);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
