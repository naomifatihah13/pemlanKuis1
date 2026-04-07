public class Car extends Vehicle {
    public Car(String kode, String nama, int harga) {
        super(kode, nama, harga);
    }

    @Override
    public int hargaSewa(int hari, boolean promo) {
        int total = getHarga() * hari;
        if (promo) {
            total -= 20000;
        }
        return Math.max(0, total);
    }

    @Override
    public String getTipe() {
        return "CAR";
    }
}
