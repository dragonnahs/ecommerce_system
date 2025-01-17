package com.baozi.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baozi.common.result.R;
import com.baozi.order.entity.Order;
import com.baozi.order.service.OrderService;
import com.baozi.order.vo.OrderDetailVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Resource
    private OrderService orderService;

    @GetMapping("/list")
    public R<Page<Order>> list(
            @RequestParam Long userId,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return R.ok(orderService.queryOrders(userId, pageNum, pageSize));
    }

    @GetMapping("/detail/{orderSn}")
    public R<OrderDetailVO> detail(@PathVariable String orderSn) {
        return R.ok(orderService.getOrderDetail(orderSn));
    }
} 