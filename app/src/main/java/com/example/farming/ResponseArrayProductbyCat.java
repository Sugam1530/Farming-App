package com.example.farming;

import java.util.List;

public class ResponseArrayProductbyCat {

    private List<ProductbyCategoryOverview> response ;

    public ResponseArrayProductbyCat()
    {}

    ResponseArrayProductbyCat(List<ProductbyCategoryOverview> response)
    {
        this.response = response;
    }

    public List<ProductbyCategoryOverview> getResponse()
    {
        return this.response;
    }
}
