/****** Object:  Table [dbo].[ETLcontrol]    Script Date: 9/19/2022 5:17:38 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ETLcontrol](
	[FPATH] [varchar](100) NOT NULL,
	[FNAME] [varchar](100) NOT NULL,
	[ISPROCESSED] [bit] NULL,
	[COMPLETEDDATE] [datetime] NULL,
	[FILEDATE]  AS (CONVERT([datetime],(stuff(stuff(substring([FNAME],patindex('%[0-9]%',[FNAME]),(8)),(3),(0),'-'),(6),(0),'-')+' ')+stuff(stuff(substring(substring([FNAME],patindex('%[0-9]%',[FNAME]),(15)),(10),(6)),(3),(0),':'),(6),(0),':'))),
 CONSTRAINT [PK_ETLcontrol] PRIMARY KEY CLUSTERED 
(
	[FPATH] ASC,
	[FNAME] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ETLcontrol] ADD  CONSTRAINT [DF_ISPROCESSED_ETLcontrol]  DEFAULT ((0)) FOR [ISPROCESSED]
GO


