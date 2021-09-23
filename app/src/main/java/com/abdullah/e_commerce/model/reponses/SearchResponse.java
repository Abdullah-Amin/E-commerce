package com.abdullah.e_commerce.model.reponses;

import com.abdullah.e_commerce.model.data_classes.SearchedProducts;

import java.util.List;

public class SearchResponse {

    public boolean status;
    public String message;
    List<SearchedProducts> searchedProducts;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<SearchedProducts> getSearchedProducts() {
        return searchedProducts;
    }

    public void setSearchedProducts(List<SearchedProducts> searchedProducts) {
        this.searchedProducts = searchedProducts;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", searchedProducts=" + searchedProducts +
                '}';
    }
}
