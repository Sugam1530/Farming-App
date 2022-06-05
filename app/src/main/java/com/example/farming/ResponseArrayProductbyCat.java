package com.example.farming;

public class ResponseArrayProductbyCat {

    private ProductbyCategoryOverview response ;

    public ResponseArrayProductbyCat()
    {}

    ResponseArrayProductbyCat(ProductbyCategoryOverview response)
    {
        this.response = response;
    }

    public ProductbyCategoryOverview getResponse()
    {
        return this.response;
    }
}
