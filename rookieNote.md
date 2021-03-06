# 目录 



# 1 Java

## 1.1 JAVA基础 

### 1.1.1 JAVA的8种数据类型

1. 四种整数类型： （byte、short、int、long） 
    byte：8 位，用于表示最小数据单位，如文件中数据，-128~127 ；short：16 位，很少用，-32768 ~ 32767 ； int：32 位、最常用，-2<sup>31</sup>-1~2<sup>31</sup>  （21 亿）；long：64 位、次常用    注意事项：    int i=5; // 5 叫直接量（或字面量），即 直接写出的常数。整数字面量默认都为 int 类型，所以在定义的 long 型数据后面加 L或 l。 小于 32 位数的变量，都按 int 结果计算。 强转符比数学运算符优先级高。见常量与变量中的例子。 
2. 两种浮点数类型(float、double)：
    float：32 位，后缀 F 或 f，1 位符号位，8 位指数，23 位有效尾数。    double：64 位，最常用，后缀 D 或 d，1 位符号位，11 位指数，52 位有效尾    注意事项：    二 进 制 浮 点 数 ： 1010100010=101010001.0*2=10101000.10*2^10（2次方)=1010100.010*2^11(3次方)= . 1010100010*2^1010(10次方)    尾数：  . 1010100010   指数：1010   基数：2    浮点数字面量默认都为 double 类型，所以在定义的 float 型数据后面加F 或 f；double 类型可不写后缀，但在小数计算中一定要写 D 或 X.X    float  的精度没有 long 高，有效位数（尾数）短。    float  的范围大于 long  指数可以很大。    浮点数是不精确的，不能对浮点数进行精确比较。
3. 一种字符类型(char)： 
    char：16 位，是整数类型，用单引号括起来的 1 个字符（可以是一个中文字符），使用 Unicode 码代表字符，0~2^16-1（65535） 。注意事项： 不能为 0个字符。    转义字符：\n  换行  \r  回车  \t Tab 字符  \" 双引号  \\ 表示一个\    两字符 char 中间用“+”连接，内部先把字符转成 int 类型，再进行加法运算，char 本质就是个数！二进制的，显示的时候，经过“处理”显示为字符。 
4. 一种布尔类型(boolean)：
    true 真  和 false 假  
5. 类型转换：  
    char-->    自动转换：byte-->short-->int-->long-->float-->double                   强制转换：①会损失精度，产生误差，小数点以后的数字全部舍弃。②容易超过取值范围。
6. 8位：Byte（字节型） 16位：short（短整型）、char（字符型）          32位：int（整型）、float（单精度型/浮点型）          64位：long（长整型）、double（双精度型）          最后一个：boolean(布尔类型

## 1.2 JAVA集合 



## 1.3 JVM 



## 1.4 JAVA多线程

## 1.5 设计模式

# 2 Spring系列

## 2.1 Spring 

## 2.2 Spring MVC

## 2.3 Spring boot

## 2.4 Spring Cloud

# 3 数据库

## 3.1 数据库基础

## 3.2 Mysql

## 3.3 Oracle

## 3.4 SQL Server

## 3.5 MongoDB

# 4 消息中间件

## 4.1 Kafka

## 4.2 RabbitMQ

## 4.3 RocketMQ

## 4.4 ActiveMQ

# 5 缓存

## 5.1 Redis

# 6 网络

## 6.1 TCP

## 6.2 HTTP

### 6.2.1 HTTP协议和状态保持 

​     cgi，jspserverlet，http无状态

## 6.3 HTTPS

## 6.4 网络IO

## 6.5 Netty

## 6.6 Cookie与Session

### 6.6.1 Session

 服务端状态保持session
 session的机制：

httpServeletRequest.getSession(true)被调用的时候创建

jsp -session   -->servelet

### 6.6.2 Cookie

客户端状态保持cookie

### 6.6.3 session的语义

1. 在一个浏览器会话期间

2. 用户在一次会话期间

3. 指的是一次连接

4. 面向连接，保持连接

5. 客户端和服务器之间保持状态的解决方案

6. 存储结构 key/value

7. HttpSession

### 6.6.4 Cookie和Session的关系

1. cookie是如何分发的
    服务端通过返回指令提升浏览器生成
    js生成
2. cookie是如何使用的
    cookie所作用的范围大于等于当前请求的资源所在的位置
    cookie的组成：名字，值，过期时间，路径，域
3. cookie的过期时间
    未设置过期时间---------会话cookie，浏览器关闭cookie消失
    设置过期时间--------------关闭浏览器cookie不消失，会存在硬盘直到过期
4. 协议本身支持状态行为；cookie客户端状态保持，session服务端状态保持

### 6.6.5 分布式环境下如何解决session跨域共享问题

1. session数据同步，比如tomcat的session同步（适合小的集群）
2. session存入redis（eg：tomcat+redis，适合session数比较多，服务器数量比较大的情况）
3. session维护在客户端，access_token/token（存在安全性问题）
4. spring-session加redis实现session共享

# 7 日志

## 7.1 Slf4j

## 7.2 Log4j

## 7.3 LogBack

## 7.4 ELK

# 8 分布式

## 8.1 Zookeeper

## 8.2 分布式锁

## 8.2 分布式ID

## 8.3 负载均衡

## 8.4 分布式事务

## 8.5 RPC

## 8.6 一致性

## 8.7 限流
### 8.7.1 为什么要限流 
    1）保证我们的系统不被拖垮；2）同时尽量提高吞吐量
### 8.7.2 限流的几个维度 
    1）节点级别VS集群级别；2）客户端VS服务端；3）服务级别VS方法级别
### 8.7.3 常用的限流方式 
1. TCP 流量整形
2. 计算器
3. 滑动窗口
4. 漏桶 
5. 令牌桶（面对突发限流，生成令牌速率是恒定的）
6. Lua+Nginx
7. Lua+Redis
## 8.8 大流量的处理方案

1. 使用缓存，CDN，使请求不到达真实的服务器 ，达到快速响应，不拖垮服务器
2. 服务降级，把不是核心的服务停掉，提高吞吐量限流
3. 限流

# 9 大数据

## 9.1 Hadoop

## 9.2 Spark

## 9.3 Storm

# 10 机器学习

# 11 云计算

## 11.1 Docker

# 12 架构

# 13 UML

# 14 加密解密

# 15 数据结构与算法

# 16 前端

## 16.1 JS

## 16.2 CSS

## 16.3 HTML

## 16.4 ES6

## 16.5 Node.js

## 16.6 VUE

## 16.7 AngularJS

## 16.8 React

## 16.9 前端UI框架

## 16.10 webpack

# 17 编程思想

# 18 工具和案例

## 18.1 常用工具

### 18.1.1 PostMan

​         PostMan可以用来测试后台接口，支持REST接口，Form表单形式，文件上传，需要权限的接口

### 18.1.2 Navicat Premium 

​         数据库客户端工具

### 18.1.3 IDEA

​        非常好用的写java代码的工具

### 18.1.4 Typora 

​        Windows和Linux or MAC中免费的用于写Markdown的工具，比较好用

### 18.1.5 Everything 

​    windows下查找文件非常方便的软件

### 18.1.6 xftp和xshell 

​    操作linux的客户端，xshell用于linux命令工具，xftp用于linux中文件上传下载的工具

### 18.1.7 Notepad++ 

​     windows下用于编辑文本的工具，比较方便

### 18.1.8 sublime 

​    一个简洁快速写文本的工具，结合插件可以用于来写前端代码，前端开发人员用的比较多

### 18.1.9 HBuilder

​    一个可以用来写前端的IDEA,也可以使用这个工具利用前端来写android的app，ios的app

### 18.1.10 BeyondCompare

​     文本比较工具，用于合并文件，比较文件夹或者文件是否相同或者找出差异点

### 18.1.11 jd-gui

​    用于反编译java的class文件，jar包文件

### 18.1.12 Adobe Acrobat

​       一个可以阅读pdf文件和编辑pdf文件的软件工具

### 18.1.13 TeamViewer

​    电脑远程工具

### 18.1.14 XMind

   用于画思维导图的软件

### 18.1.15 Axure

  用于画产品原型图的软件

# 19 逻辑思维

# 20 面试技巧

# 21 操作系统