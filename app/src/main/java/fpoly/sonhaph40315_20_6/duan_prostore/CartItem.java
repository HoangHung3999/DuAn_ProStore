package fpoly.sonhaph40315_20_6.duan_prostore;

public class CartItem {
    private int imageResId;
    private String name;
    private String price;

    public CartItem(int imageResId, String name, String price) {
        this.imageResId = imageResId;
        this.name = name;
        this.price = price;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
