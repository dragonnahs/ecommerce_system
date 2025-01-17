package com.baozi.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("order_item")
public class OrderItem {
    private Long id;
    private Long orderId;
    private String orderSn;
    private Long productId;
    private String productName;
    private String productPic;
    private BigDecimal productPrice;
    private Integer productQuantity;
} 