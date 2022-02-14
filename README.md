# 概述

JDK8 源码。

# 基础

| 知识树 | 核心理论 | 博客文章 | 
|:------|:------|:------|
|运算符大全 |1. 运算符优先级<br>2. 算术运算符<br>3. 自动递增、递减<br>4. 关系运算符<br>5. 逻辑运算符<br>6.按位运算符<br>7. 三目运算符<br>8. 字符串运算|[CSDN](https://jpeony.blog.csdn.net/article/details/51636764) |
|String、StringBuffer、StringBuilder|1. 线程安全<br>2. GC 回收|[CSDN](https://jpeony.blog.csdn.net/article/details/53514127) |
|final关键字|1. final 修饰的类，不能被继承<br>2. final 修饰的方法，不能被重写<br>3. final 修饰的变量，不能被修改|[CSDN](https://jpeony.blog.csdn.net/article/details/80873505) |
|----------------------------------------------|----------------------------------------------|----------|

# java-io

| 知识树 | 核心理论 | 博客文章 | 
|:------|:------|:------|
|概述|1. 输入输出原理<br>2. 流的概述<br>3. Java IO 特性和用途<br>4. Java IO API 类图 |[CSDN](https://jpeony.blog.csdn.net/article/details/79269481) |
|读写文件|1. FileInputStream<br>2. FileOutputStream<br>3. FileReader<br>4. FileWriter<br>5.RandomAccessFile |[CSDN](https://jpeony.blog.csdn.net/article/details/79272792) |
|管道|1. PipedInputStream<br>2. PipedOutputStream<br>3. PipedReader<br>4. PipedWriter |[CSDN](https://jpeony.blog.csdn.net/article/details/79283851) |
|字节和字符数组|1. ByteArrayInputStream<br>2. ByteArrayOutputStream<br>3. CharArrayReader<br>4. CharArrayWriter |[CSDN](https://jpeony.blog.csdn.net/article/details/79287693) |
|InputStream|1. 字节输入流<br>2. read |[CSDN](https://jpeony.blog.csdn.net/article/details/79293064) |
|OutputStream|1. 字节输出流<br>2. write<br>3. flush 刷盘|[CSDN](https://jpeony.blog.csdn.net/article/details/79306969) |
|FileInputStream|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79309114) |
|FileOutputStream|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79309114) |
|RandomAccessFile|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79311286) |
|File|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79313737) |
|BufferedInputStream|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79318713) |
|BufferedOutputStream|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79319121) |
|BufferedReader|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79319447) |
|BufferedWriter|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79319467) |
|----------------------------------------------|----------------------------------------------|----------|

# java-nio

| 知识树 | 核心理论 | 博客文章 | 
|:------|:------|:------|
|概述|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79327212) |
|Buffer|1. 缓冲区读写<br>2. capacity,position,limit 重要属性<br>3. flip 读写模式切换|[CSDN](https://jpeony.blog.csdn.net/article/details/79331010) |
|Channel|1. FileChannel<br>2. DatagramChannel<br>3. SocketChannel<br>4. ServerSocketChannel|[CSDN](https://jpeony.blog.csdn.net/article/details/79329521) |
|通道之间数据传输|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79331309) |
|Selector(选择器)|1. Selector 选择器<br>2. SelectionKey<br>3. 创建和使用实例|[CSDN](https://jpeony.blog.csdn.net/article/details/79332092) |
|FileChannel|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79335384) |
|SocketChannel|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79335552) |
|ServerSocketChannel|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79335692) |
|DatagramChannel|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79336635) |
|Pipe|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79336762) |
|scatter/gather|1. TODO<br>2. TODO|[CSDN](https://mp.csdn.net/console/editor/html/79419822) |
|----------------------------------------------|----------------------------------------------|----------|

# java-reflect

| 知识树 | 核心理论 | 博客文章 | 
|:------|:------|:------|
|概述|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79347933) |
|Class 对象|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79348852) |
|造器(Constructor)|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79349851) |
|变量(Field)|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79350171) |
|方法(Method)|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79352369) |
|Getters和Setters|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79352588) |
|私有变量和私有方法|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79352664) |
|注解(Annotation)|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79355943) |
|泛型(generics)|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79357038) |
|数组(Array)|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79357237) |
|动态代理(Proxy)|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79357372) |
|动态类加载和重载|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/79357673) |
|----------------------------------------------|----------------------------------------------|----------|

# java-collection

| 知识树 | 核心理论 | 博客文章 | 
|:------|:------|:------|
|ArrayList|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/108910769) |
|LinkedList|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/109435496) |
|Vector|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/109426679) |
|CopyOnWriteArrayList|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/106138813) |
|HashSet|1. 底层基于 HashMap 存储<br>2. 存储不重复对象<br>3. 支持按照对象查找和删除 |[CSDN](https://jpeony.blog.csdn.net/article/details/117688345) |
|ArrayBlockingQueue|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/111479502) |
|LinkedBlockingQueue|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/106544796) |
|PriorityBlockingQueue|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/111523096) |
|Stack|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/109497794) |
|ArrayDeque|1. 数组结构<br>2. 栈结构|[CSDN](https://jpeony.blog.csdn.net/article/details/122915721) |
|HashTable|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/109698072) |
|HashMap|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/110446413) |
|SynchronizedMap|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/117566333) |
|LinkedHashMap|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/118516205) |
|ConcurrentHashMap|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/110677912) |
|----------------------------------------------|----------------------------------------------|----------|

# java-annotation

| 知识树 | 核心理论 | 博客文章 | 
|:------|:------|:------|
|注解实现原理|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/80826238) |
|----------------------------------------------|----------------------------------------------|----------|

# java-net

| 知识树 | 核心理论 | 博客文章 | 
|:------|:------|:------|
|TODO|1. TODO<br>2. TODO|[CSDN]() |
|----------------------------------------------|----------------------------------------------|----------|

# java-jdbc

| 知识树 | 核心理论 | 博客文章 | 
|:------|:------|:------|
|TODO|1. TODO<br>2. TODO|[CSDN]() |
|----------------------------------------------|----------------------------------------------|----------|

# java-concurrent

| 知识树 | 核心理论 | 博客文章 | 
|:------|:------|:------|
|进程与线程|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/107590038) |
|Daemon 线程|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/113590258) |
|Java 线程实现方式|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/86665107) |
|Java 线程生命周期状态|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/86668152) |
|Java 线程终止方式|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/86673805) |
|Java 线程顺序执行方式|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/107618820) |
|wait、notify、notifyAll|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/87347946) |
|PipedOutputStream和PipedInputStream|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/87372602) |
|ThreadLocal|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/87866907) |
|CAS和ABA|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/87520148) |
|AQS|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/102535590) |
|Java锁|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/101687960) |
|线程池|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/86677049) |
|饱和策略|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/103218700) |
|synchronized 原理|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/87008888) |
|synchronized 对象锁和类锁|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/87012803) |
|volatile|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/87072642) |
|ReentrantLock|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/87088314) |
|ReentrantReadWriteLock|1. AQS 模板方法<br>2. WriteLock<br>3. ReadLock<br>4. 写写互斥，写读互斥，读读共享<br>|[CSDN](https://jpeony.blog.csdn.net/article/details/113250932) |
|CountDownLatch|1. AQS 模板方法<br>2. countDown() 源码分析<br>3. await() 源码分析|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/87181895) |
|CyclicBarrier|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/87256321) |
|Semaphore|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/87279383) |
|FutureTask|1. TODO<br>2. TODO|[CSDN](https://jpeony.blog.csdn.net/article/details/82664829) |
|----------------------------------------------|----------------------------------------------|----------|

# java-jvm

| 知识树 | 核心理论 | 博客文章 | 
|:------|:------|:------|
|内存结构|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/80882595) |
|类加载机制|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/81295635) |
|内存溢出分析|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/80946511) |
|HotSpot对象创建、内存、访问|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/80893288) |
|如何判定对象可以回收|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/80950336) |
|垃圾收集算法|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/80953776) |
|垃圾收集器|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/80956479) |
|内存分配和回收策略|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/80968456) |
|Java 内存模型|1. TODO<br>2. TODO|[CSDN](https://blog.csdn.net/yhl_jxy/article/details/103216421) |
|----------------------------------------------|----------------------------------------------|----------|

# java8

| 知识树 | 核心理论 | 博客文章 | 
|:------|:------|:------|
|TODO|1. TODO<br>2. TODO|[CSDN]() |
|----------------------------------------------|----------------------------------------------|----------|
