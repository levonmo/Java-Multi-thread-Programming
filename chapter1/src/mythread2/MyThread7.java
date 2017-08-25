package mythread2;

//能停止的线程:异常法
public class MyThread7 extends Thread {
	
	@Override
	public void run() {
		try {
			for(int i=0; i<500000; i++){
				if(this.interrupted()){//这里interrupted()方法可以打一个标记，就是标记该线程已经停止了
					System.out.println("线程已经中断，我要退出");
//				break;//这里只是跳出for循环，但还没有中断线程
					throw new InterruptedException();//利用抛出异常来中断线程，这样for循环下面的代码就不会执行了
				}
				System.out.println("i=" + (i+1));
			}
		System.out.println("我在for下面，输出这行，证明线程并没有停止");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
