package fpoly.sonhaph40315_20_6.duan_prostore.useractivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.adapter.ViewPagerAdapter;

public class OderStatus_Activity extends AppCompatActivity {
    private String[] title_donmua = {"Chờ xác nhận", "Đã giao", "Đã hủy","Đang giao"};
  private ImageButton btn_back;
    private TabLayout tablayout_donmua;
    private ViewPager2 viewpager;
    private ViewPagerAdapter viewpageradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_oder_status);
        btn_back = findViewById(R.id.btn_back);
//        toolbar_donmua = findViewById(R.id.toolbar_donmua);
//
//        toolbar_donmua.setTitle("Đơn hàng");
//        setSupportActionBar(toolbar_donmua);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tablayout_donmua = findViewById(R.id.tablayout_donmua);
        viewpager = findViewById(R.id.viewpager);
        viewpageradapter = new ViewPagerAdapter(this);
        viewpager.setAdapter(viewpageradapter);

        new TabLayoutMediator(tablayout_donmua, viewpager,
                (tab, position) ->
                        tab.setText(title_donmua[position])).attach();
    }
}