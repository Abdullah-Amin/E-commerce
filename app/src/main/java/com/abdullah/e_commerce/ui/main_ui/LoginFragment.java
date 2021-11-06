package com.abdullah.e_commerce.ui.main_ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.FragmentLoginBinding;
import com.abdullah.e_commerce.model.responses.LoginResponse;
import com.abdullah.e_commerce.model.requests.LoginRequest;
import com.abdullah.e_commerce.network.RetrofitSingleton;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    NavController navController;

    TextInputEditText emailEt;
    TextInputEditText passwordEt;

    LoginRequest loginRequest;

    private static final String TAG = "LoginFragment";

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

        emailEt = view.findViewById(R.id.fragment_login_username_et);
        passwordEt = view.findViewById(R.id.fragment_login_password_et);

        navController = Navigation.findNavController(view);

        binding.fragmentLoginLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((emailEt.getText()).toString().isEmpty()
                        || (passwordEt.getText()).toString().isEmpty()) {
                    Toast.makeText(LoginFragment.this.getActivity(), "Fields can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                loginRequest = new LoginRequest(emailEt.getText().toString()
                        ,passwordEt.getText().toString()
                        ,"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiJkD2J2whBx1MsaTx7vLgOCK1GXSlMIuGTkRBGxJu_nywCxX4He11y3jOI4puSCber8gLtGG2NABA3mZsozK2e1ap7tQckSpj3aDH9btLdSZhYEHr0APDYComArJPwa2IJdxSWbMu8HEpYhicQ4");

                connectAndLogin();

            }
        });

        setOnClicksListeners(binding.fragmentLoginForgotPasswordTv, R.id.action_loginFragment_to_forgotPasswordFragment);

        setOnClicksListeners(binding.fragmentLoginSignupTv, R.id.action_loginFragment_to_signUpFragment);
    }

    private void connectAndLogin() {
        RetrofitSingleton.connect().login(loginRequest)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if(response.isSuccessful()){
                            Log.i(TAG, "onResponse: " + response.toString());

//                            Bundle bundle = new Bundle();
//                            bundle.putString("token", response.body().getLoggedUser().getAccessToken());

//                            navController.navigate(R.id.action_loginFragment_to_navigation_home, bundle);
                            saveToken(response.body().getLoggedUser().getAccessToken().toString(), response.isSuccessful());
                            Intent intent = new Intent(getActivity(), HomeActivity.class);
                            assert response.body() != null;
                            intent.putExtra("token", response.body().getLoggedUser().getAccessToken().toString());
                            startActivity(intent);
                            requireActivity().finish();
                        }
                        else {
                            Log.i(TAG, "onResponse: uuuu ");
                            Toast.makeText(getActivity(), "Invalid Email or Password!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
                    }
                });
    }

    private void saveToken(String accessToken, boolean loginState) {
        SharedPreferences.Editor preferences = requireActivity().getSharedPreferences("userToken", Context.MODE_PRIVATE).edit();
        preferences.putString("token", accessToken);
        preferences.putBoolean("loginState", loginState);
        preferences.apply();
    }

    private void setOnClicksListeners(TextView pressedBtn, int destination) {
        pressedBtn.setOnClickListener(v -> navController.navigate(destination));
    }


}