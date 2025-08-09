package fpoly.sonhaph40315_20_6.duan_prostore.model;

public class BankCardCount_Model {
    private float gia;

    public BankCardCount_Model(float gia) {
        this.gia = gia;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "BankCardCount_Model{" +
                "gia=" + gia +
                '}';
    }
}
