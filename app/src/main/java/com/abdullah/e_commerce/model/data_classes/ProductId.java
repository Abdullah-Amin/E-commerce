package com.abdullah.e_commerce.model.data_classes;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductId{

	@SerializedName("images")
	private List<ImagesItem> images;

	@SerializedName("item_image_url")
	private String itemImageUrl;

	@SerializedName("sizes")
	private List<SizesItem> sizes;

	@SerializedName("color")
	private List<ColorItem> color;

	@SerializedName("item_id")
	private int itemId;

	@SerializedName("price")
	private String price;

	@SerializedName("review")
	private List<ReviewItem> review;

	@SerializedName("description")
	private String description;

	@SerializedName("discount")
	private String discount;

	@SerializedName("item_name")
	private String itemName;

	@SerializedName("details")
	private List<Object> details;

	@SerializedName("price_after_discount")
	private String priceAfterDiscount;

	public void setImages(List<ImagesItem> images){
		this.images = images;
	}

	public List<ImagesItem> getImages(){
		return images;
	}

	public void setItemImageUrl(String itemImageUrl){
		this.itemImageUrl = itemImageUrl;
	}

	public String getItemImageUrl(){
		return itemImageUrl;
	}

	public void setSizes(List<SizesItem> sizes){
		this.sizes = sizes;
	}

	public List<SizesItem> getSizes(){
		return sizes;
	}

	public void setColor(List<ColorItem> color){
		this.color = color;
	}

	public List<ColorItem> getColor(){
		return color;
	}

	public void setItemId(int itemId){
		this.itemId = itemId;
	}

	public int getItemId(){
		return itemId;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setReview(List<ReviewItem> review){
		this.review = review;
	}

	public List<ReviewItem> getReview(){
		return review;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setDiscount(String discount){
		this.discount = discount;
	}

	public String getDiscount(){
		return discount;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public String getItemName(){
		return itemName;
	}

	public void setDetails(List<Object> details){
		this.details = details;
	}

	public List<Object> getDetails(){
		return details;
	}

	public void setPriceAfterDiscount(String priceAfterDiscount){
		this.priceAfterDiscount = priceAfterDiscount;
	}

	public String getPriceAfterDiscount(){
		return priceAfterDiscount;
	}

	@Override
 	public String toString(){
		return 
			"ProductId{" + 
			"images = '" + images + '\'' + 
			",item_image_url = '" + itemImageUrl + '\'' + 
			",sizes = '" + sizes + '\'' + 
			",color = '" + color + '\'' + 
			",item_id = '" + itemId + '\'' + 
			",price = '" + price + '\'' + 
			",review = '" + review + '\'' + 
			",description = '" + description + '\'' + 
			",discount = '" + discount + '\'' + 
			",item_name = '" + itemName + '\'' + 
			",details = '" + details + '\'' + 
			",price_after_discount = '" + priceAfterDiscount + '\'' + 
			"}";
		}
}