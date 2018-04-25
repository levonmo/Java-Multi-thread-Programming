README
===========================
《java多线程编程核心技术》笔记  
这本书的demo很多，讲的比较清晰，容易理解，缺点就是感觉有很多内容重复，重重复复讲一个东西
看书的笔记

****
	
|Author|龙|
|---|---
|E-mail|741321320@qq.com
|Website|http://www.mowenlong.com
|CSDN|https://blog.csdn.net/weixin_38104426


****
## 目录
* 第一章:Java多线程技能
	* [初始多线程](/chapter1/src/test/Test1.java)
		* 使用多线程，启动一个多线程的几种方式
		* 线程的随机性
		* 实例变量与线程安全
    	* 留意i——与System.out.println（）的异常
    	* currentThread()
    	* start()和run()
    * [线程api](chapter1/src/test/Test2.java)  
        * isAlive()  
		* sleep()   
		* interrupt()与isInterrupted()
		* getId()
	* [停止线程1](chapter1/src/test/Test2.java)
		* 判断线程是否是停止状态
		* 能停止的线程——异常法
		* 在沉睡中停止
	* [停止线程2](/chapter1/src/test/Test3.java)
		* 暴力停止，使用stop()方法
		* 释放锁的不良后果
		* 使用return停止线程
	* [暂停线程](/chapter1/src/test/Test3.java)
		* suspend与resume方法的使用
		* suspend与resume方法的缺点——独占
		* suspend与resume方法的缺点——不同步
		* yield()方法
		* 线程的优先级
	* [守护线程](/chapter1/src/test/Test4.java)
		* 守护线程
		* 线程具有优先级的
		

* 第二章:对象及变量的并发访问
	* [synchronized同步方法1](/chapter2/src/test/Test1.java)  
		* 方法内的变量为线程安全
		* 实例变量非线程安全
		* 多个对象多个锁
		* synchronized方法与锁对象
		* 在一个类中一个是同步方法，一个不是同步方法
	* [synchronized同步方法2](/chapter2/src/test/Test2.java)
		* 脏读
		* synchronized锁重入
		* 可重入锁的父子类继承
		* 出现异常，锁自动释放
		* 同步不具有继承性
		* 使用同步代码块
	* [synchronized同步语句块](/chapter2/src/test/Test3.java)
		* 使用同步方法的弊端
		* 同步代码块，一半同步一半异步
		* synchronized代码块间的同步性
		* 验证同步synchronized(this)代码块是锁定当前对象的
		* 将任意对象作为对象监视器
		* 同步方法与同步方法代码块会相互阻塞
		* 私有变量是线程安全
		* 将任意对象作为对象监视器，对象监视器必须是同一个对象
		* 多个线程调用同一个方法是随机的
		* 其他线程执行X对象方法里面的synchronized(this)代码块
		* 静态同步synchronized方法，在static方法上加上synchronized代码块
		* 验证:synchronized+static 与 synchronized+非static 不是同一把锁
		* 使用Class锁: 两个线程对两个对象实例，结果是同步执行的
		* 同步synchronized(class)代码块
	* [数据类型String的常量池特性](/chapter2/src/test/Test3.java)
		* 数据类型String的常量池特性(1)
		* 数据类型String的常量池特性(2):synchronized同步块的使用
		* 使用new Object()来作为同步代码块的对象
		* 同步synchronized方法无限等待与解决
		* 线程的"假死"现象
	* [内置类与静态内置类](/chapter2/src/test/Test4.java)
		* 静态的内置类
		* 内置类与同步
		* 锁对象的改变
	* [volatile关键字](/chapter2/src/test/Test4.java)
		* 无法停止的线程
		* 解决同步死循环
		* 使用volatile关键字
		* volatile非原字性的特征
		* synchronized代码块有volatile同步功能(1):停不下的循环
* [第三章:线程间通信](/chapter3/src/test/Test1.java)
	* 
* [第四章:Lock的使用](/chapter4/src/test/Test1.java)
* [第五章:定时器Timer](/chapter5/src/test/Test1.java)
* [第六章:单例模式与多线程](/chapter6/src/test/Test1.java)
* [第七章:拾遗增补](/chapter7/src/test/Test1.java)
* [链接](#链接) 
    * 文字超链接
        *  链接外部URL
        *  链接本仓库里的URL
    *  锚点
    * [图片链接](#图片链接)
