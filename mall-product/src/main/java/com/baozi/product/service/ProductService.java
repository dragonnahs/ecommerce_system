package com.baozi.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baozi.product.entity.Product;

public interface ProductService {
    Page<Product> queryProducts(Integer pageNum, Integer pageSize, String keyword);
    Product getProductById(Long id);
} 