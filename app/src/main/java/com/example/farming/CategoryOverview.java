package com.example.farming;

public class CategoryOverview {

    private String id;
    private String name;
    private String is_active;
    private String created_at;
    private String updated_at;


    public CategoryOverview()
    {
    }

    public CategoryOverview(String id, String category_name, String is_active, String created_at, String updated_at)
    {
        this.id = id;
        this.name = category_name ;
        this.is_active = is_active;
        this.created_at = created_at;
        this.updated_at = updated_at ;
    }

    // Getter Methods

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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
