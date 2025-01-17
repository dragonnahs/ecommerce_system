package com.baozi.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baozi.product.entity.Product;
import com.baozi.product.mapper.ProductMapper;
import com.baozi.product.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Resource
    private ProductMapper productMapper;

    @Override
    public Page<Product> queryProducts(Integer pageNum, Integer pageSize, String keyword) {
        Page<Product> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        
        if (StringUtils.isNotBlank(keyword)) {
            wrapper.like(Product::getName, keyword)
                  .or()
                  .like(Product::getDescription, keyword);
        }
        
        wrapper.eq(Product::getStatus, 1) // 只查询上架商品
              .orderByDesc(Product::getCreateTime);
        
        return productMapper.selectPage(page, wrapper);
    }

    @Override
    public Product getProductById(Long id) {
        return productMapper.selectById(id);
    }
} 