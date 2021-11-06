package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class ProductImages {

	@SerializedName("image")
	private String latestProductImage;

	@SerializedName("image_order")
	private String latestProductImageOrder;

	public void setLatestProductImage(String latestProductImage){
		this.latestProductImage = latestProductImage;
	}

	public String getLatestProductImage(){
		return latestProductImage;
	}

	public void setLatestProductImageOrder(String latestProductImageOrder){
		this.latestProductImageOrder = latestProductImageOrder;
	}

	public String getLatestProductImageOrder(){
		return latestProductImageOrder;
	}

	@Override
 	public String toString(){
		return 
			"ProductImages{" +
			"image = '" + latestProductImage + '\'' +
			",image_order = '" + latestProductImageOrder + '\'' +
			"}";
		}
}