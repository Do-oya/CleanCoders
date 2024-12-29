package com.example.atddorder.application;

import com.example.atddorder.domain.PendingOrder;

public interface CreateOrderService {
    default PendingOrder createPendingOrder(PendingOrderRequest request) {
        return null;
    }
}
