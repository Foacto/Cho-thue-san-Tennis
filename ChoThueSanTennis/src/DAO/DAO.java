/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author vvt
 */
public class DAO {
    public static Connection con;

    public DAO() {
        if(con == null){
            String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=ChoThue_SanTennis;Username=sa;Password=27012001";
            String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

            try {
		Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
}
