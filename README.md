README
===========================
《java多线程编程核心技术》笔记  
这本书的demo很多，讲的比较清晰，容易理解，缺点就是感觉有很多内容重复，重重复复讲一个东西
看书的笔记
* 目录下面有超链接可以直接点进去
* 第一章: https://github.com/mowenlong/Java-Multi-thread-Programming/blob/master/chapter1/src/test/Test1.java
* 第二章: https://github.com/mowenlong/Java-Multi-thread-Programming/blob/master/chapter2/src/test/Test1.java
* 第三章: https://github.com/mowenlong/Java-Multi-thread-Programming/blob/master/chapter3/src/test/Test1.java
* 第四章: https://github.com/mowenlong/Java-Multi-thread-Programming/blob/master/chapter4/src/test/Test1.java
* 第五章: https://github.com/mowenlong/Java-Multi-thread-Programming/blob/master/chapter5/src/test/Test1.java
* 第六章: https://github.com/mowenlong/Java-Multi-thread-Programming/blob/master/chapter6/src/test/Test1.java
* 第七章: https://github.com/mowenlong/Java-Multi-thread-Programming/blob/master/chapter7/src/test/Test1.java

****
	
|Author|龙|
|---|---
|E-mail|741321320@qq.com
|Website|http://www.mowenlong.com
|CSDN|https://blog.csdn.net/weixin_38104426


****
## 目录
* 第一章:Java多线程技能
	* 初始多线程
		* [使用多线程，启动一个多线程的几种方式](/chapter1/src/test/Test1.java)
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
* 第三章:线程间通信
	* [等待/通知机制](/chapter3/src/test/Test1.java)
		* wait/notify的引入:不使用等待/通知机制实现线程间的通信，在这里也添加了volatile关键字
		* 等待/通知机制的实现:wait使线程停止运行，而Notify可以使停止的线程继续运行
		* 例子
		* 方法wait()锁释放与notify()锁不释放
		* 当interrupt方法遇到wait方法
		* 只通知一个线程
		* 方法wait(long)的使用
	* [生产者/消费者模式实现](/chapter3/src/test/Test2.java)
		* 多生产者与多消费者
		* 一生产与一消费
		* 方法join的使用:铺垫
		* 用join()方法解决问题
		* 方法join与异常
		* 方法join(long)的使用
		* join(long)与sleep(long)的区别
	* [类ThreadLocal的使用](/chapter3/src/test/Test2.java)
		* 方法get（）与null
		* 验证线程变量的隔离性
		* 解决get（）返回null问题
		* 再次验证线程变量的隔离性
		* 类InheritableThreadLocal的使用
* [第四章:Lock的使用](/chapter4/src/test/Test1.java)
	* [使用ReentrantLock类](/chapter4/src/test/Test1.java)
		* 使用ReentrantLock实现同步:测试一
		* 使用ReentrantLock实现同步:测试二
		* 使用Condition实现等待/通知错误用法与解决
		* 正确使用Condition实现等待/通知
		* 使用多个Condition实现通知部分线程:错误的用法
		* 使用多个Condition实现通知部分线程:正确的用法
		* 实现生产者/消费者模式:一对一交替打印
		* 实现生产者/消费者模式:多对多交替打印
		* 公平锁与非公平锁
		* 方法int getHoldCount():保持查询当前线程保持此锁定的个数，也就是调用lock()方法的次数
		*方法int getQueueLength():返回正等待获取此锁的线程估计数
		* 方法int getWaitQueueLength(Condition condition) 的作用是返回等待与此锁定给定条件的Condition的线程的估计数
		* [方法boolean hasQueuedThread(Thread thread):的作用是查询指定线程是否正在等待获取此锁](/chapter4/src/test/Test2.java)
		* 方法boolean hasWaiters(Condition condition):作用是查询是否有线程正在等待与此锁有关的condition条件
		* 方法boolean isFair():作用是判断是不是公平锁
		* 方法boolean isHeldByCurrentThread():作用是查询当前的线程是不是保持此锁定
		* 方法boolean isLocked()的作用是查询此锁定是否由任意线程保持
		* 方法lockInterruptibly():如果当前线程未被中断，则获取锁定，如果已经被中断则出现异常
		* 方法boolean tryLock()的作用是:仅在调用时锁定未被另一个线程保持的情况下，才获取该锁定
		* 方法awaitUninterruptibly()的使用,
	* [使用ReentrantReadWriteLock类](/chapter4/src/test/Test3.java)
		*  类ReentrantReadWriteLock的使用：读读共享
		*  类ReentrantReadWriteLock的使用:写写互斥
		*  类ReentrantReadWriteLock的使用:读写互斥  
* [第五章:定时器Timer](/chapter5/src/test/Test1.java)
* [第六章:单例模式与多线程](/chapter6/src/test/Test1.java)
	* 立即加载/"饿汉模式"
	* 延时加载/"懒汉模式"
	* 使用DCL双检查锁机制
	* 使用静态内置类实现单例模式
	* 序列化与反序列化的单例模式实现
	* 使用enum枚举数据类型实现单例模式
* 第七章:拾遗增补
	* [线程的状态](/chapter7/src/test/Test1.java)
		* 验证:new，runnable，terminated(结束)
		* 验证timed_waiting:线程的状态timed_waiting表示线程执行了Thread.sleep()方法，呈等待状态，等待时间到了，继续向下运行
		* 验证blocked:出现在某一个线程在等待锁的时候
		* 验证WAITING:是线程执行wait()方法后所处的状态
	* [线程组](/chapter7/src/test/Test1.java)
		* 线程对象关联线程组:1级关联 
	 
