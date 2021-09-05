package com.abdullah.e_commerce.ui.search_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.databinding.ActivitySearchResultBinding;

public class SearchResultActivity extends AppCompatActivity {

    ActivitySearchResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_result);


        binding.activitySearchResultFilterIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(new FilterDialogFragment(), "filterDialogFragment")
                        .commit();

//                new FilterDialogFragment().getDialog().getWindow().setGravity(Gravity.END);
//                WindowManager.LayoutParams p = new FilterDialogFragment().getDialog().getWindow().getAttributes();
//                p.width = ViewGroup.LayoutParams.WRAP_CONTENT;
//                p.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE;
//                p.x = 200;
//                new FilterDialogFragment().getDialog().getWindow().setAttributes(p);

            }
        });
    }

    public void click(View view) {
    }
}