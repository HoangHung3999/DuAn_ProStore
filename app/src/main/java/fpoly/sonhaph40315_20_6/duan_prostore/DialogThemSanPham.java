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

public class DialogThemSanPham extends DialogFragment {

    private EditText edtName, edtPrice, edtQuantity, edtSize, edtCategory, edtImagePath,edtDate;
    private Button btnThem;

    // Interface callback
    public interface OnProductAddedListener {
        void onProductAdded();
    }

    private OnProductAddedListener listener;

    public void setOnProductAddedListener(OnProductAddedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_them_san_pham, null);
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(view);

        // Ánh xạ view
        edtName = view.findViewById(R.id.edtName);
        edtPrice = view.findViewById(R.id.edtPrice);
        edtQuantity = view.findViewById(R.id.edtQuantity);
        edtSize = view.findViewById(R.id.edtSize);
        edtCategory = view.findViewById(R.id.edtCategory);
        edtImagePath = view.findViewById(R.id.edtImagePath);
        edtDate = view.findViewById(R.id.edtDate);
        btnThem = view.findViewById(R.id.btnThem);

        // Xử lý nút thêm
        btnThem.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String priceStr = edtPrice.getText().toString().trim();
            String quantityStr = edtQuantity.getText().toString().trim();
            String size = edtSize.getText().toString().trim();
            String category = edtCategory.getText().toString().trim();
            String imagePath = edtImagePath.getText().toString().trim();
            String date = edtDate.getText().toString().trim();

            if (name.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()) {
                Toast.makeText(getContext(), "Vui lòng nhập đủ tên, giá và số lượng", Toast.LENGTH_SHORT).show();
                return;
            }

            double price;
            int quantity;
            try {
                price = Double.parseDouble(priceStr);
                quantity = Integer.parseInt(quantityStr);
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Giá và số lượng phải là số", Toast.LENGTH_SHORT).show();
                return;
            }

            SanPham sanPham = new SanPham(0, name, price, quantity, size, category, imagePath,date);
            SanPhamDao dao = new SanPhamDao(requireContext());
            dao.insertProduct(sanPham);

            Toast.makeText(getContext(), "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();

            // Gọi callback để cập nhật danh sách
            if (listener != null) {
                listener.onProductAdded();
            }

            dismiss();
        });

        return dialog;
    }
}
