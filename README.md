# id-production
## 目的
提供id生成功能。
## v1版实现
不借助任何中间件生成32位的字符串ID
### v1版结果
经过测试1000个线程并发生成的id并没有出现重复
### 使用场景
由于取了ip末尾数据段所以可以用于分布式系统，无需担心多台服务器并发或并行造成id重复问题
## v2版实现(暂未开发)
