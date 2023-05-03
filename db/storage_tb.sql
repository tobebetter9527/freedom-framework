drop table if exists storage_tb;
CREATE TABLE `storage_tb` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `product_num` bigint(20) DEFAULT NULL COMMENT '产品数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;