1、增加系统日志文件记录配置			20190731	lul
	+/MRO2.0/src/main/java/logback.xml
	*/MRO2.0/pom.xml
	
2、spring-boot配置文件调整：测试环境		20190731	lul
	*/MRO2.0/src/main/resources/config/application.yml
	*/MRO2.0/src/main/resources/config/application-dev.yml
	*/MRO2.0/src/main/java/com/ur/Application.java

3、修改element当前样式版本替换为@2.9.2的源码	20190801	lyj
    */MRO2.0/src/main/resources/static/resources/element/index_original.yml


4、redis配置修改		20190802	lul
	*/MRO2.0/src/main/resources/config/application-dev.yml
	*/MRO2.0/src/main/java/com/ur/common/RedisConfig.java

5、修改物料编辑页，具体修改了部分下拉框的动态数据的渲染，以及店铺形象的下拉框更改为多选下拉框等 20190802 lyj
    */MRO2.0/src/main/resources/templates/mro/mat/WLbianji.html
    
6、系统管理：角色-CUDQ功能增加				20190807	lul
	新增数据表：ADMIN_ROLE_INFO
	+/MRO2.0/src/main/java/com/ur/admin/role/RoleTableCreate.sql
	+/MRO2.0/src/main/java/com/ur/admin/role
	*/MRO2.0/src/main/resources/templates/admin/AdminRoleInfoList.html
	*/MRO2.0/src/main/resources/templates/admin/AdminRoleInfoManage.html
	*/MRO2.0/src/main/resources/templates/admin/AdminRoleInfoNewJob.html

    
7、修改element的js版本更新至@2.11.1  解决级联选择器问题	 20190808	lyj
	*/MRO2.0/src/main/resources/static/resources/js/element/lib/index.min.js
	
8、系统管理：菜单-CUDQ功能增加				20190809	lul
	新增数据表：ADMIN_MENU_INFO
	+/MRO2.0/src/main/java/com/ur/admin/menu
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoList.html
	+/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoManage.html
	
9、增加对象处理工具类				20190809	lul
	+/MRO2.0/src/main/java/com/ur/common/util/Util.java
	
10、系统管理：用户组-CUDQ功能增加			20190812	lul
	新增数据表：ADMIN_USERGROUP
	+/MRO2.0/src/main/java/com/ur/admin/usergroup
	*/MRO2.0/src/main/resources/templates/admin/AdminGroupInfoList.html
	*/MRO2.0/src/main/resources/templates/admin/AdminGroupInfoManage.html
	
11、修改系统管理：菜单、角色详细页面的状态显示内容				20190812	lul
	*/MRO2.0/src/main/java/com/ur/admin/menu/controller/AdminMenuInfoController.java
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoManage.html
	*/MRO2.0/src/main/resources/templates/admin/AdminRoleInfoManage.html
	
12、增加获取所有角色、用户组的方法				20190813	lul
	*/MRO2.0/src/main/java/com/ur/admin/role/mappers/AdminRoleInfoMapper.xml
	*/MRO2.0/src/main/java/com/ur/admin/role/mappers/AdminRoleInfoMapper.java
	*/MRO2.0/src/main/java/com/ur/admin/role/service/AdminRoleInfoService.java
	*/MRO2.0/src/main/java/com/ur/admin/usergroup/mappers/AdminUserGroupMapper.xml
	*/MRO2.0/src/main/java/com/ur/admin/usergroup/mappers/AdminUserGroupMapper.java
	*/MRO2.0/src/main/java/com/ur/admin/usergroup/service/AdminUserGroupService.java
	
13、权限管理：菜单整合角色、用户组数据				20190813	lul
	+/MRO2.0/src/main/java/com/ur/admin/rightshare
	*/MRO2.0/src/main/java/com/ur/admin/menu/model/AdminMenuInfo.java
	*/MRO2.0/src/main/java/com/ur/admin/menu/controller/AdminMenuInfoController.java
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoManage.html
	*/MRO2.0/src/main/java/com/ur/common/service/RedisMessageBOService.java

14、新增MRO头部导航页面	 20190813	lyj
	+/MRO2.0/src/main/resources/templates/mro/mat/MROnav.html
	
15、后台封装数据传到前台页面：如果出现&quot; 与  双引号 转换问题，则将<script  type="text/javascript"> 变成 <script th:inline="javascript">

16、权限管理：用户组-CUDQ功能增加				20190815	lul
	+/MRO2.0/src/main/java/com/ur/admin/user
	*/MRO2.0/src/main/resources/templates/admin/AdminUserInfoList.html
	*/MRO2.0/src/main/resources/templates/admin/AdminUserInfoManage.html
	
17、用户组增加用户功能				20190819	lul
	*/MRO2.0/src/main/java/com/ur/admin/usergroup/mappers/AdminUserGroupMapper.xml
	*/MRO2.0/src/main/java/com/ur/admin/usergroup/service/AdminUserGroupService.java
	*/MRO2.0/src/main/java/com/ur/admin/usergroup/controller/AdminUserGroupController.java
	*/MRO2.0/src/main/resources/templates/admin/AdminGroupInfoManage.html
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/mappers/AdminRightshareMapper.xml
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/mappers/AdminRightshareMapper.java
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/service/AdminRightshareService.java
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/controller/AdminRightshareController.java
	
18、角色增加用户功能			20190819	lul
	*/MRO2.0/src/main/java/com/ur/admin/role/model/AdminRoleInfo.java
	*/MRO2.0/src/main/java/com/ur/admin/role/mappers/AdminRoleInfoMapper.xml
	*/MRO2.0/src/main/java/com/ur/admin/role/controller/AdminRoleInfoController.java
	*/MRO2.0/src/main/resources/templates/admin/AdminRoleInfoList.html
	*/MRO2.0/src/main/resources/templates/admin/AdminRoleInfoManage.html

19、菜单--角色、用户组授权；角色--人员授权；用户组--人员授权；人员--角色、用户组授权			20190820	lul
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/mappers/AdminRightshareMapper.xml
	*/MRO2.0/src/main/java/com/ur/admin/menu/controller/AdminMenuInfoController.java
	*/MRO2.0/src/main/java/com/ur/admin/role/controller/AdminRoleInfoController.java
	*/MRO2.0/src/main/java/com/ur/admin/usergroup/controller/AdminUserGroupController.java
	*/MRO2.0/src/main/java/com/ur/admin/user/model/SysUserInfo.java
	*/MRO2.0/src/main/java/com/ur/admin/user/mappers/SysUserInfoMapper.xml
	*/MRO2.0/src/main/java/com/ur/admin/user/controller/SysUserInfoController.java
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoList.html
	*/MRO2.0/src/main/resources/templates/admin/AdminRoleInfoList.html
	*/MRO2.0/src/main/resources/templates/admin/AdminGroupInfoList.html
	*/MRO2.0/src/main/resources/templates/admin/AdminUserInfoManage.html
	*/MRO2.0/src/main/resources/templates/admin/AdminUserInfoList.html

20、首页功能整理				20190820	lul
	*/MRO2.0/src/main/java/com/ur/common/service/IndexMainService.java
	*/MRO2.0/src/main/java/com/ur/common/controller/IndexMainController.java
	*/MRO2.0/src/main/resources/templates/indexmain.html
	
21、登录验证脱离cas			20190823	lul
	+/MRO2.0/src/main/java/com/ur/common/CustomAuthenticationSuccessHandler.java
	+/MRO2.0/src/main/java/com/ur/common/CustomLogoutHandler.java
	+/MRO2.0/src/main/java/com/ur/common/Md5PasswordEncoder.java
	*/MRO2.0/src/main/java/com/ur/common/CustomUserDetailsService.java
	*/MRO2.0/src/main/java/com/ur/common/SecurityConfig.java
	*/MRO2.0/src/main/java/com/ur/Application.java
	*/MRO2.0/src/main/resources/config/application-dev.yml
	*/MRO2.0/src/main/resources/templates/login.html

22、1、首页增加当前用户显示以及系统推出功能；2、菜单层级逻辑判断			20190823	lul
	*/MRO2.0/src/main/resources/templates/indexmain.html
	*/MRO2.0/src/main/java/com/ur/common/controller/IndexMainController.java
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoManage.html

23、权限批量修改：减少redis缓存写入删除频率			20190827	lul
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/service/AdminRightshareService.java
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/controller/AdminRightshareController.java
	*/MRO2.0/src/main/java/com/ur/admin/menu/model/AdminMenuInfo.java
	*/MRO2.0/src/main/java/com/ur/admin/menu/controller/AdminMenuInfoController.java
	*/MRO2.0/src/main/java/com/ur/admin/menu/service/AdminMenuInfoService.java
	*/MRO2.0/src/main/java/com/ur/admin/role/service/AdminRoleInfoService.java
	*/MRO2.0/src/main/java/com/ur/admin/role/model/AdminRoleInfo.java
	*/MRO2.0/src/main/java/com/ur/admin/role/controller/AdminRoleInfoController.java
	*/MRO2.0/src/main/java/com/ur/admin/user/controller/SysUserInfoController.java
	*/MRO2.0/src/main/java/com/ur/admin/usergroup/service/AdminUserGroupService.java
	*/MRO2.0/src/main/java/com/ur/admin/usergroup/controller/AdminUserGroupController.java
	*/MRO2.0/src/main/java/com/ur/common/service/RedisMessageBOService.java
	*/MRO2.0/src/main/resources/templates/admin/AdminGroupInfoManage.html

24、增加按钮CUDQ功能；按钮与菜单关联功能			20190827	lul
	+/MRO2.0/src/main/java/com/ur/admin/button
	+/MRO2.0/src/main/resources/templates/admin/AdminButtonInfoList.html
	+/MRO2.0/src/main/resources/templates/admin/AdminButtonInfoManage.html
	
25、系统会话过期后再点击其他功能，将跳转到登录页面重新登录				20190828	lul
	*/MRO2.0/src/main/java/com/ur/common/SecurityConfig.java
	*/MRO2.0/src/main/java/com/ur/Application.java
	+/MRO2.0/src/main/resources/templates/sessionInvalid.html

26、页面加载出现大括号{}，说明页面有直接配置变量名，此时需要添加样式			20190828	lul
	[v-cloak] {
        display: none !important;
    }
             且在div上增加属性 v-cloak
             
    */MRO2.0/src/main/resources/templates/admin/AdminUserInfoManage.html
    */MRO2.0/src/main/resources/templates/admin/AdminRoleInfoManage.html
    
27、菜单----> 按钮相关联				20190829	lul
	*/MRO2.0/src/main/java/com/ur/admin/menu/model/AdminMenuInfo.java
	*/MRO2.0/src/main/java/com/ur/admin/menu/controller/AdminMenuInfoController.java
	*/MRO2.0/src/main/java/com/ur/admin/button/model/AdminButtonInfo.java
	*/MRO2.0/src/main/java/com/ur/admin/button/controller/AdminButtonInfoController.java
	*/MRO2.0/src/main/resources/templates/admin/AdminButtonInfoManage.html
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoManage.html
	
28、根据权限组合修改获取权限功能			20190829	lul
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/service/AdminRightshareService.java
	
29、权限相关功能完善：角色-菜单按钮；菜单-按钮对应关系			20190903	lul
	*/MRO2.0/src/main/java/com/ur/admin/role/model/AdminRoleInfo.java
	*/MRO2.0/src/main/java/com/ur/admin/role/controller/AdminRoleInfoController.java
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/service/AdminRightshareService.java
	*/MRO2.0/src/main/java/com/ur/admin/button/controller/AdminButtonInfoController.java
	*/MRO2.0/src/main/java/com/ur/admin/menu/model/AdminMenuInfo.java
	*/MRO2.0/src/main/java/com/ur/admin/menu/controller/AdminMenuInfoController.java
	*/MRO2.0/src/main/resources/templates/admin/AdminRoleInfoManage.html

30、菜单、角色、用户组、按钮管理：详情页增加编码规则过滤				20190903	lul
	*/MRO2.0/src/main/resources/templates/admin/AdminButtonInfoManage.html
	*/MRO2.0/src/main/resources/templates/admin/AdminGroupInfoManage.html
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoList.html
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoManage.html
	*/MRO2.0/src/main/resources/templates/admin/AdminRoleInfoManage.html
	
31、主页菜单排序				20190904	lul
	*/MRO2.0/src/main/java/com/ur/admin/menu/service/AdminMenuInfoService.java
	*/MRO2.0/src/main/java/com/ur/common/service/IndexMainService.java
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoList.html
	
32、按钮权限控制，请参考菜单功能中的按钮权限控制进行配置				20190905	lul
	说明：按钮根据角色授权，需要设置中转按钮
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/service/AdminRightshareService.java
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/controller/AdminRightshareController.java
	*/MRO2.0/src/main/java/com/ur/admin/menu/controller/AdminMenuInfoController.java
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoList.html
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoManage.html
	
33、登录页面改造			20190917	lul
	-/MRO2.0/src/main/java/com/ur/common/CustomLogoutHandler.java
	-/MRO2.0/src/main/java/com/ur/common/CustomAuthenticationSuccessHandler.java
	-/MRO2.0/src/main/java/com/ur/common/CustomUserDetailsService.java
	*/MRO2.0/src/main/java/com/ur/common/SecurityConfig.java
	*/MRO2.0/src/main/resources/templates/login.html
	+/MRO2.0/src/main/resources/static/resources/images/1.jpg
	+/MRO2.0/src/main/resources/static/resources/images/2.jpg
	+/MRO2.0/src/main/resources/static/resources/images/3.jpg
	
34、登出、会话过期处理				20190917	lul
	*/MRO2.0/src/main/java/com/ur/common/SecurityConfig.java
	*/MRO2.0/src/main/java/com/ur/Application.java
	*/MRO2.0/src/main/resources/templates/indexmain.html
	*/MRO2.0/src/main/resources/templates/login.html
	
35、菜单保存异常处理				20190918	lul
	*/MRO2.0/src/main/java/com/ur/admin/menu/model/AdminMenuInfo.java
	*/MRO2.0/src/main/java/com/ur/admin/menu/controller/AdminMenuInfoController.java
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoManage.html
	
36、redis变量放在常量类里面定义				20190923	lul
	*/MRO2.0/src/main/java/com/ur/common/Constants.java
	*/MRO2.0/src/main/java/com/ur/admin/usergroup/service/AdminUserGroupService.java
	*/MRO2.0/src/main/java/com/ur/admin/user/service/SysUserInfoService.java
	*/MRO2.0/src/main/java/com/ur/admin/role/service/AdminRoleInfoService.java
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/service/AdminRightshareService.java
	*/MRO2.0/src/main/java/com/ur/admin/menu/service/AdminMenuInfoService.java
	*/MRO2.0/src/main/java/com/ur/admin/button/service/AdminButtonInfoService.java
	
37、用户组管理：多选人员组件从列表改成transfer穿梭框				20190923	lul
	*/MRO2.0/src/main/java/com/ur/admin/usergroup/model/AdminUserGroup.java
	*/MRO2.0/src/main/java/com/ur/admin/usergroup/service/AdminUserGroupService.java
	*/MRO2.0/src/main/java/com/ur/admin/usergroup/controller/AdminUserGroupController.java
	*/MRO2.0/src/main/resources/templates/admin/AdminGroupInfoManage.html
	
38、系统权限管理：按钮页面控制				20190925	lul
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/service/AdminRightshareService.java
	*/MRO2.0/src/main/java/com/ur/admin/rightshare/controller/AdminRightshareController.java
	*/MRO2.0/src/main/java/com/ur/admin/menu/service/AdminMenuInfoService.java
	*/MRO2.0/src/main/java/com/ur/admin/menu/controller/AdminMenuInfoController.java
	*/MRO2.0/src/main/java/com/ur/admin/button/service/AdminButtonInfoService.java
	*/MRO2.0/src/main/java/com/ur/admin/role/model/AdminRoleInfo.java
	*/MRO2.0/src/main/java/com/ur/admin/role/controller/AdminRoleInfoController.java
	*/MRO2.0/src/main/java/com/ur/admin/user/controller/SysUserInfoController.java
	*/MRO2.0/src/main/java/com/ur/common/service/IndexMainService.java
	*/MRO2.0/src/main/java/com/ur/mro/shop/controller/Shop2GCController.java
	*/MRO2.0/src/main/resources/templates/admin/AdminGroupInfoManage.html
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoList.html
	*/MRO2.0/src/main/resources/templates/admin/AdminMenuInfoManage.html
	*/MRO2.0/src/main/resources/templates/admin/AdminRoleInfoManage.html
	*/MRO2.0/src/main/resources/templates/admin/AdminUserInfoList.html
	*/MRO2.0/src/main/resources/templates/admin/AdminUserInfoManage.html

	38、店铺主数据按钮权限修改			20190926	lxj
	*/MRO2.0/src/main/java/com.ur.mro.shop.controller.Shop2GCController.java