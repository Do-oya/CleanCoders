package com.example.atddorder.api;

import com.example.atddorder.application.CreateOrderService;
import com.example.atddorder.application.PendingOrderRequestDto;
import com.example.atddorder.application.PendingOrderResponseDto;
import com.example.atddorder.domain.PendingOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderApiController {
    private final CreateOrderService createOrderService;

    @PostMapping("/orders/pendingOrder")
    public ResponseEntity<PendingOrderResponseDto> createPendingOrder(@RequestBody PendingOrderRequestDto request) {
        PendingOrder pendingOrder = createOrderService.createPedingOroder(request);
        PendingOrderResponseDto response = new PendingOrderResponseDto(pendingOrder);
        return ResponseEntity.ok(response);
    }
}
