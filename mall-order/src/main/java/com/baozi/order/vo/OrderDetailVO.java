package com.baozi.order.vo;

import com.baozi.order.entity.Order;
import com.baozi.order.entity.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailVO {
    private Order order;
    private List<OrderItem> orderItems;
} 