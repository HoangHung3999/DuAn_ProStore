package fpoly.sonhaph40315_20_6.duan_prostore;

import java.io.Serializable;

public class Product implements Serializable {
    private int imageResId;
    private String name;
    private String price;
    private int quantity;
    private String size;
    private String category;

    public Product(int imageResId, String name, String price, String category) {
        this.imageResId = imageResId;
        this.name = name;
        this.price = price;
        this.quantity = 1;
        this.size = "M";
        this.category = category;
    }

    // Getter và Setter
    public int getImageResId() { return imageResId; }
    public String getName() { return name; }
    public String getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPriceAsDouble() {
        try {
            String number = price.replaceAll("[^\\d]", "");
            return Double.parseDouble(number);
        } catch (Exception e) {
            return 0;
        }
    }
}
