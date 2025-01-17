package com.baozi.admin.feign;

import com.baozi.common.result.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baozi.product.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mall-product", path = "/product")
public interface ProductFeignClient {
    
    @GetMapping("/list")
    R<Page<Product>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                         @RequestParam(defaultValue = "10") Integer pageSize,
                         @RequestParam(required = false) String keyword);
    
    @GetMapping("/detail/{id}")
    R<Product> detail(@PathVariable Long id);
} 