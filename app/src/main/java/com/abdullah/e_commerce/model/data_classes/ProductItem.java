package com.abdullah.e_commerce.model.data_classes;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ProductItem {

	@SerializedName("images")
	private List<ProductImage> productImages;

	@SerializedName("item_image_url")
	private String latestProductImageUrl;

	@SerializedName("sizes")
	private List<ProductSizes> productSizes;

	@SerializedName("color")
	private List<ProductColor> productColor;

	@SerializedName("item_id")
	private int latestProductId;

	@SerializedName("price")
	private String latestProductPrice;

	@SerializedName("review")
	private List<ProductReviews> latestProductReviews;

	@SerializedName("description")
	private String latestProductDescription;

	@SerializedName("discount")
	private String latestProductDiscount;

	@SerializedName("item_name")
	private String latestProductName;

	@SerializedName("details")
	private List<ProductDetails> latestProductDetails;

	@SerializedName("price_after_discount")
	private String latestProductPriceAfterDiscount;

	public void setLatestProductImages(List<ProductImage> productImages){
		this.productImages = productImages;
	}

	public List<ProductImage> getLatestProductImages(){
		return productImages;
	}

	public void setLatestProductImageUrl(String latestProductImageUrl){
		this.latestProductImageUrl = latestProductImageUrl;
	}

	public String getLatestProductImageUrl(){
		return latestProductImageUrl;
	}

	public void setLatestProductSizes(List<ProductSizes> productSizes){
		this.productSizes = productSizes;
	}

	public List<ProductSizes> getLatestProductSizes(){
		return productSizes;
	}

	public void setLatestProductColor(List<ProductColor> productColor){
		this.productColor = productColor;
	}

	public List<ProductColor> getLatestProductColor(){
		return productColor;
	}

	public void setLatestProductId(int latestProductId){
		this.latestProductId = latestProductId;
	}

	public int getLatestProductId(){
		return latestProductId;
	}

	public void setLatestProductPrice(String latestProductPrice){
		this.latestProductPrice = latestProductPrice;
	}

	public String getLatestProductPrice(){
		return latestProductPrice;
	}

	public void setLatestProductReviews(List<ProductReviews> latestProductReviews){
		this.latestProductReviews = latestProductReviews;
	}

	public List<ProductReviews> getLatestProductReviews(){
		return latestProductReviews;
	}

	public void setLatestProductDescription(String latestProductDescription){
		this.latestProductDescription = latestProductDescription;
	}

	public String getLatestProductDescription(){
		return latestProductDescription;
	}

	public void setLatestProductDiscount(String latestProductDiscount){
		this.latestProductDiscount = latestProductDiscount;
	}

	public String getLatestProductDiscount(){
		return latestProductDiscount;
	}

	public void setLatestProductName(String latestProductName){
		this.latestProductName = latestProductName;
	}

	public String getLatestProductName(){
		return latestProductName;
	}

	public void setLatestProductDetails(List<ProductDetails> latestProductDetails){
		this.latestProductDetails = latestProductDetails;
	}

	public List<ProductDetails> getLatestProductDetails(){
		return latestProductDetails;
	}

	public void setLatestProductPriceAfterDiscount(String latestProductPriceAfterDiscount){
		this.latestProductPriceAfterDiscount = latestProductPriceAfterDiscount;
	}

	public String getLatestProductPriceAfterDiscount(){
		return latestProductPriceAfterDiscount;
	}

	@Override
 	public java.lang.String toString(){
		return
			"DataItem{" +
			"images = '" + productImages + '\'' +
			",item_image_url = '" + latestProductImageUrl + '\'' +
			",sizes = '" + productSizes + '\'' +
			",color = '" + productColor + '\'' +
			",item_id = '" + latestProductId + '\'' +
			",price = '" + latestProductPrice + '\'' +
			",review = '" + latestProductReviews + '\'' +
			",description = '" + latestProductDescription + '\'' +
			",discount = '" + latestProductDiscount + '\'' +
			",item_name = '" + latestProductName + '\'' +
			",details = '" + latestProductDetails + '\'' +
			",price_after_discount = '" + latestProductPriceAfterDiscount + '\'' +
			"}";
		}
}