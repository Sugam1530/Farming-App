package com.example.farming;

import Adapters.FarmerLoginOverview;

public class ResponseArrayFarmerLoginOverview {

    private int status;
    private FarmerLoginOverview response;
    public ResponseArrayFarmerLoginOverview()
    {}

    ResponseArrayFarmerLoginOverview(FarmerLoginOverview response,int status) {this.response = response; this.status = status;}
    public FarmerLoginOverview getResponse() { return this.response;}
    public int getStatus() { return this.status;}

}
