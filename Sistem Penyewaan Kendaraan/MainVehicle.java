import java.util.HashMap;
import java.util.Scanner;

public class MainVehicle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();

        HashMap<String, Vehicle> v = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String line = in.nextLine();
            String[] input = line.split(" ");
            String command = input[0];

            if (command.equals("ADD")) {
                String tipe = input[1];
                String kode = input[2];
                String nama = input[3];
                int harga = Integer.parseInt(input[4]);

                if (v.containsKey(kode)) {
                    System.out.println("Kendaraan sudah terdaftar");
                } else {
                    if (tipe.equals("CAR")) {
                        v.put(kode, new Car(kode, nama, harga));
                    } else if ( tipe.equals("BIKE")) {
                        v.put(kode, new Bike(kode, nama, harga));
                    }
                    System.out.println(tipe + " " + kode + " berhasil ditambahkan");
                }
            } else if (command.equals("RENT")) {
                String kode = input[1];
                int hari = Integer.parseInt(input[2]);
                boolean promo = input.length == 4;

                if (!v.containsKey(kode)) {
                    System.out.println("Kendaraan tidak ditemukan");
                } else {
                    Vehicle vhc = v.get(kode);
                    if (!vhc.isStatus()) {
                        System.out.println("Kendaraan sedang disewa");
                    } else {
                        int total = vhc.hargaSewa(hari, promo);
                        vhc.isStatus = false;
                        System.out.println("Total sewa " + vhc.getKode() + ": " + total);
                    }
                }
            } else if (command.equals("RETURN")) {
                String kode = input[1];

                if (!v.containsKey(kode)) {
                    System.out.println("Kendaraan tidak ditemukan");
                } else {
                    Vehicle vhc = v.get(kode);
                    if (vhc.isStatus) {
                        System.out.println("Kendaraan belum disewa");
                    } else {
                        vhc.isStatus = true;
                        System.out.println(kode + " berhasil dikembalikan");
                    }
                }
            } else if (command.equals("DETAIL")) {
                String kode = input[1];

                if (!v.containsKey(kode)) {
                    System.out.println("Kendaraan tidak ditemukan");
                } else {
                    Vehicle vhc = v.get(kode);
                    String status = vhc.isStatus ? "TERSEDIA" : "DISEWA";
                    System.out.println(kode + " | " + vhc.getTipe() + " | " + vhc.getNama() + " | harga: "  + vhc.getHarga() + " | status: " + status);
                }
            } else if (command.equals("COUNT")) {
                System.out.println("Total kendaraan: " + v.size());
            }
        }
    }
}
