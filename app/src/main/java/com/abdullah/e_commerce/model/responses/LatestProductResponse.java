package com.abdullah.e_commerce.model.responses;

import androidx.annotation.NonNull;

import java.util.List;

import com.abdullah.e_commerce.model.data_classes.ProductItem;
import com.google.gson.annotations.SerializedName;

public class LatestProductResponse{

	@SerializedName("data")
	private List<ProductItem> latestProductData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setLatestProductData(List<ProductItem> latestProductData){
		this.latestProductData = latestProductData;
	}

	public List<ProductItem> getLatestProductData(){
		return latestProductData;
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

	@NonNull
	@Override
 	public String toString(){
		return 
			"LatestProductResponse{" + 
			"data = '" + latestProductData + '\'' +
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}