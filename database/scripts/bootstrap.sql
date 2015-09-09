/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.35 : Database - teamforge
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`teamforge` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `activity` */

DROP TABLE IF EXISTS `activity`;

CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  `subject` varchar(20) NOT NULL,
  `target` varchar(200) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `creatorId` int(11) NOT NULL,
  `action` varchar(100) NOT NULL,
  `attachId` int(11) NOT NULL,
  `attachType` varchar(30) NOT NULL DEFAULT '',
  `created` datetime NOT NULL,
  `bcId` int(11) DEFAULT NULL,
  `creatorName` varchar(50) NOT NULL,
  `projectName` varchar(50) NOT NULL,
  `trash` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `projectId` (`projectId`),
  KEY `creatorId` (`creatorId`),
  KEY `FK_activity_company` (`companyId`),
  CONSTRAINT `activity_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `activity_ibfk_2` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_activity_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=590068 DEFAULT CHARSET=utf8;

/*Table structure for table `attach_todo` */

DROP TABLE IF EXISTS `attach_todo`;

CREATE TABLE `attach_todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attachType` varchar(100) NOT NULL,
  `attachId` int(11) NOT NULL,
  `todoId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `attachment` */

DROP TABLE IF EXISTS `attachment`;

CREATE TABLE `attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `name` varchar(200) NOT NULL DEFAULT '',
  `size` bigint(20) NOT NULL,
  `code` varchar(200) NOT NULL,
  `contentType` varchar(100) NOT NULL DEFAULT '',
  `creatorId` int(11) NOT NULL,
  `attachId` int(11) NOT NULL,
  `attachType` varchar(30) NOT NULL DEFAULT '',
  `created` datetime NOT NULL,
  `bcId` int(11) DEFAULT NULL,
  `creatorName` varchar(50) DEFAULT NULL,
  `targetType` varchar(100) DEFAULT '',
  `targetId` int(11) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `projectId` (`projectId`),
  KEY `creatorId` (`creatorId`),
  KEY `FK_attachment_company` (`companyId`),
  CONSTRAINT `attachment_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `attachment_ibfk_2` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_attachment_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36538698 DEFAULT CHARSET=utf8;

/*Table structure for table `attachments_capacity` */

DROP TABLE IF EXISTS `attachments_capacity`;

CREATE TABLE `attachments_capacity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  `currentCapacity` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `auth_group` */

DROP TABLE IF EXISTS `auth_group`;

CREATE TABLE `auth_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Table structure for table `auth_group_permissions` */

DROP TABLE IF EXISTS `auth_group_permissions`;

CREATE TABLE `auth_group_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_id` (`group_id`,`permission_id`),
  KEY `auth_group_permissions_5f412f9a` (`group_id`),
  KEY `auth_group_permissions_83d7f98b` (`permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Table structure for table `auth_permission` */

DROP TABLE IF EXISTS `auth_permission`;

CREATE TABLE `auth_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `content_type_id` int(11) NOT NULL,
  `codename` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `content_type_id` (`content_type_id`,`codename`),
  KEY `auth_permission_37ef4eb4` (`content_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

/*Table structure for table `auth_user` */

DROP TABLE IF EXISTS `auth_user`;

CREATE TABLE `auth_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(128) NOT NULL,
  `last_login` datetime NOT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(30) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(75) NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `auth_user_groups` */

DROP TABLE IF EXISTS `auth_user_groups`;

CREATE TABLE `auth_user_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`group_id`),
  KEY `auth_user_groups_6340c63c` (`user_id`),
  KEY `auth_user_groups_5f412f9a` (`group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Table structure for table `auth_user_user_permissions` */

DROP TABLE IF EXISTS `auth_user_user_permissions`;

CREATE TABLE `auth_user_user_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`permission_id`),
  KEY `auth_user_user_permissions_6340c63c` (`user_id`),
  KEY `auth_user_user_permissions_83d7f98b` (`permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Table structure for table `bug` */

DROP TABLE IF EXISTS `bug`;

CREATE TABLE `bug` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) NOT NULL,
  `projectId` int(11) NOT NULL,
  `creatorId` int(11) NOT NULL,
  `creatorName` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` text,
  `createdTime` datetime NOT NULL,
  `completedTime` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  `priority` int(11) NOT NULL,
  `assigneeId` int(11) DEFAULT NULL,
  `bugType` int(11) DEFAULT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `dueTime` datetime DEFAULT NULL,
  `idInProject` int(11) DEFAULT '0',
  `storyId` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `bug_fk_companyId` (`companyId`),
  KEY `bug_fk_projectId` (`projectId`),
  KEY `bug_fk_creatorId` (`creatorId`),
  CONSTRAINT `bug_fk_companyId` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`),
  CONSTRAINT `bug_fk_creatorId` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`),
  CONSTRAINT `bug_fk_projectId` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `changelog` */

DROP TABLE IF EXISTS `changelog`;

CREATE TABLE `changelog` (
  `ID` decimal(20,0) NOT NULL,
  `APPLIED_AT` varchar(25) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ci_build_trigger` */

DROP TABLE IF EXISTS `ci_build_trigger`;

CREATE TABLE `ci_build_trigger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trigger_type` varchar(255) DEFAULT NULL,
  `trigger_value` varchar(255) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bdl5qcde5hx2aiv4b2ycmhip5` (`project_id`),
  CONSTRAINT `FK_bdl5qcde5hx2aiv4b2ycmhip5` FOREIGN KEY (`project_id`) REFERENCES `ci_project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ci_builds` */

DROP TABLE IF EXISTS `ci_builds`;

CREATE TABLE `ci_builds` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `build_result` longtext,
  `created` datetime DEFAULT NULL,
  `project_index` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `test_result` longtext,
  `ci_project_id` int(11) DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `buildResultStatus` varchar(255) DEFAULT NULL,
  `jenkinsBuildId` varchar(255) NOT NULL DEFAULT '0' COMMENT 'related jenkins build id',
  `hasTestReport` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `FK_54coqxagbf799hbuyo7vtqcwp` (`ci_project_id`),
  CONSTRAINT `FK_54coqxagbf799hbuyo7vtqcwp` FOREIGN KEY (`ci_project_id`) REFERENCES `ci_project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ci_project` */

DROP TABLE IF EXISTS `ci_project`;

CREATE TABLE `ci_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `companyId` int(11) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `build_command` longtext,
  `build_version` varchar(255) DEFAULT NULL,
  `docker_container_id` varchar(255) DEFAULT NULL,
  `language_version` varchar(255) DEFAULT NULL,
  `project_type` varchar(255) DEFAULT NULL,
  `repository` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `test_command` longtext,
  `test_version` varchar(255) DEFAULT NULL,
  `last_build_id` int(11) DEFAULT NULL,
  `last_failed_build_id` int(11) DEFAULT NULL,
  `last_success_build_id` int(11) DEFAULT NULL,
  `keepContainerUp` bit(1) NOT NULL DEFAULT b'0',
  `exposedPort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `collection` */

DROP TABLE IF EXISTS `collection`;

CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  `projectName` varchar(50) NOT NULL DEFAULT '',
  `projectId` int(11) NOT NULL,
  `creatorId` int(11) NOT NULL,
  `creatorName` varchar(50) NOT NULL DEFAULT '',
  `attachId` int(11) NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `title` varchar(200) NOT NULL DEFAULT '',
  `attachType` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `creatorId` int(11) NOT NULL,
  `attachId` int(11) NOT NULL,
  `attachType` varchar(30) NOT NULL DEFAULT '',
  `deleted` tinyint(1) NOT NULL,
  `projectId` int(11) NOT NULL DEFAULT '0',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `bcId` int(11) DEFAULT NULL,
  `creatorName` varchar(50) NOT NULL DEFAULT 'name',
  `companyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `creatorId` (`creatorId`),
  KEY `FK_comment_company` (`companyId`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_comment_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39202979 DEFAULT CHARSET=utf8;

/*Table structure for table `commit_review` */

DROP TABLE IF EXISTS `commit_review`;

CREATE TABLE `commit_review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `creatorId` int(11) NOT NULL,
  `creatorName` varchar(50) NOT NULL,
  `file` varchar(500) NOT NULL,
  `line` int(11) NOT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `projectId` int(11) NOT NULL,
  `commitId` varchar(40) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `line_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `commit_todo` */

DROP TABLE IF EXISTS `commit_todo`;

CREATE TABLE `commit_todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commitId` varchar(500) NOT NULL,
  `todoId` int(11) NOT NULL,
  `repoId` int(11) NOT NULL,
  `attachType` varchar(255) DEFAULT 'todo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `creatorId` int(11) DEFAULT NULL,
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  `privileged` bit(1) NOT NULL DEFAULT b'0' COMMENT '如果没有特权，默认为0。特权团队，比如说onboard，值为1',
  `money` int(11) NOT NULL DEFAULT '0',
  `lastPayTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `creatorId` (`creatorId`),
  CONSTRAINT `company_ibfk_1` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1234251 DEFAULT CHARSET=utf8;

/*Table structure for table `company_application` */

DROP TABLE IF EXISTS `company_application`;

CREATE TABLE `company_application` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `teamName` varchar(255) NOT NULL DEFAULT '',
  `contactEmail` varchar(255) NOT NULL,
  `contactName` varchar(255) DEFAULT NULL,
  `description` varchar(4096) DEFAULT NULL,
  `teamSize` varchar(50) NOT NULL DEFAULT '',
  `codeHost` varchar(255) DEFAULT '',
  `code` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `company_limit` */

DROP TABLE IF EXISTS `company_limit`;

CREATE TABLE `company_limit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) NOT NULL,
  `projectCount` int(11) DEFAULT NULL,
  `diskSize` int(11) DEFAULT NULL,
  `repositorySize` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `company_log` */

DROP TABLE IF EXISTS `company_log`;

CREATE TABLE `company_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) NOT NULL,
  `content` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `creatorId` int(11) DEFAULT NULL,
  `changes` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `company_privilege` */

DROP TABLE IF EXISTS `company_privilege`;

CREATE TABLE `company_privilege` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) NOT NULL,
  `companyId` int(10) NOT NULL,
  `isAdmin` bit(1) DEFAULT b'0' COMMENT '是否是管理员',
  `canCreateProject` bit(1) DEFAULT b'0' COMMENT '是否能创建项目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=186 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `companyId` int(11) NOT NULL,
  `customOrder` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `group_ibfk_1` (`companyId`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

/*Table structure for table `discussion` */

DROP TABLE IF EXISTS `discussion`;

CREATE TABLE `discussion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `subject` varchar(200) NOT NULL DEFAULT '',
  `content` text,
  `creatorId` int(11) NOT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `bcId` int(11) DEFAULT NULL,
  `creatorName` varchar(50) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `projectId` (`projectId`),
  KEY `creatorId` (`creatorId`),
  KEY `FK_discussion_company` (`companyId`),
  CONSTRAINT `discussion_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `discussion_ibfk_2` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_discussion_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1905164 DEFAULT CHARSET=utf8;

/*Table structure for table `django_admin_log` */

DROP TABLE IF EXISTS `django_admin_log`;

CREATE TABLE `django_admin_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action_time` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `content_type_id` int(11) DEFAULT NULL,
  `object_id` longtext,
  `object_repr` varchar(200) NOT NULL,
  `action_flag` smallint(5) unsigned NOT NULL,
  `change_message` longtext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `django_admin_log_6340c63c` (`user_id`),
  KEY `django_admin_log_37ef4eb4` (`content_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Table structure for table `django_content_type` */

DROP TABLE IF EXISTS `django_content_type`;

CREATE TABLE `django_content_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `app_label` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `app_label` (`app_label`,`model`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Table structure for table `django_session` */

DROP TABLE IF EXISTS `django_session`;

CREATE TABLE `django_session` (
  `session_key` varchar(40) NOT NULL,
  `session_data` longtext NOT NULL,
  `expire_date` datetime NOT NULL,
  PRIMARY KEY (`session_key`),
  KEY `django_session_b7b81f0c` (`expire_date`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Table structure for table `django_site` */

DROP TABLE IF EXISTS `django_site`;

CREATE TABLE `django_site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `document` */

DROP TABLE IF EXISTS `document`;

CREATE TABLE `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` mediumtext,
  `creatorId` int(11) NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `bcId` int(11) DEFAULT NULL,
  `creatorName` varchar(50) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  `isHomePage` tinyint(1) NOT NULL,
  `docType` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `projectId` (`projectId`),
  KEY `creatorId` (`creatorId`),
  KEY `FK_document_company` (`companyId`),
  CONSTRAINT `document_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `document_ibfk_2` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_document_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Table structure for table `document_history` */

DROP TABLE IF EXISTS `document_history`;

CREATE TABLE `document_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `documentId` int(11) NOT NULL,
  `version` varchar(64) DEFAULT NULL,
  `updaterId` int(11) NOT NULL,
  `updaterName` varchar(50) NOT NULL,
  `created` datetime NOT NULL,
  `note` tinytext,
  `projectId` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` mediumtext,
  PRIMARY KEY (`id`),
  KEY `FK_document_history_user_idx` (`updaterId`),
  KEY `FK_document_history_document_idx` (`documentId`),
  KEY `FK_document_history_project_idx` (`projectId`),
  CONSTRAINT `FK_document_history_document` FOREIGN KEY (`documentId`) REFERENCES `document` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_document_history_project` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_document_history_user` FOREIGN KEY (`updaterId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=371864101 DEFAULT CHARSET=utf8;

/*Table structure for table `event` */

DROP TABLE IF EXISTS `event`;

CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `summary` varchar(100) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `creatorId` int(11) NOT NULL,
  `startTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `bcId` int(11) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `creatorId` (`creatorId`),
  KEY `event_ibfk_1` (`projectId`),
  KEY `FK_event_company` (`companyId`),
  CONSTRAINT `event_ibfk_2` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_event_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Table structure for table `git_user_email` */

DROP TABLE IF EXISTS `git_user_email`;

CREATE TABLE `git_user_email` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `companyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `github_info` */

DROP TABLE IF EXISTS `github_info`;

CREATE TABLE `github_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `code` varchar(100) DEFAULT NULL,
  `token` varchar(100) DEFAULT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `userEmail` varchar(100) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `onboardUserId` int(11) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `invitation` */

DROP TABLE IF EXISTS `invitation`;

CREATE TABLE `invitation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `message` varchar(500) DEFAULT NULL,
  `token` varchar(50) NOT NULL DEFAULT '',
  `created` datetime NOT NULL,
  `email` varchar(100) NOT NULL DEFAULT '',
  `companyId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `companyId` (`companyId`),
  CONSTRAINT `invitation_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `invitation_ibfk_2` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28425684 DEFAULT CHARSET=utf8;

/*Table structure for table `invitation_projects` */

DROP TABLE IF EXISTS `invitation_projects`;

CREATE TABLE `invitation_projects` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `invitationId` int(11) NOT NULL,
  `projectId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `projectId` (`projectId`),
  KEY `invitationId` (`invitationId`),
  CONSTRAINT `invitation_projects_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `invitation_projects_ibfk_2` FOREIGN KEY (`invitationId`) REFERENCES `invitation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=406 DEFAULT CHARSET=utf8;

/*Table structure for table `iteration` */

DROP TABLE IF EXISTS `iteration`;

CREATE TABLE `iteration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `status` varchar(45) NOT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `todoCount` int(11) NOT NULL,
  `indexId` int(11) NOT NULL,
  `creatorId` int(11) NOT NULL,
  `projectId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `summary` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `iteration_object` */

DROP TABLE IF EXISTS `iteration_object`;

CREATE TABLE `iteration_object` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iterationId` int(11) NOT NULL,
  `objectType` varchar(255) NOT NULL,
  `objectId` int(11) NOT NULL,
  `completed` bit(1) DEFAULT NULL,
  `completedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `iteration_story` */

DROP TABLE IF EXISTS `iteration_story`;

CREATE TABLE `iteration_story` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iterationId` int(11) DEFAULT NULL,
  `storyId` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `completedTime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `iteration_todo` */

DROP TABLE IF EXISTS `iteration_todo`;

CREATE TABLE `iteration_todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iterationId` int(11) NOT NULL,
  `todoId` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  `completedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `keyword` */

DROP TABLE IF EXISTS `keyword`;

CREATE TABLE `keyword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  `keyword` varchar(50) NOT NULL,
  `times` bigint(50) NOT NULL DEFAULT '0',
  `attachType` varchar(30) NOT NULL,
  `attachId` int(11) NOT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `tfidf` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `note` */

DROP TABLE IF EXISTS `note`;

CREATE TABLE `note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  `text` text,
  `posX` double NOT NULL,
  `posY` double NOT NULL,
  `width` double NOT NULL,
  `height` double NOT NULL,
  `lastDate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `note_ibfk_1` (`userId`),
  KEY `note_ibfk_2` (`companyId`),
  CONSTRAINT `note_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `note_ibfk_2` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1832381 DEFAULT CHARSET=utf8;

/*Table structure for table `notification` */

DROP TABLE IF EXISTS `notification`;

CREATE TABLE `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `isRead` tinyint(1) NOT NULL,
  `activityId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `notification.userId` (`userId`),
  KEY `notification.companyId` (`companyId`),
  KEY `notification.activityId` (`activityId`),
  CONSTRAINT `notification.userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `notification.companyId` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `notification.activityId` FOREIGN KEY (`activityId`) REFERENCES `activity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `archived` tinyint(1) NOT NULL DEFAULT '0',
  `creatorId` int(11) NOT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `bcId` int(11) DEFAULT NULL,
  `colorId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `companyId` (`companyId`),
  KEY `creatorId` (`creatorId`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`),
  CONSTRAINT `project_ibfk_2` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5532506 DEFAULT CHARSET=utf8;

/*Table structure for table `project_privilege` */

DROP TABLE IF EXISTS `project_privilege`;

CREATE TABLE `project_privilege` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) NOT NULL,
  `projectId` int(10) NOT NULL,
  `isAdmin` bit(1) DEFAULT b'0' COMMENT '是否是项目管理员',
  PRIMARY KEY (`id`),
  KEY `projectId` (`projectId`),
  CONSTRAINT `projectId` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `project_todo_id` */

DROP TABLE IF EXISTS `project_todo_id`;

CREATE TABLE `project_todo_id` (
  `projectId` int(11) NOT NULL,
  `todoId` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `project_todo_status` */

DROP TABLE IF EXISTS `project_todo_status`;

CREATE TABLE `project_todo_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `pull_request` */

DROP TABLE IF EXISTS `pull_request`;

CREATE TABLE `pull_request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text,
  `source` varchar(500) NOT NULL,
  `destination` varchar(500) NOT NULL,
  `title` varchar(500) NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT 'declined, merged, open',
  `creatorId` int(11) NOT NULL,
  `todoId` int(11) NOT NULL,
  `creatorName` varchar(50) NOT NULL DEFAULT 'name',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `projectId` int(11) NOT NULL,
  `scopeId` int(11) NOT NULL DEFAULT '0',
  `sourceHash` varchar(500) NOT NULL,
  `destinationHash` varchar(500) NOT NULL,
  `repositoryId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `creatorId` (`creatorId`),
  KEY `todoId` (`todoId`),
  KEY `projectId` (`projectId`),
  KEY `pf_repository_id` (`repositoryId`),
  KEY `pr_company_id` (`companyId`),
  CONSTRAINT `pr_company_id` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pf_repository_id` FOREIGN KEY (`repositoryId`) REFERENCES `repository` (`id`),
  CONSTRAINT `pr_creator_id` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`),
  CONSTRAINT `pr_project_id` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `pr_todo_id` FOREIGN KEY (`todoId`) REFERENCES `todo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21757 DEFAULT CHARSET=utf8;

/*Table structure for table `pull_request_push` */

DROP TABLE IF EXISTS `pull_request_push`;

CREATE TABLE `pull_request_push` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pullRequestId` int(11) NOT NULL,
  `pushId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `pull_request_reviewer` */

DROP TABLE IF EXISTS `pull_request_reviewer`;

CREATE TABLE `pull_request_reviewer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pullRequestId` int(11) NOT NULL,
  `reviewerId` int(11) NOT NULL,
  `projectId` int(11) NOT NULL,
  `approved` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pullRequestId` (`pullRequestId`),
  KEY `reviewerId` (`reviewerId`),
  KEY `projectId` (`projectId`),
  CONSTRAINT `prr_project_id` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `prr_pull_request_id` FOREIGN KEY (`pullRequestId`) REFERENCES `pull_request` (`id`),
  CONSTRAINT `prr_reviewer_id` FOREIGN KEY (`reviewerId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2903 DEFAULT CHARSET=utf8;

/*Table structure for table `push` */

DROP TABLE IF EXISTS `push`;

CREATE TABLE `push` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `since` varchar(500) DEFAULT NULL,
  `until` varchar(500) DEFAULT NULL,
  `creatorId` int(11) NOT NULL,
  `creatorName` varchar(50) NOT NULL,
  `repositoryId` int(11) DEFAULT NULL,
  `branchName` varchar(500) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `repo_branch_privilege` */

DROP TABLE IF EXISTS `repo_branch_privilege`;

CREATE TABLE `repo_branch_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) NOT NULL,
  `projectId` int(11) NOT NULL,
  `repositoryId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `refName` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `repository` */

DROP TABLE IF EXISTS `repository`;

CREATE TABLE `repository` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `slug` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(128) COLLATE utf8_bin NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `projectId` int(11) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `updatedBranch` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `companyId` int(11) NOT NULL DEFAULT '1',
  `lastCommitId` varchar(128) COLLATE utf8_bin DEFAULT '1',
  `lastCommitShortMessage` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `lastCommitUsername` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `lastCommitTimestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_slug_project_id` (`slug`,`projectId`),
  KEY `idx_repository_project_id` (`projectId`),
  KEY `fk_repository_company` (`companyId`),
  CONSTRAINT `fk_repository_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_repository_project` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `repository_privilege` */

DROP TABLE IF EXISTS `repository_privilege`;

CREATE TABLE `repository_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) NOT NULL,
  `projectId` int(11) NOT NULL,
  `repositoryId` int(11) NOT NULL,
  `defaultOwner` int(11) NOT NULL,
  `action` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `repository_privilege_user` */

DROP TABLE IF EXISTS `repository_privilege_user`;

CREATE TABLE `repository_privilege_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `repositoryRrivilegeId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `review` */

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `creatorId` int(11) NOT NULL,
  `creatorName` varchar(50) NOT NULL,
  `file` varchar(500) NOT NULL,
  `line` int(11) NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `projectId` int(11) NOT NULL,
  `pullRequestId` int(11) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `line_type` varchar(50) DEFAULT NULL,
  `since` varchar(500) DEFAULT NULL,
  `until` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `creatorId` (`creatorId`),
  KEY `projectId` (`projectId`),
  KEY `pullRequestId` (`pullRequestId`),
  CONSTRAINT `review_creator_id` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`),
  CONSTRAINT `review_project_id` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `review_pull_request_id` FOREIGN KEY (`pullRequestId`) REFERENCES `pull_request` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29031903 DEFAULT CHARSET=utf8;

/*Table structure for table `sshkey` */

DROP TABLE IF EXISTS `sshkey`;

CREATE TABLE `sshkey` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `keytext` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `title` varchar(255) NOT NULL DEFAULT '',
  `md5` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `sshkey_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `step` */

DROP TABLE IF EXISTS `step`;

CREATE TABLE `step` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attachType` varchar(255) NOT NULL,
  `attachId` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `dueDate` datetime DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `updatedTime` datetime DEFAULT NULL,
  `creatorId` int(11) DEFAULT NULL,
  `creatorName` varchar(255) DEFAULT NULL,
  `assigneeId` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `completedTime` datetime DEFAULT NULL,
  `completerId` int(11) DEFAULT NULL,
  `idInProject` int(11) DEFAULT '0',
  `projectId` int(11) DEFAULT '0',
  `companyId` int(11) DEFAULT '0',
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `story` */

DROP TABLE IF EXISTS `story`;

CREATE TABLE `story` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  `pre` text,
  `post` text,
  `position` double NOT NULL DEFAULT '0',
  `deleted` tinyint(1) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `completedTime` datetime DEFAULT NULL,
  `completed` tinyint(1) NOT NULL,
  `creatorId` int(11) NOT NULL,
  `creatorName` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `acceptanceLevel` text,
  `priority` int(11) NOT NULL DEFAULT '1',
  `parentStoryId` int(11) NOT NULL DEFAULT '0',
  `completable` tinyint(1) NOT NULL DEFAULT '1',
  `idInProject` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `story_todo` */

DROP TABLE IF EXISTS `story_todo`;

CREATE TABLE `story_todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storyId` int(11) NOT NULL,
  `todoId` int(11) NOT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `story_todos` */

DROP TABLE IF EXISTS `story_todos`;

CREATE TABLE `story_todos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `todoId` int(11) DEFAULT NULL,
  `storyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `subscriber` */

DROP TABLE IF EXISTS `subscriber`;

CREATE TABLE `subscriber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `subscribeId` int(11) NOT NULL,
  `subscribeType` varchar(30) NOT NULL DEFAULT '',
  `companyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `only_one_subscriber` (`userId`,`subscribeId`,`subscribeType`),
  KEY `userId` (`userId`),
  KEY `FK_subscriber_company` (`companyId`),
  CONSTRAINT `FK_subscriber_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`),
  CONSTRAINT `subscriber_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10042 DEFAULT CHARSET=utf8;

/*Table structure for table `suggestion` */

DROP TABLE IF EXISTS `suggestion`;

CREATE TABLE `suggestion` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `content` varchar(2000) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

/*Table structure for table `tag` */

DROP TABLE IF EXISTS `tag`;

CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagname` varchar(50) NOT NULL,
  `projectId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tag_projectId` (`projectId`),
  CONSTRAINT `tag_projectId` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tag_attach` */

DROP TABLE IF EXISTS `tag_attach`;

CREATE TABLE `tag_attach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagId` int(11) NOT NULL,
  `attachId` int(11) NOT NULL,
  `attachType` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tagId` (`tagId`),
  CONSTRAINT `tagId` FOREIGN KEY (`tagId`) REFERENCES `tag` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `todo` */

DROP TABLE IF EXISTS `todo`;

CREATE TABLE `todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL DEFAULT '0',
  `todolistId` int(11) DEFAULT NULL,
  `content` varchar(200) NOT NULL,
  `position` double NOT NULL DEFAULT '0',
  `completed` tinyint(1) NOT NULL,
  `dueDate` datetime DEFAULT NULL,
  `creatorName` varchar(50) DEFAULT NULL,
  `creatorId` int(11) NOT NULL,
  `assigneeId` int(11) DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `companyId` int(11) DEFAULT NULL,
  `doing` tinyint(1) NOT NULL DEFAULT '0',
  `projectTodoId` int(11) DEFAULT NULL,
  `todoType` varchar(45) NOT NULL DEFAULT 'task',
  `description` text,
  `estimate` int(11) DEFAULT NULL,
  `spendTime` int(11) DEFAULT NULL,
  `priority` int(11) NOT NULL DEFAULT '1',
  `status` varchar(45) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `completeTime` datetime DEFAULT NULL,
  `completerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `todoListId` (`todolistId`),
  KEY `creatorId` (`creatorId`),
  KEY `assigneeId` (`assigneeId`),
  KEY `FK_todo_company` (`companyId`),
  KEY `projectId` (`projectId`),
  CONSTRAINT `FK_todo_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`),
  CONSTRAINT `todo_ibfk_1` FOREIGN KEY (`todolistId`) REFERENCES `todolist` (`id`),
  CONSTRAINT `todo_ibfk_2` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`),
  CONSTRAINT `todo_ibfk_3` FOREIGN KEY (`assigneeId`) REFERENCES `user` (`id`),
  CONSTRAINT `todo_ibfk_4` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54324229 DEFAULT CHARSET=utf8;

/*Table structure for table `todo_duration` */

DROP TABLE IF EXISTS `todo_duration`;

CREATE TABLE `todo_duration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) DEFAULT NULL,
  `companyId` int(11) NOT NULL,
  `todoId` int(11) DEFAULT NULL,
  `creatorId` int(11) NOT NULL,
  `startTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `todolist` */

DROP TABLE IF EXISTS `todolist`;

CREATE TABLE `todolist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `position` double NOT NULL DEFAULT '0',
  `creatorId` int(11) NOT NULL,
  `creatorName` varchar(50) DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `bcId` int(11) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  `archived` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'todolist归档',
  PRIMARY KEY (`id`),
  KEY `projectId` (`projectId`),
  KEY `creatorId` (`creatorId`),
  KEY `FK_todolist_company` (`companyId`),
  CONSTRAINT `FK_todolist_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`),
  CONSTRAINT `todolist_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `todolist_ibfk_2` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3457728 DEFAULT CHARSET=utf8;

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `excerpt` varchar(200) NOT NULL,
  `lastUpdatorId` int(11) NOT NULL,
  `lastUpdatorName` varchar(50) DEFAULT NULL,
  `refId` int(11) NOT NULL,
  `refType` varchar(50) NOT NULL DEFAULT '',
  `deleted` tinyint(1) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `bcId` int(11) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  `stick` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `projectId` (`projectId`),
  KEY `lastUpdatorId` (`lastUpdatorId`),
  KEY `FK_topic_company` (`companyId`),
  CONSTRAINT `FK_topic_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`),
  CONSTRAINT `topic_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `topic_ibfk_2` FOREIGN KEY (`lastUpdatorId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4531701 DEFAULT CHARSET=utf8;

/*Table structure for table `upload` */

DROP TABLE IF EXISTS `upload`;

CREATE TABLE `upload` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `content` varchar(200) DEFAULT NULL,
  `creatorId` int(11) NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `bcId` int(11) DEFAULT NULL,
  `creatorName` varchar(50) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `projectId` (`projectId`),
  KEY `creatorId` (`creatorId`),
  KEY `FK_upload_company` (`companyId`),
  CONSTRAINT `FK_upload_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`),
  CONSTRAINT `upload_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `upload_ibfk_2` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7442257 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `activated` tinyint(1) NOT NULL,
  `avatar` varchar(200) NOT NULL DEFAULT '/avatar/default.png',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `password` varchar(50) NOT NULL DEFAULT '',
  `newPassword` varchar(80) DEFAULT NULL,
  `bcId` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=793342 DEFAULT CHARSET=utf8;

/*Table structure for table `user_company` */

DROP TABLE IF EXISTS `user_company`;

CREATE TABLE `user_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  `groupId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `companyId` (`companyId`),
  CONSTRAINT `user_company_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `user_company_ibfk_2` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=270 DEFAULT CHARSET=utf8;

/*Table structure for table `user_project` */

DROP TABLE IF EXISTS `user_project`;

CREATE TABLE `user_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `projectId` int(11) NOT NULL,
  `companyId` int(11) DEFAULT NULL,
  `customOrder` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userId` (`userId`,`projectId`),
  KEY `projectId` (`projectId`),
  KEY `FK_user_project_company` (`companyId`),
  CONSTRAINT `FK_user_project_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`),
  CONSTRAINT `user_project_ibfk_2` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=828 DEFAULT CHARSET=utf8;

/*Table structure for table `user_starred_project` */

DROP TABLE IF EXISTS `user_starred_project`;

CREATE TABLE `user_starred_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `projectId` int(11) NOT NULL,
  `companyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `projectId` (`projectId`),
  KEY `FK_user_starred_project_company` (`companyId`),
  CONSTRAINT `FK_user_starred_project_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`),
  CONSTRAINT `user_starred_project_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `user_starred_project_ibfk_2` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `version` */

DROP TABLE IF EXISTS `version`;

CREATE TABLE `version` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` varchar(45) NOT NULL,
  `description` text,
  `createTime` datetime DEFAULT NULL,
  `publicTime` datetime DEFAULT NULL,
  `projectId` int(11) NOT NULL,
  `companyId` int(11) NOT NULL,
  `isPublic` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `version_todo` */

DROP TABLE IF EXISTS `version_todo`;

CREATE TABLE `version_todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `versionId` int(11) NOT NULL,
  `todoId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `worklog` */

DROP TABLE IF EXISTS `worklog`;

CREATE TABLE `worklog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `todoId` int(11) DEFAULT NULL,
  `projectId` int(11) NOT NULL,
  `startTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `description` text NOT NULL,
  `creatorId` int(11) NOT NULL,
  `companyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `worklog_ibfk_1` (`todoId`),
  KEY `worklog_ibfk_2` (`projectId`),
  KEY `worklog_ibfk_3` (`creatorId`),
  KEY `FK_worklog_company` (`companyId`),
  CONSTRAINT `FK_worklog_company` FOREIGN KEY (`companyId`) REFERENCES `company` (`id`),
  CONSTRAINT `worklog_ibfk_1` FOREIGN KEY (`todoId`) REFERENCES `todo` (`id`),
  CONSTRAINT `worklog_ibfk_2` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `worklog_ibfk_3` FOREIGN KEY (`creatorId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
