package com.store.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderItemRequest
{
    @NotNull(message = "Required")
    private String productId;

    @NotNull(message = "Quantity is Required")
    @Min(value = 1, message = "Qunatity Should be Greater than 1")
    private Integer quantity;


}
