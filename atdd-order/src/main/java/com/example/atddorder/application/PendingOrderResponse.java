package com.example.atddorder.application;

import com.example.atddorder.domain.PendingOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class PendingOrderResponse {
    private long id;
    private long productId;
    private int quantity;

    public PendingOrderResponse(PendingOrder pendingOrder) {
        this.id = pendingOrder.getId();
        this.productId = pendingOrder.getProductId();
        this.quantity = pendingOrder.getQuantity();
    }

    public PendingOrderResponse(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
