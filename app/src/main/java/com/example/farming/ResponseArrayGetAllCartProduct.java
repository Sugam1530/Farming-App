package com.example.farming;

import java.util.List;

public class ResponseArrayGetAllCartProduct {

    private List<GetAllCartProduct> response;

    public ResponseArrayGetAllCartProduct(){}

    ResponseArrayGetAllCartProduct(List<GetAllCartProduct> response) {this.response = response;}

    public List<GetAllCartProduct> getResponse() {return this.response = response;}
}
