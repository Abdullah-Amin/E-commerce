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

import com.abdullah.e_commerce.databinding.FragmentSignUpBinding;

public class SignUpFragment extends Fragment {

    FragmentSignUpBinding binding;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        setOnClicksListeners(binding.signupFragmentLoginTv, R.id.action_signUpFragment_to_loginFragment);

        setOnClicksListeners(binding.signupFragmentForgotPasswordTv, R.id.action_signUpFragment_to_forgotPasswordFragment);

        binding.signupFragmentSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_signUpFragment_to_navigation_home);
            }
        });
    }

    private void setOnClicksListeners(TextView pressedBtn, int destination) {
        pressedBtn.setOnClickListener(v -> navController.navigate(destination));
    }
}