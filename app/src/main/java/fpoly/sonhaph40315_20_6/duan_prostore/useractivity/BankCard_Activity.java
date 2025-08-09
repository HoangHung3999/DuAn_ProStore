package fpoly.sonhaph40315_20_6.duan_prostore.useractivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.adapter.BankCardAcount_Adapter;
import fpoly.sonhaph40315_20_6.duan_prostore.adapter.CreditCard_Adapter;
import fpoly.sonhaph40315_20_6.duan_prostore.model.BankCardCount_Model;
import fpoly.sonhaph40315_20_6.duan_prostore.model.CreditCard_Model;

public class BankCard_Activity extends AppCompatActivity {
    ImageView btn_back;
    Button btn_item_thetindung;
    Button btn_item_themtknganhang;
    CreditCard_Adapter taiKhoanNganHangAdapter;
    ArrayList<CreditCard_Model> listTaiKhoanNganHang;
    RecyclerView rcv_thetindung, rcv_taikhoannganhang;
    BankCardAcount_Adapter bankCardAcountAdapter;
    ArrayList<BankCardCount_Model> listCreditCardModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bank_card);
        initUl();
        listTaiKhoanNganHang = new ArrayList<>();
        listTaiKhoanNganHang.add(new CreditCard_Model(99999999, "Hoàng Anh Sơn", getMillis(2000, 0, 5)));
        listTaiKhoanNganHang.add(new CreditCard_Model(99999999, "Hoàng Anh Sơn", getMillis(2000, 0, 5)));
        listTaiKhoanNganHang.add(new CreditCard_Model(99999999, "Hoàng Anh Sơn", getMillis(2000, 0, 5)));
        taiKhoanNganHangAdapter = new CreditCard_Adapter(this, listTaiKhoanNganHang);
        rcv_thetindung.setLayoutManager(new LinearLayoutManager(this));
        rcv_thetindung.setAdapter(taiKhoanNganHangAdapter);

        // tài khoản ngân hàng
        listCreditCardModel = new ArrayList<>();
        listCreditCardModel.add(new BankCardCount_Model(9999999));
        listCreditCardModel.add(new BankCardCount_Model(1345678));
        bankCardAcountAdapter = new BankCardAcount_Adapter(this, listCreditCardModel);
        rcv_taikhoannganhang.setLayoutManager(new LinearLayoutManager(this));
        rcv_taikhoannganhang.setAdapter(bankCardAcountAdapter);
        btn_back.setOnClickListener(v -> finish());
    }

    private void initUl() {
        btn_back = findViewById(R.id.btn_back);
        btn_item_thetindung = findViewById(R.id.btn_item_thetindung);
        btn_item_themtknganhang = findViewById(R.id.btn_item_themtknganhang);
        rcv_thetindung = findViewById(R.id.rcv_thetindung);
        rcv_taikhoannganhang = findViewById(R.id.rcv_taikhoannganhang);

    }

    private long getMillis(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTimeInMillis();
    }
}