package fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import fpoly.sonhaph40315_20_6.duan_prostore.MainActivity;
import fpoly.sonhaph40315_20_6.duan_prostore.R;
import fpoly.sonhaph40315_20_6.duan_prostore.useractivity.BankCard_Activity;
import fpoly.sonhaph40315_20_6.duan_prostore.useractivity.Contact_Activity;
import fpoly.sonhaph40315_20_6.duan_prostore.useractivity.InformationUser_Activity;
import fpoly.sonhaph40315_20_6.duan_prostore.useractivity.Order_Activity;


public class UserFragment extends Fragment {

    private LinearLayout settingContainer;

    private TextView txt_title_user1;

    private ImageButton img_btn_back_user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        settingContainer = view.findViewById(R.id.settingContainer);

        txt_title_user1 = view.findViewById(R.id.txt_title_user);
        img_btn_back_user = view.findViewById(R.id.img_btn_back_user);
        img_btn_back_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        // Gọi hàm ẩn bottom
        ((MainActivity)getActivity()) .hideBottomNav();
        settingContainer = view.findViewById(R.id.settingContainer);
        addSettingItem(R.drawable.user_order_icon, "Đơn hàng");
        addDivider();
        addSettingItem(R.drawable.user_bankcard__icon, "Thẻ ngân hàng");
        addDivider();
        addSettingItem(R.drawable.user_information_, "Thông tin cá nhân");
        addDivider();
        addSettingItem(R.drawable.user_contact_icon, "Liên hệ");
        addDivider();
        addSettingItem(R.drawable.user_logout_icon, "Đăng xuất");
        addDivider();
        return view;

    }

    private void addSettingItem(int iconRes, String title) {
        View item = LayoutInflater.from(getContext()).inflate(R.layout.layout_item_user_function, null);
        ((ImageView) item.findViewById(R.id.layout_item_img_user_icon)).setImageResource(iconRes);
        ((TextView) item.findViewById(R.id.layout_item_text_name_user)).setText(title);
        item.setOnClickListener(v -> {
            Context context = requireContext();
            if (title.equals("Đơn hàng")) {

                startActivity(new Intent(context, Order_Activity.class));
            } else if (title.equals("Thẻ ngân hàng")) {

                startActivity(new Intent(context, BankCard_Activity.class));
            } else if (title.equals("Thông tin cá nhân")) {

                startActivity(new Intent(context, InformationUser_Activity.class));
            } else if (title.equals("Liên hệ")) {

                startActivity(new Intent(context, Contact_Activity.class));
            } else if (title.equals("Đăng xuất")) {

                Toast.makeText(context, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
        settingContainer.addView(item);
    }

    private void addDivider() {
        View divider = new View(getContext());
        divider.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                1)); // chiều cao 1dp
        divider.setBackgroundColor(Color.parseColor("#333333"));
        settingContainer.addView(divider);
    }
}