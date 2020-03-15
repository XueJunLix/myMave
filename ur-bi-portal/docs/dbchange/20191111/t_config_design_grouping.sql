
CREATE TABLE `t_config_design_grouping` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `design_grouping` varchar(10) NOT NULL COMMENT '设计分组',
  `serial` varchar(10) DEFAULT '' COMMENT '系列',
  `original_serial` varchar(10) DEFAULT '' COMMENT '原系列',
  `style` varchar(10) DEFAULT '' COMMENT '风格',
  `goods_level` varchar(10) DEFAULT '' COMMENT '商品层',
  `category` varchar(10) DEFAULT '' COMMENT '品类',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(50) NOT NULL COMMENT '创建者',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `modify_by` varchar(50) NOT NULL COMMENT '修改者',
  PRIMARY KEY (`id`),
  KEY `Index_1` (`design_grouping`) USING BTREE,
  KEY `Index_2` (`serial`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8 COMMENT='bi设计分组配置'