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

import java.util.ArrayList;
import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.CartActivity;
import fpoly.sonhaph40315_20_6.duan_prostore.CartAdapter;
import fpoly.sonhaph40315_20_6.duan_prostore.CartManager;
import fpoly.sonhaph40315_20_6.duan_prostore.MainActivity;
import fpoly.sonhaph40315_20_6.duan_prostore.PaymentActivity;
import fpoly.sonhaph40315_20_6.duan_prostore.Product;
import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.adapter.ShoppingCart_Adapter;
import fpoly.sonhaph40315_20_6.duan_prostore.model.ShoppingCart_Model;


public class ShoppingCartFragment extends Fragment implements CartAdapter.OnCartChangedListener {

//    RecyclerView recyclerView_shoppingCart;
//    TextView txt_shoppingCart_tonggiatien;
//    Button btn_shoppingCart_thanhtoan;
//    ArrayList<ShoppingCart_Model> arrayList_ShoppingCart;
//    ShoppingCart_Adapter shoppingCartAdapter;

    ///  định code
    private RecyclerView rcvCart;
    private TextView tvTotal;
    private Button btnCheckout;
    private ImageButton btnBack;
    private CartAdapter adapter;
    private double total; // Declare total at class level.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
//        recyclerView_shoppingCart = view.findViewById(R.id.recyclerView_shoppingCart);
//        txt_shoppingCart_tonggiatien = view.findViewById(R.id.txt_shoppingCart_tonggiatien);
//        btn_shoppingCart_thanhtoan = view.findViewById(R.id.btn_shoppingCart_thanhtoan);
//
//        arrayList_ShoppingCart = new ArrayList<>();
//        arrayList_ShoppingCart.add(new ShoppingCart_Model( R.drawable.product_useravata_icon, 1, "Áo trẻ em", 100));
//        arrayList_ShoppingCart.add(new ShoppingCart_Model(R.drawable.product_useravata_icon, 1, "Áo trẻ em", 100));
//        arrayList_ShoppingCart.add(new ShoppingCart_Model(R.drawable.product_useravata_icon, 1, "Áo trẻ em", 100));
//        arrayList_ShoppingCart.add(new ShoppingCart_Model(R.drawable.product_useravata_icon, 1, "Áo trẻ em", 100));
//        arrayList_ShoppingCart.add(new ShoppingCart_Model(R.drawable.product_useravata_icon, 1, "Áo trẻ em", 100));
//
//
//        shoppingCartAdapter = new ShoppingCart_Adapter(getContext(),arrayList_ShoppingCart);
//        recyclerView_shoppingCart.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView_shoppingCart.setAdapter(shoppingCartAdapter);

        rcvCart = view.findViewById(R.id.rcvCart);
        tvTotal = view.findViewById(R.id.tvTotalPrice);
        btnCheckout = view.findViewById(R.id.btnCheckout);
        btnBack = view.findViewById(R.id.btnBack);

        setupRecyclerView();
        updateTotal();

        btnCheckout.setOnClickListener(v -> {
            if (total > 0) { // Check if total amount is greater than zero before proceeding.
                Intent intent = new Intent(getContext(), PaymentActivity.class);
                intent.putExtra("TOTAL_AMOUNT", total);  // Pass the total amount to PaymentActivity
                startActivity(intent);
            } else {
                Toast.makeText(getContext(), "Giỏ hàng trống!", Toast.LENGTH_SHORT).show(); // Show message if cart is empty.
            }
        });

        btnBack.setOnClickListener(v -> {
                    // requireActivity().onBackPressed();
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }
        );

        return view;
    }

    private void setupRecyclerView() {
        List<Product> cartItems = CartManager.getInstance().getCartItems();
        adapter = new CartAdapter(getContext(), cartItems, this);
        rcvCart.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvCart.setAdapter(adapter);
    }

    private void updateTotal() {
        total = 0;
        for (Product item : CartManager.getInstance().getCartItems()) {
            total += item.getPriceAsDouble() * item.getQuantity();
        }
        tvTotal.setText(String.format("%,.0f VND", total));
    }

    @Override
    public void onCartUpdated() {
        updateTotal();

        // If cart is empty, return to previous screen
        if (CartManager.getInstance().getCartItems().isEmpty()) {

        }
    }
}