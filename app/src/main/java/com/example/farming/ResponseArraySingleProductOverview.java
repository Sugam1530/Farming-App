package com.example.farming;

import java.util.List;

public class ResponseArraySingleProductOverview {

    private SingleProductOverview response ;

    public ResponseArraySingleProductOverview()
    {}

    ResponseArraySingleProductOverview(SingleProductOverview response)
    {
        this.response = response;
    }

    public SingleProductOverview getResponse()
    {
        return this.response;
    }
}
