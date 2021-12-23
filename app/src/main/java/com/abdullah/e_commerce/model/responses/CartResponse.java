package com.abdullah.e_commerce.model.responses;

import java.util.List;

import com.abdullah.e_commerce.model.data_classes.ShowedCartItem;
import com.google.gson.annotations.SerializedName;

public class CartResponse{

	@SerializedName("showedData")
	private List<ShowedCartItem> showedData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setShowedData(List<ShowedCartItem> showedData){
		this.showedData = showedData;
	}

	public List<ShowedCartItem> getShowedData(){
		return showedData;
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
			"CartResponse{" + 
			"showedData = '" + showedData + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}