package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class ImagesItem{

	@SerializedName("image")
	private String image;

	@SerializedName("image_order")
	private String imageOrder;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setImageOrder(String imageOrder){
		this.imageOrder = imageOrder;
	}

	public String getImageOrder(){
		return imageOrder;
	}

	@Override
 	public String toString(){
		return 
			"ImagesItem{" + 
			"image = '" + image + '\'' + 
			",image_order = '" + imageOrder + '\'' + 
			"}";
		}
}