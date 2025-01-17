-- 订单测试数据
INSERT INTO `order` (`order_sn`, `user_id`, `order_status`, `total_amount`, `pay_amount`, `freight_amount`)
VALUES 
('202401010001', 1, 1, 6098.00, 5999.00, 99.00),
('202401010002', 1, 2, 13098.00, 12999.00, 99.00);

-- 订单商品测试数据
INSERT INTO `order_item` (`order_id`, `order_sn`, `product_id`, `product_name`, `product_pic`, `product_price`, `product_quantity`)
VALUES 
(1, '202401010001', 1, 'iPhone 15', 'http://example.com/iphone15.jpg', 5999.00, 1),
(2, '202401010002', 2, 'MacBook Pro', 'http://example.com/macbook.jpg', 12999.00, 1); 