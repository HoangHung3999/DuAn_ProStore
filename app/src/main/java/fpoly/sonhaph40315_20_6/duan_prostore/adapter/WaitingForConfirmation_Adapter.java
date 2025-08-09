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
import fpoly.sonhaph40315_20_6.duan_prostore.model.StatusOrder_Model;

public class WaitingForConfirmation_Adapter extends RecyclerView.Adapter<WaitingForConfirmation_Adapter.ViewHolder>{

   // Chờ xác nhận adapter
    private final Context context;

    private final ArrayList<StatusOrder_Model> trangThaiModelArrayList;

    public WaitingForConfirmation_Adapter(Context context, ArrayList<StatusOrder_Model> trangThaiModelArrayList) {
        this.context = context;
        this.trangThaiModelArrayList = trangThaiModelArrayList;
    }

    @NonNull
    @Override
    public WaitingForConfirmation_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_waitingforconfirmation_fragment, parent, false);
        return new WaitingForConfirmation_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StatusOrder_Model item = trangThaiModelArrayList.get(position);
        holder.img_layout_item_choxacnhan_avata.setImageResource(item.getAvata());
        holder.txt_layout_item_choxacnhan_aotreem.setText(item.getName());
        holder.txt_layout_item_choxacnhan_trangthai.setText(item.getTrangthai());
        holder.txt_layout_item_choxacnhan_giatien.setText(String.valueOf(item.getGia()+ "K"));
    }



    @Override
    public int getItemCount() {
        return trangThaiModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_layout_item_choxacnhan_avata;
        TextView txt_layout_item_choxacnhan_aotreem;
        TextView txt_layout_item_choxacnhan_tongtien;
        TextView txt_layout_item_choxacnhan_giatien;
        TextView txt_layout_item_choxacnhan_vnd;
        TextView txt_layout_item_choxacnhan_trangthai;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_layout_item_choxacnhan_avata = itemView.findViewById(R.id.img_layout_item_choxacnhan_avata);
            txt_layout_item_choxacnhan_aotreem = itemView.findViewById(R.id.txt_layout_item_choxacnhan_aotreem);
            txt_layout_item_choxacnhan_tongtien = itemView.findViewById(R.id.txt_layout_item_choxacnhan_tongtien);
            txt_layout_item_choxacnhan_giatien = itemView.findViewById(R.id.txt_layout_item_choxacnhan_giatien);
            txt_layout_item_choxacnhan_vnd = itemView.findViewById(R.id.txt_layout_item_choxacnhan_vnd);
            txt_layout_item_choxacnhan_trangthai = itemView.findViewById(R.id.txt_layout_item_choxacnhan_trangthai);

        }
    }
}
