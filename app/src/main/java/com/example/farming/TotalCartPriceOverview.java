package com.example.farming;

public class TotalCartPriceOverview {
    private String total_sum;

    public  TotalCartPriceOverview()
    {}

    public TotalCartPriceOverview(String total_sum) {
        this.total_sum = total_sum;
    }


    // Getter Methods

    public String getTotal_sum() {
        return total_sum;
    }

    // Setter Methods

    public void setTotal_sum(String total_sum) {
        this.total_sum = total_sum;
    }
}
