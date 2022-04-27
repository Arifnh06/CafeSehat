/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.transaksi;

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

@WebService(serviceName = "CafeSehatTransaksi")
public class CafeSehatTransaksi {
/*Panggil Koneksi MySQL*/
KoneksiMySQL kon = new KoneksiMySQL();
Connection con;
PreparedStatement ps;
ResultSet rs;

@WebMethod(operationName = "getTransaksi")
public List getTransaksi(
        
@WebParam(name = "nama") String nama,
@WebParam(name = "kontak") int kontak,
@WebParam(name = "alamat") String alamat,
@WebParam(name = "pesanan") String pesanan,
@WebParam(name = "pembayaran") String pembayaran,
@WebParam(name = "total") int total
 ) 
{
    List transaksi = new ArrayList();
    try 
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojek", "root", "");
        Statement st = conn.createStatement();
        con = kon.getCon();
        
        ps = con.prepareStatement("select * from transaksi where nama=?");
        ps.setString(1, nama);
        ResultSet rst = ps.executeQuery();
        while (rst.next()) 
        {
            transaksi.add("<div class=\"form-group\">\n" +
            " <label class=\"control-label col-sm-1\">Nama</label>\n" +
            " <div class=\"col-sm-2\">\n" +
            " <input type=\"text\" class=\"form-control\" name=\"nama\" value=\""+rst.getString("nama")+"\" readonly=\"true\">\n" +
            " </div>\n" +
            " </div>\n" +
            " \n" +
            " <div class=\"form-group\">\n" +
            " <label class=\"control-label col-sm-1\">Kontak</label>\n" +
            " <div class=\"col-sm-2\">\n" +
            " <input type=\"text\" class=\"form-control\" name=\"kontak\" value=\""+rst.getInt("kontak")+"\">\n" +
            " </div>\n" +
            " </div>\n" +
            " \n" +
            " <div class=\"form-group\">\n" +
            " <label class=\"control-label col-sm-1\">alamat</label>\n" +
            " <div class=\"col-sm-2\">\n" +
            " <input type=\"text\" class=\"form-control\" name=\"alamat\" value=\""+rst.getString("alamat")+"\">\n" +
            " </div>\n" +
            " </div>\n" +
            " \n" +
            " <div class=\"form-group\">\n" +
            " <label class=\"control-label col-sm-1\">pesanan</label>\n" +
            " <div class=\"col-sm-2\">\n" +
            " <input type=\"text\" class=\"form-control\" name=\"pesanan\" value=\""+rst.getString("pesanan")+"\">\n" +
            " </div>\n" +
            " </div>\n" +
            " \n" +        
            " <div class=\"form-group\">\n" +
            " <label class=\"control-label col-sm-1\">pembayaran</label>\n" +
            " <div class=\"col-sm-2\">\n" +
            " <input type=\"text\" class=\"form-control\" name=\"pembayaran\" value=\""+rst.getString("pembayaran")+"\">\n" +
            " </div>\n" +
            " </div>\n" +
            " \n" +
            " <div class=\"form-group\">\n" +
            " <label class=\"control-label col-sm-1\">Total</label>\n" +
            " <div class=\"col-sm-2\">\n" +
            " <input type=\"text\" class=\"form-control\" name=\"total\" value=\""+rst.getInt("total")+"\">\n" +
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
    return transaksi;
}

@WebMethod(operationName = "addTransaksi")
public void addTransaksi(
@WebParam(name = "nama") String nama,
@WebParam(name = "kontak") int kontak,
@WebParam(name = "alamat") String alamat,
@WebParam(name = "pesanan") String pesanan,
@WebParam(name = "pembayaran") String pembayaran,
@WebParam(name = "total") int total
){
    try
    {
        con = kon.getCon();
        ps = con.prepareStatement("insert into transaksi value (?,?,?,?,?,?)");
        ps.setString(1, nama);
        ps.setInt(2, kontak);
        ps.setString(3, alamat);
        ps.setString(4, pesanan);
        ps.setString(5, pembayaran);
        ps.setInt(6, total);
        
        ps.executeUpdate();
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
}
/*Selesai Tambah Snack*/
/*-----------------------------------------------------------------------------------------------------*/
/*Hapus Snack*/
@WebMethod(operationName = "delTransaksi")
public void delTransaksi(
@WebParam(name = "nama") String nama) 
{
    try
    {
        con = kon.getCon();
        ps = con.prepareStatement("delete from transaksi where nama = ?");
        ps.setString(1, nama);
        ps.executeUpdate();
        } catch (Exception e) {
        System.out.println("Failed to remove transaksi because " + e.toString());
    }
}
/*Selesai Hapus Snack*/
/*-----------------------------------------------------------------------------------------------------*/
/*Edit Snack*/
@WebMethod(operationName = "editTransaksi")
public void editTranskasi(
@WebParam(name = "nama") String nama,
@WebParam(name = "kontak") int kontak,
@WebParam(name = "alamat") String alamat,
@WebParam(name = "pesanan") String pesanan,
@WebParam(name = "pembayaran") String pembayaran,
@WebParam(name = "total") int total ) 
{
    try 
    {
        con = kon.getCon();
        ps = con.prepareStatement("update transkasi set nama=?,kontak=?,alamat=?,pesanan=?,pembayaran=? where total=?");
       ps.setString(1, nama);
        ps.setInt(2, kontak);
        ps.setString(3, alamat);
         ps.setString(4, pesanan);
        ps.setString(5, pembayaran);
        ps.setInt(6, total);
        ps.executeUpdate();
        } catch (Exception e) {
        System.out.println("Failed to edit transaksi because " + e.toString());
    }
}
/*Selesai Edit Snack*/
/*-----------------------------------------------------------------------------------------------------*/
@WebMethod(operationName = "tampilTransaksi")
public List tampilTransaksi() {
    List daftar = new ArrayList();
    String sql_daftar = "select * from transaksi";
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojek", "root", "");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql_daftar);
       
        while (rs.next())
        {
            daftar.add("<td>" + rs.getString("nama") + "</td>"
                    + "<td>" + rs.getInt("kontak") + "</td>"
                    + "<td>" + rs.getString("alamat") + "</td>"
                     + "<td>" + rs.getString("pesanan") + "</td>"
                    + "<td>" + rs.getString("pembayaran")+"</td>"
                    + "<td>" + rs.getInt("total") + "</td>");
        }
        con.close();
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        }
        return daftar;
    }
}
