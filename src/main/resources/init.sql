/***test1库 */
DROP TABLE IF EXISTS `test_f`;
CREATE TABLE `test_f` (
  `id` int(10) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `test_f` VALUES ('1', '小王', '18');

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES ('test', '098f6bcd4621d373cade4e832627b4f6');
SET FOREIGN_KEY_CHECKS=1;

/***test2库 */
DROP TABLE IF EXISTS `test_g`;
CREATE TABLE `test_g` (
  `id` int(10) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `test_g` VALUES ('1', '小明', '16');
