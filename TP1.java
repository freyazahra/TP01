import java.util.Scanner;

public class TP1 {
    static Scanner input = new Scanner(System.in);
    static int stok_awal;
    static float harga_barang;
    static float saldo_awal = 0;
    static float saldo_pertama;

    public static void main(String[] args) {
        tampilkanHeader();

        stok_awal = validasiInputInteger("Masukkan stok awal: ");
        harga_barang = validasiInputFloat("Masukkan harga barang: ");
        saldo_pertama = validasiInputFloat("Masukkan saldo awal: ");
        saldo_awal = saldo_pertama;

        while (true) {
            tampilkanMenuUtama();
            int perintah = input.nextInt();
            switch (perintah) {
                case 1:
                    menuPenjual();
                    break;
                case 2:
                    menuPembeli();
                    break;
                case 4:
                    keluar();
                    return;
            }
        }
    }

    static void tampilkanHeader() {
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

    }

    static void tampilkanMenuUtama() {
        System.out.println("\nPilih menu\n" +
                "1. Penjual\n" +
                "2. Pembeli\n" +
                "3. Hari Selanjutnya\n" +
                "4. Keluar\n");
        System.out.print("Perintah: ");
    }

    static void menuPenjual() {
        while (true) {
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
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    cekStok();
                    break;
                case 2:
                    cekHargaBarang();
                    break;
                case 3:
                    tambahStok();
                    break;
                case 4:
                    ubahHargaBarang();
                    break; 
                case 7:
                    laporanPendapatan(0, 0, 0, 0);
                    break;  
                case 8:
                    return;
            }
        }
    }

    static void menuPembeli() { 
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
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    cekSaldo();
                    break;
                case 2:
                    topUpSaldo();
                    break;
                case 3:
                    cekHargaBarang();
                    break;
                case 4:
                    beliBarang();
                    break;
                case 5:
                    generateVoucher();
                    System.out.println("Voucher berhasil dibuat: " + generateVoucher());
                    break;
                case 7:
                    laporanPengeluaran(0, 0, 0);
                    break;  
                case 8:
                    return;
            }
        }
    }

    static void cekStok() {
        System.out.println("==============================\n" + 
                        "Stok saat ini: " + stok_awal +
                        "\n==============================");
    }

    static void cekHargaBarang() {
        System.out.println("==============================\n" + 
                        "Harga barang saat ini: " + harga_barang +
                        "\n==============================" );
    }

    static void tambahStok() {
        int tambah = validasiInputInteger("Masukkan jumlah stok yang ingin ditambah: ");
        stok_awal += tambah;
        System.out.println("Stok berhasil ditambah! Stok saat ini: " + stok_awal);
    }

    static void ubahHargaBarang() {
        harga_barang = validasiInputFloat("Masukkan harga barang yang baru: ");
        System.out.println("Harga barang diperbarui: " + harga_barang);
    }

    // pilihan untuk pembeli
    static void cekSaldo() {
        System.out.println("Saldo saat ini: " + saldo_awal);
    }

    static void topUpSaldo() {
        float tambahSaldo = validasiInputFloat("Masukkan jumlah saldo yang ingin ditambah: ");
        saldo_awal += tambahSaldo ;
        System.out.println("Saldo berhasil ditambah! Saldo saat ini: " + saldo_awal);
    }

    public static String generateVoucher() { 
    String karakter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] kodeVoucher = new char[10];  // Array untuk menyimpan karakter voucher
    
    // Generate kode huruf acak
    for (int i = 0; i < 10; i++) {
        int randomIndex = (int) (karakter.length() * Math.random());
        kodeVoucher[i] = karakter.charAt(randomIndex);
    }

    String kodeVoucherStr = new String(kodeVoucher); // Konversi ke string

    // Konversi ke angka
    char[] voucherInt = new char[kodeVoucherStr.length()];
    for (int i = 0; i < kodeVoucherStr.length(); i++) { 
        int x = (int) kodeVoucherStr.charAt(i) - 55; // Konversi ASCII, dikurang 55 karena huruf A dimulai dari 65, biar hasilnya 10-35
        int result = x * i;
        result %= 10;
        voucherInt[i] = (char) (result + '0'); // Konversi ke karakter angka (0 karena angka dimulai dari 48 sebagai ASCII)
    }

    return new String(voucherInt);
    }

    public static int hitungVoucher(String voucherInt){
        int panjangVoucher = voucherInt.length();
        int totalVoucher = 0;

        for (int i = 0; i < panjangVoucher; i++) {
            int angkaDepan = voucherInt.charAt(i) - '0';
            int angkaBelakang = voucherInt.charAt(panjangVoucher - i - 1) - '0';
            totalVoucher += angkaDepan * angkaBelakang;
        }
        return normalisasiDiskon(totalVoucher);
    }

    public static int normalisasiDiskon(int totalVoucher){ // kalau hasilnya leih dari 100, bakal di modulus 100
        return totalVoucher % 100;
    }

    public static void beliBarang() {
        float jumlahBarang = validasiInputFloat("Masukkan jumlah barang yang ingin dibeli: ");
        float totalHarga = jumlahBarang * harga_barang;
        int jumlahTransaksi = 0;
        float harga_total_diskon = 0;
        float pembelianTerbesar = 0;
        float totalPajak = 0;
        
        while (true) {
            System.out.println("Masukkan kode voucher\n" + 
                               "Jika tidak ada, ketik 'skip'\n" + 
                               "Jika ingin buat, ketik 'generate'\n" + 
                               "================================");

            System.out.print("================================\n" +
                               "Kode : ");
            String kode = input.next();

            // if generate bakal ke fungsi generateVoucher
            if (kode.equals("generate")) {
                String generatedVoucher = generateVoucher();
                System.out.println("Voucher berhasil dibuat: " + generatedVoucher);
                continue;
            } 
            // if kode voucher valid
            else if (!kode.equals("skip")) {
                int diskon = hitungVoucher(kode);

                // hitung harga setelah diskon
                float harga_diskon = totalHarga * diskon / 100;
                harga_total_diskon += harga_diskon;
                float hargaSetelahDiskon = totalHarga - harga_diskon;

                // hitung harga setelah pajak
                float harga_pajak = hargaSetelahDiskon * 3 / 100;
                totalPajak += harga_pajak;
                float hargaBersih = hargaSetelahDiskon + harga_pajak;
                
                System.out.println("Voucher berhasil digunakan! Harga setelah diskon: " + hargaBersih);
                saldo_awal -= hargaBersih;
                jumlahTransaksi++;

                if (hargaBersih > pembelianTerbesar) {
                    pembelianTerbesar = hargaBersih;
                }   // nentuin pembelian terbesar untuk laporan pengeluaran

                System.out.println("Pembelian sukses! Saldo saat ini: " + saldo_awal);
                break;
            } 
            // kalo skip bakal lansung dikurangin aja
            else if (kode.equals("skip")) {
                System.out.println("Voucher tidak digunakan");
                jumlahTransaksi++;

                float harga_pajak = totalHarga * 3 / 100;
                totalPajak += harga_pajak;
                float hargaBersih = totalHarga + harga_pajak;

                if (hargaBersih > pembelianTerbesar) {
                    pembelianTerbesar = hargaBersih;
                }

                saldo_awal -= hargaBersih;
                System.out.println("Pembelian sukses! Saldo saat ini: " + saldo_awal);

                break;
            }
        }
    }
    

    public static void laporanPengeluaran(int jumlahTransaksi, float harga_total_diskon, float pembelianTerbesar) {
        float totalPengeluaran = saldo_pertama - saldo_awal;

        float rataRataPembelian = totalPengeluaran / jumlahTransaksi ;

        System.out.println("\n================================\n" +
                           "Laporan Pengeluaran\n" +
                           "------------------------------\n" +
                           "Total pengeluaran: " + totalPengeluaran + 
                           "\nTotal diskon: " + harga_total_diskon + 
                           "\nPembelian terbesar: " + pembelianTerbesar + 
                           "\nRata-rata pembelian: " + rataRataPembelian + 
                           "\n================================");
            }

    public static void laporanPendapatan(int jumlahTransaksi, float harga_total_diskon, float pembelianTerbesar, float totalPajak) {
        float totalPendapatan = (saldo_awal - saldo_pertama) - totalPajak;

        float rataRataPembelian = totalPendapatan / jumlahTransaksi;

        System.out.println("\n================================\n" +
                           "Laporan Pendapatan\n" +
                           "------------------------------\n" +
                           "Total pendapatan: " + totalPendapatan + 
                           "\nTotal diskon: " + harga_total_diskon + 
                           "\nPembelian terbesar: " + pembelianTerbesar + 
                           "\nRata-rata pembelian: " + rataRataPembelian + 
                           "\n================================");
    }
    static void keluar() {
        input.close();
    }

    static int validasiInputInteger(String pesan) {
        int nilai;
        while (true) {
            System.out.print(pesan);
            if (input.hasNextInt()) {
                nilai = input.nextInt();
                if (nilai >= 0) break;
            }
            input.nextLine(); 
            System.out.println("Input tidak valid! Masukkan angka positif.");
        }
        return nilai;
    }

    static float validasiInputFloat(String pesan) { // input nggak bakal bisa minus
        float nilai;
        while (true) {
            System.out.print(pesan);
            if (input.hasNextFloat()) {
                nilai = input.nextFloat();
                if (nilai >= 0) break;
            }
            input.nextLine(); 
            System.out.println("Input tidak valid! Masukkan angka positif.");
        }
        return nilai;
    }
}
