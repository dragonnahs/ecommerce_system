package com.baozi.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baozi.common.result.R;
import com.baozi.product.entity.Product;
import com.baozi.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Resource
    private ProductService productService;

    @GetMapping("/list")
    public R<Page<Product>> list(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String keyword) {
        return R.ok(productService.queryProducts(pageNum, pageSize, keyword));
    }

    @GetMapping("/detail/{id}")
    public R<Product> detail(@PathVariable Long id) {
        return R.ok(productService.getProductById(id));
    }
} 