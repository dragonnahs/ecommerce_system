-- 订单表
CREATE TABLE `order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(64) NOT NULL COMMENT '订单编号',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `order_status` tinyint NOT NULL COMMENT '订单状态：0-待付款 1-待发货 2-待收货 3-已完成 4-已取消',
  `total_amount` decimal(10,2) NOT NULL COMMENT '订单总金额',
  `pay_amount` decimal(10,2) NOT NULL COMMENT '应付金额',
  `freight_amount` decimal(10,2) NOT NULL COMMENT '运费金额',
  `pay_type` tinyint COMMENT '支付方式：1-支付宝 2-微信',
  `pay_time` datetime COMMENT '支付时间',
  `delivery_time` datetime COMMENT '发货时间',
  `receive_time` datetime COMMENT '确认收货时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_order_sn` (`order_sn`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

-- 订单商品表
CREATE TABLE `order_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint NOT NULL COMMENT '订单id',
  `order_sn` varchar(64) NOT NULL COMMENT '订单编号',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `product_name` varchar(255) NOT NULL COMMENT '商品名称',
  `product_pic` varchar(255) COMMENT '商品图片',
  `product_price` decimal(10,2) NOT NULL COMMENT '销售价格',
  `product_quantity` int NOT NULL COMMENT '购买数量',
  PRIMARY KEY (`id`),
  KEY `idx_order_sn` (`order_sn`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单商品表'; 