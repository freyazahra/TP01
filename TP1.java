import java.util.Scanner;

public class TP1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=============================================================");
        System.out.println("\n  ____             _                 _____         _ _       \r\n" +
                " |  _ \\           | |               |  __ \\       | (_)      \r\n" +
                " | |_) |_   _ _ __| |__   __ _ _ __ | |__) |__  __| |_  __ _ \r\n" +
                " |  _ <| | | | '__| '_ \\ / _` | '_ \\|  ___/ _ \\/ _` | |/ _` |\r\n" +
                " | |_) | |_| | |  | | | | (_| | | | | |  |  __/ (_| | | (_| |\r\n" +
                " |____/ \\__,_|_|  |_| |_|\\__,_|_| |_|_|   \\___|\\__,_|_|\\__,_|\r\n" +
                "                                                             \r\n" +
                "                                                             ");
        System.out.println("=============================================================");
        System.out.println("============== Selamat datang di Burhanpedia! ===============");
        System.out.println("=============================================================\n");
        
        int stok_awal = 0;
        float harga_barang = 0;
        float saldo_awal = 0;

        stok_awal = validasiInputInteger(input, "Masukkan stok awal: ");

        harga_barang = validasiInputFloat(input, "Masukkan harga barang: ");

        saldo_awal = validasiInputFloat(input, "Masukkan saldo awal: ");

        while (true) { //lopping pertama untuk pilih menu 
            
            System.out.println("\nPilih menu\n" +
                            "1. Penjual\n" +
                            "2. Pembeli\n" +
                            "3. Hari Selanjutnya\n" +
                            "4. Keluar\n");
            
            System.out.print("Perintah: ");
            int perintah1 = input.nextInt();

            switch (perintah1) {
                case 1 :

                    while (true){ // looping kedua
                    System.out.println("\n===== MENU PENJUAL =====\n" +
                            "1. Cek Stok\n" +
                            "2. Cek Harga Barang\n" +
                            "3. Tambah Stok\n" +
                            "4. Ubah Harga Barang\n" +
                            "5. Generate Voucher\n" +
                            "6. Kirim Barang\n" +
                            "7. Lihat Laporan Pendapatan\n" +
                            "8. Kembali ke menu utama\n");
                            
                    System.out.print("Perintah: ");
                    int perintah_penjual = input.nextInt();

                    switch (perintah_penjual) {
                        case 1 : 
                            System.out.println("==============================\n" +
                                        "Stok saat ini: " + stok_awal +
                                        "\n==============================");
                            break;

                        case 2:
                            System.out.println("==============================\n" +
                                        "Harga barang saat ini: " + harga_barang +
                                        "\n==============================");
                            break;
                            
                        case 3:
                            System.out.print("Masukkan jumlah stok yang ingin ditambah: "); 
                            int tambah_stok = input.nextInt();

                            stok_awal += tambah_stok;

                            System.out.println("Stok berhasil ditambah! Stok saat ini : " + stok_awal);
                            break;

                        case 4:
                            System.out.print("Masukkan harga barang yang baru : "); 
                            float ganti_harga = input.nextFloat();
                            
                            harga_barang = ganti_harga;

                            System.out.println("Harga barang diperbarui: " + harga_barang);
                            break;

                        case 8:
                            break;
                    }

                    if(perintah_penjual == 8){
                        break; // keluar dari looping menu penjual

                    }
                }
                break; // break  untuk kembali pilihan menu utama
                
                case 2: // menu pembeli

                    while (true) {                        
                        System.out.println("\n===== MENU PEMBELI =====\n" + 
                                                "1. Cek Saldo\n" + 
                                                "2. Top Up Saldo\n" + 
                                                "3. Cek Harga Barang\n" + 
                                                "4. Beli Barang\n" + 
                                                "5. Generate Voucher\n" + 
                                                "6. Lacak Barang\n" + 
                                                "7. Lihat Laporan Pengeluaran\n" + 
                                                "8. Kembali ke menu utama\n");
                        
                        System.out.print("Perintah: ");
                        int perintah_pembeli = input.nextInt();

                            switch (perintah_pembeli) {
                                case 1 :
                                    System.out.println("==============================\n" + 
                                                        "Saldo saat ini: " + saldo_awal +
                                                        "\n==============================");
                                break;
                                    
                                case 2:
                                    System.out.print("Masukkan jumlah saldo yang ingin ditambah: ");
                                    float tambah_saldo = input.nextFloat();

                                    saldo_awal += tambah_saldo;

                                    System.out.println("Saldo berhasil ditambah! Saldo saat ini: " + saldo_awal);
                                    break;

                                case 3:
                                    System.out.println("==============================\n" +
                                                        "Harga barang saat ini: " + harga_barang +
                                                        "\n ==============================");
                                    break;

                                case 8:
                                    break;

                            }
                        
                            if (perintah_pembeli== 8){
                                break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("===========================================\n" + 
                                        "Terima kasih telah menggunakan Burhanpedia!\n" + 
                                        "===========================================");
                    input.close();
                    return; 
            }
        }
    }
            public static int validasiInputInteger (Scanner input, String pesan){ // buat ngecek int kalo input selain angka atau minus
                int nilai ;
                do {System.out.print(pesan);
                    nilai = input.nextInt();
                    if (nilai < 0) {
                        System.out.println("Input tidak boleh negatif! Silakan masukkan angka positif.");
                    }
                } while (nilai < 0);// kalo input salah bakal nanya ulang 
                return nilai;}
            

            public static int validasiInputFloat (Scanner input, String pesan){ // buat ngecek float kalo input selain angka atau minus
                int nilai ;
                do {System.out.print(pesan);
                    nilai = input.nextInt();
                    if (nilai < 0) {
                        System.out.println("Input tidak boleh negatif! Silakan masukkan angka positif.");
                    }
                } while (nilai < 0); // kalo input salah bakal nanya ulang
                return nilai;}

}
