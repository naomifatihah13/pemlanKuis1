public class Beasiswa extends Student {
    
    public Beasiswa(String nama) {
        super(nama);
    }

    @Override
    public boolean ambil(int jumlah) {
        int bayar = jumlah - 1000;
        if (bayar < 0) {
            bayar = 0;
        }

        if (getSaldo() < bayar) return false;
        kurang(bayar);
        return true;
    }

    @Override
    public String getTipe() {
        return "Beasiswa";
    }
}
