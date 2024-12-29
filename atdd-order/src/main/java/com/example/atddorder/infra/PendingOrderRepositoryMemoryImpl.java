package com.example.atddorder.infra;

import com.example.atddorder.domain.PendingOrder;
import com.example.atddorder.domain.PendingOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PendingOrderRepositoryMemoryImpl implements PendingOrderRepository {
    private final AtomicLong atomicId = new AtomicLong(1);

    @Override
    public PendingOrder save(PendingOrder pendingOrder) {
        pendingOrder.assignId(nextId());
        return pendingOrder;
    }

    private long nextId() {
        return atomicId.getAndIncrement();
    }
}
