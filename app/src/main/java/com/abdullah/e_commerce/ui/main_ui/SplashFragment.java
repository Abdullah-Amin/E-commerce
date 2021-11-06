package com.abdullah.e_commerce.ui.main_ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.FragmentSplashBinding;

import java.util.Objects;


public class SplashFragment extends Fragment {
    private FragmentSplashBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
//        binding.fragmentSplashPb.setVisibility(View.VISIBLE);
        SharedPreferences preferences = requireActivity().getSharedPreferences("userToken", Context.MODE_PRIVATE);
        String token = preferences.getString("token", "no token found");
        boolean loginState = preferences.getBoolean("loginState", false);

        if (!token.isEmpty() || !loginState){
            navController.navigate(R.id.action_splashFragment_to_loginFragment);
        }else{
            navController.navigate(R.id.action_splashFragment_to_navigation_home);
        }

    }
}