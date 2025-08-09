package fpoly.sonhaph40315_20_6.duan_prostore;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

import fpoly.sonhaph40315_20_6.duan_prostore.model.SanPham;

public class ProductDetailActivity extends AppCompatActivity {

    private SanPham product;
    private String selectedSize = "M";

    // Mô tả mẫu (vì model chưa có trường description)
    private final String defaultDescription = "Marvel Avengers Kids T-Shirt - Áo thun trẻ em chất liệu cotton mềm mại, co giãn tốt.\n\n" +
            "✔ Chất liệu: 100% Cotton\n" +
            "✔ Size: M - L - XL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Ánh xạ view
        ImageView imgProduct = findViewById(R.id.imgProductDetail);
        TextView tvName = findViewById(R.id.tvProductName);
        TextView tvPrice = findViewById(R.id.tvProductPrice);
        TextView tvDescription = findViewById(R.id.tvProductDesc);
        TextView tvDelivery = findViewById(R.id.tvDelivery);
        Button btnAddToCart = findViewById(R.id.btnAddToCart);
        ImageButton btnBack = findViewById(R.id.btnBack);

        // Nút size
        Button btnSizeM = findViewById(R.id.btnSizeM);
        Button btnSizeL = findViewById(R.id.btnSizeL);
        Button btnSizeXL = findViewById(R.id.btnSizeXL);

        // Nhận dữ liệu sản phẩm từ Intent
        product = (SanPham) getIntent().getSerializableExtra("product");
        if (product == null) {
            showErrorAndExit();
            return;
        }

        // Hiển thị thông tin sản phẩm
        displayProductInfo(imgProduct, tvName, tvPrice, tvDescription, tvDelivery);

        // Xử lý chọn size
        setupSizeButtons(btnSizeM, btnSizeL, btnSizeXL);

        // Thêm vào giỏ hàng
        btnAddToCart.setOnClickListener(v -> addToCart());

        // Quay lại
        btnBack.setOnClickListener(v -> finish());
    }

    private void showErrorAndExit() {
        Toast.makeText(this, "Sản phẩm không tồn tại", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void displayProductInfo(ImageView imgView, TextView nameView,
                                    TextView priceView, TextView descView,
                                    TextView deliveryView) {
        // Load ảnh: nếu imagePath là ID resource thì parse, nếu là URL thì dùng Glide
        try {
            int imageResId = Integer.parseInt(product.getImagePath());
            imgView.setImageResource(imageResId);
        } catch (NumberFormatException e) {
            Glide.with(imgView.getContext())
                    .load(product.getImagePath())
                    .into(imgView);
        }

        nameView.setText(product.getName());
        priceView.setText(String.format("%,.0f VND", product.getPrice()));

        // Nếu không có category/size thì dùng mô tả mặc định
        String desc = (product.getCategory() != null ? "Loại: " + product.getCategory() : "") +
                (product.getSize() != null ? " - Size: " + product.getSize() : "");
        if (desc.trim().isEmpty()) {
            desc = defaultDescription;
        }
        descView.setText(desc);

        deliveryView.setText("Giao hàng từ 1-3 ngày");
    }

    private void setupSizeButtons(Button... sizeButtons) {
        for (Button btn : sizeButtons) {
            btn.setOnClickListener(v -> {
                selectedSize = btn.getText().toString();
                updateSizeSelection(btn, sizeButtons);
            });
        }
        // Mặc định chọn size M
        sizeButtons[0].setBackgroundTintList(
                ContextCompat.getColorStateList(this, R.color.colorPrimary));
    }

    private void updateSizeSelection(Button selectedBtn, Button... allBtns) {
        for (Button btn : allBtns) {
            int colorRes = (btn == selectedBtn) ? R.color.colorPrimary : R.color.gray;
            btn.setBackgroundTintList(ContextCompat.getColorStateList(this, colorRes));
        }
    }

    private void addToCart() {
        product.setSize(selectedSize);
        CartManager.getInstance().addToCart(product);
        showSuccessMessage();
    }

    private void showSuccessMessage() {
        Toast.makeText(this,
                "Đã thêm " + product.getName() + " (Size " + selectedSize + ") vào giỏ hàng",
                Toast.LENGTH_SHORT).show();
    }
}
