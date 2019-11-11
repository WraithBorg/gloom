
根据域名动态切换数据源

http://127.0.0.1:8080/html/index.html

http://127.0.0.1:8080/user/users?projectCode=project_001
http://127.0.0.1:8080/user/users?projectCode=project_002
CREATE database userin;
CREATE database userout;

CREATE TABLE `userinfo` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('a', 'a', '`');
INSERT INTO `userinfo` VALUES ('b', 'b', '1');
INSERT INTO `userinfo` VALUES ('c', 'c', '2');