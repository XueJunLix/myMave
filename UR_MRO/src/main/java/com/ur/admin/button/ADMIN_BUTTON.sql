USE [me_test]
GO

EXEC sys.sp_dropextendedproperty @name=N'MS_Description' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'MEMO'
GO

EXEC sys.sp_dropextendedproperty @name=N'MS_Description' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'ORDERBY'
GO

EXEC sys.sp_dropextendedproperty @name=N'MS_Description' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'BUTTON_STYLE'
GO

EXEC sys.sp_dropextendedproperty @name=N'MS_Description' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'BUTTON_CLASS'
GO

EXEC sys.sp_dropextendedproperty @name=N'MS_Description' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'BUTTON_ICON'
GO

EXEC sys.sp_dropextendedproperty @name=N'MS_Description' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'BUTTON_CLICK'
GO

EXEC sys.sp_dropextendedproperty @name=N'MS_Description' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'BUTTON_NAME'
GO

EXEC sys.sp_dropextendedproperty @name=N'MS_Description' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'BUTTON_CODE'
GO

EXEC sys.sp_dropextendedproperty @name=N'MS_Description' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'ID'
GO

/****** Object:  Table [dbo].[ADMIN_BUTTON]    Script Date: 2019/8/30 星期五 16:02:43 ******/
DROP TABLE [dbo].[ADMIN_BUTTON]
GO

/****** Object:  Table [dbo].[ADMIN_BUTTON]    Script Date: 2019/8/30 星期五 16:02:43 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ADMIN_BUTTON](
	[ID] [bigint] IDENTITY(-1,-1) NOT NULL,
	[BUTTON_CODE] [varchar](100) NOT NULL,
	[BUTTON_NAME] [varchar](100) NOT NULL,
	[BUTTON_CLICK] [varchar](100) NULL,
	[BUTTON_ICON] [varchar](500) NULL,
	[BUTTON_CLASS] [varchar](200) NULL,
	[BUTTON_STYLE] [varchar](500) NULL,
	[ORDERBY] [bigint] NULL,
	[MEMO] [varchar](100) NULL,
	[CREATED_BY] [varchar](50) NOT NULL,
	[CREATED_TIME] [datetime2](7) NOT NULL,
	[LAST_UPDATED_BY] [varchar](50) NOT NULL,
	[LAST_UPDATED_TIME] [datetime2](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'主键ID' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'ID'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'按钮编码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'BUTTON_CODE'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'按钮名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'BUTTON_NAME'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'按钮点击事件' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'BUTTON_CLICK'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'按钮图标' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'BUTTON_ICON'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'按钮Class样式' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'BUTTON_CLASS'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'按钮自定义样式' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'BUTTON_STYLE'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'顺序' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'ORDERBY'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备注' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ADMIN_BUTTON', @level2type=N'COLUMN',@level2name=N'MEMO'
GO

