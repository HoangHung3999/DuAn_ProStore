package fpoly.sonhaph40315_20_6.duan_prostore.model;

public class DanhGia {
    private int id;
    private String tenKhachHang;
    private String tenSanPham;
    private int soSao;
    private String noiDung;
    private String thoiGian;

    public DanhGia(int id, String tenKhachHang, String tenSanPham, int soSao, String noiDung, String thoiGian) {
        this.id = id;
        this.tenKhachHang = tenKhachHang;
        this.tenSanPham = tenSanPham;
        this.soSao = soSao;
        this.noiDung = noiDung;
        this.thoiGian = thoiGian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoSao() {
        return soSao;
    }

    public void setSoSao(int soSao) {
        this.soSao = soSao;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
}
