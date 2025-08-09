package fpoly.sonhaph40315_20_6.duan_prostore.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.ProductDetailActivity;
import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.SanPhamChiTietFragment;
import fpoly.sonhaph40315_20_6.duan_prostore.model.SanPham;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder> {

    private final Context context;
    private final List<SanPham> productList;
    private final boolean isFromUserSide;
    private final OnProductActionListener listener;

    public interface OnProductActionListener {
        void onEdit(SanPham product);
        void onDelete(SanPham product);
    }

    public SanPhamAdapter(Context context, List<SanPham> productList, boolean isFromUserSide, OnProductActionListener listener) {
        this.context = context;
        this.productList = productList;
        this.isFromUserSide = isFromUserSide;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sanpham, parent, false);
        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {
        SanPham product = productList.get(position);

        holder.tvName.setText(product.getName());
        holder.tvQuantity.setText("Số lượng: " + product.getQuantity());
        holder.tvDate.setText("Ngày: " + product.getDate());
        holder.tvPrice.setText(product.getPrice()+"Vnd");

        // Load hình
        if (product.getImagePath() != null && !product.getImagePath().isEmpty()) {
            Glide.with(context)
                    .load(Uri.parse(product.getImagePath()))
                    .placeholder(R.drawable.ic_product)
                    .into(holder.imgProduct);
        } else {
            holder.imgProduct.setImageResource(R.drawable.ic_product);
        }

        // Hiện hoặc ẩn nút Edit/Delete
        if (isFromUserSide) {
            holder.btnEdit.setVisibility(View.GONE);
            holder.btnDelete.setVisibility(View.GONE);
        } else {
            holder.btnEdit.setVisibility(View.VISIBLE);
            holder.btnDelete.setVisibility(View.VISIBLE);

            holder.btnEdit.setOnClickListener(v -> {
                if (listener != null) listener.onEdit(product);
            });

            holder.btnDelete.setOnClickListener(v -> {
                if (listener != null) listener.onDelete(product);
            });
        }


        // Sự kiện click item
        holder.itemView.setOnClickListener(v -> {
            if (isFromUserSide) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("product", product);
                context.startActivity(intent);
            } else {
                SanPhamChiTietFragment fragment = new SanPhamChiTietFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("sanpham", product);
                fragment.setArguments(bundle);

                ((AppCompatActivity) context).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void filterList(List<SanPham> filteredList) {
        productList.clear();
        productList.addAll(filteredList);
        notifyDataSetChanged();
    }

    public static class SanPhamViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct, btnEdit, btnDelete;
        TextView tvName, tvQuantity, tvDate,tvPrice;

        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            tvName = itemView.findViewById(R.id.tvName);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
