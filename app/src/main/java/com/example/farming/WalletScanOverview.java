package com.example.farming;

public class WalletScanOverview {
    private String response;

    public WalletScanOverview()
    {}

    public WalletScanOverview(String response){
        this.response = response;
    }


    // Getter Methods

    public String getResponse() {
        return response;
    }

    // Setter Methods

    public void setResponse(String response) {
        this.response = response;
    }
}
