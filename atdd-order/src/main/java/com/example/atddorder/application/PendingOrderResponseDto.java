package com.example.atddorder.application;

import com.example.atddorder.domain.PendingOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class PendingOrderResponseDto {
    private long id;
    private long productId;
    private int quantity;

    public PendingOrderResponseDto(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    

    public PendingOrderResponseDto(PendingOrder pendingOrder) {
        this.id = pendingOrder.getId();
        this.productId = pendingOrder.getProductId();
        this.quantity = pendingOrder.getQuantity();
    }
}
