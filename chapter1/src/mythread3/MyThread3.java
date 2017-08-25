package mythread3;

import other.synchronizedObject.SynchronizedObject;

/*	stop()方法的异常
 * 		会抛出java.lang.ThreadDeath异常
 * 	以及释放锁的不良后果
 *		stop()方法可以强制 让线程停止，但可能使一些清理的工作得不到完成，另一种情况就是对锁定的对象进行"解锁"，导致数据出现问题
 */
public class MyThread3 extends Thread {
	
	private SynchronizedObject object;
	
	@Override
	public void run() {
		super.run();
		object.printString("b","bb");
	}

	public MyThread3(SynchronizedObject object) {
		super();
		this.object = object;
	}
}
