package fpoly.sonhaph40315_20_6.duan_prostore.useractivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation.UserFragment;
import fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation.WaitingForConfirmation_Fragment;

public class Order_Activity extends AppCompatActivity {

    ImageView img_choxacnhan, img_chogiaohang, img_dahuy, img_danggiao;
    ImageButton btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);
        img_choxacnhan = findViewById(R.id.img_choxacnhan);
        img_chogiaohang = findViewById(R.id.img_chogiaohang);
        img_dahuy = findViewById(R.id.img_dahuy);
        img_danggiao = findViewById(R.id.img_danggiao);
        btn_back = findViewById(R.id.btn_back);
        img_choxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order_Activity.this, OderStatus_Activity.class);
                startActivity(intent);
            }
        });
        img_chogiaohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order_Activity.this, OderStatus_Activity.class);
                startActivity(intent);
            }
        });

        img_dahuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order_Activity.this, OderStatus_Activity.class);
                startActivity(intent);
            }
        });

        img_danggiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order_Activity.this, OderStatus_Activity.class);
                startActivity(intent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}