import java.util.Scanner;

public class KlinikSapi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nama;
        int berat;
        String layanan;
        String kelas;

        while (true) {
            nama = in.nextLine();
            if (nama.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println("Mooo! Nama sapi harus pakai huruf, bukan angka atau simbol!");
            }
        }

        while (true) {
            try {
                berat = Integer.parseInt(in.nextLine());
                if (berat >= 1 && berat <= 80) {
                    break;
                } else {
                    System.out.println("Sapi astral? Masukkan berat yang valid dulu, bestie!");
                }
            } catch (Exception e) {
                System.out.println("Sapi astral? Masukkan berat yang valid dulu, bestie!");
            }
        }

        while (true) {
            layanan = in.nextLine();
            if (layanan.equals("spa") || layanan.equals("potong_kuku") || layanan.equals("grooming")) {
                break;
            } else {
                System.out.println("Pilih spa, potong_kuku, atau grooming! Sapi kamu mau dirawat apa, sih?");
            }
        }

        while (true) {
            kelas = in.nextLine();
            if (kelas.equals("reguler") || kelas.equals("vip")) {
                break;
            } else {
                System.out.println("Pilih reguler atau vip! Sapi kamu mau treatmen sultan atau biasa aja?");
            }
        }

        boolean gratis = nama.equals("Moo") || nama.equals("Mooo") || nama.equals("Moooo");

        int hargaPerKg = 0;
        if (layanan.equals("spa")) {
            hargaPerKg = 8000;
        } else if (layanan.equals("potong_kuku")) {
            hargaPerKg = 6000;
        } else if (layanan.equals("grooming")) {
            hargaPerKg = 10000;
        }

        double biayaDasar = berat * hargaPerKg;
        double diskon = 0;
        if (berat > 30) {
            diskon = 0.1 * biayaDasar;
        }

        double tambahanVIP = 0;
        if (kelas.equals("vip")) {
            tambahanVIP = 0.2 * biayaDasar;
        }

        double subtotal = biayaDasar - diskon + tambahanVIP;

        double pajak = 0.08 * subtotal;

        double total = subtotal + pajak;

        if (gratis) {
            total = 0;
        }

        System.out.println("============= NOTA KLINIK SAPI =============");
        System.out.println("Nama Sapi: " + nama);
        System.out.println("Berat: " + berat + " kg");
        System.out.println("Jenis Layanan: " + layanan);
        System.out.println("Kelas: " + kelas);
        System.out.println("Biaya Dasar: Rp " + biayaDasar);
        System.out.println("Diskon: Rp " + diskon);
        System.out.println("Biaya Tambahan VIP: Rp " + tambahanVIP);
        System.out.println("Subtotal: Rp " + subtotal);
        System.out.println("Pajak: Rp " + pajak);
        System.out.println("Total Biaya: Rp " + total);
        System.out.println("===========================================");
        if (gratis) {
            System.out.println("Terima kasih, " + nama + " ! Sapi spesial memang beda perlakuan~");
        } else {
            System.out.println("Terima kasih, " + nama +" ! Semoga sapinya makin glow up.");
        }

    }
}