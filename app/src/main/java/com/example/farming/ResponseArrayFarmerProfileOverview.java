package com.example.farming;

import java.util.List;

public class ResponseArrayFarmerProfileOverview {

    private FarmerProfileOverview response;

    public ResponseArrayFarmerProfileOverview()
    {}

   ResponseArrayFarmerProfileOverview(FarmerProfileOverview response) {this.response = response;}

    public FarmerProfileOverview getResponse() {return this.response;}
}
