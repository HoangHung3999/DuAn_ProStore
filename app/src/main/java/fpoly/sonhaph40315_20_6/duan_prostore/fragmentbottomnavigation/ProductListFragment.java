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
import fpoly.sonhaph40315_20_6.duan_prostore.adapter.ProductList_Adapter;
import fpoly.sonhaph40315_20_6.duan_prostore.model.ProductList_Model;


public class ProductListFragment extends Fragment {

    private RecyclerView recyclerView_productList;
    private ProductList_Adapter productListAdapter;
    private ArrayList<ProductList_Model> arrayList_ProductList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_product_list, container, false);
        recyclerView_productList = view.findViewById(R.id.recyclerView_productList);
        arrayList_ProductList = new ArrayList<>();
        arrayList_ProductList.add(new ProductList_Model(1,R.drawable.product_useravata_icon,"Áo trẻ em",100,100));
        arrayList_ProductList.add(new ProductList_Model(1,R.drawable.product_useravata_icon,"Áo trẻ em",100,100));
        arrayList_ProductList.add(new ProductList_Model(1,R.drawable.product_useravata_icon,"Áo trẻ em",100,100));
        arrayList_ProductList.add(new ProductList_Model(1,R.drawable.product_useravata_icon,"Áo trẻ em",100,100));
        arrayList_ProductList.add(new ProductList_Model(1,R.drawable.product_useravata_icon,"Áo trẻ em",100,100));

        productListAdapter = new ProductList_Adapter(getContext(),arrayList_ProductList);
        recyclerView_productList.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView_productList.setAdapter(productListAdapter);
        return view;
    }
}