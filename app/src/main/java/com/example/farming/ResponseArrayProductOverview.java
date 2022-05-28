package com.example.farming;

import java.util.List;

public class ResponseArrayProductOverview {
    private List<ProductOverview> response ;

    public ResponseArrayProductOverview()
    {}

    ResponseArrayProductOverview(List<ProductOverview> response)
    {
        this.response = response;
    }

    public List<ProductOverview> getResponse()
    {
        return this.response;
    }
}