package fpoly.sonhaph40315_20_6.duan_prostore;

import java.util.ArrayList;
import java.util.List;

public class CartManager {

    private static CartManager instance;
    private final List<Product> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addToCart(Product product) {
        for (Product item : cartItems) {
            if (item.getName().equals(product.getName()) && item.getSize().equals(product.getSize())) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
        // Nếu chưa có sản phẩm giống (name + size), thêm mới vào giỏ
        product.setQuantity(1);
        cartItems.add(product);
    }

    public void removeFromCart(Product product) {
        for (Product item : cartItems) {
            if (item.getName().equals(product.getName()) && item.getSize().equals(product.getSize())) {
                if (item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                } else {
                    cartItems.remove(item);
                }
                return;
            }
        }
    }

    public void clearCart() {
        cartItems.clear();
    }

    public List<Product> getCartItems() {
        return new ArrayList<>(cartItems);
    }

    public double getTotalAmount() {
        double total = 0;
        for (Product item : cartItems) {
            total += Double.parseDouble(item.getPrice()) * item.getQuantity();

        }
        return total;
    }
}
