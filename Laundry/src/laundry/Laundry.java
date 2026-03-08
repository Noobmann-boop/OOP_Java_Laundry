/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package laundry;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author adili
 */
public class Laundry {
    
    static ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    static ArrayList<paketCuci> daftarPaketCuci = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean kondisi = true;
        
        while(kondisi){
            System.out.println("\n===SELAMAT DATANG DI LAUNDRYKITA===");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Keluar");
            System.out.print("Pilih Menu : ");
            
            String pilih = sc.nextLine().trim();
            
            switch(pilih) {
                case "1":
                    tambahPesan(sc);
                    break;
                case "2":
                    kondisi = false;
                    tampilRekap();
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid");
            }
        }
        sc.close();
    }
    
    static void tambahPesan(Scanner sc) {
        System.out.println("\n---Data Pelanggan---");
        System.out.println("Nama: ");
        String nama = sc.nextLine().trim();
        
        System.out.println("No Telepon: ");
        String NoTelp = sc.nextLine().trim();
        
        if(!NoTelp.matches("\\d+")){
            System.out.println("Nomor Telepon Harus Angka!");
            return;
        }
        System.out.println("\n---Data Paket---");
        System.out.print("Harga Dasar: ");
        double hargaDasar;
        try {
            hargaDasar = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Harga dasar harus berupa angka!");
            return;
        }
        
        System.out.print("Jenis Paket (1. Regular / 2. Express): ");
        String jenisPaket = sc.nextLine().trim();

        try {
            paketCuci paket;
            switch (jenisPaket) {
                case "1":
                    paket = new CuciRegular(hargaDasar);
                    break;
                case "2":
                    paket = new CuciExpress(hargaDasar);
                    break;
                default:
                    System.out.println("ERROR: Jenis paket tidak valid!");
                    return;
            }

            Pelanggan pelanggan = new Pelanggan(nama, NoTelp);
            daftarPelanggan.add(pelanggan);
            daftarPaketCuci.add(paket);
            System.out.println("BERHASIL: Pesanan berhasil ditambahkan!");

        } catch (DataPaketTidakValidException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    static void tampilRekap() {
        if (daftarPelanggan.isEmpty()) {
            System.out.println("\nTidak ada pesanan yang tercatat.");
            return;
        }

        System.out.println("\n=========== REKAP PESANAN ===========");
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            Pelanggan p = daftarPelanggan.get(i);
            paketCuci paket = daftarPaketCuci.get(i);

            System.out.println("Pelanggan : " + p.getNama());
            System.out.println("Paket     : " + paket.getNamaPaket());
            System.out.printf("Total     : Rp %,.0f%n", paket.hitungTotalbiaya());

            if (paket instanceof layananAntar) {
                System.out.print("Antar     : ");
                ((layananAntar) paket).cetakInfoAntar();
            } else {
                System.out.println("Antar     : -");
            }

            System.out.println("--------------------------------------");
        }
        System.out.println("=====================================");
    }
}


