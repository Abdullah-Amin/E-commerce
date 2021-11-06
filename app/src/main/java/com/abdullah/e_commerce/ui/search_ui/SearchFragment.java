package com.abdullah.e_commerce.ui.search_ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.FragmentSearchBinding;
import com.abdullah.e_commerce.model.responses.SearchResponse;
import com.abdullah.e_commerce.model.requests.SearchRequest;
import com.abdullah.e_commerce.network.RetrofitSingleton;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    FragmentSearchBinding binding;
    NavController navController;

    private static final String TAG = "SearchFragment";

    CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);

        return binding.getRoot();
    }

    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        binding.fragmentSearchSearchV.setOnClickListener(v -> {
            navController.navigate(R.id.action_navigation_search_to_searchResultActivity);
        });

//        Observable<Object> observable = Observable.create(new ObservableOnSubscribe<Object>() {
//            @Override
//            public void subscribe(@io.reactivex.annotations.NonNull ObservableEmitter<Object> emitter) throws Exception {
//                binding.fragmentSearchSearchEt.addTextChangedListener(new TextWatcher() {
//                    @Override
//                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                        Log.i(TAG, "beforeTextChanged: " + s);
//                    }
//
//                    @Override
//                    public void onTextChanged(CharSequence s, int start, int before, int count) {
//                        emitter.onNext(s);
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable s) {
//                        Log.i(TAG, "afterTextChanged: " + s);
//                    }
//                });
//                emitter.onComplete();
//            }
//        });
//
//        Observer observer = new Observer() {
//            @Override
//            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
//                Log.i(TAG, "onSubscribe: ");
//                disposable.add(d);
//            }
//
//            @Override
//            public void onNext(@io.reactivex.annotations.NonNull Object o) {
//                Log.i(TAG, "onNext: "+o);
//                connectAndSearch(o.toString());
//            }
//
//            @Override
//            public void onError(@io.reactivex.annotations.NonNull Throwable e) {
//                Log.i(TAG, "onError: "+ e.getLocalizedMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.i(TAG, "onComplete: ");
//            }
//        };
//
//        observable.subscribeOn(Schedulers.io())
//                .distinctUntilChanged()
//                .debounce(350, TimeUnit.MILLISECONDS, Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);

        Observable.create(emitter-> {

            binding.fragmentSearchSearchEt.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    Log.i(TAG, "abdo beforeTextChanged: "+ s);
                    Log.i(TAG, "abdo beforeTextChanged: " + Thread.currentThread().getName());
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    emitter.onNext(s);
                    Log.i(TAG, "abdo onTextChanged: "+ s);
                    Log.i(TAG, "abdo onTextChanged: " + Thread.currentThread().getName());
                }

                @Override
                public void afterTextChanged(Editable s) {
                    Log.i(TAG, "abdo afterTextChanged: "+ s);
                    Log.i(TAG, "abdo afterTextChanged: " + Thread.currentThread().getName());
                    emitter.setDisposable(new CompositeDisposable());
                }
            });
        })
                .debounce(1, TimeUnit.SECONDS)
                .distinct()
                .subscribe(s-> {
                    connectAndSearch(s.toString());
                });

    }

    private void connectAndSearch(String stream) {
        RetrofitSingleton.connect().search(new SearchRequest(stream))
                .enqueue(new Callback<SearchResponse>() {
                    @Override
                    public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                        if(response.isSuccessful()){
                            Log.i(TAG, "onResponse: " + response.toString());
                        }
                        else {
                            Log.i(TAG, "onResponse: uuuu ");
                            Toast.makeText(getActivity(), "couldn't find results for " + stream, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchResponse> call, Throwable t) {
                        Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}