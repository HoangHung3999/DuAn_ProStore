package fpoly.sonhaph40315_20_6.duan_prostore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.model.CreditCard_Model;

public class CreditCard_Adapter extends RecyclerView.Adapter<CreditCard_Adapter.ViewHolder>{
    private Context context;
    private ArrayList<CreditCard_Model> creaditCardList_model;

    public CreditCard_Adapter(Context context, ArrayList<CreditCard_Model> creaditCardList_model) {
        this.context = context;
        this.creaditCardList_model = creaditCardList_model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_creditcard,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CreditCard_Model items = creaditCardList_model.get(position);
        holder.txt_item_namename.setText(items.getTen());
        holder.txt_item_macard.setText(String.valueOf(items.getSothe()));
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String formatteDate = date.format(items.getNgayhethan());
        holder.txt_item_datedate.setText(formatteDate);


    }

    @Override
    public int getItemCount() {
        return creaditCardList_model.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_item_creaditcard;
        private ImageView img_item_card;
        private ImageView img_item_visa;
        private TextView txt_item_macard,txt_item_name,txt_item_date,txt_item_namename,txt_item_datedate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_item_creaditcard = itemView.findViewById(R.id.txt_item_creaditcard);
            img_item_card = itemView.findViewById(R.id.img_item_card);
            img_item_visa = itemView.findViewById(R.id.img_item_visa);
            txt_item_macard = itemView.findViewById(R.id.txt_item_macard);
            txt_item_name = itemView.findViewById(R.id.txt_item_name);
            txt_item_date = itemView.findViewById(R.id.txt_item_date);
            txt_item_namename = itemView.findViewById(R.id.txt_item_namename);
            txt_item_datedate = itemView.findViewById(R.id.txt_item_datedate);
        }
    }
}
