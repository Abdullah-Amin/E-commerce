package com.abdullah.e_commerce;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new SignUpFragment();
            case 1:
                return new LoginFragment();
            default:
                return new ForgotPasswordFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
