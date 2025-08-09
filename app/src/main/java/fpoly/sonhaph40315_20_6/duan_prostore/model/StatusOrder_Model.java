package fpoly.sonhaph40315_20_6.duan_prostore.model;

public class StatusOrder_Model {
    private int avata;
    private String name;
    private int gia;
    private String trangthai;

    public StatusOrder_Model(int avata, String name, int gia, String trangthai) {
        this.avata = avata;
        this.name = name;
        this.gia = gia;
        this.trangthai = trangthai;
    }

    public int getAvata() {
        return avata;
    }

    public void setAvata(int avata) {
        this.avata = avata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "StatusOrder_Model{" +
                "avata=" + avata +
                ", name='" + name + '\'' +
                ", gia=" + gia +
                ", trangthai='" + trangthai + '\'' +
                '}';
    }
}
