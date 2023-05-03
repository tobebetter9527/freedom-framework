drop table if exists user_tb;

CREATE TABLE `user_tb` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_by_name` varchar(255) DEFAULT NULL COMMENT '创建人姓名',
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '更新人',
  `update_by_name` varchar(255) DEFAULT NULL COMMENT '更新人姓名',
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `user_tb` (
	`id`,
	`name`,
	`age`,
	`email`,
	`create_by`,
	`create_by_name`,
	`create_date`,
	`update_by`,
	`update_by_name`,
	`update_date`,
	`version`
)
VALUES
	(
		'1345368146133819649',
		'Mike',
		'30',
		'gaim.com',
		'lu',
		'system',
		'2021-01-02 23:10:42',
		'system2',
		'system2',
		'2021-01-03 09:59:02',
		'5'
	);

