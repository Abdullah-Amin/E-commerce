package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class AddedToCartProductData {

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("product_id")
	private String productId;

	@SerializedName("product_size")
	private int productSize;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("product_color")
	private Object productColor;

	@SerializedName("id")
	private int id;

	@SerializedName("status")
	private int status;

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getProductId(){
		return productId;
	}

	public void setProductSize(int productSize){
		this.productSize = productSize;
	}

	public int getProductSize(){
		return productSize;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setProductColor(Object productColor){
		this.productColor = productColor;
	}

	public Object getProductColor(){
		return productColor;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"AddedToCartProductData{" +
			"quantity = '" + quantity + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",product_id = '" + productId + '\'' + 
			",product_size = '" + productSize + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",product_color = '" + productColor + '\'' + 
			",id = '" + id + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}