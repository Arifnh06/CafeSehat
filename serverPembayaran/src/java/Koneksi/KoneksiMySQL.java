/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author anurh
 */
public class KoneksiMySQL {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/dbprojek";
    String usern = "root";
    String passw = "";
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Connection getCon()
    {
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usern, passw);
        }
        catch(Exception ex) 
        {
            System.out.println(ex.getMessage());
        }
        return con;
    }
}
