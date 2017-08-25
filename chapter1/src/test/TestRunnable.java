package test;

import myrunnable.MyRunnable;

import org.junit.Test;

public class TestRunnable {
	
	//通过实现Runnable接口来创建一个线程类
	@Test
	public void createThreadByRunnable(){
		//通过实现Runnable接口的需要新建一个Thread类，并将该实现runnable接口的类的对象 放进Thread中
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start();
		System.out.println("ending");
	}
	
	
	
}
