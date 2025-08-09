package fpoly.sonhaph40315_20_6.duan_prostore.useractivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import fpoly.sonhaph40315_20_6.duan_prostore.dao.LienHeDao;
import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.model.LienHe;

public class Contact_Activity extends AppCompatActivity {

    ImageButton btn_back;
    EditText edtName, edtPhone, edtEmail, edtAddress, edtMessage;
    Button btnSend;
    LienHeDao contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        contactDao = new LienHeDao(this);

        // Ánh xạ
        btn_back = findViewById(R.id.btn_back);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        edtAddress = findViewById(R.id.edtAddress);
        edtMessage = findViewById(R.id.edtMessage);
        btnSend = findViewById(R.id.btnSend);

        // Quay lại
        btn_back.setOnClickListener(v -> finish());

        // Gửi liên hệ
        btnSend.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String phone = edtPhone.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String address = edtAddress.getText().toString().trim();
            String message = edtMessage.getText().toString().trim();

            if (name.isEmpty() || phone.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

            LienHe contact = new LienHe(0, name, phone, email, address, message, currentDate);
            boolean success = contactDao.insertContact(contact);

            if (success) {
                Toast.makeText(this, "Gửi liên hệ thành công!", Toast.LENGTH_SHORT).show();
                edtName.setText("");
                edtPhone.setText("");
                edtEmail.setText("");
                edtAddress.setText("");
                edtMessage.setText("");
            } else {
                Toast.makeText(this, "Gửi thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
