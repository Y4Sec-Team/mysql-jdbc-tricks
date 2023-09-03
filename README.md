## mysql-jdbc-tricks

这里是很多`MySQL JDBC Attack`的小技巧，我仅在`MySQL`的`JDBC`驱动中测试，这里的技巧可能在其他类型的数据库驱动中也存在

文章：https://mp.weixin.qq.com/s/lmoWKK41ZQzZOh-P26VUng

推荐搭建：推荐配合 https://github.com/4ra1n/mysql-fake-server 使用

### 基本示例

参考`Application1`和`Example1`代码

这是一个不存在任何过滤的情况，直接执行即可`RCE`

### 大小写绕过

参考`Application1`和`Example1`代码

这里展示了一种简单的防护和绕过，`MySQL`驱动对于连接参数的大小不做限制，如果开发者不做大小写限制，将会被轻易饶过

### YES绕过

参考`Application3`和`Example3`代码

这里展示了一种简单的防护和绕过，`MySQL`驱动允许的`Bool`值是包含`true/yes`两种的，因此存在一种绕过

### 编码绕过

参考`Application4`和`Example4`代码

这里展示了某些情况下的绕过，`MySQL`驱动允许`URL`编码，因此如果开发者没有按照标准`URL`解析和过滤，将会存在绕过

### 暂时的安全

参考`Application5`和`Example5`代码

对于这种情况，似乎是安全了，或许有其他的绕过？

### 另一种形式的传参

参考`Application6`和`Example6`代码

这也是`JDBC`攻击很常见的一种情况

### 额外参数检查绕过

参考`Application7`和`Example7Bypass`代码

限制额外连接参数情况下如何绕过

### 特殊情况下的#号绕过

参考`Application8`和`Example8Bypass`代码

一种特殊情况的绕过，属于一种逻辑漏洞

### 另一种特殊场景的绕过

参考`Application9`和`Example9Bypass`代码

另一种特殊情况的绕过，开发者忽略某些参数过滤导致的绕过

### 可能安全

参考`Application10`和`Example10`代码

对于这种情况，似乎是安全了，或许有其他的绕过？
