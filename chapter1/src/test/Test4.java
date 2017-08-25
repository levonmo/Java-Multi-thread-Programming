package test;

import mythread4.MyThread1;

import org.junit.Test;

public class Test4 {

	/*
	 * 守护线程
	 * 	一个线程不会自动结束的，只有当run方法执行完它才会自动结束
	 *		但是当一个线程是守护线程时，run方法没有执行完成它都会自动结束(当没有非守护线程时) 		
	 *	
	 *	例如下面，myThread1被设置为守护线程(一个线程在未start之前就要被设置为守护线程了)，
	 *			当main线程结束时(非守护线程没有了)，守护线程也自动结束，把setDaemon注释看看效果
	 */
	public static void main(String[] args) {
		try {
			MyThread1 myThread1 = new MyThread1();
			myThread1.setDaemon(true);
			myThread1.start();
			Thread.sleep(700);
			System.out.println("我要离开thread对象也不再打印，也就是停止了");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//线程具有优先级的
	@Test
	public void priority() throws InterruptedException{
		Thread thread = new Thread(){
			@Override
			public void run() {
				long beginTime = System.currentTimeMillis();
				for(int i=0; i < 500; i++){
					System.out.println("线程一打印" + (i+1));
				}
				long endTime = System.currentTimeMillis();
				System.out.println("线程一用时间" + (endTime - beginTime));
			}
		};
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				long beginTime = System.currentTimeMillis();
				for(int i=0; i < 500; i++){
					System.out.println("线程二打印" + (i+1));
				}
				long endTime = System.currentTimeMillis();
				System.out.println("线程二用时间" + (endTime - beginTime));
			}
		};
		
		thread.setPriority(10);
		thread2.setPriority(1);
		//因为线程一的优先级比线程二的高，所以一般来说执行同样的代码线程一用的时间较少
		thread.start();
		thread2.start();
		Thread.sleep(5000);
	}
	
}
