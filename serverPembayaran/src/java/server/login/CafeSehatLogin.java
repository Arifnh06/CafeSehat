
package server.login;

import Koneksi.KoneksiMySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CafeSehatLogin")
public class CafeSehatLogin {
/*Panggil Koneksi MySQL*/
KoneksiMySQL kon = new KoneksiMySQL();
Connection con;
PreparedStatement ps;
ResultSet rs;
/*Selesai Panggil Koneksi MySQL*/
/*-----------------------------------------------------------------------------------------------------*/
/*Get Snack*/


    @WebMethod(operationName = "login")
    public int login(
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password) {

        //TODO write your implementation code here:
        int status = 0;
        try {
            con = kon.getCon();
            ps = con.prepareStatement("select * from login where username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = 1;
            } else {
                status = 0;
            }
            con.close();
        } catch (Exception ex) {

        }
        return status;
    }

@WebMethod(operationName = "getLogin")
public List getlogin(
            
@WebParam(name = "username") String username,
@WebParam(name = "password") String password)
{
    List login = new ArrayList();
    try 
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojek", "root", "");
        Statement st = conn.createStatement();
        con = kon.getCon();
        ps = con.prepareStatement("select * from login where username=?");
        ps.setString(1, username);
        ResultSet rst = ps.executeQuery();
        while (rst.next()) 
        {
            login.add(
                   
            " <div class=\"form-group\">\n" +
            " <label class=\"control-label col-sm-1\">Username</label>\n" +
            " <div class=\"col-sm-2\">\n" +
            " <input type=\"text\" class=\"form-control\" name=\"username\" value=\""+rst.getString("username")+"\">\n" +
            " </div>\n" +
            " </div>\n" +
            " \n" +
            " <div class=\"form-group\">\n" +
            " <label class=\"control-label col-sm-1\">No_telfon</label>\n" +
            " <div class=\"col-sm-2\">\n" +
            " <input type=\"text\" class=\"form-control\" name=\"password\" value=\""+rst.getString("password")+"\">\n" +
            " </div>\n" +
            " </div>\n" +
            " \n" +
      
            
            " </div>");
        }      
    }
    catch (Exception ex) 
    {
        System.out.println(ex.getMessage());
    }
    return login;
}
/*Selesai Get Snack*/
/*-----------------------------------------------------------------------------------------------------*/
/*Selesai Tambah Snack*/
@WebMethod(operationName = "addLogin")
public void addLogin(
@WebParam(name = "username") String username,
@WebParam(name = "email") String email,
@WebParam(name = "kontak") int kontak,
@WebParam(name = "password") String password)

{
    try
    {
        con = kon.getCon();
        ps = con.prepareStatement("insert into login value (?,?,?,?)");
        ps.setString(1, username);
        ps.setString(2, email);
        ps.setInt(3, kontak);
        ps.setString(4, password);
       
        ps.executeUpdate();
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
}
/*Selesai Tambah Snack*/
/*-----------------------------------------------------------------------------------------------------*/
/*Hapus Snack*/
@WebMethod(operationName = "delLogin")
public void delLogin(
@WebParam(name = "username") String username) 
{
    try
    {
        con = kon.getCon();
        ps = con.prepareStatement("delete from login where username = ?");
        ps.setString(1, username);
        ps.executeUpdate();
        } catch (Exception e) {
        System.out.println("Failed to remove Login because " + e.toString());
    }
}
/*Selesai Hapus Snack*/
/*-----------------------------------------------------------------------------------------------------*/
/*Edit Snack*/
@WebMethod(operationName = "editLogin")
public void editLogin(
@WebParam(name = "username") String username,
@WebParam(name = "password") String password)
{
    try 
    {
        con = kon.getCon();
        ps = con.prepareStatement("update login set username=?,password=?");
        ps.setString(1, username);
        ps.setString(2, password);
    
        ps.executeUpdate();
        } catch (Exception e) {
        System.out.println("Failed to edit Login because " + e.toString());
    }
}
/*Selesai Edit Snack*/
/*-----------------------------------------------------------------------------------------------------*/
@WebMethod(operationName = "tampilLogin")
public List tampilLogin() {
    List daftar = new ArrayList();
    String sql_daftar = "select * from login";
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojek", "root", "");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql_daftar);
       
        while (rs.next())
        {
            daftar.add("<td>" + rs.getString("username") + "</td>"
                    + "<td>" + rs.getString("password") + "</td>");
        }
        con.close();
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        }
        return daftar;
    }
}