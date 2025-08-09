package fpoly.sonhaph40315_20_6.duan_prostore;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.adapter.SanPhamAdapter;
import fpoly.sonhaph40315_20_6.duan_prostore.dao.SanPhamDao;
import fpoly.sonhaph40315_20_6.duan_prostore.model.SanPham;

public class SanPhamFragment extends Fragment {

    private RecyclerView recyclerView;
    private SanPhamAdapter adapter;
    private SanPhamDao dao;
    private List<SanPham> sanPhamList;

    public SanPhamFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_san_pham, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerSanPham);
        dao = new SanPhamDao(requireContext());

        // Chèn dữ liệu mẫu nếu danh sách trống
        if (dao.getAllProducts().isEmpty()) {
            insertFakeData(dao);
        }

        sanPhamList = dao.getAllProducts();

        adapter = new SanPhamAdapter(requireContext(), sanPhamList, false, new SanPhamAdapter.OnProductActionListener() {
            @Override
            public void onEdit(SanPham product) {
                DialogSuaSanPham dialog = DialogSuaSanPham.newInstance(product);
                dialog.setOnProductUpdatedListener(() -> loadProductList());
                dialog.show(getChildFragmentManager(), "EditDialog");
            }

            @Override
            public void onDelete(SanPham product) {
                new AlertDialog.Builder(requireContext())
                        .setTitle("Xoá sản phẩm")
                        .setMessage("Bạn có chắc chắn muốn xoá sản phẩm này?")
                        .setPositiveButton("Xoá", (dialog, which) -> {
                            dao.deleteProduct(product.getId());
                            loadProductList();
                        })
                        .setNegativeButton("Huỷ", null)
                        .show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapter);

        // Xử lý nút Add
        FloatingActionButton fabAdd = view.findViewById(R.id.fabAddProduct);
        fabAdd.setOnClickListener(v -> {
            DialogThemSanPham dialog = new DialogThemSanPham();
            dialog.setOnProductAddedListener(() -> loadProductList());
            dialog.show(getChildFragmentManager(), "AddProductDialog");
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        loadProductList();
    }

    private void loadProductList() {
        if (dao != null && sanPhamList != null && adapter != null) {
            sanPhamList.clear();
            sanPhamList.addAll(dao.getAllProducts());
            adapter.notifyDataSetChanged();
        }
    }

    private void insertFakeData(SanPhamDao dao) {
        dao.insertProduct(new SanPham(0, "Áo trẻ em", 150000, 10, "L", "Áo", "R.drawable.ic_kids1", "25/07/2025"));
        dao.insertProduct(new SanPham(0, "Áo thể thao nam", 230000, 8, "M", "Áo","R.drawable.ic_kids2", "24/07/2025"));
        dao.insertProduct(new SanPham(0, "Quần đùi nam", 320000, 5, "32", "Quần", "R.drawable.ic_kids3", "23/07/2025"));
    }
}
