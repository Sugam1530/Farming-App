package com.example.farming;

public class FeaturedCategoryOverview {
    private String id;
    private String name;
    private String is_featured;
    private String is_active;
    private String created_at;
    private String updated_at;

    public FeaturedCategoryOverview()
    {}

    public FeaturedCategoryOverview(String name){
        this.name = name;
    }


    // Getter Methods

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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
