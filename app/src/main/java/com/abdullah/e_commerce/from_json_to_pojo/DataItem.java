package com.abdullah.e_commerce.from_json_to_pojo;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("quantity")
	private String quantity;

	@SerializedName("user_id")
	private UserId userId;

	@SerializedName("product_id")
	private ProductId productId;

	public void setQuantity(String quantity){
		this.quantity = quantity;
	}

	public String getQuantity(){
		return quantity;
	}

	public void setUserId(UserId userId){
		this.userId = userId;
	}

	public UserId getUserId(){
		return userId;
	}

	public void setProductId(ProductId productId){
		this.productId = productId;
	}

	public ProductId getProductId(){
		return productId;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"quantity = '" + quantity + '\'' + 
			",user_id = '" + userId + '\'' + 
			",product_id = '" + productId + '\'' + 
			"}";
		}
}