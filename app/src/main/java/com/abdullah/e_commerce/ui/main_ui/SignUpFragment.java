package com.abdullah.e_commerce.ui.main_ui;

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
import com.abdullah.e_commerce.databinding.FragmentSignUpBinding;
import com.abdullah.e_commerce.model.reponses.RegisterResponse;
import com.abdullah.e_commerce.model.requests.RegisterRequest;
import com.abdullah.e_commerce.network.RetrofitSingleton;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpFragment extends Fragment {

    private static final String TAG = "SignUpFragment";

    FragmentSignUpBinding binding;
    NavController navController;

    TextInputEditText email;
    TextInputEditText username;
    TextInputEditText password;
    TextInputEditText confirmPassword;

    RegisterRequest registerRequest;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        email = view.findViewById(R.id.signup_fragment_email_et);
        username = view.findViewById(R.id.signup_fragment_username_et);
        password = view.findViewById(R.id.signup_fragment_password_et);
        confirmPassword = view.findViewById(R.id.signup_fragment_confirm_password_et);

        navController = Navigation.findNavController(view);

        binding.signupFragmentSignupBtn.setOnClickListener(v ->{

            if(Objects.requireNonNull(email.getText()).toString().isEmpty()
                    || Objects.requireNonNull(username.getText()).toString().isEmpty()
                    ||Objects.requireNonNull(password.getText()).toString().isEmpty()
                    || Objects.requireNonNull(confirmPassword.getText()).toString().isEmpty()){
                Toast.makeText(getActivity(), "Fields can't be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            registerRequest = new RegisterRequest(username.getText().toString(), email.getText().toString(),
                    password.getText().toString(), confirmPassword.getText().toString());

            connectAndRegister();

        });

        setOnClicksListeners(binding.signupFragmentLoginTv, R.id.action_signUpFragment_to_loginFragment);

        setOnClicksListeners(binding.signupFragmentForgotPasswordTv, R.id.action_signUpFragment_to_forgotPasswordFragment);
    }

    private void connectAndRegister() {

        RetrofitSingleton.connect().register(registerRequest)
                .enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(@NotNull Call<RegisterResponse> call, @NotNull Response<RegisterResponse> response) {
                        if(response.isSuccessful()){
                            Log.i(TAG, "onResponse: " + response.body().getMessage());

//                            Bundle bundle = new Bundle();
//                            assert response.body() != null;
//                            bundle.putString("token", response.body().getRegisteredUser().getAccessToken());
//                            navController.navigate(R.id.action_signUpFragment_to_navigation_home, bundle);
                        }

                        else {

                            try {
                                JSONObject jObjError = new JSONObject(response.errorBody().string());
                                Toast.makeText(getContext(), jObjError.getJSONObject("data").getString("message"), Toast.LENGTH_LONG).show();
                                Log.i(TAG, "onResponse: try" + jObjError.getJSONObject("data"));
                            } catch (Exception e) {
                                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                Log.i(TAG, "onResponse: catch" + e.getLocalizedMessage());
                            }

//                            Log.i(TAG, "onResponse: uuuu"
//                                    + response.body().getData().toString());
//                            Toast.makeText(getActivity(),
//                                    response.body().getData().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<RegisterResponse> call, @NotNull Throwable t) {
                        Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
                    }
                });
    }

    private void setOnClicksListeners(TextView pressedBtn, int destination) {
        pressedBtn.setOnClickListener(v -> navController.navigate(destination));
    }
}