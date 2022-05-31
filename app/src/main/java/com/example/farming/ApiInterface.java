package com.example.farming;

import android.app.DownloadManager;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiInterface {


@GET("api/product/getall")
    Call<ResponseArrayProductOverview> getproduct();

@GET("api/category/getall")
    Call<ResponseArrayCategoryOverview> getcategory();

@GET("api/product/getsingleproduct/{num}")
    Call<ResponseArraySingleProductOverview> getSingleProductDetails(@Path("num") int num);

@Multipart
@POST("api/farmer/login")
    Call<ResponseArrayFarmerLoginOverview> postFarmerLogin (@Part("username") RequestBody username, @Part("password") RequestBody password);

}