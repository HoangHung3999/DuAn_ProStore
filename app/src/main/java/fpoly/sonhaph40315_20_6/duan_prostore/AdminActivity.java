package fpoly.sonhaph40315_20_6.duan_prostore;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import fpoly.sonhaph40315_20_6.duan_prostore.*;

public class AdminActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);



        // Toolbar
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Trang chính Admin");

        // Toggle menu
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Xử lý click item trong menu
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            Fragment selectedFragment = null;

            if (id == R.id.nav_main) {
                selectedFragment = new AdminFragment();
            } else if (id == R.id.nav_user) {
                selectedFragment = new QuanLyTaiKhoanFragment();
            } else if (id == R.id.nav_orders) {
                selectedFragment = new DonHangFragment();
            } else if (id == R.id.nav_order) {
                selectedFragment = new DonHangChiTietFragment();
            } else if (id == R.id.nav_dashboard) {
                selectedFragment = new ThongKeFragment();
            } else if (id == R.id.nav_evaluate) {
                selectedFragment = new DanhGiaFragment();
            } else if (id == R.id.nav_product) {
                selectedFragment = new SanPhamFragment();
            } else if (id == R.id.nav_contact) {
                selectedFragment = new LienHeFragment();
            } else if (id == R.id.nav_logout) {
                startActivity(new Intent(AdminActivity.this, LoginActivity.class));
                finish();
                return true;
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        // Hiển thị mặc định một Fragment (nếu cần)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new AdminFragment())
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
