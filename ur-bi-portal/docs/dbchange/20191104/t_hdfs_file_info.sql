--  Drop table

--  DROP TABLE ur_bi.t_hdfs_file_info;

CREATE TABLE `t_hdfs_file_info` (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `uri` varchar(400) COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件完整的URI',
  `path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件在HDFS上的路径',
  `original_filename` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件的原始文件名',
  `folder` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件的父级目录，用于区分文件的用途',
  `data_date` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件的数据日期（yyyyMMDD）',
  `filename` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件的存放在HDFS上的文件名',
  `size` decimal(20,0) DEFAULT NULL COMMENT '文件的大小（bytes）',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '1-删除，0-未删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者（工号）',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modify_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者（工号）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='文件信息'