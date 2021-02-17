CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_by` varchar(64) DEFAULT NULL,
  `create_by_name` varchar(64) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(64) DEFAULT NULL,
  `update_by_name` varchar(255) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` (
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

