package mythread2;

/*
 * 两个方法:
 * 		1.this.interrupted():测试当前线程是否已经中断
 * 		2.this.isInterrupted():测试线程是否已经中断
 * 
 * 		1.测试当前线程是指运行this.interruptes()这段代码的线程
 * 		该方法是声明是 public static boolean interrupted()
 * 
 * 		2.isInterrupted()方法
 * 		该方法的声明:public boolean isInterrupted();可以看出该方法并不是static
 * 
 */
public class MyThread6 extends Thread {
	
 	public void run() {
		super.run();
		for(int i=0; i < 500000; i++){
			System.out.println("i=" + (i+1));
		}
	}  

}
