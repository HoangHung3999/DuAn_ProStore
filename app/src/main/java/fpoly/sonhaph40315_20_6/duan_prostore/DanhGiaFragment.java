package fpoly.sonhaph40315_20_6.duan_prostore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.Adapter.DanhGiaAdapter;
import fpoly.sonhaph40315_20_6.duan_prostore.Model.DanhGia;

public class DanhGiaFragment extends Fragment {

    private RecyclerView rcvDanhGia;
    private DanhGiaAdapter adapter;
    private TextView tvTieuDe;
    private List<DanhGia> danhGiaList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danh_gia, container, false);

        rcvDanhGia = view.findViewById(R.id.rcvDanhGia);
        tvTieuDe = view.findViewById(R.id.tvTieuDe);

        danhGiaList = new ArrayList<>();
        fakeData();

        adapter = new DanhGiaAdapter(getContext(), danhGiaList);
        adapter.setData(danhGiaList);

        rcvDanhGia.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvDanhGia.setAdapter(adapter);

        tvTieuDe.setOnClickListener(v -> showFilterMenu(v));

        return view;
    }

    private void showFilterMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(getContext(), anchorView);
        popupMenu.getMenu().add("Tất cả");
        popupMenu.getMenu().add("5 sao");
        popupMenu.getMenu().add("4 sao");
        popupMenu.getMenu().add("3 sao");
        popupMenu.getMenu().add("2 sao");
        popupMenu.getMenu().add("1 sao");

        popupMenu.setOnMenuItemClickListener(item -> {
            String title = item.getTitle().toString();
            tvTieuDe.setText("\ud83d\udcca Lọc theo sao: [" + title + " \u25bc]");

            if (title.equals("Tất cả")) {
                adapter.filterByStars(0);
            } else {
                int sao = Integer.parseInt(title.substring(0, 1));
                adapter.filterByStars(sao);
            }
            return true;
        });

        popupMenu.show();
    }

    private void fakeData() {
        danhGiaList.add(new DanhGia(1, "Nguyễn Văn A", "Áo thun", 5, "Rất đẹp, giao nhanh", "12:10 31/07/2025"));
        danhGiaList.add(new DanhGia(2, "Nguyễn Văn B", "Áo khoác", 4, "Đáng tiền", "13:00 30/07/2025"));
        danhGiaList.add(new DanhGia(3, "Nguyễn Văn C", "Quần jean", 3, "Tạm ổn", "14:15 29/07/2025"));
        danhGiaList.add(new DanhGia(4, "Nguyễn Văn D", "Áo sơ mi", 5, "Tuyệt vời", "15:30 28/07/2025"));
    }
}
