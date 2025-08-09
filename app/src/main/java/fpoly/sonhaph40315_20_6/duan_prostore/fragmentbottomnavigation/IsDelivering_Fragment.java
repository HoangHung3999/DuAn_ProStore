package fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.adapter.IsDelivering_Adapter;
import fpoly.sonhaph40315_20_6.duan_prostore.model.StatusOrder_Model;

public class IsDelivering_Fragment extends Fragment {

//ang giao đơn hàng


    private RecyclerView recyclerView_danggiao;
    private IsDelivering_Adapter dangGiaoDonHangAdapter;
    private ArrayList<StatusOrder_Model> trangThaiModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inde_divery_, container, false);
        recyclerView_danggiao = view.findViewById(R.id.recyclerView_danggiao);
        trangThaiModelArrayList = new ArrayList<>();
        trangThaiModelArrayList.add(new StatusOrder_Model( R.drawable.product_useravata_icon,  "Áo trẻ em", 100, "Đang giao"));
        trangThaiModelArrayList.add(new StatusOrder_Model( R.drawable.product_useravata_icon,  "Áo trẻ em", 100, "Đang giao"));
        trangThaiModelArrayList.add(new StatusOrder_Model( R.drawable.product_useravata_icon,  "Áo trẻ em", 100, "Đang giao"));

        dangGiaoDonHangAdapter = new IsDelivering_Adapter(getContext(),trangThaiModelArrayList);
        recyclerView_danggiao.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView_danggiao.setAdapter(dangGiaoDonHangAdapter);

        return  view;
    }
}