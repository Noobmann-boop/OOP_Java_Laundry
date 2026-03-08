/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laundry;

/**
 *
 * @author adili
 */
public abstract class paketCuci {
    private String namaPaket;
    private double hargaDasar;
    
    public paketCuci(String namaPaket, double hargaDasar) throws DataPaketTidakValidException {
        if (hargaDasar <= 0){
            throw new DataPaketTidakValidException("Tidak Boleh 0 atau Negatif");
        }
        this.namaPaket = namaPaket;
        this.hargaDasar = hargaDasar;
    }

    public String getNamaPaket() {
        return namaPaket;
    }

    public double getHargaDasar() {
        return hargaDasar;
    }
    
    public abstract double hitungTotalbiaya(); 
}
