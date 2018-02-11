# zndo-metronic-admin
基于 Spring Boot 1.5.10.RELEASE &amp; Thymeleaf 和 Metronic 5.0.7.1 模板的后台管理项目

Features:
国际化
-- app_url?lang=zh_CN
-- app_url?lang=en_US
持久化-MyBatis
缓存
-- 一级 EhCache
-- 二级 Redis

登录
-- Ajax 表单提交
-- 验证码
-- 登录错误次数限制


注意事项：
1、MBG 插件不会识别 rootClass 和 rootInterface，生成后需要手动 import
2、使用 DevTools 和 TK 通用 Mapper 时，在 src/main/resources 添加 spring-devtools.properties 文件，内容：
restart.include.mapper=/mapper-[\\w-\\.]+jar
restart.include.pagehelper=/pagehelper-[\\w-\\.]+jar







