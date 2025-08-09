package fpoly.sonhaph40315_20_6.duan_prostore;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import fpoly.sonhaph40315_20_6.duan_prostore.dao.SanPhamDao;
import fpoly.sonhaph40315_20_6.duan_prostore.model.SanPham;

public class DialogSuaSanPham extends DialogFragment {

    private static final String ARG_SAN_PHAM = "sanPham";
    private EditText edtName, edtPrice, edtQuantity, edtSize, edtCategory, edtImagePath,edtDate;
    private Button btnCapNhat;
    private SanPham sanPham;
    private OnProductUpdatedListener listener;

    public interface OnProductUpdatedListener {
        void onUpdated();
    }

    public void setOnProductUpdatedListener(OnProductUpdatedListener listener) {
        this.listener = listener;
    }

    public static DialogSuaSanPham newInstance(SanPham sanPham) {
        DialogSuaSanPham fragment = new DialogSuaSanPham();
        Bundle args = new Bundle();
        args.putSerializable(ARG_SAN_PHAM, sanPham);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_sua_san_pham, null);
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(view);

        // Lấy dữ liệu sản phẩm
        if (getArguments() != null) {
            sanPham = (SanPham) getArguments().getSerializable(ARG_SAN_PHAM);
        }

        // Ánh xạ view
        edtName = view.findViewById(R.id.edtName);
        edtPrice = view.findViewById(R.id.edtPrice);
        edtQuantity = view.findViewById(R.id.edtQuantity);
        edtSize = view.findViewById(R.id.edtSize);
        edtCategory = view.findViewById(R.id.edtCategory);
        edtImagePath = view.findViewById(R.id.edtImagePath);
        edtDate = view.findViewById(R.id.edtDate);
        btnCapNhat = view.findViewById(R.id.btnCapNhat);

        // Gán dữ liệu cũ
        if (sanPham != null) {
            edtName.setText(sanPham.getName());
            edtPrice.setText(String.valueOf(sanPham.getPrice()));
            edtQuantity.setText(String.valueOf(sanPham.getQuantity()));
            edtSize.setText(sanPham.getSize());
            edtCategory.setText(sanPham.getCategory());
            edtImagePath.setText(sanPham.getImagePath());
            edtDate.setText(sanPham.getDate());
        }

        btnCapNhat.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            String priceStr = edtPrice.getText().toString();
            String quantityStr = edtQuantity.getText().toString();
            String size = edtSize.getText().toString();
            String category = edtCategory.getText().toString();
            String date = edtDate.getText().toString();
            String imagePath = edtImagePath.getText().toString();

            if (name.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()) {
                Toast.makeText(getContext(), "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(quantityStr);

            sanPham.setName(name);
            sanPham.setPrice(price);
            sanPham.setQuantity(quantity);
            sanPham.setSize(size);
            sanPham.setCategory(category);
            sanPham.setImagePath(imagePath);
            sanPham.setDate(date);

            // Cập nhật vào database
            SanPhamDao dao = new SanPhamDao(requireContext());
            dao.updateProduct(sanPham);

            Toast.makeText(getContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            if (listener != null) listener.onUpdated();
            dismiss();
        });

        return dialog;
    }
}
