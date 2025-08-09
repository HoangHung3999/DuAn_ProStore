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
import fpoly.sonhaph40315_20_6.duan_prostore.adapter.Delivered_Adapter;
import fpoly.sonhaph40315_20_6.duan_prostore.adapter.WaitingForConfirmation_Adapter;
import fpoly.sonhaph40315_20_6.duan_prostore.model.StatusOrder_Model;


public class Delivered_Fragment extends Fragment {


// đã giao đơn hàng

    private RecyclerView recyclerView_dagiao;

    private Delivered_Adapter daGiaoDonHangAdapter;
    private ArrayList<StatusOrder_Model> trangThaiModelArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivered, container, false);
        recyclerView_dagiao = view.findViewById(R.id.recyclerView_dagiao);
        trangThaiModelArrayList = new ArrayList<>();
        trangThaiModelArrayList.add(new StatusOrder_Model( R.drawable.product_useravata_icon,  "Áo trẻ em", 100, "Đã giao"));
        trangThaiModelArrayList.add(new StatusOrder_Model( R.drawable.product_useravata_icon,  "Áo trẻ em", 100, "Đã giao"));
        trangThaiModelArrayList.add(new StatusOrder_Model( R.drawable.product_useravata_icon,  "Áo trẻ em", 100, "Đã giao"));

        daGiaoDonHangAdapter = new Delivered_Adapter(getContext(),trangThaiModelArrayList);
        recyclerView_dagiao.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView_dagiao.setAdapter(daGiaoDonHangAdapter);
        return view;
    }
}