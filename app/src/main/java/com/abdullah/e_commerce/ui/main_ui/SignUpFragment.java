package com.abdullah.e_commerce.ui.main_ui;

import android.content.Intent;
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
import com.abdullah.e_commerce.model.data_classes.RegisterErrorBody;
import com.abdullah.e_commerce.model.responses.RegisterResponse;
import com.abdullah.e_commerce.model.requests.RegisterRequest;
import com.abdullah.e_commerce.network.RetrofitSingleton;
import com.abdullah.e_commerce.network.SharedPref;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
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
                        assert response.body() != null;
                        if(response.isSuccessful()){
                            Log.i(TAG, "onResponse: " + response.body().getMessage());

                            SharedPref.write("token", "Bearer " + response.body().getRegisteredUser().getAccessToken());
                            startActivity(new Intent(requireActivity(), HomeActivity.class));
                        }

                        else {

                            String json = null;
                            ObjectMapper objectMapper = new ObjectMapper();
                            RegisterErrorBody errorBody = null;
                            try {
                                json = response.errorBody().string();
                                errorBody = objectMapper.readValue(json, RegisterErrorBody.class);
                                Log.i(TAG, "onResponse: "+ errorBody.getData());
                                Toast.makeText(getContext(), errorBody.getData().toString(), Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                                Log.i(TAG, "onResponse: catch "+ e.getLocalizedMessage());
                            }

//                                ProductImage errorBody = response.errorBody().string();
//
//                                JSONObject jsonObject = new JSONObject(errorBody.trim());
//
//                                Gson gson = new Gson();
//
//                                RegisterErrorBody registerResponse = gson.fromJson(jsonObject.toString(), RegisterErrorBody.class);
//                                Log.i(TAG, "onResponse: "+ registerResponse.toString());
//
////                                jsonObject = jsonObject.getJSONObject("error");
//
//
//                                JSONArray jsonArray = new JSONArray(errorBody);
//                                JSONObject jsonObject = jsonArray.toJSONObject(jsonArray);
//                                jsonObject = jsonObject.getJSONObject("data");
////                                ProductImage errors = "";
////                                for (int i = 0; i < jsonArray.getJSONArray(2).length(); i++) {
////                                    errors += jsonArray.getString(i) + "\n";
////                                }
////
////                                Log.i(TAG, "onResponse: "+ errors);
//
//                                Iterator<ProductImage> keys = jsonObject.keys();
//                                ProductImage errors = "";
//                                while (keys.hasNext()) {
//                                    ProductImage key = keys.next();
//                                    JSONArray arr = jsonObject.getJSONArray(key);
//                                    for (int i = 0; i < arr.length(); i++) {
//                                        errors += key + " : " + arr.getString(i) + "\n";
//                                        Log.i(TAG, "onResponse: "+ errors);
//                                        Log.i(TAG, "onResponse: "+ jsonObject);
//                                    }
//                                }
//                            } catch (JSONException | IOException e) {
//                                e.printStackTrace();
//                                Log.i(TAG, "onResponse: catch "+ e.getLocalizedMessage());
//                            }

//                            ProductImage data = "[\"email The email has already been taken.\"]";
//                            try {
//                                JSONArray jsonArray = new JSONArray(data);
//                                JSONObject object = jsonArray.getJSONObject(0);
//                                JSONObject sendingReqDataSetObject = object.getJSONObject("data");
//                                JSONArray arrayContacts = sendingReqDataSetObject.getJSONArray("data");
//
//                                for (int i = 0; i<arrayContacts.length(); i++) {
//                                    JSONObject contactObject = arrayContacts.getJSONObject(i);
//                                    System.out.println(contactObject.getString("status"));
//                                    Log.i(TAG, "onResponse: uuuu"+ contactObject.getString("status"));
//                                    Log.i(TAG, "onResponse: uuuu"+ contactObject.getString("data"));
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                                Log.i(TAG, "onResponse: catch " + e.getLocalizedMessage());
//                            }

//                            try {
//                                JSONObject jObjError = new JSONObject(response.errorBody().toString());
//                                Toast.makeText(getContext(), jObjError.getJSONObject("data").getString("data"), Toast.LENGTH_LONG).show();
//                                Log.i(TAG, "onResponse: try -- " + jObjError.getJSONObject("data"));
//                            } catch (Exception e) {
//                                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
//                                Log.i(TAG, "onResponse: catch -- " + e.getLocalizedMessage());
//                            }

//                            List<RegisteredUser> contacts;
//                            Type listType = new TypeToken<List<RegisteredUser>>() {
//                            }.getType();
//                            contacts= new Gson().fromJson(ProductImage.valueOf(response.body().getRegisteredUser()), listType);
//
//                            Log.i(TAG, "onResponse: uuuu"+ contacts.toString());

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