package fpoly.sonhaph40315_20_6.duan_prostore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation.HomeFragment;

public class CartActivity extends AppCompatActivity  {

    private RecyclerView rcvCart;
    private TextView tvTotal;
    private Button btnCheckout;
    private ImageButton btnBack;
    private CartAdapter adapter;
    private double total; // Declare total at class level.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
//
//        rcvCart = findViewById(R.id.rcvCart);
//        tvTotal = findViewById(R.id.tvTotalPrice);
//        btnCheckout = findViewById(R.id.btnCheckout);
//        btnBack = findViewById(R.id.btnBack);
//
//        setupRecyclerView();
//        updateTotal();
//
//        btnCheckout.setOnClickListener(v -> {
//            if (total > 0) { // Check if total amount is greater than zero before proceeding.
//                Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
//                intent.putExtra("TOTAL_AMOUNT", total);  // Pass the total amount to PaymentActivity
//                startActivity(intent);
//            } else {
//                Toast.makeText(CartActivity.this, "Giỏ hàng trống!", Toast.LENGTH_SHORT).show(); // Show message if cart is empty.
//            }
//        });
//
//        btnBack.setOnClickListener(item ->{
//            Intent intent = new Intent(CartActivity.this, MainActivity.class);
//            startActivity(intent);
//        } );
//    }
//
//    private void setupRecyclerView() {
//        List<Product> cartItems = CartManager.getInstance().getCartItems();
//        adapter = new CartAdapter(this, cartItems, this);
//        rcvCart.setLayoutManager(new LinearLayoutManager(this));
//        rcvCart.setAdapter(adapter);
//    }
//
//    private void updateTotal() {
//        total = 0;
//        for (Product item : CartManager.getInstance().getCartItems()) {
//            total += item.getPriceAsDouble() * item.getQuantity();
//        }
//        tvTotal.setText(String.format("%,.0f VND", total));
//    }
//
//    @Override
//    public void onCartUpdated() {
//        updateTotal();
//
//        // If cart is empty, return to previous screen
//        if (CartManager.getInstance().getCartItems().isEmpty()) {
//            finish();
//        }
   }
}
