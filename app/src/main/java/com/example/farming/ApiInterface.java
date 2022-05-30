package com.example.farming;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {


@GET("api/product/getall")
    Call<ResponseArrayProductOverview> getproduct();

@GET("api/category/getall")
    Call<ResponseArrayCategoryOverview> getcategory();

@GET("api/product/getsingleproduct/{num}")
    Call<ResponseArraySingleProductOverview> getSingleProductDetails(@Path("num") int num);

}
