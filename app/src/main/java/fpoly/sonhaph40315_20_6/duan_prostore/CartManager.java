package fpoly.sonhaph40315_20_6.duan_prostore;

import java.util.ArrayList;
import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.model.SanPham;

public class CartManager {

    private static CartManager instance;
    private final List<SanPham> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addToCart(SanPham product) {
        for (SanPham item : cartItems) {
            if (item.getName().equals(product.getName()) &&
                    item.getSize().equals(product.getSize())) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
        // Nếu chưa có sản phẩm giống (name + size), thêm mới vào giỏ
        product.setQuantity(1);
        cartItems.add(product);
    }

    public void removeFromCart(SanPham product) {
        for (SanPham item : cartItems) {
            if (item.getName().equals(product.getName()) &&
                    item.getSize().equals(product.getSize())) {
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

    public List<SanPham> getCartItems() {
        return new ArrayList<>(cartItems); // Tránh sửa trực tiếp danh sách gốc
    }

    public double getTotalAmount() {
        double total = 0;
        for (SanPham item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}
