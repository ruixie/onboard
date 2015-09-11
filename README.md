### Onboard 敏捷软件开发协同工具

Onboard是用于软件开发团队在开发过程中对生产过程进行协同的工具，其开源版本包含如下基本功能：

- 团队管理：对团队成员、权限和分组进行管理
- 项目管理：对团队进行中和已经结束的项目进行管理
- 迭代管理：利用敏捷开发的思维，将开发分解成一个个迭代来进行，加速开发的效率
- 需求管理：对产品目标的管理，利用需求树将需求层级分解
- 缺陷管理：对产品安全性能的管理，帮助提高产品的质量
- 话题与讨论：为团队成员提供在线讨论的平台
- 日历与回顾：记录团队和项目的大事件，并为所有操作提供记录
- 文档与文件管理：将项目中重要的文档文件集中存储，便于协同编辑和共享。  

### 安装

#### 必备软件下载与安装

- Eclipse Java EE，推荐使用Kepler版本
- JDK，推荐使用1.6版本
- Virgo，推荐使用3.6版本
- Mybatis Migration，推荐使用3.1.0版本
- MySQL，推荐使用最新版
- Redis，推荐使用2.0.2版本（推荐安装为系统Service）

#### 环境变量配置

- JAVA_HOME：JDK的安装目录，如“C:\Program Files\Java\jdk1.6.0_45”
- JAVA_TOOL_OPTIONS：Java的启动命令，如“-Dfile.encoding=UTF-8”
- MIGRATION_HOME：Mybatis Migration的安装目录

Path里需要添加Mybatis Migration的路径，如“%MIGRATION_HOME%\bin”

#### Eclipse配置

- 设置 Installed JREs (Eclipse --Windows--Preferences--Java--Installed JREs)，将安装的JDK引入
- 安装 Virgo Runtime Server 插件 (Eclipse -- Help --Install New Software,  Work with ""Virgo IDE Releases" - http://download.eclipse.org/virgo/release/tooling/" 添加上面路径， 安装 Eclipse Virgo Tools，

#### Git clone代码到本地

- 使用git进行克隆
- 将../database/environments/development-sample.properties重命名为development.properties，此为数据库的基本设置
- 将../frontend/kernel/src/main/resources/application.examples.properties重命名为application.properties，此为前端的基本设置
- 将../onboard.properties.sample重命名为onboard.properties，并复制到 Virgo安装目录/repository/usr中，此为后端的基本设置
- 将Virgo需要用到的第三方库（外链：Virgo第三方库仓库）复制到 Virgo安装目录/repository/usr中

#### 初始化数据库

- 在MySQL中建立新Scheme，名称设为onboard，密码如123456
- 在命令行中进入Onboard根目录下的database目录，如C:\user\git\osgicn\database，并依次执行下列命令
- migrate bootstrap,
- mysql -u root -p 123456 onboard < teamforge-data.sql
- migrate up
- migrate status

#### 配置后端

- 在Eclipse中导入Maven Project（选定Onboard的根目录），并对parent包右键Run As - Maven Build - clean install，以进行构建。

#### 配置Virgo

- 将前一步中引入的包依次导入到Virgo Runtime Server中，参考顺序如下：

{"artefacts":[{"id":"org.eclipse.virgo.server.modulefactory:/onboard/onboard.plan"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.domain.mapper.model"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.domain.model"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.index"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.index.impl"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.api"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.domain.transform"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.domain.mapper"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.common"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.common.impl"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.web"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.web.impl"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.account"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.account.impl"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.activity"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.activity.impl"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.collaboration"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.notification"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.collaboration.impl"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.notification.impl"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.websocket"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.security"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.security.impl"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.github"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.github.impl"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.help"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.help.impl"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.upload"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.upload.impl"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.wiki"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.wiki.impl"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.service.sampleProject"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.web.api"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.plugin.git"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.plugin.ci"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.plugin.git.httpserver"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.plugin.ssh"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.plugin.git.sshserver"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.plugin.calendar"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.plugin.mailgun"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.plugin.solr"},
{"id":"org.eclipse.virgo.server.modulefactory:com.onboard.plugin.suggestion"}]}

并右键点击，Start以部署后端。

#### 配置与部署前端

- 在Eclipse中导入Maven Project（选定Onboard的根目录/frontend）
- 右键选中com.onboard.frontend.parent，Run As - Maven Build - clean install，以进行构建。
- 在成功后，右键选中com.onboard.frontend.kernel/src/main/java/Application.java, Run As - Java Application，以进行部署。
- 随后，可在本地127.0.0.1:8000中查看启动的前端

### 参与开发

Onboard的额外功能开发主要是通过编写插件的形式，可以自由的在大多数层级的页面/前后端加入定制的内容，有关插件的编写方法，请查阅下列的各类指南。

外链：插件编写指南

### 关于我们

我们是一群来自北京大学软件工程专业的研究生和本科生，帮助千千万万软件开发人员提高效率降低成本是我们的梦想，也是我们的使命。我们希望学以致用，通过不懈的努力将专业研究与最佳实践完美结合，做最专业的敏捷软件开发协同工具与服务。

### 联系方式

北京市颐和园路5号北京大学
wye@pku.edu.cn 
13011106131