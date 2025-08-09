package fpoly.sonhaph40315_20_6.duan_prostore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    private FrameLayout creditCardWrapper, bankAccountWrapper;
    private ImageView btnBack;
    private TextView tvTotalAmount;
    private Button btnPayment;
    private boolean isCreditCardSelected = true;
    private double totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        initViews();
        receiveTotalAmount();
        setupEventListeners();
        updatePaymentUI();
    }

    private void initViews() {
        creditCardWrapper = findViewById(R.id.creditCardWrapper);
        bankAccountWrapper = findViewById(R.id.bankAccountWrapper);
        btnBack = findViewById(R.id.btnBack);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        btnPayment = findViewById(R.id.btnPayment);
    }

    private void receiveTotalAmount() {
        totalAmount = getIntent().getDoubleExtra("TOTAL_AMOUNT", 0);
        tvTotalAmount.setText(String.format("Tổng\n%,.0f VND", totalAmount));
    }

    private void setupEventListeners() {
        creditCardWrapper.setOnClickListener(v -> {
            isCreditCardSelected = true;
            updatePaymentUI();
        });

        bankAccountWrapper.setOnClickListener(v -> {
            isCreditCardSelected = false;
            updatePaymentUI();
        });

        btnPayment.setOnClickListener(v -> processPayment());

        btnBack.setOnClickListener(v -> finish());
    }

    private void updatePaymentUI() {
        if (isCreditCardSelected) {
            creditCardWrapper.setBackgroundResource(R.drawable.bg_card_border);
            bankAccountWrapper.setBackgroundResource(R.drawable.bg_bank_button);
            btnPayment.setText("Thanh toán bằng thẻ tín dụng");
        } else {
            creditCardWrapper.setBackgroundResource(R.drawable.bg_bank_button);
            bankAccountWrapper.setBackgroundResource(R.drawable.bg_card_border);
            btnPayment.setText("Thanh toán bằng ngân hàng");
        }
    }

    private void processPayment() {
        String message = isCreditCardSelected ?
                "Thanh toán bằng thẻ tín dụng thành công!" :
                "Thanh toán bằng tài khoản ngân hàng thành công!";

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        CartManager.getInstance().clearCart();

        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
