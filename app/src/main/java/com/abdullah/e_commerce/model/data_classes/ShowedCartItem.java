package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class ShowedCartItem {

	@SerializedName("quantity")
	private String quantity;

	@SerializedName("user_id")
	private UserId userId;

	@SerializedName("product_id")
	private ProductItem productItem;

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

	public void setProductItem(ProductItem productItem){
		this.productItem = productItem;
	}

	public ProductItem getProductId(){
		return productItem;
	}

	@Override
 	public String toString(){
		return 
			"ShowedCartItem{" +
			"quantity = '" + quantity + '\'' + 
			",user_id = '" + userId + '\'' + 
			",product_id = '" + productItem + '\'' +
			"}";
		}
}