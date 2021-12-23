package com.abdullah.e_commerce.from_json_to_pojo;

import com.google.gson.annotations.SerializedName;

public class ColorItem{

	@SerializedName("colorid")
	private String colorid;

	public void setColorid(String colorid){
		this.colorid = colorid;
	}

	public String getColorid(){
		return colorid;
	}

	@Override
 	public String toString(){
		return 
			"ColorItem{" + 
			"colorid = '" + colorid + '\'' + 
			"}";
		}
}