public class Reguler extends Student {
    
    public Reguler(String nama) {
        super(nama);
    }

    @Override
    public String getTipe() {
        return "Reguler";
    }
}
