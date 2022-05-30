package com.example.farming;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


@GET("trader_erp/api/product")
    Call<ResponseArrayProductOverview> getproduct();

@GET("trader_erp/api/category")
    Call<ResponseArrayCategoryOverview> getcategory();


}
