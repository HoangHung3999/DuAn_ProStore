package fpoly.sonhaph40315_20_6.duan_prostore.model;

public class DonHangChiTiet {
    private int id;
    private int orderId;
    private int productId;
    private int soLuong;
    private double giaTien;
    private String username;

    public DonHangChiTiet() {}

    public DonHangChiTiet(int id, int orderId, int productId, int soLuong, double giaTien, String username) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.username = username;
    }

    // getters và setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public double getGiaTien() { return giaTien; }
    public void setGiaTien(double giaTien) { this.giaTien = giaTien; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
