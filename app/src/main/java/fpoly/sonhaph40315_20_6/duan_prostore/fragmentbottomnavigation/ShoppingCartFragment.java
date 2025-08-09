package fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.CartAdapter;
import fpoly.sonhaph40315_20_6.duan_prostore.CartManager;
import fpoly.sonhaph40315_20_6.duan_prostore.MainActivity;
import fpoly.sonhaph40315_20_6.duan_prostore.PaymentActivity;
import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.model.SanPham;

public class ShoppingCartFragment extends Fragment implements CartAdapter.OnCartChangedListener {

    private RecyclerView rcvCart;
    private TextView tvTotal;
    private Button btnCheckout;
    private ImageButton btnBack;
    private CartAdapter adapter;
    private double total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

        rcvCart = view.findViewById(R.id.rcvCart);
        tvTotal = view.findViewById(R.id.tvTotalPrice);
        btnCheckout = view.findViewById(R.id.btnCheckout);
        btnBack = view.findViewById(R.id.btnBack);

        setupRecyclerView();
        updateTotal();

        btnCheckout.setOnClickListener(v -> {
            if (total > 0) {
                Intent intent = new Intent(getContext(), PaymentActivity.class);
                intent.putExtra("TOTAL_AMOUNT", total);
                startActivity(intent);
            } else {
                Toast.makeText(getContext(), "Giỏ hàng trống!", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
        });

        return view;
    }

    private void setupRecyclerView() {
        List<SanPham> cartItems = CartManager.getInstance().getCartItems();
        adapter = new CartAdapter(getContext(), cartItems, this);
        rcvCart.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvCart.setAdapter(adapter);
    }

    private void updateTotal() {
        total = 0;
        for (SanPham item : CartManager.getInstance().getCartItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        tvTotal.setText(String.format("%,.0f VND", total));
    }

    @Override
    public void onCartUpdated() {
        updateTotal();

        if (CartManager.getInstance().getCartItems().isEmpty()) {
            // Có thể thêm xử lý nếu cần, ví dụ: quay về trang chính
        }
    }
}
