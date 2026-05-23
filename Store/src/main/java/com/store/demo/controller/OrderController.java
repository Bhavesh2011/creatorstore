package com.store.demo.controller;

import com.store.demo.dto.OrderRequest;
import com.store.demo.entities.Order;
import com.store.demo.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor

public class OrderController
{
    private final OrderService orderService;

    @PostMapping
    public Order createOrder(@Valid @RequestBody OrderRequest orderRequest)
    {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping
    public List<Order> getAllOrders()
    {
        return orderService.getAllOrders();
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id)
    {
        return orderService.getOrderById(id);
    }
}
