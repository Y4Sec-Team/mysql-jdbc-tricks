## mysql-jdbc-tricks

这里是很多`MySQL JDBC Attack`的小技巧，我仅在`MySQL`的`JDBC`驱动中测试，这里的技巧可能在其他类型的数据库驱动中也存在

推荐搭建：https://github.com/4ra1n/mysql-fake-server 使用

### 基本示例

参考`Application1`和`Example1`代码

这是一个不存在任何过滤的情况，直接执行即可`RCE`

### 大小写绕过

参考`Application1`和`Example1`代码

这里展示了一种简单的防护和绕过，`MySQL`驱动对于连接参数的大小不做限制，如果开发者不做大小写限制，将会被轻易饶过