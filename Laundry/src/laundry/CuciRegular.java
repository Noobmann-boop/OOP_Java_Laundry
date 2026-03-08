/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laundry;

/**
 *
 * @author adili
 */
public class CuciRegular extends paketCuci {
    
    public CuciRegular(double hargaDasar) throws DataPaketTidakValidException {
        super("Cuci Regular", hargaDasar);
    }
    
    @Override
    public double hitungTotalbiaya(){
        return getHargaDasar();
    }
}
