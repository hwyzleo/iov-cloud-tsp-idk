DROP TABLE IF EXISTS `db_idk`.`tb_btm`;
CREATE TABLE `db_idk`.`tb_btm`
(
    `id`            BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `sn`            VARCHAR(255) NOT NULL COMMENT '序列号',
    `no`            VARCHAR(255)          DEFAULT NULL COMMENT '零件编号',
    `config_word`   VARCHAR(255)          DEFAULT NULL COMMENT '配置字',
    `supplier_code` VARCHAR(255)          DEFAULT NULL COMMENT '供应商编码',
    `hardware_ver`  VARCHAR(255)          DEFAULT NULL COMMENT '硬件版本号',
    `software_ver`  VARCHAR(255)          DEFAULT NULL COMMENT '软件版本号',
    `hardware_no`   VARCHAR(255)          DEFAULT NULL COMMENT '硬件零件号',
    `software_no`   VARCHAR(255)          DEFAULT NULL COMMENT '软件零件号',
    `hsm`           VARCHAR(100)          DEFAULT NULL COMMENT '硬件安全模块',
    `mac`           VARCHAR(100)          DEFAULT NULL COMMENT 'MAC地址',
    `description`   VARCHAR(255)          DEFAULT NULL COMMENT '备注',
    `create_time`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`     VARCHAR(64)           DEFAULT NULL COMMENT '创建者',
    `modify_time`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `modify_by`     VARCHAR(64)           DEFAULT NULL COMMENT '修改者',
    `row_version`   INT                   DEFAULT 1 COMMENT '记录版本',
    `row_valid`     TINYINT               DEFAULT 1 COMMENT '记录是否有效',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`sn`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='蓝牙模块信息表';

DROP TABLE IF EXISTS `db_idk`.`tb_btm_log`;
CREATE TABLE `db_idk`.`tb_btm_log`
(
    `id`           BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `sn`           VARCHAR(255) NOT NULL COMMENT '序列号',
    `config_word`  VARCHAR(255)          DEFAULT NULL COMMENT '配置字',
    `hardware_ver` VARCHAR(255)          DEFAULT NULL COMMENT '硬件版本号',
    `software_ver` VARCHAR(255)          DEFAULT NULL COMMENT '软件版本号',
    `hardware_no`  VARCHAR(255)          DEFAULT NULL COMMENT '硬件零件号',
    `software_no`  VARCHAR(255)          DEFAULT NULL COMMENT '软件零件号',
    `hsm`          VARCHAR(100)          DEFAULT NULL COMMENT '硬件安全模块',
    `mac`          VARCHAR(100)          DEFAULT NULL COMMENT 'MAC地址',
    `description`  VARCHAR(255)          DEFAULT NULL COMMENT '备注',
    `create_time`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`    VARCHAR(64)           DEFAULT NULL COMMENT '创建者',
    `modify_time`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `modify_by`    VARCHAR(64)           DEFAULT NULL COMMENT '修改者',
    `row_version`  INT                   DEFAULT 1 COMMENT '记录版本',
    `row_valid`    TINYINT               DEFAULT 1 COMMENT '记录是否有效',
    PRIMARY KEY (`id`),
    INDEX `idx_sn` (`sn`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='蓝牙模块信息变更日志表';