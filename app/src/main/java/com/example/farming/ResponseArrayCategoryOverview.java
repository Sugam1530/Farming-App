package com.example.farming;

import java.util.List;

public class ResponseArrayCategoryOverview {
    private List<CategoryOverview> response ;

    public ResponseArrayCategoryOverview()
    {}

    ResponseArrayCategoryOverview(List<CategoryOverview> response)
    {
        this.response = response;
    }

    public List<CategoryOverview> getResponse()
    {
        return this.response;
    }
}