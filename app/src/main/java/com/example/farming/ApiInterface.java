package com.example.farming;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


@GET("/trader_erp/api/product")
    Call<ResponseArray> getproduct();


}
