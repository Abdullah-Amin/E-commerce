package com.abdullah.e_commerce.from_json_to_pojo;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("name")
	private String name;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"name = '" + name + '\'' + 
			"}";
		}
}