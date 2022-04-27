/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.produk;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author anurh
 */
public class produk {
   String Kd_produk,Nm_produk;
   int id_produk, Harga_produk,Qty;

    public String getKd_produk() {
        return Kd_produk;
    }

    public void setKd_produk(String Kd_produk) {
        this.Kd_produk = Kd_produk;
    }

    public String getNm_produk() {
        return Nm_produk;
    }

    public void setNm_produk(String Nm_produk) {
        this.Nm_produk = Nm_produk;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public int getHarga_produk() {
        return Harga_produk;
    }

    public void setHarga_produk(int Harga_produk) {
        this.Harga_produk = Harga_produk;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    

}