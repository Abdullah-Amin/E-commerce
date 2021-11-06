package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class ProductImage {

	@SerializedName("image")
	private String productImage;

	@SerializedName("image_order")
	private String productImageOrder;

	public void setProductImage(String productImage){
		this.productImage = productImage;
	}

	public String getProductImage(){
		return productImage;
	}

	public void setProductImageOrder(String productImageOrder){
		this.productImageOrder = productImageOrder;
	}

	public String getProductImageOrder(){
		return productImageOrder;
	}

	@Override
 	public String toString(){
		return 
			"ProductImage{" +
			"image = '" + productImage + '\'' +
			",image_order = '" + productImageOrder + '\'' +
			"}";
		}
}