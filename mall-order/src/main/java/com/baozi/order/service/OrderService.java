package com.baozi.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baozi.order.entity.Order;
import com.baozi.order.vo.OrderDetailVO;

public interface OrderService {
    Page<Order> queryOrders(Long userId, Integer pageNum, Integer pageSize);
    OrderDetailVO getOrderDetail(String orderSn);
} 