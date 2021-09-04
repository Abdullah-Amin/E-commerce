package com.abdullah.e_commerce;

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

import com.abdullah.e_commerce.databinding.FragmentLoginBinding;

import org.jetbrains.annotations.NotNull;

public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    NavController navController;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        setOnClicksListeners(binding.fragmentLoginForgotPasswordTv, R.id.action_loginFragment_to_forgotPasswordFragment);

        setOnClicksListeners(binding.fragmentLoginSignupTv, R.id.action_loginFragment_to_signUpFragment);

        binding.fragmentLoginLoginBtn.setOnClickListener(v -> navController.navigate(R.id.action_loginFragment_to_navigation_home));
    }

    private void setOnClicksListeners(TextView pressedBtn, int destination) {
        pressedBtn.setOnClickListener(v -> navController.navigate(destination));
    }
}