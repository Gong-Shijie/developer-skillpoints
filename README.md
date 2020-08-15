# 1.操作系统

## 进程管理 
操作系统划分任务给进程，同时把内存资源也交给进程  
进程组织线程来执行任务，线程执行过程是栈的形式执行  
* 每个线程有自己的变量空间 --> 栈空间  
栈空间保存的是一些局部变量或者一些引用，new出的对象还是在堆内存，栈空间保留引用   
* 进程空间 --> 堆空间  

操作系统划分任务和资源分配最小单位  --> 进程  
CPU调度执行的最小单位（时间片轮转） --> 线程  



##  [内存管理](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E5%86%85%E5%AD%98%E7%AE%A1%E7%90%86.md)  
物理内存和虚拟内存的 **组织** 和 **映射关系**

## 进程间通信  
* [Binder](https://www.jianshu.com/p/f2b34ba05e0b)  
* AIDL  
* Messenger  


## 输入输出 

## 文件系统

## 网络系统 

# 2. 计算机网络 

## [概述](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E7%BD%91%E7%BB%9C%E6%A6%82%E8%BF%B0.md)  

## [应用层](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E5%BA%94%E7%94%A8%E5%B1%82.md)   

## [网络层](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E7%BD%91%E7%BB%9C%E5%B1%82.md)   

## [传输层](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E4%BC%A0%E8%BE%93%E5%B1%82.md) 
* TCP：面向连接，可靠有序  
流量控制：滑动窗口协议。客户端和服务端都有可用窗口的概念，服务端在收到客户端ACK后，可用窗口移动可以发送下一部分数据  
拥塞避免：慢启动超过阈值后启动线性增长。指数性增加拥塞窗口，拥塞窗口决定发送的速率。    
* UDP：尽力而为，充分发挥能力  

## [数据链路层](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E6%95%B0%E6%8D%AE%E9%93%BE%E8%B7%AF%E5%B1%82.md)  

## 物理层

## HTTP/HTTPS
HTTPS 多一层 TLS / SSL 层不再面文传输数据  
CA：数字证书，权威机构发布，里面有 公钥
![](https://upload-images.jianshu.io/upload_images/19741117-f9f4d1c73db679c4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  


# 3. 数据结构 

## 链表 

## 树

## 栈/队列 

## 哈希表 

## 字符串

## 数组 

## 图 

# 4. Java  
编程范式：面向对象  
* 封装  
* 继承  
* 多态  


## 语法 

## jvm 
![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/258676a7335b4b5cb7e94d8d0d4f7b7b~tplv-k3u1fbpfcp-zoom-1.image)
##### 类加载过程  
* 加载：将字节流中的内容（jar文件 编译后的.class文件）加载为JVM认可的数据类型 --> class对象     
* 链接：
* 	验证加载对象符合规范
* 	分配一些静态内存  
* 初始化：该赋值的赋值，将类 --> 可执行类对象      

### 内存回收  
* 复制：发生在新生代，划分from to交换区，不是垃圾的对象复制  
* 标记：发生在老年代，将垃圾进行标记回收，回收后的内存空闲链表式结构管理空闲内存  
* 整理：切割后的零碎内存的整理，方便内存分配  
* 垃圾判断：可达性分析，从 GCRoot出发，查看引用关系，在引用链中的都不是垃圾，否则是垃圾。
* GCRoot：栈上变量，方法区（静态变量）  

## 数据结构 

#### [HashMap](https://mp.weixin.qq.com/s/tcsgEAoYnWs9zL3-8n9-LQ)  

#### [LRUCache](https://mp.weixin.qq.com/s/OD2P5xuowNCSfWqHpiCoGg) 

## [并发](https://mp.weixin.qq.com/s/tOOQYrBemg76AiN2-ZkIQw)  
[volatile](https://www.jianshu.com/p/8ff20f7acd88)

# 5. Android

## Activity 

## [Service](https://www.jianshu.com/p/24b9e5da5918) 

## ContentProvider 

## BroadCast 

## 界面布局 

## JetPack 
* [Room](https://mp.weixin.qq.com/s/QT_ZA89LMv01CcI-8nE3Gw)  
* [Paging](https://mp.weixin.qq.com/s/L3DMgjB4syZEu35B2eoaSQ)  
* [Navigation](https://www.jianshu.com/p/68df095bed8d)  
* [ViewModel DataBinding](https://www.jianshu.com/p/68df095bed8d)

## API  
* [ConstraintLayout](https://mp.weixin.qq.com/s/QT_ZA89LMv01CcI-8nE3Gw)  
* [AsyncTask](https://mp.weixin.qq.com/s/QT_ZA89LMv01CcI-8nE3Gw)  

## [Binder](https://mp.weixin.qq.com/s/4YX8LepbSpzJuWZ3JPuXTg)

## [Handler](https://mp.weixin.qq.com/s/QT_ZA89LMv01CcI-8nE3Gw) 

# 6. 设计模式
![](https://p9-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/9bac8aadb3cb41dea05e4d77b47815f8~tplv-k3u1fbpfcp-zoom-1.image)


# 7.音视频  
* 采集  
* 编码 ffmpeg   
* 压缩 H264
* 封装 mp4 flv  

# 8.Git  
* [常用](https://mp.weixin.qq.com/s/jNWWdC23X7xfejEVT3GrJg)

# 100.企业题库  

## [字节跳动](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E5%AD%97%E8%8A%82%E8%B7%B3%E5%8A%A8.md)  

## 阿里巴巴  

## 腾讯  
# 101. 算法题


```
        
// 留白艺术
        // if后  {前有空行
        if (true) {
            // for后空 = < > << >> && || ; , 等符号两侧有空
            for (int i = 0; i < 10; i++) {
                int num = i;
            }
        }

```

try catch 规范
```
        try {
            // 业务代码
        } catch (IOException e) {
            // 捕获异常后 记得打印日志
            Log
        } finally {
            // 关闭对应 流  
        }

```


## 数据结构类 

### 链表 

### [树](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E6%A0%91.md) 

### 栈/队列 

### 哈希表 

### [字符串](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E5%AD%97%E7%AC%A6%E4%B8%B2.md)

### [组 矩阵](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E6%95%B0%E7%BB%84%20%E7%9F%A9%E9%98%B5.md)

### 图 

### 位运算 

## 算法思想类 

### 广度搜索 

### [深度搜索](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E6%B7%B1%E5%BA%A6%E6%90%9C%E7%B4%A2.md)    

### 动态规划 

### 排序 

### [双指针](https://github.com/Gong-Shijie/developer-skillpoints/blob/master/source/%E5%8F%8C%E6%8C%87%E9%92%88.md)


### 贪心 

### 二分 

### 分治

### 数学

![](https://p6-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/c8725e250b9a407ba41dc17d403689c5~tplv-k3u1fbpfcp-zoom-1.image)

