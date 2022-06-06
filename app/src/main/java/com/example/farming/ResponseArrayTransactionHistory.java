package com.example.farming;

import java.util.List;

public class ResponseArrayTransactionHistory {

    private List<TransactionHistoryOverview> response;

    public ResponseArrayTransactionHistory()
    {}

    ResponseArrayTransactionHistory(List<TransactionHistoryOverview> response){
        this.response = response;
    }

    public List<TransactionHistoryOverview> getResponse()
    {
        return this.response;
    }
}
