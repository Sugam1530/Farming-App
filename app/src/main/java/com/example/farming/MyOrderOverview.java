package com.example.farming;

public class MyOrderOverview {

    private String id;
    private String order_id;
    private String total_amount;
    private String coupon_used;
    private String discount_amount;
    private String tax_amount;
    private String tax_percentage;
    private String subtotal_amount;
    private String customer_id;
    private String customer_name;
    private String customer_address;
    private String customer_pincode;
    private String txn_type;
    private String order_status;
    private String created_at;
    private String updated_at;

    public MyOrderOverview()
    {}

    public MyOrderOverview(String id, String order_id, String total_amount, String coupon_used, String discount_amount, String tax_amount, String tax_percentage, String subtotal_amount, String customer_id, String customer_name, String customer_address, String customer_pincode, String txn_type, String order_status, String created_at, String updated_at){
        this.id = id;
        this.order_id = order_id;
        this.total_amount = total_amount;
        this.coupon_used = coupon_used;
        this.discount_amount = discount_amount;
        this.tax_amount = tax_amount;
        this.tax_percentage = tax_percentage;
        this.subtotal_amount = subtotal_amount;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.customer_pincode = customer_pincode;
        this.txn_type = txn_type;
        this.order_status = order_status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }


    // Getter Methods

    public String getId() {
        return id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public String getCoupon_used() {
        return coupon_used;
    }

    public String getDiscount_amount() {
        return discount_amount;
    }

    public String getTax_amount() {
        return tax_amount;
    }

    public String getTax_percentage() {
        return tax_percentage;
    }

    public String getSubtotal_amount() {
        return subtotal_amount;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public String getCustomer_pincode() {
        return customer_pincode;
    }

    public String getTxn_type() {
        return txn_type;
    }

    public String getOrder_status() {
        return order_status;
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

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public void setCoupon_used(String coupon_used) {
        this.coupon_used = coupon_used;
    }

    public void setDiscount_amount(String discount_amount) {
        this.discount_amount = discount_amount;
    }

    public void setTax_amount(String tax_amount) {
        this.tax_amount = tax_amount;
    }

    public void setTax_percentage(String tax_percentage) {
        this.tax_percentage = tax_percentage;
    }

    public void setSubtotal_amount(String subtotal_amount) {
        this.subtotal_amount = subtotal_amount;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public void setCustomer_pincode(String customer_pincode) {
        this.customer_pincode = customer_pincode;
    }

    public void setTxn_type(String txn_type) {
        this.txn_type = txn_type;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
