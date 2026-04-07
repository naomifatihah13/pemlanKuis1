public class Bike extends Vehicle {
    public Bike(String kode, String nama, int harga) {
        super(kode, nama, harga);
    }

    @Override
    public int hargaSewa(int hari, boolean promo) {
        int total = getHarga() * hari;
        if (promo) {
            total -= 10000;
        }
        return Math.max(0, total);
    }

    @Override
    public String getTipe() {
        return "BIKE";
    }
}
