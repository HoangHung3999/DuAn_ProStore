package fpoly.sonhaph40315_20_6.duan_prostore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etAddress;
    Button btnSave;
    ImageButton btnBack;
    ImageView ivUser;

    SharedPreferences sharedPreferences;
    public static final String PREF_NAME = "UserProfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Ánh xạ view
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnBack);
        ivUser = findViewById(R.id.ivUser);

        // SharedPreferences để lưu trữ dữ liệu
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // Tải dữ liệu đã lưu
        loadUserData();

        // Lưu thông tin
        btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String address = etAddress.getText().toString().trim();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name", name);
            editor.putString("email", email);
            editor.putString("phone", phone);
            editor.putString("address", address);
            editor.apply();

            Toast.makeText(this, "Thông tin đã được lưu!", Toast.LENGTH_SHORT).show();
        });

        // Quay lại
        btnBack.setOnClickListener(v -> {
            finish();
        });
    }

    private void loadUserData() {
        etName.setText(sharedPreferences.getString("name", ""));
        etEmail.setText(sharedPreferences.getString("email", ""));
        etPhone.setText(sharedPreferences.getString("phone", ""));
        etAddress.setText(sharedPreferences.getString("address", ""));
        // Ảnh đại diện không cần xử lý nếu bạn để ảnh tĩnh sẵn trong drawable
    }
}
