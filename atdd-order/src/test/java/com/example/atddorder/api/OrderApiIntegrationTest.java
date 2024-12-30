package com.example.atddorder.api;

import com.example.atddorder.application.PendingOrderResponseDto;
import com.example.atddorder.application.PendingOrderRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderApiIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPendingOrderTest() throws Exception {
        // given
        Long productId = 1L;
        int quantity = 2;
        PendingOrderRequestDto request = PendingOrderRequestDto.of(productId, quantity);


        // when
        MockHttpServletResponse response = mockMvc.perform(post("/orders/pendingOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        PendingOrderResponseDto pendingOrderResponse = objectMapper.readValue(response.getContentAsString(), PendingOrderResponseDto.class);
        assertThat(pendingOrderResponse.getId()).isGreaterThan(0);
    }
}
