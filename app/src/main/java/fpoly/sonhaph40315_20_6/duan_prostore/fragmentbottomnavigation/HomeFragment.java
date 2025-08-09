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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.ProfileActivity;
import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.adapter.SanPhamAdapter;
import fpoly.sonhaph40315_20_6.duan_prostore.model.SanPham;

public class HomeFragment extends Fragment {

    private RecyclerView rcvProducts;
    private EditText etSearch;
    private SanPhamAdapter adapter;
    private List<SanPham> originalProductList;
    private String currentCategory = "All";
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        rcvProducts = view.findViewById(R.id.rcvProducts);
        etSearch = view.findViewById(R.id.etSearch);

        setupProductList();
        setupSearch();
        setupCategoryTabs();
        setupProfileButton();

        return view;
    }

    private void setupProductList() {
        originalProductList = new ArrayList<>();
        // id, name, price, quantity, size, category, imagePath, date
        originalProductList.add(new SanPham(1, "Áo trẻ em", 119000, 1, "M", "Kids", String.valueOf(R.drawable.ic_kids1), "2025-08-09"));
        originalProductList.add(new SanPham(2, "Áo thể thao nam", 139000, 1, "L", "Men", String.valueOf(R.drawable.ic_kids2), "2025-08-09"));
        originalProductList.add(new SanPham(3, "Quần đùi nam", 99000, 1, "XL", "Men", String.valueOf(R.drawable.ic_kids3), "2025-08-09"));
        originalProductList.add(new SanPham(4, "Áo trễ vai nữ", 159000, 1, "S", "Women", String.valueOf(R.drawable.ic_kids4), "2025-08-09"));

        adapter = new SanPhamAdapter(getContext(), originalProductList, true,null);
        rcvProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
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
        List<SanPham> filteredList = new ArrayList<>();
        for (SanPham product : originalProductList) {
            boolean matchesCategory = category.equals("All") || product.getCategory().equalsIgnoreCase(category);
            boolean matchesQuery = product.getName().toLowerCase().contains(query.toLowerCase());

            if (matchesCategory && matchesQuery) {
                filteredList.add(product);
            }
        }
        adapter.filterList(filteredList);
    }

    private void setupProfileButton() {
        ImageView ivUser = view.findViewById(R.id.ivUser);
        ivUser.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ProfileActivity.class);
            startActivity(intent);
        });
    }
}
