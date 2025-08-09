package fpoly.sonhaph40315_20_6.duan_prostore.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation.Canceled_Fragment;
import fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation.Delivered_Fragment;
import fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation.IsDelivering_Fragment;
import fpoly.sonhaph40315_20_6.duan_prostore.fragmentbottomnavigation.WaitingForConfirmation_Fragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new WaitingForConfirmation_Fragment();
            case 1:
                return new Delivered_Fragment();
            case 2:
                return new Canceled_Fragment();
            case 3:
                return new IsDelivering_Fragment();
            default:
                return new WaitingForConfirmation_Fragment();
        }
    }
    @Override
    public int getItemCount() {
        return 4;
    }
}
