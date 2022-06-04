package com.example.farming;

import java.util.List;

public class ResponseArrayFeaturedProductOverview {
    private List<FeaturedProductOverview> response;

    ResponseArrayFeaturedProductOverview()
    {}

    public ResponseArrayFeaturedProductOverview(List<FeaturedProductOverview> response) {
        this.response = response;
    }
    public List<FeaturedProductOverview> getResponse()
    {

        return this.response;
    }
}
