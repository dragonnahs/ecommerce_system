package com.baozi.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("product")
public class Product {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String pictureUrl;
    private Integer status; // 0-下架 1-上架
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
} 