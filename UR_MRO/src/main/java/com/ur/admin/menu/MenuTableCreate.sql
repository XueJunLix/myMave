CREATE TABLE [dbo].[ADMIN_MENU_INFO] (
[ID] bigint NOT NULL IDENTITY(1,1) ,
[MENU_CODE] varchar(100) NULL ,
[MENU_NAME] varchar(100) NULL ,
[PARENT_MENU_ID] bigint NULL ,
[MENU_URL] varchar(500) NULL ,
[MENU_LEVEL] int NOT NULL ,
[STATUS] int NOT NULL ,
[MENU_DESC] varchar(1000) NULL ,
[CREATED_BY] varchar(50) NOT NULL ,
[CREATED_TIME] datetime2(7) NOT NULL ,
[LAST_UPDATED_BY] varchar(50) NOT NULL ,
[LAST_UPDATED_TIME] datetime2(7) NOT NULL 
)
GO

IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_MENU_INFO', 
'COLUMN', N'ID')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'主键ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'ID'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'主键ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'ID'
GO

IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_MENU_INFO', 
'COLUMN', N'MENU_CODE')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'菜单编码'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'MENU_CODE'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'菜单编码'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'MENU_CODE'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_MENU_INFO', 
'COLUMN', N'MENU_NAME')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'菜单名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'MENU_NAME'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'菜单名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'MENU_NAME'
GO

IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_MENU_INFO', 
'COLUMN', N'PARENT_MENU_ID')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'上级菜单ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'PARENT_MENU_ID'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'上级菜单ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'PARENT_MENU_ID'
GO

IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_MENU_INFO', 
'COLUMN', N'MENU_URL')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'菜单链接'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'MENU_URL'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'菜单链接'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'MENU_URL'
GO

IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_MENU_INFO', 
'COLUMN', N'MENU_LEVEL')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'菜单层级'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'MENU_LEVEL'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'菜单层级'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'MENU_LEVEL'
GO

IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_MENU_INFO', 
'COLUMN', N'STATUS')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'状态'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'STATUS'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'状态'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'STATUS'
GO

IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'ADMIN_MENU_INFO', 
'COLUMN', N'MENU_DESC')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'备注'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'MENU_DESC'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'备注'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'ADMIN_MENU_INFO'
, @level2type = 'COLUMN', @level2name = N'MENU_DESC'
GO


-- ----------------------------
-- Indexes structure for table ADMIN_MENU_INFO
-- ----------------------------
CREATE UNIQUE INDEX [IDX_MENUDATAID] ON [dbo].[ADMIN_MENU_INFO]
([ID] ASC) 
WITH (IGNORE_DUP_KEY = ON)
GO

-- ----------------------------
-- Primary Key structure for table ADMIN_MENU_INFO
-- ----------------------------
ALTER TABLE [dbo].[ADMIN_MENU_INFO] ADD PRIMARY KEY ([ID])
GO