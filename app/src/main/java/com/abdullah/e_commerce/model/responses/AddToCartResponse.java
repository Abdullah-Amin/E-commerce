package com.abdullah.e_commerce.model.responses;

import com.abdullah.e_commerce.model.data_classes.AddedToCartProductData;
import com.google.gson.annotations.SerializedName;

public class AddToCartResponse{

	@SerializedName("addedToCartProductData")
	private AddedToCartProductData addedToCartProductData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setAddedToCartProductData(AddedToCartProductData addedToCartProductData){
		this.addedToCartProductData = addedToCartProductData;
	}

	public AddedToCartProductData getAddedToCartProductData(){
		return addedToCartProductData;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"AddToCartResponse{" + 
			"addedToCartProductData = '" + addedToCartProductData + '\'' +
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}