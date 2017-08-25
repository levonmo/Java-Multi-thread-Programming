package test;

import object.ObjectA;
import object.ObjectB;
import object.ObjectC;
import object.ObjectD;
import object.ObjectF;
import object.ObjectG;

import org.junit.Test;

public class Test1 {
	
	
	//下面讲的就是单例模式
	
	//立即加载/"饿汉模式"
	@Test
	public void singleton(){
		Thread thread = new Thread(){
			public void run() {
				System.out.println(ObjectA.getInstance().hashCode());
			}
		};
		Thread thread2 = new Thread(){
			public void run() {
				System.out.println(ObjectA.getInstance().hashCode());
			}
		};
		Thread thread3 = new Thread(){
			public void run() {
				System.out.println(ObjectA.getInstance().hashCode());
			}
		};
		
		thread.start();
		thread2.start();
		thread3.start();
		/*
		 * 立即加载/饿汉模式，就是使用类的时候已经将对象创建完毕
		 * 		从控制台打印的hashCode是同一个值，说明对象就是同一个，也就是实现了单例设计模式
		 */
	}
	
	
	//延时加载/"懒汉模式"
	@Test
	public void singleton_1(){
		Thread thread = new Thread(){
			public void run() {
				System.out.println(ObjectB.getInstance().hashCode());
			}
		};
		thread.start();
		Thread thread2 = new Thread(){
			public void run() {
				System.out.println(ObjectB.getInstance().hashCode());
			}
		};
		thread2.start();
		Thread thread3 = new Thread(){
			public void run() {
				System.out.println(ObjectB.getInstance().hashCode());
			}
		}; 
		thread3.start();
		/*
		 * 这样的话多线程加载出来是有多个对象的，主要原因是多个线程同时进入if语句，就创建了多个对象
		 * 	解决的办法在getInstance()方法加synchronized的话是可以得，但是效率太低了
		 * 		另一种就是使用DCL双检查锁机制
		 */
	}
	
	
	//使用DCL双检查锁机制
	@Test
	public void singleton_2(){
		
		Thread thread = new Thread(){
			public void run() {
				System.out.println(ObjectC.getInstance().hashCode());
			}
		};
		thread.start();
		
		Thread thread2 = new Thread(){
			public void run() {
				System.out.println(ObjectC.getInstance().hashCode());
			}
		};
		thread2.start();
		
		Thread thread3 = new Thread(){
			public void run() {
				System.out.println(ObjectC.getInstance().hashCode());
			}
		};
		thread3.start();
		/*
		 * 使用双重检查锁功能。成功地解决了"懒汉模式"遇到多线程的问题。
		 * 	DCL也是大多数多线程结合单例模式使用的解决方案
		 */
	}
	
	
	//使用静态内置类实现单例模式
	@Test
	public void singleton_3(){
		
		Thread thread = new Thread(){
			public void run() {
				System.out.println(ObjectD.getInstance().hashCode());
			}
		};
		thread.start();
		
		Thread thread2 = new Thread(){
			public void run() {
				System.out.println(ObjectD.getInstance().hashCode());
			}
		};
		thread2.start();
		
		Thread thread3 = new Thread(){
			public void run() {
				System.out.println(ObjectD.getInstance().hashCode());
			}
		};
		thread3.start();
	}
	
	
	
	//序列化与反序列化的单例模式实现
	@Test
	public void singleton_4(){
		//这里不是很明白
	}
	
	
	//使用静态static代码块实现单例模式
	@Test
	public void singleton_5(){
		
		Thread thread = new Thread(){
			public void run() {
				for (int i = 0; i < 6; i++) {
					System.out.println(ObjectF.getIntance().hashCode());
				}
			}
		};
		thread.start();
		
		Thread thread2 = new Thread(){
			public void run() {
				for (int i = 0; i < 6; i++) {
					System.out.println(ObjectF.getIntance().hashCode());
				}
			}
		};
		thread2.start();
		
		Thread thread3 = new Thread(){
			public void run() {
				for (int i = 0; i < 6; i++) {
					System.out.println(ObjectF.getIntance().hashCode());
				}
			}
		};
		thread3.start();
	}
	
	
	//使用enum枚举数据类型实现单例模式
	@Test
	public void singleton_6(){
		//这里不是很明白,为什么要连接数据库
	}
	
	
	
}
	
 