package fpoly.sonhaph40315_20_6.duan_prostore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.model.DonHangChiTiet;

public class DonHangChiTietAdapter extends RecyclerView.Adapter<DonHangChiTietAdapter.ViewHolder> {
    private Context context;
    private List<DonHangChiTiet> list;

    public DonHangChiTietAdapter(Context context, List<DonHangChiTiet> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DonHangChiTietAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_donhang_chitiet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonHangChiTietAdapter.ViewHolder holder, int position) {
        DonHangChiTiet item = list.get(position);
        holder.tvProductId.setText("Mã SP: " + item.getProductId());
        holder.tvSoLuong.setText("Số lượng: " + item.getSoLuong());
        holder.tvGiaTien.setText("Giá: " + item.getGiaTien());
        holder.tvUsername.setText("Khách: " + item.getUsername());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductId, tvSoLuong, tvGiaTien, tvUsername;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductId = itemView.findViewById(R.id.tvProductId);
            tvSoLuong = itemView.findViewById(R.id.tvSoLuong);
            tvGiaTien = itemView.findViewById(R.id.tvGiaTien);
            tvUsername = itemView.findViewById(R.id.tvUsername);
        }
    }
}
