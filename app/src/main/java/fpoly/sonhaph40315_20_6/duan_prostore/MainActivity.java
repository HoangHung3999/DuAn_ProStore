package fpoly.sonhaph40315_20_6.duan_prostore;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation.HomeFragment;
import fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation.ProductListFragment;
import fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation.ShoppingCartFragment;
import fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation.UserFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Fragment shoppingCartFragment = new ShoppingCartFragment();
    Fragment productListFragment = new ProductListFragment();
    Fragment homeFragment = new HomeFragment();
    Fragment userFragment = new UserFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.item_home) {
                loadFragment(homeFragment);
                return true;
            } else if (id == R.id.item_productList) {
                loadFragment(productListFragment);
                return true;
            } else if (id == R.id.item_cart) {
                loadFragment(shoppingCartFragment);
                return true;
            } else if (id == R.id.item_user) {
                loadFragment(userFragment);
                return true;
            }
            return false;
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }

    public void hideBottomNav(){
        bottomNavigationView.setVisibility(View.GONE);
    }

    public void showBottomNav(){
        bottomNavigationView.setVisibility(View.VISIBLE);
    }
}
