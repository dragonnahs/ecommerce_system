package com.baozi.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baozi.order.entity.Order;
import com.baozi.order.entity.OrderItem;
import com.baozi.order.mapper.OrderItemMapper;
import com.baozi.order.mapper.OrderMapper;
import com.baozi.order.service.OrderService;
import com.baozi.order.vo.OrderDetailVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Resource
    private OrderMapper orderMapper;
    
    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public Page<Order> queryOrders(Long userId, Integer pageNum, Integer pageSize) {
        Page<Order> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<>();
        
        wrapper.eq(Order::getUserId, userId)
              .orderByDesc(Order::getCreateTime);
        
        return orderMapper.selectPage(page, wrapper);
    }

    @Override
    public OrderDetailVO getOrderDetail(String orderSn) {
        // 查询订单基本信息
        LambdaQueryWrapper<Order> orderWrapper = new LambdaQueryWrapper<>();
        orderWrapper.eq(Order::getOrderSn, orderSn);
        Order order = orderMapper.selectOne(orderWrapper);
        
        if (order == null) {
            return null;
        }
        
        // 查询订单商品信息
        LambdaQueryWrapper<OrderItem> itemWrapper = new LambdaQueryWrapper<>();
        itemWrapper.eq(OrderItem::getOrderSn, orderSn);
        List<OrderItem> orderItems = orderItemMapper.selectList(itemWrapper);
        
        // 组装返回数据
        OrderDetailVO detailVO = new OrderDetailVO();
        detailVO.setOrder(order);
        detailVO.setOrderItems(orderItems);
        
        return detailVO;
    }
} 