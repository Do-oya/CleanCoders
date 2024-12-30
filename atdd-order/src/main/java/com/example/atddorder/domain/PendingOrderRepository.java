package com.example.atddorder.domain;

import org.springframework.stereotype.Repository;

@Repository
public interface PendingOrderRepository {
    PendingOrder save(PendingOrder pendingOrder);
}
