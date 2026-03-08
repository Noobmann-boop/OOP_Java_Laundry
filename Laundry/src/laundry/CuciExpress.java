/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laundry;

/**
 *
 * @author adili
 */
public class CuciExpress extends paketCuci implements layananAntar {
     public CuciExpress(double hargaDasar) throws DataPaketTidakValidException {
        super("Cuci Express", hargaDasar);
    }
    
    @Override
    public double hitungTotalbiaya(){
        return getHargaDasar() + 20000;
    }
    
     @Override
    public void cetakInfoAntar(){
        System.out.println("Layanan Antar Jemput Tersedia Untuk Paket Ini");
    }
}
