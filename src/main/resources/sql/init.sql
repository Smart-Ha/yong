DROP TABLE IF EXISTS `t_user`;
DROP TABLE IF EXISTS `t_resource`;
DROP TABLE IF EXISTS `t_resource`;
DROP TABLE IF EXISTS `t_resource`;
DROP TABLE IF EXISTS `t_resource`;




CREATE TABLE `t_user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(20) NOT NULL COMMENT '帐号',
  `password` varchar(32) NOT NULL COMMENT '密码MD5(密码+盐)',
  `salt` varchar(32) DEFAULT NULL COMMENT '盐',
  `realname` varchar(20) DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(150) DEFAULT NULL COMMENT '头像',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `locked` tinyint(4) DEFAULT NULL COMMENT '状态(0:正常,1:锁定)',
  `deleted`   bool default false COMMENT '是否已删除',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `modify_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  constraint `pk_t_user` primary key(`user_id`),
  constraint `unique_t_user_username` unique(`username`),
  constraint `unique_t_user_email` unique(`email`),
  constraint `unique_t_user_phone` unique(`phone`),
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户';
alter table `t_user` auto_increment=10000;



/**
权限表
 */
create table `t_permission`(
  `id`         bigint not null auto_increment,
  `name`      varchar(100),
  `permission`  varchar(100),
  `description`      varchar(200),
  `is_show`       bool,
  constraint `pk_t_permission` primary key(`id`),
  index idx_t_permission_name (`name`),
  index idx_t_permission_permission (`permission`),
  index idx_t_permission_show (`is_show`)
) charset=utf8mb4 ENGINE=InnoDB;;
alter table `t_permission` auto_increment=10000;



/**
角色表
 */
create table `t_role`(
  `id`         bigint not null auto_increment,
  `name`      varchar(100),
  `role`  varchar(100),
  `description`      varchar(200),
  `is_show`       bool,
  constraint `pk_t_role` primary key(`id`),
  index `idx_t_role_name` (`name`),
  index `idx_t_role_role` (`role`),
  index `idx_t_role_show` (`is_show`)
) charset=utf8mb4 ENGINE=InnoDB;;
alter table `t_role` auto_increment=10000;

/**
资源表
 */
create table `t_resource`(
  `id`         bigint not null auto_increment,
  `name`      varchar(100),
  `identity`  varchar(100),
  `url`      varchar(200),
  `parent_id` bigint,
  `parent_ids`  varchar(200) default '',
  `icon`       varchar(200),
  `weight`    int,
  `is_show`       bool,
  constraint `pk_t_resource` primary key(`id`),
  index `idx_t_resource_name` (`name`),
  index `idx_t_resource_identity` (`identity`),
  index `idx_t_resource_user` (`url`),
  index `idx_t_resource_parent_id` (`parent_id`),
  index `idx_t_resource_parent_ids_weight` (`parent_ids`, `weight`)
) charset=utf8mb4 ENGINE=InnoDB;;
alter table `t_resource` auto_increment=10000;



/**
资源权限表
 */
create table `t_role_resource_permission`(
  `id`         bigint not null auto_increment,
  `role_id`   bigint,
  `resource_id` bigint,
  `permission_ids` varchar(500),
  constraint `pk_t_role_resource_permission` primary key(`id`),
  constraint `unique_t_role_resource_permission` unique(`role_id`, `resource_id`)
) charset=utf8mb4 ENGINE=InnoDB;;
alter table `t_role_resource_permission` auto_increment=1000;;

/**
用户角色权限表
 */
create table `t_auth`(
  `id`         bigint not null auto_increment,
  `user_id`        bigint,
  `group_id`       bigint,
  `role_ids`       varchar(500),
  `type`           varchar(50),
  constraint `pk_sys_auth` primary key(`id`),
  index `idx_sys_auth_user` (`user_id`),
  index `idx_sys_auth_group` (`group_id`),
  index `idx_sys_auth_type` (`type`)
) charset=utf8mb4 ENGINE=InnoDB;;
alter table `sys_auth` auto_increment=1000;;


create table `t_user_status_history`(
  `id`         bigint not null auto_increment,
  `user_id`    bigint,
  `status`    varchar(50),
  `reason`     varchar(200),
  `op_user_id`  bigint,
  `op_date`    timestamp default 0 ,
  constraint `pk_t_user_block_history` primary key(`id`),
  index `idx_t_user_block_history_user_id_block_date` (`user_id`,`op_date`),
  index `idx_t_user_block_history_op_user_id_op_date` (`op_user_id`, `op_date`)
) charset=utf8mb4 ENGINE=InnoDB;;


create table `t_user_online`(
  `id`         varchar(100) not null,
  `user_id`    bigint default 0,
  `username`    varchar(100),
  `host`  varchar(100),
  `ttem_host`  varchar(100),
  `user_agent` varchar(200),
  `status`  varchar(50),
  `start_timestsamp`    timestamp default 0 ,
  `last_access_time`    timestamp default 0 ,
  `timeout`    bigint ,
  `session` mediumtext,
  constraint `pk_t_user_online` primary key(`id`),
  index `idx_t_user_online_t_user_id` (`user_id`),
  index `idx_t_user_online_username` (`username`),
  index `idx_t_user_online_host` (`host`),
  index `idx_t_user_online_ttem_host` (`ttem_host`),
  index `idx_t_user_online_start_timestsamp` (`start_timestsamp`),
  index `idx_t_user_online_last_access_time` (`last_access_time`),
  index `idx_t_user_online_user_agent` (`user_agent`)
) charset=utf8mb4 ENGINE=InnoDB;;


create table `t_user_last_online`(
  `id`         bigint not null auto_increment,
  `user_id`    bigint,
  `username`    varchar(100),
  `uid`        varchar(100),
  `host`    varchar(100),
  `user_agent` varchar(200),
  `ttem_host`  varchar(100),
  `last_login_timestamp`    timestamp default 0 ,
  `last_stop_timestamp`    timestamp default 0 ,
  `login_count`    bigint ,
  `total_online_time` bigint,
  constraint `pk_t_user_last_online` primary key(`id`),
  constraint `unique_t_user_last_online_t_user_id` unique(`user_id`),
  index `idx_t_user_last_online_username` (`username`),
  index `idx_t_user_last_online_host` (`host`),
  index `idx_t_user_last_online_ttem_host` (`ttem_host`),
  index `idx_t_user_last_online_last_login_timestamp` (`last_login_timestamp`),
  index `idx_t_user_last_online_last_stop_timestamp` (`last_stop_timestamp`),
  index `idx_t_user_last_online_user_agent` (`user_agent`)
) charset=utf8mb4 ENGINE=InnoDB;;


