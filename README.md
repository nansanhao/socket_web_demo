# 新人任务-http静态文件服务器

### 任务描述

使用socket api完成一个异步单线程的http静态文件服务器，要求运行于8000端口，可以代理同级目录内static文件里的静态文件(html、js、css, etc.)。

### 前置条件

1. socket api的基本使用，以及非阻塞socket api
2. select、poll、epoll等io多路复用机制
3. reactor、proactor两种io设计模式，并选择其一使用
4. http请求报文和响应报文的格式

### 基本要求

1.要求程序可在linux下运行

2.使用c或java

3.不允许使用第三方框架