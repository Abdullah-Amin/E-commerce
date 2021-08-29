package com.abdullah.e_commerce;

public class SliderItem {

    int productImage;
    String productName;


    public SliderItem(int productImage, String productName) {
//        this.image = image;
        this.productImage = productImage;
        this.productName = productName;
    }

    public int getproductImage() {
        return productImage;
    }

    //    @BindingAdapter({"android:src"})
    public void setproductImage(int productImage) {
        this.productImage = productImage;

//        imageView.setImageResource(productImage);
    }

    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }
}


