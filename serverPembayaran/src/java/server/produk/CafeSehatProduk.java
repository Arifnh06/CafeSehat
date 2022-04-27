/*
    Ujian Akhir Semester - Pemrograman Web 2
    Nama File  : TokoSnackBarokah.java
    Project    : Siakad
    Author     : Enggar(16.3.00008)-Ramadhan(16.3.00013)-Fikri(16.3.00017)
*/

package server.produk;

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

@WebService(serviceName = "CafeProduk")
public class CafeSehatProduk {
/*Panggil Koneksi MySQL*/
KoneksiMySQL kon = new KoneksiMySQL();
Connection con;
PreparedStatement ps;
ResultSet rs;
/*Selesai Panggil Koneksi MySQL*/
/*-----------------------------------------------------------------------------------------------------*/
/*Get Snack*/
@WebMethod(operationName = "getProduk")
public List getProduk(    
        @WebParam(name = "idProduk") int idProduk)
{
    List produk = new ArrayList();
    try 
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojek", "root", "");
        Statement st = conn.createStatement();
        con = kon.getCon();
        ps = con.prepareStatement("select * from produk where idProduk=?");
        ps.setInt(1, idProduk);
        ResultSet rst = ps.executeQuery();
        while (rst.next()) 
        {
            produk.add("<div class=\"form-group\">\n" +           
            " <input type=\"text\" class=\"form-control\" name=\"id_Produk\" value=\""+rst.getInt("id_Produk")+"\" readonly=\"true\">\n" +
            " </div>\n" +
            " </div>\n" +
            " \n" +
            " <div class=\"form-group\">\n" +
            " <label class=\"control-label col-sm-1\">kd Produk</label>\n" +
            " <div class=\"col-sm-2\">\n" +
            " <input type=\"text\" class=\"form-control\" name=\"Kd_produk\" value=\""+rst.getString("Kd_produk")+"\">\n" +
            " </div>\n" +
            " </div>\n" +
            " \n" +
            " <div class=\"form-group\">\n" +
            " <label class=\"control-label col-sm-1\">nm Produk</label>\n" +
            " <div class=\"col-sm-2\">\n" +
            " <input type=\"text\" class=\"form-control\" name=\"Nm_produk\" value=\""+rst.getString("Nm_produk")+"\">\n" +
            " </div>\n" +
            " </div>\n" +
            " \n" +
            " <div class=\"form-group\">\n" +
            " <label class=\"control-label col-sm-1\">Harga Produk</label>\n" +
            " <div class=\"col-sm-2\">\n" +
            " <input type=\"text\" class=\"form-control\" name=\"Harga_roduk\" value=\""+rst.getInt("Harga_produk")+"\">\n" +
            " </div>\n" +
            " </div>\n" +
            " \n" +
            "<div class=\"form-group\">\n" +
            " <label class=\"control-label col-sm-1\">Qty</label>\n" +
            " <div class=\"col-sm-2\">\n" +
            " <input type=\"text\" class=\"form-control\" name=\"Qty\" value=\""+rst.getInt("Qty")+"\" readonly=\"true\">\n" +
            " </div>\n"
            );
           
        }      
    }
    catch (Exception ex) 
    {
        System.out.println(ex.getMessage());
    }
    return produk;
}
/*Selesai Get Snack*/
/*-----------------------------------------------------------------------------------------------------*/
/*Selesai Tambah Snack*/
@WebMethod(operationName = "addProduk")
public void addProduk(
@WebParam(name = "id_produk") int id_produk,
@WebParam(name = "Kd_produk") String Kd_produk,
@WebParam(name = "Nm_produk") String Nm_produk,
@WebParam(name = "Harga_produk") int Harga_produk,
@WebParam(name = "Qty") int Qty)
{
    try
    {
        con = kon.getCon();
        ps = con.prepareStatement("insert into produk value (?,?,?,?,?)");
        ps.setInt(1, id_produk);
        ps.setString(2, Kd_produk);
        ps.setString(3, Nm_produk);
        ps.setInt(4, Harga_produk);
        ps.setInt(5, Qty);
        
        ps.executeUpdate();
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
}
/*Selesai Tambah Snack*/
/*-----------------------------------------------------------------------------------------------------*/
/*Hapus Snack*/
@WebMethod(operationName = "delProduk")
public void delProduk(
@WebParam(name = "id_produk") int id_produk) 
{
    try
    {
        con = kon.getCon();
        ps = con.prepareStatement("delete from produk where id_produk = ?");
        ps.setInt(1, id_produk);
        ps.executeUpdate();
        } catch (Exception e) {
        System.out.println("Failed to remove produk because " + e.toString());
    }
}
/*Selesai Hapus Snack*/
/*-----------------------------------------------------------------------------------------------------*/
/*Edit Snack*/
@WebMethod(operationName = "editProduk")
public void editProduk(
@WebParam(name = "id_produk") int id_produk,
@WebParam(name = "Kd_produk") String Kd_produk,
@WebParam(name = "Nm_produk") String Nm_produk,
@WebParam(name = "Harga_produk") int Harga_produk,
@WebParam(name = "Qty") int Qty)
{
    try 
    {
        con = kon.getCon();
        ps = con.prepareStatement("update produk set id_produk=?,Kd_produk=?,Nm_produk=?,Harga_produk=? where Qty=?");
         ps.setInt(1, id_produk);
        ps.setString(2, Kd_produk);
        ps.setString(3, Nm_produk);
        ps.setInt(4, Harga_produk);
        ps.setInt(5, Qty);
        ps.executeUpdate();
        } catch (Exception e) {
        System.out.println("Failed to edit produk because " + e.toString());
    }
}
/*Selesai Edit Snack*/
/*-----------------------------------------------------------------------------------------------------*/
@WebMethod(operationName = "tampilProduk")
public List tampilProduk() {
    List daftar = new ArrayList();
    String sql_daftar = "select * from produk";
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojek", "root", "");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql_daftar);
       
        while (rs.next()) {
                daftar.add("<td class=\\\"c1\\\">" +rs.getInt("id_produk") + "</td>"
                        + "<td class=\\\"c2\\\">" + rs.getString("Kd_produk") + "</td>"
                        + "<td class=\\\"c3\\\">" + rs.getString("Nm_produk") + "</td>"
                        + "<td class=\\\"c4\\\">" + rs.getInt("Harga_produk") + "</td>"
                        + "<td class=\\\"c5\\\">" + rs.getInt("Qty") + "</td><tr>");
            }
            con.close();
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        }
        return daftar;
    }


    @WebMethod(operationName = "cariProduk")
    public List cariProduk(@WebParam(name = "search") String search) {
        //TODO write your implementation code here:
        List barang = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojek", "root", "");
            Statement st = conn.createStatement();
            con = kon.getCon();
            ps = con.prepareStatement("select * from produk where Nm_produk like ?");
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                barang.add("<td class=\\\"c1\\\">" +rs.getInt("id_produk") + "</td>"
                        + "<td class=\\\"c2\\\">" + rs.getString("Kd_produk") + "</td>"
                        + "<td class=\\\"c3\\\">" + rs.getString("Nm_produk") + "</td>"
                        + "<td class=\\\"c4\\\">" + rs.getInt("Harga_produk") + "</td>"
                        + "<td class=\\\"c5\\\">" + rs.getInt("Qty") + "</td>"
                        + "<td class=\\\"c6\\\"><button class=\"btn-info\"><a href=\"checkout.jsp?id=" + rs.getInt("id_produk")
                        + "\">Cekout</a></button></td><tr>");
            }
            conn.close();
        } catch (Exception e) {

        }
        return barang;
    }

    @WebMethod(operationName = "urutkanProduk")
    public List urutkanProduk(@WebParam(name = "sortir") String sortir) {
        //TODO write your implementation code here:
        List barang = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojek", "root", "");
            Statement st = conn.createStatement();
            con = kon.getCon();
            if (sortir.equals("Nm_produk")){
                ps = con.prepareStatement("SELECT * from produk order by nmProduk");
            }    
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                barang.add("<td class=\\\"c1\\\">" +rs.getInt("id_produk") + "</td>"
                        + "<td class=\\\"c2\\\">" + rs.getString("Kd_produk") + "</td>"
                        + "<td class=\\\"c3\\\">" + rs.getString("Nm_produk") + "</td>"
                        + "<td class=\\\"c4\\\">" + rs.getInt("Harga_produk") + "</td>"
                        + "<td class=\\\"c5\\\">" + rs.getInt("Qty") + "</td>"
                        + "<td class=\\\"c6\\\"><button class=\"btn-info\"><a href=\"checkout.jsp?id=" + rs.getInt("id_produk")
                        + "\">Cekout</a></button></td><tr>");
            }
            conn.close();
        } catch (Exception e) {

        }
        return barang;
    }
    
}