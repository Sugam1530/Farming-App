package com.example.farming;

public class ApplyCouponOverview {

    private String id;
    private String coupon_name;
    private String discount_percentage;
    private String limit_usage;
    private String is_active;
    private String created_at;
    private String updated_at;

    public ApplyCouponOverview()
    {}

    public ApplyCouponOverview(String id, String coupon_name, String discount_percentage, String limit_usage, String is_active, String created_at, String updated_at){
        this.id = id;
        this.coupon_name = coupon_name;
        this.discount_percentage = discount_percentage;
        this.limit_usage = limit_usage;
        this.is_active = is_active;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }


    // Getter Methods

    public String getId() {
        return id;
    }

    public String getCoupon_name() {
        return coupon_name;
    }

    public String getDiscount_percentage() {
        return discount_percentage;
    }

    public String getLimit_usage() {
        return limit_usage;
    }

    public String getIs_active() {
        return is_active;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setCoupon_name(String coupon_name) {
        this.coupon_name = coupon_name;
    }

    public void setDiscount_percentage(String discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public void setLimit_usage(String limit_usage) {
        this.limit_usage = limit_usage;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
