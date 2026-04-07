import java.util.HashMap;
import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();

        HashMap<String, Student> s = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String line = in.nextLine();
            String[] input = line.split(" ");
            String command = input[0];

            if (command.equals("CREATE")) {
                String tipe = input[1];
                String nama = input[2];

                if (s.containsKey(nama)) {
                    System.out.println("Akun sudah terdaftar");
                } else {
                    if (tipe.equals("REGULER")) {
                        s.put(nama, new Reguler(nama));
                    } else {
                        s.put(nama, new Beasiswa(nama));
                    }
                    System.out.println(tipe + " " + nama + " berhasil dibuat");
                }
            } else if (command.equals("SAVE")) {
                String nama = input[1];
                int jumlah = Integer.parseInt(input[2]);
                Student student = s.get(nama);
                if (student == null) {
                    System.out.println("Akun tidak ditemukan");
                } else {
                    student.simpan(jumlah);
                    System.out.println("Saldo " + nama + ": " + student.getSaldo());
                }
            } else if (command.equals("TAKE")) {
                String nama = input[1];
                int jumlah = Integer.parseInt(input[2]);
                Student student = s.get(nama);
                if (student == null) {
                    System.out.println("Akun tidak ditemukan");
                } else {
                    boolean sukses = student.ambil(jumlah);
                    if (!sukses) {
                        System.out.println("Saldo " + nama + " tidak cukup");
                    } else {
                        System.out.println("Saldo " + nama + ": " + student.getSaldo());
                    }
                }
            } else if (command.equals("CHECK")) {
                String nama = input[1];
                Student student = s.get(nama);
                if (student != null) {
                    System.out.println(student.getNama() + " | " + student.getTipe() + " | " + "saldo: " + student.getSaldo());
                }
            }
        }
    }
}