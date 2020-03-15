# UR BI Portal

## 代码结构

* ur-bi-portal/src/main/java --> 后端代码
  * ur-bi-portal/src/main/java/com/ur/bi/controller --> 控制制器逻辑，即MVC分层中的`C（控制层）`层，负责处理前端请求，并将请求分发给服务层
    * 参考[FileManageController.java](../src/main/java/com/ur/bi/controller/FileManageController.java)。
  * ur-bi-portal/src/main/java/com/ur/bi/mappers --> 数据库表映射对象及配置文件，相当于DAO层，负责与数据库的交互
  * ur-bi-portal/src/main/java/com/ur/bi/model --> 数据库映射实体，定义Java实体类
    * 参考[FileInfo.java](../src/main/java/com/ur/bi/model/FileInfo.java)。
  * ur-bi-portal/src/main/java/com/ur/bi/service --> 业务服务逻辑，相当于MVC分层中的`M（模型层）`层
    * 参考[FileInfoService.java](../src/main/java/com/ur/bi/service/FileInfoService.java)。
* ur-bi-portal/src/main/resources
  * ur-bi-portal/src/main/resources/application*.yml --> 后端项目配置
    * 开始开发前，需要将`application.yml.example`重命名为`application.yml`
  * ur-bi-portal/src/main/resources/static --> 静态资源
  * ur-bi-portal/src/main/resources/templates --> Thymeleaf模板目录，相当于MVC分层中的`V（视图层）`层

## 开发技术

### 前端

#### Thymeleaf

Thymeleaf是一个后端的前端选渲染模板语言，是SpringBoot的默认支持的模板语言，其官网为：[https://www.thymeleaf.org/](https://www.thymeleaf.org/)，中文的一些教程可以参考：[Thymeleaf的使用](https://yq.aliyun.com/articles/636559)。

在本项目中请参考[MonthStandard.html](../src/main/resources/templates/config/MonthStandard.html)及[files.html](../src/main/resources/templates/file-manage/files.html)。

以下代码结构体现了使用thymeleaf统一引入公共的`样式库`及`js库`的方法，每个页的结构应参考如下代码结构，其中需要关注`<head th:include="/common/common_head :: commonHeader('月度标准值配置')"></head>`及`<div th:include="/common/onload_js :: onloadJS"></div>`在代码中的位置，其中`<!-- TODO 具体的页面元素的实现 -->`与`/* TODO 具体的Vue.js的逻辑实现 */`分别为HTML与JavaScript中的注释，相应的HTML代码和JavaScript代码需要在对应的位置上实现。

**示例**(关注**TODO**的部分)：

```html
<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head th:include="/common/common_head :: commonHeader('文件管理')"></head>
<body>
<div id="app">
      <!-- TODO 具体的页面元素的实现 -->
</div>
</body>

<!-- include 公共js库 -->
<div th:include="/common/onload_js :: onloadJS"></div>
  <script>
  /*<![CDATA[*/
    new Vue({
      /* TODO 具体的Vue.js的逻辑实现 */
    })
    /*]]>*/
  </script>
</html>
```

#### Vue.js

项目目前需要使用`Vue.js`，Vue (读音 /vjuː/，类似于 view) 是一套用于构建用户界面的渐进式框架。与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。官方指南假设你已了解关于 HTML、CSS和JavaScript的中级知识。所以要体系化地学习Vue.js的话，需要有一些基础的HTML、CSS和JavaScript知识，如果已经具备，则可跳过。

* HTML及JavaScript基础
  * [HTML教程](https://www.w3school.com.cn/html/index.asp)
    * [HTML表单](https://www.w3school.com.cn/html/html_forms.asp)
  * [JavaScript简介](https://www.w3cschool.cn/javascript/js-intro.html)
* Vue.js
  * [模板语法](https://cn.vuejs.org/v2/guide/syntax.html)
  * [深入响应式原理](https://cn.vuejs.org/v2/guide/reactivity.html)
  * [表单输入绑定](https://cn.vuejs.org/v2/guide/forms.html)
  * [事件处理方法](https://cn.vuejs.org/v2/guide/events.html#事件处理方法)

**示例**(关注**TODO**的部分)：

```html
<script type="text/javascript" th:inline="javascript">
    /*<![CDATA[*/
    new Vue({
        el: '#app',
        data() {
            return {
                // TODO 参考 [深入响应式原理](https://cn.vuejs.org/v2/guide/reactivity.html)、[表单输入绑定](https://cn.vuejs.org/v2/guide/forms.html)
            };
        },
        mounted: function () {
          // TODO 此处的逻辑了为页面加载时即运行的逻辑
        },
        methods: {
          // TODO 此处为JS的响应的事件处理函数， 参考 [事件处理方法](https://cn.vuejs.org/v2/guide/events.html#事件处理方法)
        }
    })
    /*]]>*/
</script>
```

#### Element UI

目前系统前端的元素均使用了`Element UI`进行实现，可以随时参考：[Element UI组件](https://element.eleme.cn/#/zh-CN/component/installation)，可以在页面上获取相应的元素的代码进行使用。

**示例**(关注使用`<!-- -->`**注释**的部分)：

```html
<div id="app">
    <div id="file-upload" style="margin-top: 20px; margin-left: 10px;">
        <div style="margin-bottom: 5px;">
            <!-- 日期选择器 -->
            <el-date-picker
                    v-model="queryCondition.dataDate"
                    type="date"
                    value-format="yyyyMMdd"
                    placeholder="选择上传的日期">
            </el-date-picker>
            <!-- 下拉选择器 -->
            <el-select v-model="queryCondition.folder" default-first-option="true" placeholder="请选择上传的目录">
                <el-option
                        v-for="item in folderOptions"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                </el-option>
            </el-select>
            <!-- 普通按钮 -->
            <el-button type="text" @click="showUploadPanel">上传文件</el-button>
            <el-button type="text" @click="loadTableData">查询</el-button>
        </div>
        <div>
            <el-dialog
                    title="上传文件"
                    :visible.sync="dialogVisible"
                    :onclose="handleClose"
                    width="30%">
                <el-form>
                    <el-form-item>
                        <el-upload ref="upload"
                                   name="dataFiles"
                                   accept=".xls,.xlsx"
                                   :action="uploadAction"
                                   :before-upload="beforeUpload"
                                   :limit="1"
                                   :file-list="dataFiles"
                                   :auto-upload="true">
                            <el-button slot="trigger" type="primary">上传文件</el-button>
                            <div slot="tip" class="el-upload__tip">只能上传xls/xlsx 文件,每次只能上传一个</div>
                        </el-upload>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="handleClose">关闭</el-button>
              </span>
            </el-dialog>
        </div>
        <div>
            <!-- 二维数据表展示 -->
            <el-table
                    :data="this.queryResult.data"
                    style="width: 100%">
                <el-table-column v-for="col in cols" v-bind:key="col.prop" :prop="col.prop" :label="col.label">
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                @click="handleDownload(scope.$index, scope.row)">下载</el-button>
                        <el-button
                                size="mini"
                                type="danger"
                                @click="handleDelete(scope.$index, scope.row)">删除</el-button>

                    </template>
                </el-table-column>
            </el-table>
            <!-- 分页器 -->
            <el-pagination :page-size="20" :total="queryResult.totalRecordNum" :current-page="queryResult.currPage" v-on:current-change="handleCurrentChange" v-on:size-change="handleSizeChange" layout="total, sizes, prev, pager, next, jumper">
            </el-pagination>
        </div>
    </div>
</div>
```

### 后端

#### SpringBoot

Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者。

* [Spring-Boot干货系列](http://tengj.top/categories/Spring-Boot干货系列/)
  * [Spring Boot干货系列：（一）优雅的入门篇](http://tengj.top/2017/02/26/springboot1/)
  * [Spring Boot干货系列：（二）配置文件解析](http://tengj.top/2017/02/28/springboot2/)
  * [Spring Boot干货系列：（四）开发Web应用之Thymeleaf篇](http://tengj.top/2017/03/13/springboot4/)
  * [Spring Boot干货系列：（六）静态资源和拦截器处理](http://tengj.top/2017/03/30/springboot6/)
  * [Spring Boot干货系列：（九）数据存储篇-SQL关系型数据库之MyBatis的使用](http://tengj.top/2017/04/23/springboot9/)
  * [Spring Boot干货系列：（十一）数据存储篇-Spring Boot整合Mybatis通用Mapper插件](http://tengj.top/2017/12/20/springboot11/)
* [SpringBoot【SpringMVC+mybatis完成CRUD案例】](https://dpb-bobokaoya-sm.blog.csdn.net/article/details/90244244)

#### MyBatis

* Model，参考[FileInfo.java](../src/main/java/com/ur/bi/model/FileInfo.java)。
  * Model的编写时，使用`Lombok`插件，可以减少Getters和Setters代码的编写和生成。
* Mapper配置，参考[FileInfoMapper.java](../src/main/java/com/ur/bi/mappers/FileInfoMapper.java)及[FileInfoMapper.xml](../src/main/java/com/ur/bi/mappers/FileInfoMapper.xml)。

## 开发环境准备

### Maven

Maven 翻译为"专家"、"内行"，是 Apache 下的一个纯 Java 开发的开源项目。基于项目对象模型（缩写：POM）概念，Maven利用一个中央信息片断能管理一个项目的构建、报告和文档等步骤。

Maven 是一个项目管理工具，可以对 Java 项目进行构建、依赖管理。

* [Maven教程](https://www.runoob.com/maven/maven-tutorial.html)

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

#### IDEA

* [IDEA新手使用教程（详解）](https://cloud.tencent.com/developer/article/1448115)
* [激活码](http://idea.lanyus.com/)

#### Lombok

* [Intellij IDEA 安装lombok及使用详解](https://blog.csdn.net/zhglance/article/details/54931430)

常用注解如下：

* @Slf4j
* @Data
* @ToString
* @NoArgsConstructor
