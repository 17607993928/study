SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `weather` (
  `id` bigint NOT NULL,
  `adcode` varchar(255) DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `weather` varchar(255) DEFAULT NULL,
  `temperature` varchar(255) DEFAULT NULL,
  `wind_direction` varchar(255) DEFAULT NULL,
  `wind_power` varchar(255) DEFAULT NULL,
  `humidity` varchar(255) DEFAULT NULL,
  `reporttime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `weather_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
