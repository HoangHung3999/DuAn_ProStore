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
import fpoly.sonhaph40315_20_6.duan_prostore.model.ShoppingCart_Model;

public class ShoppingCart_Adapter extends RecyclerView.Adapter<ShoppingCart_Adapter.ViewHolder>{

    private final Context context;
    private final ArrayList<ShoppingCart_Model> arrayList_ShoppingCart;

    public ShoppingCart_Adapter(Context context, ArrayList<ShoppingCart_Model> arrayList_ShoppingCart) {
        this.context = context;
        this.arrayList_ShoppingCart = arrayList_ShoppingCart;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_shoppingcart,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShoppingCart_Model item = arrayList_ShoppingCart.get(position);
        holder.img_item_shoppingCart_avata.setImageResource(item.getShoppingCart_Image());
        holder.txt_item_shoppingCart_txtaotreem.setText(item.getShoppingCart_Name());
        holder.txt_item_shoppingCart_giatien.setText(String.valueOf(item.getShoppingCart_Price()+ "K"));
        holder.txt_item_shoppingCart_giamsoluong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Giam số lượng
            }
        });

        holder.txt_item_shoppingCart_tangsoluong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tăng số lượng
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList_ShoppingCart.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_item_shoppingCart_avata;
        TextView txt_item_shoppingCart_txtaotreem;
        TextView txt_item_shoppingCart_size;
        TextView txt_item_shoppingCart_giatien;
        TextView txt_item_shoppingCart_vnd;
        TextView txt_item_shoppingCart_giamsoluong;
        TextView txt_item_shoppingCart_soluong;
        TextView txt_item_shoppingCart_tangsoluong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_item_shoppingCart_avata = itemView.findViewById(R.id.img_item_shoppingCart_avata);
            txt_item_shoppingCart_txtaotreem = itemView.findViewById(R.id.txt_item_shoppingCart_txtaotreem);
            txt_item_shoppingCart_size = itemView.findViewById(R.id.txt_item_shoppingCart_size);
            txt_item_shoppingCart_giatien = itemView.findViewById(R.id.txt_item_shoppingCart_giatien);
            txt_item_shoppingCart_vnd = itemView.findViewById(R.id.txt_item_shoppingCart_vnd);
            txt_item_shoppingCart_giamsoluong = itemView.findViewById(R.id.txt_item_shoppingCart_giamsoluong);
            txt_item_shoppingCart_soluong = itemView.findViewById(R.id.txt_item_shoppingCart_soluong);
            txt_item_shoppingCart_tangsoluong = itemView.findViewById(R.id.txt_item_shoppingCart_tangsoluong);
        }
    }
}
