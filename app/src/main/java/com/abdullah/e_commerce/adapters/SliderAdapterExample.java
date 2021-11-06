package com.abdullah.e_commerce.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.abdullah.e_commerce.R;
import com.abdullah.e_commerce.model.data_classes.ProductImage;
import com.abdullah.e_commerce.model.data_classes.SliderItem;
import com.abdullah.e_commerce.databinding.ImageSliderLayoutItemBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SliderAdapterExample extends
        SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;
    private List<SliderItem> mSliderItems;

    private static final java.lang.String TAG = "SliderAdapterExample";

    public SliderAdapterExample(Context context, List<SliderItem> mSliderItems) {
        this.context = context;
        this.mSliderItems = mSliderItems;
    }

    public void renewItems(List<SliderItem> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(SliderItem sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        return new SliderAdapterVH(DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.image_slider_layout_item, parent, false));
    }

    public String getImages(SliderItem image){
        return image.getProductImage();
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        SliderItem sliderItem = mSliderItems.get(position);

        Log.i(TAG, "onBindViewHolder: "+ sliderItem.getProductImage().toString());

        Picasso
                .get()
                .load(java.lang.String.valueOf(sliderItem.getProductImage().toString()))
                .placeholder(R.drawable.place_holder_image)
                .into(viewHolder.binding.imageSliderLayoutItemIv);



//        viewHolder.binding.imageSliderLayoutItemTv.setText(sliderItem.productName);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    static class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        ImageSliderLayoutItemBinding binding;

        public SliderAdapterVH(ImageSliderLayoutItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }

}
