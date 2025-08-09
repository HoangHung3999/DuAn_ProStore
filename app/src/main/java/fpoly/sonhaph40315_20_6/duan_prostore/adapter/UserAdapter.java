package fpoly.sonhaph40315_20_6.duan_prostore.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.dao.UserDao;
import fpoly.sonhaph40315_20_6.duan_prostore.model.User;
import fpoly.sonhaph40315_20_6.duan_prostore.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;
    private Context context;
    private UserDao userDao;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
        this.userDao = new UserDao(context);
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvUsername, tvEmail, tvRole,tvId;
        ImageButton btnEdit, btnDelete;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvRole = itemView.findViewById(R.id.tvRole);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.tvId.setText(String.valueOf(user.getId()));
        holder.tvUsername.setText(user.getUsername());
        holder.tvEmail.setText(user.getEmail());
        holder.tvRole.setText(user.getRole());

        holder.btnDelete.setOnClickListener(v -> showDeleteConfirmDialog(user,position));

        holder.btnEdit.setOnClickListener(v -> showEditDialog(user, position));

    }
    private void showEditDialog(User user, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Sửa thông tin người dùng");

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_edit_user, null);
        EditText edtUsername = view.findViewById(R.id.edtUsername);
        EditText edtEmail = view.findViewById(R.id.edtEmail);
        EditText edtRole = view.findViewById(R.id.edtRole);

        edtUsername.setText(user.getUsername());
        edtEmail.setText(user.getEmail());
        edtRole.setText(user.getRole());

        builder.setView(view);

        builder.setPositiveButton("Lưu", (dialog, which) -> {
            user.setUsername(edtUsername.getText().toString());
            user.setEmail(edtEmail.getText().toString());
            user.setRole(edtRole.getText().toString());

            // Cập nhật vào database
            int result = userDao.updateUser(user);
            if (result > 0) {
                userList.set(position, user); // cập nhật UI
                notifyItemChanged(position);
                Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Hủy", null);
        builder.show();
    }

    private void showDeleteConfirmDialog(User user, int position) {
        new AlertDialog.Builder(context)
                .setTitle("Xác nhận xóa")
                .setMessage("Bạn có chắc muốn xóa người dùng này không?")
                .setPositiveButton("Xóa", (dialog, which) -> {
                    int result = userDao.deleteUser(user.getId());
                    if (result > 0) {
                        userList.remove(position);
                        notifyItemRemoved(position);
                        Toast.makeText(context, "Đã xóa", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Hủy", null)
                .show();
    }



    @Override
    public int getItemCount() {
        return userList.size();
    }
}
