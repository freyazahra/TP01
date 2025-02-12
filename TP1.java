import java.util.Scanner;

public class TP1 {
    static Scanner input = new Scanner(System.in);
    static int stok_awal;
    static float harga_barang;
    static float saldo_awal;

    public static void main(String[] args) {
        tampilkanHeader();

        stok_awal = validasiInputInteger("Masukkan stok awal: ");
        harga_barang = validasiInputFloat("Masukkan harga barang: ");
        saldo_awal = validasiInputFloat("Masukkan saldo awal: ");

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
                case 8:
                    return;
            }
        }
    }

    static void cekStok() {
        System.out.println("Stok saat ini: " + stok_awal);
    }

    static void cekHargaBarang() {
        System.out.println("Harga barang saat ini: " + harga_barang);
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

    static void cekSaldo() {
        System.out.println("Saldo saat ini: " + saldo_awal);
    }

    static void topUpSaldo() {
        float tambah = validasiInputFloat("Masukkan jumlah saldo yang ingin ditambah: ");
        saldo_awal += tambah;
        System.out.println("Saldo berhasil ditambah! Saldo saat ini: " + saldo_awal);
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
