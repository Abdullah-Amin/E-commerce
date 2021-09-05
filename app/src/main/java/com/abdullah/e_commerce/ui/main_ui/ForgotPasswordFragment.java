package com.abdullah.e_commerce.ui.main_ui;

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
import android.widget.TextView;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.FragmentForgotPasswordBinding;

public class ForgotPasswordFragment extends Fragment {

    FragmentForgotPasswordBinding binding;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forgot_password, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        setOnClicksListeners(binding.fragmentForgotPasswordSignupTv, R.id.action_forgotPasswordFragment_to_signUpFragment);

        setOnClicksListeners(binding.fragmentForgotPasswordLoginTv, R.id.action_forgotPasswordFragment_to_loginFragment);

        binding.fragmentForgotPasswordLoginTv.setOnClickListener(v -> navController.navigate(R.id.action_forgotPasswordFragment_to_loginFragment));
    }

    private void setOnClicksListeners(TextView pressedBtn, int destination) {
        pressedBtn.setOnClickListener(v -> navController.navigate(destination));
    }
}