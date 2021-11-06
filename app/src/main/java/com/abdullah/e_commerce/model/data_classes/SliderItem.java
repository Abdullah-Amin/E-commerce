package com.abdullah.e_commerce.model.data_classes;

public class SliderItem {

    private String productImage;
//    public ProductImage productName;


    public SliderItem(String productImage) {
//        this.image = image;
        this.productImage = productImage;
//        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    //    @BindingAdapter({"android:src"})
    public void setProductImage(String productImage) {
        this.productImage = productImage;

//        imageView.setImageResource(productImage);
    }

//    public ProductImage getProductName() {
//        return productName;
//    }
//
//    public void setProductName(ProductImage productName) {
//        this.productName = productName;
//    }
}


