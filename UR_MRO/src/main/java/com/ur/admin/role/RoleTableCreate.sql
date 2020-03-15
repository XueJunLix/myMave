/*
Navicat SQL Server Data Transfer

Source Server         : metest
Source Server Version : 110000
Source Host           : 192.168.13.37,1433:1433
Source Database       : me_test
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 110000
File Encoding         : 65001

Date: 2019-08-07 14:00:17
*/


-- ----------------------------
-- Table structure for ADMIN_ROLE_INFO
-- ----------------------------
DROP TABLE [dbo].[ADMIN_ROLE_INFO]
GO
CREATE TABLE [dbo].[ADMIN_ROLE_INFO] (
[ID] bigint NOT NULL IDENTITY(1,1) ,
[ROLE_CODE] varchar(100) NULL ,
[ROLE_NAME] varchar(200) NULL ,
[MEMO] varchar(100) NULL ,
[STATUS] int NOT NULL ,
[CREATED_BY] varchar(50) NOT NULL ,
[CREATED_TIME] datetime2(7) NOT NULL ,
[LAST_UPDATED_BY] varchar(50) NOT NULL ,
[LAST_UPDATED_TIME] datetime2(7) NOT NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[ADMIN_ROLE_INFO]', RESEED, 3)
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_ROLE_INFO', 
'COLUMN', N'ID')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'主键ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_ROLE_INFO'
, @level2type = 'COLUMN', @level2name = N'ID'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'主键ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_ROLE_INFO'
, @level2type = 'COLUMN', @level2name = N'ID'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_ROLE_INFO', 
'COLUMN', N'ROLE_CODE')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'角色编码'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_ROLE_INFO'
, @level2type = 'COLUMN', @level2name = N'ROLE_CODE'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'角色编码'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_ROLE_INFO'
, @level2type = 'COLUMN', @level2name = N'ROLE_CODE'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_ROLE_INFO', 
'COLUMN', N'ROLE_NAME')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'角色名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_ROLE_INFO'
, @level2type = 'COLUMN', @level2name = N'ROLE_NAME'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'角色名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_ROLE_INFO'
, @level2type = 'COLUMN', @level2name = N'ROLE_NAME'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_ROLE_INFO', 
'COLUMN', N'MEMO')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'备注'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_ROLE_INFO'
, @level2type = 'COLUMN', @level2name = N'MEMO'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'备注'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_ROLE_INFO'
, @level2type = 'COLUMN', @level2name = N'MEMO'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_ROLE_INFO', 
'COLUMN', N'STATUS')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'状态'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_ROLE_INFO'
, @level2type = 'COLUMN', @level2name = N'STATUS'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'状态'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_ROLE_INFO'
, @level2type = 'COLUMN', @level2name = N'STATUS'
GO

-- ----------------------------
-- Indexes structure for table ADMIN_ROLE_INFO
-- ----------------------------
CREATE UNIQUE INDEX [IDX_ROLEDATAID] ON [dbo].[ADMIN_ROLE_INFO]
([ID] ASC) 
WITH (IGNORE_DUP_KEY = ON)
GO

-- ----------------------------
-- Primary Key structure for table ADMIN_ROLE_INFO
-- ----------------------------
ALTER TABLE [dbo].[ADMIN_ROLE_INFO] ADD PRIMARY KEY ([ID])
GO
