package com.baozi.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baozi.admin.feign.ProductFeignClient;
import com.baozi.common.result.R;
import com.baozi.product.entity.Product;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/product")
public class ProductController {
    
    @Resource
    private ProductFeignClient productFeignClient;
    
    @GetMapping("/list")
    public R<Page<Product>> list(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String keyword) {
        return productFeignClient.list(pageNum, pageSize, keyword);
    }
    
    @GetMapping("/detail/{id}")
    public R<Product> detail(@PathVariable Long id) {
        return productFeignClient.detail(id);
    }
} 