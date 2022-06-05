package com.example.farming;

public class ResponseArrayTotalCartPrice {
    private TotalCartPriceOverview response;

    public ResponseArrayTotalCartPrice()
    {}

    ResponseArrayTotalCartPrice(TotalCartPriceOverview response)
    {this.response = response;}

    public TotalCartPriceOverview getResponse() {return this.response;}
}
