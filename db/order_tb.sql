-- fr_order.order_tb definition
drop table if exists order_tb;
CREATE TABLE `order_tb` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `order_name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_by_name` varchar(255) DEFAULT NULL COMMENT '创建人姓名',
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_by_name` varchar(255) DEFAULT NULL COMMENT '更新人姓名',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;