package com.abdullah.e_commerce.ui.search_ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
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
import com.abdullah.e_commerce.databinding.FragmentSearchBinding;
import com.abdullah.e_commerce.model.reponses.LoginResponse;
import com.abdullah.e_commerce.model.reponses.SearchResponse;
import com.abdullah.e_commerce.model.requests.SearchRequest;
import com.abdullah.e_commerce.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    FragmentSearchBinding binding;
    NavController navController;

    SearchRequest searchRequest;

    private static final String TAG = "SearchFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        binding.fragmentSearchSearchV.setOnClickListener(v -> {
            navController.navigate(R.id.action_navigation_search_to_searchResultActivity);
        });

        binding.fragmentSearchSearchV.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        connectAndSearch();
    }

    private void connectAndSearch() {
        RetrofitSingleton.connect().search(searchRequest)
                .enqueue(new Callback<SearchResponse>() {
                    @Override
                    public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                        if(response.isSuccessful()){
                            Log.i(TAG, "onResponse: " + response.toString());


                        }
                        else {
                            Log.i(TAG, "onResponse: uuuu ");
                            Toast.makeText(getActivity(), "Invalid Email or Password!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
                    }
                });
    }
}