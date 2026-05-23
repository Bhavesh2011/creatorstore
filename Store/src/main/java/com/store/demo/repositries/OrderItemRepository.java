package com.store.demo.repositries;

import com.store.demo.entities.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItems , Long>
{

}
