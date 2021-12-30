package com.abdullah.e_commerce.ui.profile_ui;

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
import android.widget.Toast;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.FragmentMoreBinding;
import com.abdullah.e_commerce.model.responses.LogoutResponse;
import com.abdullah.e_commerce.network.RetrofitSingleton;
import com.abdullah.e_commerce.network.SharedPref;
import com.abdullah.e_commerce.ui.main_ui.HomeActivity;
import com.abdullah.e_commerce.ui.main_ui.MainActivity;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoreFragment extends Fragment {


    FragmentMoreBinding binding;
    NavController navController;

    private static final String TAG = "MoreFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_more, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        binding.fragmentMoreLogoutBtn.setOnClickListener(v->{
            connectAndLogout();
        });
    }

    private void connectAndLogout() {
        RetrofitSingleton.connect().logout(getToken())
                .enqueue(new Callback<LogoutResponse>() {
                    @Override
                    public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                        if(response.isSuccessful()){
                            Log.i(TAG, "onResponse: " + response.toString());
//                            navController.navigate(R.id.action_navigation_more_to_loginFragment);
                            SharedPref.clearAll();
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                        }
                        else {
                            Log.i(TAG, "onResponse: "+ response.body().getMessage());
                            Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LogoutResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
                    }
                });
    }

    private String getToken() {
        String token = SharedPref.read("token", null);
        if(token == null || token.isEmpty()){
            Log.i(TAG, "getToken: " + "toke is  -- " + token + " --");
            return null;
        }
        return token;
    }
}