# UR BI Portal

## 代码结构

### ur-bi-portal/src/main/java

### ur-bi-portal/src/main/resources/config

### ur-bi-portal/src/main/resources/static

### ur-bi-portal/src/main/resources/templates

## 开发技术

### 前端

#### Vue.js

#### Element UI

随时参考：[Element UI组件](https://element.eleme.cn/#/zh-CN/component/installation)

#### Thymeleaf

### 后端

#### SpringBoot

#### SpringMVC

* Controller层，参考[FileManageController.java](../src/main/java/com/ur/bi/controller/FileManageController.java)。
* Services层，参考[FileInfoService.java](../src/main/java/com/ur/bi/service/FileInfoService.java)。
* Model层，参考[MyBatis](MyBatis)

#### MyBatis

* Model，参考[FileInfo.java](../src/main/java/com/ur/bi/model/FileInfo.java)。
    * Model的编写时，使用Lombok插件，可以减少Getters和Setters代码的编写和生成。
* Mapper配置，参考[FileInfoMapper.java](../src/main/java/com/ur/bi/mappers/FileInfoMapper.java)及[FileInfoMapper.xml](../src/main/java/com/ur/bi/mappers/FileInfoMapper.xml)。

## 开发环境准备

### Maven

按如下方式配置用户目录下的`.m2/settings.xml`：
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      https://maven.apache.org/xsd/settings-1.0.0.xsd">
  <localRepository/>
  <interactiveMode/>
  <offline/>
  <pluginGroups/>
  <servers/>
  <mirrors>
    <mirror>
      <id>aliyunmaven</id>
      <mirrorOf>*,!cloudera</mirrorOf>
      <name>阿里云公共仓库</name>
      <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
  </mirrors>
  <proxies/>
  <profiles/>
  <activeProfiles/>
</settings>
```

### IDE

建议使用`IDEA`进行开发，并且安装插件`Lombok`。

#### IDEA

#### Lombok

常用注解如下：

* @Slf4j
* @Data
* @ToString
* @NoArgsConstructor

