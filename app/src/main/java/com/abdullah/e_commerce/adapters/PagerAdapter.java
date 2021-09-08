package com.abdullah.e_commerce.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.abdullah.e_commerce.ui.main_ui.ForgotPasswordFragment;
import com.abdullah.e_commerce.ui.main_ui.LoginFragment;
import com.abdullah.e_commerce.ui.main_ui.SignUpFragment;

public class PagerAdapter extends FragmentStateAdapter {

    Context context;

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.context  = fragmentActivity;
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
