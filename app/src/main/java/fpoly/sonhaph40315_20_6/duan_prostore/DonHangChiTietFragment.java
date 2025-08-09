package fpoly.sonhaph40315_20_6.duan_prostore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.adapter.DonHangChiTietAdapter;
import fpoly.sonhaph40315_20_6.duan_prostore.dao.DonHangChiTietDao;
import fpoly.sonhaph40315_20_6.duan_prostore.model.DonHangChiTiet;

public class DonHangChiTietFragment extends Fragment {

    private RecyclerView rcvDonHangChiTiet;
    private DonHangChiTietAdapter adapter;
    private List<DonHangChiTiet> list;
    private int orderId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_don_hang_chi_tiet, container, false);

        rcvDonHangChiTiet = view.findViewById(R.id.rcvDonHangChiTiet);
        list = new ArrayList<>();
        adapter = new DonHangChiTietAdapter(getContext(), list);
        rcvDonHangChiTiet.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvDonHangChiTiet.setAdapter(adapter);

        if (getArguments() != null) {
            orderId = getArguments().getInt("orderId", -1);
            loadData(orderId);
        }

        return view;
    }

    private void loadData(int orderId) {
        DonHangChiTietDao dao = new DonHangChiTietDao(getContext());
        list.clear();
        list.addAll(dao.getByOrderId(orderId));
        adapter.notifyDataSetChanged();
    }
}
