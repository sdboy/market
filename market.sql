/*
 Navicat Premium Data Transfer

 Source Server         : raspberry
 Source Server Type    : MariaDB
 Source Server Version : 100509
 Source Host           : 192.168.1.4:3306
 Source Schema         : market

 Target Server Type    : MariaDB
 Target Server Version : 100509
 File Encoding         : 65001

 Date: 20/04/2021 01:43:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for MARKET_CART
-- ----------------------------
DROP TABLE IF EXISTS `MARKET_CART`;
CREATE TABLE `MARKET_CART`  (
    `ID` int(11) NOT NULL AUTO_INCREMENT,
    `USER_ID` int(11) NOT NULL,
    `PRODUCT_ID` int(11) NULL DEFAULT NULL COMMENT '商品id',
    `QUANTITY` int(11) NULL DEFAULT NULL COMMENT '数量',
    `CHECKED` int(11) NULL DEFAULT NULL COMMENT '是否选择,1=已勾选,0=未勾选',
    `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
    `UPDATE_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`ID`) USING BTREE,
    INDEX `USER_ID_INDEX`(`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for MARKET_CATEGORY
-- ----------------------------
DROP TABLE IF EXISTS `MARKET_CATEGORY`;
CREATE TABLE `MARKET_CATEGORY`  (
    `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别Id',
    `PARENT_ID` int(11) NULL DEFAULT NULL COMMENT '父类别id当id=0时说明是根节点,一级类别',
    `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
    `STATUS` tinyint(1) NULL DEFAULT 1 COMMENT '类别状态1-正常,2-已废弃',
    `SORT_ORDER` int(4) NULL DEFAULT NULL COMMENT '排序编号,同类展示顺序,数值相等则自然排序',
    `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
    `UPDATE_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100031 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '目录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for MARKET_ORDER
-- ----------------------------
DROP TABLE IF EXISTS `MARKET_ORDER`;
CREATE TABLE `MARKET_ORDER`  (
    `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
    `ORDER_NO` bigint(20) NULL DEFAULT NULL COMMENT '订单号',
    `USER_ID` int(11) NULL DEFAULT NULL COMMENT '用户id',
    `SHIPPING_ID` int(11) NULL DEFAULT NULL,
    `PAYMENT` decimal(20, 2) NULL DEFAULT NULL COMMENT '实际付款金额,单位是元,保留两位小数',
    `PAYMENT_TYPE` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付',
    `POSTAGE` int(10) NULL DEFAULT NULL COMMENT '运费,单位是元',
    `STATUS` int(10) NULL DEFAULT NULL COMMENT '订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭',
    `PAYMENT_TIME` datetime NULL DEFAULT NULL COMMENT '支付时间',
    `SEND_TIME` datetime NULL DEFAULT NULL COMMENT '发货时间',
    `END_TIME` datetime NULL DEFAULT NULL COMMENT '交易完成时间',
    `CLOSE_TIME` datetime NULL DEFAULT NULL COMMENT '交易关闭时间',
    `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
    `UPDATE_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE INDEX `ORDER_NO_INDEX`(`ORDER_NO`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for MARKET_ORDER_ITEM
-- ----------------------------
DROP TABLE IF EXISTS `MARKET_ORDER_ITEM`;
CREATE TABLE `MARKET_ORDER_ITEM`  (
    `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单子表id',
    `USER_ID` int(11) NULL DEFAULT NULL,
    `ORDER_NO` bigint(20) NULL DEFAULT NULL,
    `PRODUCT_ID` int(11) NULL DEFAULT NULL COMMENT '商品id',
    `PRODUCT_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
    `PRODUCT_IMAGE` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片地址',
    `CURRENT_UNIT_PRICE` decimal(20, 2) NULL DEFAULT NULL COMMENT '生成订单时的商品单价，单位是元,保留两位小数',
    `QUANTITY` int(10) NULL DEFAULT NULL COMMENT '商品数量',
    `TOTAL_PRICE` decimal(20, 2) NULL DEFAULT NULL COMMENT '商品总价,单位是元,保留两位小数',
    `CREATE_TIME` datetime NULL DEFAULT NULL,
    `UPDATE_TIME` datetime NULL DEFAULT NULL,
    PRIMARY KEY (`ID`) USING BTREE,
    INDEX `ORDER_NO_INDEX`(`ORDER_NO`) USING BTREE,
    INDEX `ORDER_NO_USER_ID_INDEX`(`USER_ID`, `ORDER_NO`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单子表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for MARKET_PAY_INFO
-- ----------------------------
DROP TABLE IF EXISTS `MARKET_PAY_INFO`;
CREATE TABLE `MARKET_PAY_INFO`  (
    `ID` int(11) NOT NULL AUTO_INCREMENT,
    `USER_ID` int(11) NULL DEFAULT NULL COMMENT '用户id',
    `ORDER_NO` bigint(20) NULL DEFAULT NULL COMMENT '订单号',
    `PAY_PLATFORM` int(10) NULL DEFAULT NULL COMMENT '支付平台:1-支付宝,2-微信',
    `PLATFORM_NUMBER` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付宝支付流水号',
    `PLATFORM_STATUS` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付宝支付状态',
    `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
    `UPDATE_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '支付信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for MARKET_PRODUCT
-- ----------------------------
DROP TABLE IF EXISTS `MARKET_PRODUCT`;
CREATE TABLE `MARKET_PRODUCT`  (
    `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
    `CATEGORY_ID` int(11) NOT NULL COMMENT '分类id,对应mmall_category表的主键',
    `NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
    `SUBTITLE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品副标题',
    `MAIN_IMAGE` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品主图,url相对地址',
    `SUB_IMAGES` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址,json格式,扩展用',
    `DETAIL` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品详情',
    `PRICE` decimal(20, 2) NOT NULL COMMENT '价格,单位-元保留两位小数',
    `STOCK` int(11) NOT NULL COMMENT '库存数量',
    `STATUS` int(6) NULL DEFAULT 1 COMMENT '商品状态.1-在售 2-下架 3-删除',
    `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
    `UPDATE_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for MARKET_SHIPPING
-- ----------------------------
DROP TABLE IF EXISTS `MARKET_SHIPPING`;
CREATE TABLE `MARKET_SHIPPING`  (
    `ID` int(11) NOT NULL AUTO_INCREMENT,
    `USER_ID` int(11) NULL DEFAULT NULL COMMENT '用户id',
    `RECEIVER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货姓名',
    `RECEIVER_PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货固定电话',
    `RECEIVER_MOBILE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货移动电话',
    `RECEIVER_PROVINCE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份',
    `RECEIVER_CITY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
    `RECEIVER_DISTRICT` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区/县',
    `RECEIVER_ADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
    `RECEIVER_ZIP` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
    `CREATE_TIME` datetime NULL DEFAULT NULL,
    `UPDATE_TIME` datetime NULL DEFAULT NULL,
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '邮寄信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for MARKET_USER
-- ----------------------------
DROP TABLE IF EXISTS `MARKET_USER`;
CREATE TABLE `MARKET_USER`  (
    `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
    `USERNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
    `PASSWORD` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码，MD5加密',
    `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `QUESTION` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '找回密码问题',
    `ANSWER` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '找回密码答案',
    `ROLE` int(4) NOT NULL COMMENT '角色0-管理员,1-普通用户',
    `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
    `UPDATE_TIME` datetime NOT NULL COMMENT '最后一次更新时间',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE INDEX `USER_NAME_UNIQUE`(`USERNAME`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
