package com.example.farming;

import java.util.List;

public class ResponseArrayTotalCartPrice {
    private List<TotalCartPriceOverview> response;

    public ResponseArrayTotalCartPrice()
    {}

    ResponseArrayTotalCartPrice(List<TotalCartPriceOverview> response)
    {this.response = response;}

    public List<TotalCartPriceOverview> getResponse() {return this.response;}
}
