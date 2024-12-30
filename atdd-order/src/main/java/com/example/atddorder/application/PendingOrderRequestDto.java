package com.example.atddorder.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class PendingOrderRequestDto {
    private long productId;
    private int quantity;

    public PendingOrderRequestDto(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public static PendingOrderRequestDto of(Long productId, int quantity) {
        return new PendingOrderRequestDto(productId, quantity);
    }
}
