# 根据URL访问地址,动态切换数据源

### 初始化数据库
```
DROP database IF EXISTS dy_test_db ;
DROP database IF EXISTS dy_prod_db ;
DROP database IF EXISTS dy_dev_dp ;
CREATE database dy_test_db;
CREATE database dy_prod_db;
CREATE database dy_dev_dp;

USE dy_test_db;
CREATE TABLE `userinfo` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
INSERT INTO `userinfo` VALUES ('a', '测试环境用户', '');

USE dy_prod_db;
CREATE TABLE `userinfo` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
INSERT INTO `userinfo` VALUES ('a', '生产环境用户', '');

USE dy_dev_dp;
CREATE TABLE `userinfo` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
INSERT INTO `userinfo` VALUES ('a', '开发环境用户', '');
```

### 测试地址,根据URL不同,访问不同的数据库
`http://127.0.0.1:8888/gloom/product/user/users`
`http://127.0.0.1:8888/gloom/test/user/users`
`http://127.0.0.1:8888/gloom/develop/user/users`

