# UT-Manual

整理单元测试用例，用于指导如何编写单元测试

## 示例

Unit Test

- [Business Service](./src/test/java/com/github/wangyuheng/utmanual/service/BizServiceTest.java)
- [Check Throw The Specified Exception](./src/test/java/com/github/wangyuheng/utmanual/conf/UtPropertiesTestWithThrown.java)
- [Mock File](./src/test/java/com/github/wangyuheng/utmanual/conf/UtPropertiesTestWithFileMock.java)
- [Interceptor AOP](./src/test/java/com/github/wangyuheng/utmanual/aop/LoginInterceptorTestMockHttpServlet.java)
- [Mock HttpServletRequest & Response](./src/test/java/com/github/wangyuheng/utmanual/aop/LoginInterceptorTestMockHttpServlet.java)
- [Repository Dao With H2](./src/test/java/com/github/wangyuheng/utmanual/repository/CommonRepositoryTest.java)
- [embedded redis](./src/test/java/com/github/wangyuheng/utmanual/service/CacheServiceTest.java)

Debug

- [Debug ThirdParty Sever](./src/test/java/com/github/wangyuheng/utmanual/adapter/OuterAdapter.java)

Deprecated

- [Force Case Execute Order](./src/test/java/com/github/wangyuheng/utmanual/util/CommonUtilCareSeq.java)

## 单元测试

> 以终为始，拆解任务

小到一个函数，大到一个平台，都是为了达成某个目标。如何证明你是否完成了目标？或者应该说一定是先有目标，然后才是拆解、完成任务

### 误区

#### Q

1. 谁来测试
2. 单测是额外的工作量
3. 代码不好测试
4. 先写代码还是先测试?

#### A

- 1&2: 测试其实已经在潜移默化的进行了，贯穿整个开发过程。完成的功能一定是执行过的
- 3&4: 写好的代码不好补充单测，在编码之前先通过单测明确目标及完成任务拆解

### 目标
    
编写可测试的代码

![ut](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/wangyuheng/ut-manual/master/.doc/ut.puml)
