package com.abdullah.e_commerce.model.data_classes;

import com.google.gson.annotations.SerializedName;

public class DetailsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("desc")
	private String desc;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}

	public String getDesc(){
		return desc;
	}

	@Override
 	public String toString(){
		return 
			"DetailsItem{" + 
			"name = '" + name + '\'' + 
			",desc = '" + desc + '\'' + 
			"}";
		}
}