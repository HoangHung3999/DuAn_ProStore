package fpoly.sonhaph40315_20_6.duan_prostore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.adapter.DonHangAdapter;
import fpoly.sonhaph40315_20_6.duan_prostore.dao.DonHang_Dao;
import fpoly.sonhaph40315_20_6.duan_prostore.model.DonHang_Model;

public class DonHangFragment extends Fragment {

    private RecyclerView rcvDonHang;
    private DonHangAdapter adapter;
    private List<DonHang_Model> donHangList;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView icMenu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_don_hang, container, false);

        // Ánh xạ view
        rcvDonHang = view.findViewById(R.id.rcvDonHang);
        icMenu = view.findViewById(R.id.icMenu);
        drawerLayout = requireActivity().findViewById(R.id.drawer_layout);
        navigationView = requireActivity().findViewById(R.id.nav_view);

        // Bắt sự kiện mở menu
        icMenu.setOnClickListener(v -> {
            if (drawerLayout != null) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // Tạo dữ liệu mẫu (có thể thay bằng dữ liệu từ DAO)
        donHangList = new ArrayList<>();
        donHangList.add(new DonHang_Model(1, R.drawable.ic_kids1, "Áo sơ mi", "250.000đ", "M", 2, "Đang giao"));
        donHangList.add(new DonHang_Model(2, R.drawable.ic_kids2, "Quần jean", "400.000đ", "L", 1, "Hoàn thành"));
        donHangList.add(new DonHang_Model(3, R.drawable.ic_kids4, "Giày thể thao", "750.000đ", "42", 1, "Đang xử lý"));

        // Setup RecyclerView
        adapter = new DonHangAdapter(getContext(), donHangList);
        rcvDonHang.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvDonHang.setAdapter(adapter);

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        DonHang_Dao dao = new DonHang_Dao(getContext());
        donHangList.clear();
        donHangList.addAll(dao.getDonHangChoXacNhan());
        adapter.notifyDataSetChanged();
    }

}
