package mythread4;

/*
 * 	守护线程:
 * 		java的线程中有两种线程:一种是用户线程，一种是守护线程
 * 		
 * 		守护线程是一种特殊的线程:是"陪伴"的意思，当进程中不存在非守护线程了，则守护线程自动销毁
 * 			最典型的守护线程就是GC(垃圾回收器)，当进程中没有了非守护线程，则垃圾回收器也就没有必要存在了。
 * 
 * 		守护线程:任何一个守护线程都是整个JVM中所有非守护线程的"保姆"，只有当jvm实例中存在任何一个非守护线程没有结束，
 * 				守护线程就在工作，只有当最后一个非守护线程结束时，守护线程才能随着JVM一同结束工作
 * 
 * 		Daemon的作用是为了其他线程的运行提供便利服务，守护线程最典型的应用就是GC(垃圾回收器)，它是一个很称职的守护线程
 * 
 */
public class MyThread1 extends Thread{
	private int i = 0;
	@Override
	public void run() {
		try {
			while(true){
				i++;
				System.out.println("i=" + i);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
