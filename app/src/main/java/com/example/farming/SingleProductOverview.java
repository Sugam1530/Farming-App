package com.example.farming;

public class SingleProductOverview {

    private String id;
    private String cat_id;
    private String product_name;
    private String product_details;
    private String image;
    private String is_active;
    private String created_at;
    private String updated_at;
    private String mrp;
    private String sp;

    public SingleProductOverview()
    {
    }

    public SingleProductOverview(String id, String cat_id, String product_name, String mrp, String sp, String product_details, String image, String is_active, String created_at, String updated_at)
    {
        this.id = id;
        this.cat_id = cat_id;
        this.product_name = product_name ;
        this.product_details = product_details;
        this.image = image;
        this.is_active = is_active;
        this.created_at = created_at;
        this.updated_at = updated_at ;
        this.mrp = mrp;
        this.sp = sp;
    }


    // Getter Methods

    public String getId() {
        return id;
    }

    public String getCat_id() {
        return cat_id;
    }

    public String getSingleProductDetails_name() {
        return product_name;
    }

    public String getMrp(){
        return mrp;
    }

    public String getSp(){
        return sp;
    }

    public String getSingleProduct_details() {
        return product_details;
    }

    public String getImage() {
        return image;
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

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_details(String product_details) {
        this.product_details = product_details;
    }

    public void setMrp(String mrp){
        this.mrp = mrp;
    }

    public void setSp(String sp){
        this.sp = sp;
    }

    public void setImage(String image) {
        this.image = image;
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
