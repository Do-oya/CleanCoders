package com.example.atddorder.application;

import lombok.Getter;

@Getter
public class PendingOrderRequest {
    private long productId;
    private int quantity;

    public PendingOrderRequest() {
    }

    public PendingOrderRequest(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public static PendingOrderRequest of(Long productId, int quantity) {
        return new PendingOrderRequest(productId, quantity);
    }
}
