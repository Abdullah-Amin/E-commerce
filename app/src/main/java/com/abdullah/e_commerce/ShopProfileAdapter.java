package com.abdullah.e_commerce;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ShopProfileAdapter extends FragmentStateAdapter {

    public ShopProfileAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new ShopHomeFragment();
            case 1:
                return new ShopProductFragment();
            default:
                return new ReviewsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
