public class Student {
    private String nama;
    private int saldo;

    public Student() {
    }

    public Student(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public Student(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void simpan(int jumlah) {
        saldo += jumlah;
    }

    protected void kurang(int jumlah) {
        saldo -= jumlah;
    }

    public boolean ambil(int jumlah) {
        if (jumlah > saldo) return false;
        saldo -= jumlah;
        return true;
    }

    public String getTipe() {
        return "Student";
    }
}