package com.example.farming;

public class GetAllCartProduct {

    private String cart_id;
    private String product_id;
    private String product_name;
    private String sp;
    private String image;

    public GetAllCartProduct()
    {
    }

    public GetAllCartProduct(String cart_id, String product_id, String product_name, String sp, String image)
    {
        this.cart_id = cart_id;
        this.product_name = product_name;
        this.product_id = product_id;
        this.sp = sp;
        this.image = image;
    }


    // Getter Methods

    public String getCart_id() {
        return cart_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getSp() {
        return sp;
    }

    public String getImage() {
        return image;
    }

    // Setter Methods

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
