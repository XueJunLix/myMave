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

Date: 2019-08-13 15:32:42
*/


-- ----------------------------
-- Table structure for ADMIN_RIGHTSHARE
-- ----------------------------
DROP TABLE [dbo].[ADMIN_RIGHTSHARE]
GO
CREATE TABLE [dbo].[ADMIN_RIGHTSHARE] (
[ID] bigint NOT NULL IDENTITY(1,1) ,
[RIGHT_TYPE] varchar(10) NOT NULL ,
[RIGHT_SOUTCE_ID] int NOT NULL ,
[RESOURCE_TYPE] varchar(10) NOT NULL ,
[RESOURCE_ID] int NOT NULL ,
[CREATED_BY] varchar(50) NOT NULL ,
[CREATED_TIME] datetime2(7) NOT NULL ,
[LAST_UPDATED_BY] varchar(50) NOT NULL ,
[LAST_UPDATED_TIME] datetime2(7) NOT NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[ADMIN_RIGHTSHARE]', RESEED, 5)
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_RIGHTSHARE', 
'COLUMN', N'ID')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'主键ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_RIGHTSHARE'
, @level2type = 'COLUMN', @level2name = N'ID'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'主键ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_RIGHTSHARE'
, @level2type = 'COLUMN', @level2name = N'ID'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_RIGHTSHARE', 
'COLUMN', N'RIGHT_TYPE')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'授权资源：M-菜单 R-角色 U-用户组'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_RIGHTSHARE'
, @level2type = 'COLUMN', @level2name = N'RIGHT_TYPE'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'授权资源：M-菜单 R-角色 U-用户组'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_RIGHTSHARE'
, @level2type = 'COLUMN', @level2name = N'RIGHT_TYPE'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_RIGHTSHARE', 
'COLUMN', N'RIGHT_SOUTCE_ID')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'授权资源ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_RIGHTSHARE'
, @level2type = 'COLUMN', @level2name = N'RIGHT_SOUTCE_ID'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'授权资源ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_RIGHTSHARE'
, @level2type = 'COLUMN', @level2name = N'RIGHT_SOUTCE_ID'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_RIGHTSHARE', 
'COLUMN', N'RESOURCE_TYPE')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'资源类别：0-角色 1-用户组 2-人员'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_RIGHTSHARE'
, @level2type = 'COLUMN', @level2name = N'RESOURCE_TYPE'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'资源类别：0-角色 1-用户组 2-人员'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_RIGHTSHARE'
, @level2type = 'COLUMN', @level2name = N'RESOURCE_TYPE'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_RIGHTSHARE', 
'COLUMN', N'RESOURCE_ID')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'资源ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_RIGHTSHARE'
, @level2type = 'COLUMN', @level2name = N'RESOURCE_ID'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'资源ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_RIGHTSHARE'
, @level2type = 'COLUMN', @level2name = N'RESOURCE_ID'
GO

-- ----------------------------
-- Indexes structure for table ADMIN_RIGHTSHARE
-- ----------------------------
CREATE UNIQUE INDEX [IDX_ROLEDATAID] ON [dbo].[ADMIN_RIGHTSHARE]
([ID] ASC) 
WITH (IGNORE_DUP_KEY = ON)
GO

-- ----------------------------
-- Primary Key structure for table ADMIN_RIGHTSHARE
-- ----------------------------
ALTER TABLE [dbo].[ADMIN_RIGHTSHARE] ADD PRIMARY KEY ([ID])
GO
