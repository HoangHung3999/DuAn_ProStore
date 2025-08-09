
package fpoly.sonhaph40315_20_6.duan_prostore.model;

public class DonHang_Model {
    private int id;
    private int imageresid;
    private String name;
    private String price;
    private String size;
    private int quantity;
    private String status;

    public DonHang_Model(int id, int imageresid, String name, String price, String size, int quantity, String status) {
        this.id = id;
        this.imageresid = imageresid;
        this.name = name;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageresid() {
        return imageresid;
    }

    public void setImageresid(int imageresid) {
        this.imageresid = imageresid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DonHang_Model{" +
                "id=" + id +
                ", imageresid=" + imageresid +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                '}';
    }
}
