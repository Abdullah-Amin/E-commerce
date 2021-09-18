package com.abdullah.e_commerce.model.requests;

import com.google.gson.annotations.SerializedName;

public class SearchRequest {

    @SerializedName("search-name")
    public String searchName;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public String toString() {
        return "SearchRequest{" +
                "searchName='" + searchName + '\'' +
                '}';
    }
}
