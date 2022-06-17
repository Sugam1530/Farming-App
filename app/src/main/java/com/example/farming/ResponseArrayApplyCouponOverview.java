package com.example.farming;

public class ResponseArrayApplyCouponOverview {

    private int status;
    private ApplyCouponOverview response;
    private String message;
    public ResponseArrayApplyCouponOverview()
    {}

    ResponseArrayApplyCouponOverview(ApplyCouponOverview response, int status, String message) {this.response = response; this.status = status; this.message = message;}
    public ApplyCouponOverview getResponse() {return this.response;}
    public int getStatus() {return this.status;}
    public String getMessage(){return this.message;}
}
