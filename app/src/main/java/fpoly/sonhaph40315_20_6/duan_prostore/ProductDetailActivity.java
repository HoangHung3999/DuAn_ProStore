package fpoly.sonhaph40315_20_6.duan_prostore;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ProductDetailActivity extends AppCompatActivity {

    private Product product;
    private String selectedSize = "M";
    private String productDescription = "Marvel Avengers Kids T-Shirt - Áo thun trẻ em chất liệu cotton mềm mại, co giãn tốt.\n\n" +
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

        // Ánh xạ các nút size
        Button btnSizeM = findViewById(R.id.btnSizeM);
        Button btnSizeL = findViewById(R.id.btnSizeL);
        Button btnSizeXL = findViewById(R.id.btnSizeXL);

        // Nhận dữ liệu sản phẩm
        product = (Product) getIntent().getSerializableExtra("product");
        if (product == null) {
            showErrorAndExit();
            return;
        }

        // Hiển thị thông tin sản phẩm
        displayProductInfo(imgProduct, tvName, tvPrice, tvDescription, tvDelivery);

        // Xử lý chọn size
        setupSizeButtons(btnSizeM, btnSizeL, btnSizeXL);

        // Xử lý nút thêm vào giỏ hàng
        btnAddToCart.setOnClickListener(v -> addToCart());

        btnBack.setOnClickListener(v -> finish());
    }

    private void showErrorAndExit() {
        Toast.makeText(this, "Sản phẩm không tồn tại", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void displayProductInfo(ImageView imgView, TextView nameView,
                                    TextView priceView, TextView descView,
                                    TextView deliveryView) {
        imgView.setImageResource(product.getImageResId());
        nameView.setText(product.getName());
        priceView.setText(product.getPrice());
        descView.setText(productDescription);
        deliveryView.setText("Giao hàng từ 1-3 ngày");
    }

    private void setupSizeButtons(Button... sizeButtons) {
        for (Button btn : sizeButtons) {
            btn.setOnClickListener(v -> {
                selectedSize = btn.getText().toString();
                updateSizeSelection(btn, sizeButtons);
            });
        }
        // Chọn size M mặc định
        sizeButtons[0].setBackgroundTintList(
                ContextCompat.getColorStateList(this, R.color.colorPrimary));
    }

    private void updateSizeSelection(Button selectedBtn, Button... allBtns) {
        for (Button btn : allBtns) {
            int colorRes = btn == selectedBtn ? R.color.colorPrimary : R.color.gray;
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
