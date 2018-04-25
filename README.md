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
* [第一章:Java多线程技能](/chapter1/src/test/Test1.java)
	* 使用多线程，启动一个多线程的几种方式
	* 线程的随机性
	* 实例变量与线程安全
    * 留意i——与System.out.println（）的异常
    * currentThread()
    * start()和run()
* [第二章:对象及变量的并发访问](/chapter2/src/test/Test1.java)
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
* [第三章:线程间通信](/chapter3/src/test/Test1.java)
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
