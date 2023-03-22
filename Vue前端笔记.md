### vue 项目-目录结构
* 基于Vue脚手架创建出来的工程，有标准的目录结构
  1. node_modules:整个项目的依赖包  
  2. public：存放项目的静态文件
  3. src：存放项目的源代码
    1. assets:静态资源
    2. component：可重用的组件
    3. router：路由配置
    4. view：视图组件(页面)
    5. App.vue：入口页面(根组件)
    6. main.js：入口js文件
  4.package.json:模块基本信息，项目开发所需要模块，版本信息
  5. vue.config.js:保存vue配置的文件，代理、端口的配置等
<br><br>
* Vue的组件文件以.vue结尾，每个组件有三个部分组成
  1. \<template>:模板部分，由他生成HTML代码
  2. \<script>：控制模板的数据来源
  3. \<style>：css样式

#### Element
1. 是Element:是饿了么团队研发的，一套为开发者、设计师和产品经理准备的基于Vue 2.0的桌面端组件库。
2. 组件:组成网页的部件，例如超链接、按钮、图片、表格、表单、分页条等等。

3. 常见组件
  1. Table 表格
  2. Pagination 分页
  3. Dialog 对话框

4. Vue路由：URL中的hash(#)与组件之间的对应关系
  * 组成
    1. VueRouter:路由器类，根据路由请求在路由视图中动态渲染选中的组件
    2. \<router-link>:请求链接组件，浏览器<a>
    3. \<router-view>:动态视图组件，用来渲染展示与路由路径对应的组件
  <br><br>
#### Nginx
  
1. 一款轻量级的Web服务器/反向代理服务器及电子邮件代理服务器。占有内存少，并发能力强
2. 目录
  1. conf：配置文件目录
  2. html：静态资源文件目录
  3. logs：日志文件目录
  4. temp：临时文件目录
  
  
  
