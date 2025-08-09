package fpoly.sonhaph40315_20_6.duan_prostore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.model.ProductList_Model;

public class ProductList_Adapter extends RecyclerView.Adapter<ProductList_Adapter.ViewHolder> {
    private final Context context;
    private final ArrayList<ProductList_Model> arrayList_ProductList;

    public ProductList_Adapter(Context context, ArrayList<ProductList_Model> arrayList_ProductList) {
        this.context = context;
        this.arrayList_ProductList = arrayList_ProductList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_productlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductList_Model item = arrayList_ProductList.get(position);
        holder.img_item_productlist_avata.setImageResource(item.getProductList_Image());
        holder.txt_item_productlist_txtaotreem.setText(item.getProductList_Name());
        holder.txt_item_productlist_giatien.setText(String.valueOf(item.getProductList_Price() + "K"));
        holder.txt_item_productlist_soluongdaban.setText(String.valueOf(item.getProductList_quantitySold()));
    }

    @Override
    public int getItemCount() {
        return arrayList_ProductList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_item_productlist_avata;
        TextView txt_item_productlist_txtaotreem;
        TextView txt_item_productlist_giatien;
        TextView txt_item_productlist_vnd;

        TextView txt_item_productlist_daban;
        TextView txt_item_productlist_soluongdaban;

        ImageView img_item_productlist_sao1;

        ImageView img_item_productlist_sao2;

        ImageView img_item_productlist_sao3;

        ImageView img_item_productlist_sao4;

        ImageView img_item_productlist_sao5;

        TextView txt_item_productlist_danhgia;
        TextView txt_item_productlist_soluongdanhgia;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_item_productlist_avata = itemView.findViewById(R.id.img_item_productlist_avata);
            txt_item_productlist_txtaotreem = itemView.findViewById(R.id.txt_item_productlist_txtaotreem);
            txt_item_productlist_giatien = itemView.findViewById(R.id.txt_item_productlist_giatien);
            txt_item_productlist_vnd = itemView.findViewById(R.id.txt_item_productlist_vnd);
            txt_item_productlist_daban = itemView.findViewById(R.id.txt_item_productlist_daban);
            txt_item_productlist_soluongdaban = itemView.findViewById(R.id.txt_item_productlist_soluongdaban);
            txt_item_productlist_danhgia = itemView.findViewById(R.id.txt_item_productlist_danhgia);
            txt_item_productlist_soluongdanhgia = itemView.findViewById(R.id.txt_item_productlist_soluongdanhgia);
            img_item_productlist_sao1 = itemView.findViewById(R.id.img_item_productlist_sao1);
            img_item_productlist_sao2 = itemView.findViewById(R.id.img_item_productlist_sao2);
            img_item_productlist_sao3 = itemView.findViewById(R.id.img_item_productlist_sao3);
            img_item_productlist_sao4 = itemView.findViewById(R.id.img_item_productlist_sao4);
            img_item_productlist_sao5 = itemView.findViewById(R.id.img_item_productlist_sao5);

        }
    }
}
