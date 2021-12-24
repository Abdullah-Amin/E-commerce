package com.abdullah.e_commerce.from_json_to_pojo;

import com.google.gson.annotations.SerializedName;

public class UserId{

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
			"UserId{" + 
			"name = '" + name + '\'' + 
			"}";
		}
}