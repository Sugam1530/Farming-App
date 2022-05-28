package com.example.farming;

import java.util.List;

public class ResponseArray {
    private List<PostPojo> response ;

    public ResponseArray()
    {}

    ResponseArray(List<PostPojo> response)
    {
        this.response = response;
    }
}