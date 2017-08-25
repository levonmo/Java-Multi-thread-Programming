package otherObject2;

//内置类与同步，实验1:内置类中有两个同步方法，但使用的却是不同的锁，打印的结果也是异步的
public class ObjectT {
	public static class classA{
		public void methodA(){
			synchronized ("其他的锁") {
				try {
					for (int i = 0; i < 50; i++) {
						System.out.println(Thread.currentThread().getName() + "线程进入A方法" + "i的值是" + i);
						Thread.sleep(100);

					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		synchronized public void methodB(){
			try {
				for (int i = 0; i < 50; i++) {
					System.out.println(Thread.currentThread().getName() + "线程进入B方法" + "i的值是" + i);
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
