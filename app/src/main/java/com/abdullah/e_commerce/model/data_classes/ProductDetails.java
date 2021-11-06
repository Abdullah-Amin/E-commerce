package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class ProductDetails {

	@SerializedName("name")
	private String latestProductName;

	@SerializedName("desc")
	private String latestProductDescription;

	public void setLatestProductName(String latestProductName){
		this.latestProductName = latestProductName;
	}

	public String getLatestProductName(){
		return latestProductName;
	}

	public void setLatestProductDescription(String latestProductDescription){
		this.latestProductDescription = latestProductDescription;
	}

	public String getLatestProductDescription(){
		return latestProductDescription;
	}

	@Override
 	public String toString(){
		return 
			"ProductDetails{" +
			"name = '" + latestProductName + '\'' +
			",desc = '" + latestProductDescription + '\'' +
			"}";
		}
}