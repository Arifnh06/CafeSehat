/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.transaksi;

/**
 *
 * @author anurh
 */
public class transaksi {
    private int kontak, total;
    private String nama, alamat, pesanan, pembayaran;

    public int getKontak() {
        return kontak;
    }

    public void setKontak(int kontak) {
        this.kontak = kontak;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPesanan() {
        return pesanan;
    }

    public void setPesanan(String pesanan) {
        this.pesanan = pesanan;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }

    

}
