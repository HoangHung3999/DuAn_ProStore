package fpoly.sonhaph40315_20_6.duan_prostore.useractivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import fpoly.sonhaph40315_20_6.duan_prostore.dao.LienHeDao;
import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation.UserFragment;
import fpoly.sonhaph40315_20_6.duan_prostore.model.LienHe;



public class InformationUser_Activity extends AppCompatActivity {

    ImageButton btn_back;
    EditText edtName, edtEmail, edtPhone, edtAddress;
    Button btnSave;

    LienHeDao contactDao;
    LienHe currentContact = null; // Liên hệ hiện tại

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_user);

        btn_back = findViewById(R.id.btn_back);
        edtName = findViewById(R.id.editTextName);
        edtEmail = findViewById(R.id.editTextEmail);
        edtPhone = findViewById(R.id.editTextPhone);
        edtAddress = findViewById(R.id.editTextAddress);
        btnSave = findViewById(R.id.btnSave); // thêm id trong XML: @+id/btnSave

        contactDao = new LienHeDao(this);

        btn_back.setOnClickListener(v -> finish());

        // Load liên hệ mới nhất
        List<LienHe> contactList = contactDao.getAllContacts();
        if (!contactList.isEmpty()) {
            currentContact = contactList.get(contactList.size() - 1);
            edtName.setText(currentContact.getName());
            edtEmail.setText(currentContact.getEmail());
            edtPhone.setText(currentContact.getPhone());
            edtAddress.setText(currentContact.getAddress());
        }

        // Cập nhật thông tin
        btnSave.setOnClickListener(v -> {
            if (currentContact == null) {
                Toast.makeText(this, "Không có thông tin để cập nhật", Toast.LENGTH_SHORT).show();
                return;
            }

            String newName = edtName.getText().toString().trim();
            String newEmail = edtEmail.getText().toString().trim();
            String newPhone = edtPhone.getText().toString().trim();
            String newAddress = edtAddress.getText().toString().trim();

            currentContact.setName(newName);
            currentContact.setEmail(newEmail);
            currentContact.setPhone(newPhone);
            currentContact.setAddress(newAddress);

            boolean updated = contactDao.updateContact(currentContact);
            if (updated) {
                Toast.makeText(this, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
