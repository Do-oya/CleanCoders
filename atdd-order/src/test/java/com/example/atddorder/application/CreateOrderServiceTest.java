package com.example.atddorder.application;

import com.example.atddorder.domain.PendingOrder;
import com.example.atddorder.domain.PendingOrderRepository;
import com.example.atddorder.infra.PendingOrderRepositoryMemoryImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateOrderServiceTest {
    private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();
    private CreateOrderService createOrderService = new CreateOrderServiceImpl(pendingOrderRepository);

    @Test
    void createPendingOrder() {
        Long productId = 1L;
        int quantity = 2;
        PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);

        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
        assertThat(pendingOrder.getId()).isPositive();
    }
}
