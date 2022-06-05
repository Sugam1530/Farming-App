package com.example.farming;

public class ProductbyCategoryOverview {

    private String id;
    private String cat_id;
    private String product_name;
    private String product_details;
    private String image;
    private String mrp;
    private String sp;
    private String is_featured;
    private String is_active;
    private String created_at;
    private String updated_at;

    public ProductbyCategoryOverview()
    {}

    public ProductbyCategoryOverview(String id, String cat_id, String product_name, String product_details, String image, String mrp, String sp, String is_active, String is_featured, String created_at, String updated_at){
        this.id = id;
        this.cat_id = cat_id;
        this.product_details = product_details;
        this.product_name = product_name;
        this.image = image;
        this.mrp = mrp;
        this.sp = sp;
        this.is_active = is_active;
        this.is_featured = is_featured;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }


    // Getter Methods

    public String getId() {
        return id;
    }

    public String getCat_id() {
        return cat_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_details() {
        return product_details;
    }

    public String getImage() {
        return image;
    }

    public String getMrp() {
        return mrp;
    }

    public String getSp() {
        return sp;
    }

    public String getIs_featured() {
        return is_featured;
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

    public void setImage(String image) {
        this.image = image;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public void setIs_featured(String is_featured) {
        this.is_featured = is_featured;
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
