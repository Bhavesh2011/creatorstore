package com.store.demo.services;

import com.store.demo.dto.OrderItemRequest;
import com.store.demo.dto.OrderRequest;
import com.store.demo.entities.Order;
import com.store.demo.entities.OrderItems;
import com.store.demo.entities.Product;
import com.store.demo.repositries.OrderRepository;
import com.store.demo.repositries.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService
{
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Order createOrder(OrderRequest orderRequest)
    {
        List<OrderItems> orderItemsList = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;

        Order order = new Order();

        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("Confirmed");

        for (OrderItemRequest itemRequest : orderRequest.getItems())
        {
            Product product = productRepository
                    .findById(Long.valueOf(itemRequest.getProductId()))
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getStockQuantity() < itemRequest.getQuantity())
            {
                throw new RuntimeException("Not Enough Stock");
            }

            BigDecimal priceOfItem = product.getPrice()
                    .multiply(BigDecimal.valueOf(itemRequest.getQuantity()));

            totalPrice = totalPrice.add(priceOfItem);

            product.setStockQuantity(
                    product.getStockQuantity() - itemRequest.getQuantity()
            );

            productRepository.save(product);

            OrderItems orderItem = OrderItems.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemRequest.getQuantity())
                    .priceAtPurchase(product.getPrice())
                    .build();

            orderItemsList.add(orderItem);
        }

        order.setTotalPrice(totalPrice);
        order.setOrderItems(orderItemsList);

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders()
    {
        return orderRepository.findAll();
    }
    public Order getOrderById(Long id)
    {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}