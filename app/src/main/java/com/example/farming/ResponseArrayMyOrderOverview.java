package com.example.farming;

import java.util.List;

public class ResponseArrayMyOrderOverview {

    private List<MyOrderOverview> response ;

    public ResponseArrayMyOrderOverview()
    {}

    ResponseArrayMyOrderOverview(List<MyOrderOverview> response)
    {
        this.response = response;
    }

    public List<MyOrderOverview> getResponse()
    {
        return this.response;
    }
}
