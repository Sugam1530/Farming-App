package com.example.farming;

import java.util.List;

public class ResponseArrayFeaturedCategoryOverview {

    private List<FeaturedCategoryOverview> response;

    ResponseArrayFeaturedCategoryOverview()
    {}

    public ResponseArrayFeaturedCategoryOverview(List<FeaturedCategoryOverview> response) {
        this.response = response;
    }

    public List<FeaturedCategoryOverview> getResponse()
    {
        return this.response;
    }
}
