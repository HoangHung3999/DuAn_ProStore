package fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.CartActivity;
import fpoly.sonhaph40315_20_6.duan_prostore.HomeActivity;
import fpoly.sonhaph40315_20_6.duan_prostore.Product;
import fpoly.sonhaph40315_20_6.duan_prostore.ProductAdapter;
import fpoly.sonhaph40315_20_6.duan_prostore.ProfileActivity;
import fpoly.sonhaph40315_20_6.duan_prostore.R;


public class HomeFragment extends Fragment {

    private RecyclerView rcvProducts;
    private EditText etSearch;
    private ProductAdapter adapter;
    private List<Product> originalProductList;
    private String currentCategory = "All";
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);


        rcvProducts = view.findViewById(R.id.rcvProducts);
        etSearch = view.findViewById(R.id.etSearch);

        setupProductList();
        setupSearch();
        setupCategoryTabs();
//        setupCartButton();
        setupProfileButton(); // Thêm dòng này

        return view;
    }

    private void setupProductList() {
        originalProductList = new ArrayList<>();
        originalProductList.add(new Product(R.drawable.ic_kids1, "Áo trẻ em", "119,000 VND", "Kids"));
        originalProductList.add(new Product(R.drawable.ic_kids2, "Áo thể thao nam", "139,000 VND", "Men"));
        originalProductList.add(new Product(R.drawable.ic_kids3, "Quần đùi nam", "99,000 VND", "Men"));
        originalProductList.add(new Product(R.drawable.ic_kids4, "Áo trễ vai nữ", "159,000 VND", "Women"));

        adapter = new ProductAdapter(getContext(), originalProductList);
        rcvProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rcvProducts.setAdapter(adapter);
    }

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString(), currentCategory);
            }
        });
    }

    private void setupCategoryTabs() {
        TextView tvAll = view.findViewById(R.id.tvAll);
        TextView tvMen = view.findViewById(R.id.tvNam);
        TextView tvWomen = view.findViewById(R.id.tvNu);
        TextView tvKids = view.findViewById(R.id.tvTreEm);

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

//    private void setupCartButton() {
//        ImageButton btnCart = view.findViewById(R.id.btnCart);
//        btnCart.setOnClickListener(v -> {
//            startActivity(new Intent(getContext(), CartActivity.class));
//        });
//    }

    // ✅ Mới thêm: Nút chuyển đến trang cá nhân
    private void setupProfileButton() {
        ImageView ivUser = view.findViewById(R.id.ivUser);
        ivUser.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ProfileActivity.class);
            startActivity(intent);
        });
    }
}