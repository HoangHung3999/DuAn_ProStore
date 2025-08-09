package fpoly.sonhaph40315_20_6.duan_prostore;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rcvProducts;
    private EditText etSearch;
    private ProductAdapter adapter;
    private List<Product> originalProductList;
    private String currentCategory = "All";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rcvProducts = findViewById(R.id.rcvProducts);
        etSearch = findViewById(R.id.etSearch);

        setupProductList();
        setupSearch();
        setupCategoryTabs();
        setupCartButton();
        setupProfileButton(); // Thêm dòng này
    }

    private void setupProductList() {
        originalProductList = new ArrayList<>();
        originalProductList.add(new Product(R.drawable.ic_kids1, "Áo trẻ em", "119,000 VND", "Kids"));
        originalProductList.add(new Product(R.drawable.ic_kids2, "Áo thể thao nam", "139,000 VND", "Men"));
        originalProductList.add(new Product(R.drawable.ic_kids3, "Quần đùi nam", "99,000 VND", "Men"));
        originalProductList.add(new Product(R.drawable.ic_kids4, "Áo trễ vai nữ", "159,000 VND", "Women"));

        adapter = new ProductAdapter(this, originalProductList);
        rcvProducts.setLayoutManager(new GridLayoutManager(this, 2));
        rcvProducts.setAdapter(adapter);
    }

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString(), currentCategory);
            }
        });
    }

    private void setupCategoryTabs() {
        TextView tvAll = findViewById(R.id.tvAll);
        TextView tvMen = findViewById(R.id.tvNam);
        TextView tvWomen = findViewById(R.id.tvNu);
        TextView tvKids = findViewById(R.id.tvTreEm);

        tvAll.setOnClickListener(v -> {
            currentCategory = "All";
            filter(etSearch.getText().toString(), currentCategory);
            updateTabSelection(tvAll, tvMen, tvWomen, tvKids);
        });

        tvMen.setOnClickListener(v -> {
            currentCategory = "Men";
            filter(etSearch.getText().toString(), currentCategory);
            updateTabSelection(tvMen, tvAll, tvWomen, tvKids);
        });

        tvWomen.setOnClickListener(v -> {
            currentCategory = "Women";
            filter(etSearch.getText().toString(), currentCategory);
            updateTabSelection(tvWomen, tvAll, tvMen, tvKids);
        });

        tvKids.setOnClickListener(v -> {
            currentCategory = "Kids";
            filter(etSearch.getText().toString(), currentCategory);
            updateTabSelection(tvKids, tvAll, tvMen, tvWomen);
        });

        tvAll.setTextColor(getResources().getColor(R.color.tab_selected));
    }

    private void updateTabSelection(TextView selectedTab, TextView... otherTabs) {
      selectedTab.setTextColor(getResources().getColor(R.color.tab_selected));
        for (TextView tab : otherTabs) {
           tab.setTextColor(getResources().getColor(R.color.tab_unselected));
        }
    }

    private void filter(String query, String category) {
        List<Product> filteredList = new ArrayList<>();

        for (Product product : originalProductList) {
            boolean matchesCategory = category.equals("All") || product.getCategory().equals(category);
            boolean matchesQuery = product.getName().toLowerCase().contains(query.toLowerCase());

            if (matchesCategory && matchesQuery) {
                filteredList.add(product);
            }
        }

        adapter.filterList(filteredList);
    }

    private void setupCartButton() {
        ImageButton btnCart = findViewById(R.id.btnCart);
        btnCart.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, CartActivity.class));
        });
    }

    // ✅ Mới thêm: Nút chuyển đến trang cá nhân
    private void setupProfileButton() {
        ImageView ivUser = findViewById(R.id.ivUser);
        ivUser.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}
