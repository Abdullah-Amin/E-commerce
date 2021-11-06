package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class ProductSizes {

	@SerializedName("name")
	private String latestProductSizeName;

	@SerializedName("id")
	private int latestProductSizeId;

	public void setLatestProductSizeName(String latestProductSizeName){
		this.latestProductSizeName = latestProductSizeName;
	}

	public String getLatestProductSizeName(){
		return latestProductSizeName;
	}

	public void setLatestProductSizeId(int latestProductSizeId){
		this.latestProductSizeId = latestProductSizeId;
	}

	public int getLatestProductSizeId(){
		return latestProductSizeId;
	}

	@Override
 	public String toString(){
		return 
			"ProductSizes{" +
			"name = '" + latestProductSizeName + '\'' +
			",id = '" + latestProductSizeId + '\'' +
			"}";
		}
}