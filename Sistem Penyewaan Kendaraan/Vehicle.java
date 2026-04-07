public class Vehicle {
    private String kode;
    private String nama;
    private int harga;
    private boolean status;
    public boolean isStatus;

    public Vehicle() {
    }

    public Vehicle(String kode, String nama, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.status = true;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public boolean isStatus() {
        return status;
    }

    public int hargaSewa(int hari, boolean promo) {
        int total = harga * hari;
        return total;
    }

    public String getTipe() {
        return "Vehicle";
    }
}