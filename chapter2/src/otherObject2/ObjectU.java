package otherObject2;

public class ObjectU {

	public static class ClassB{
		
		public void methodA(ClassC classC){
			String threadName = Thread.currentThread().getName();
			synchronized (classC) {
				System.out.println(threadName + "进入ClassB中的methodA方法" );
				for (int i = 0; i < 10; i++) {
					System.out.println("i=" + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println(threadName + "退出ClassB中的methodA方法" );
		}
		
		public synchronized void methodB()  {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + "进入ClassB中的methodB方法" );
			for (int i = 0; i < 10; i++) {
				System.out.println("i=" + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName + "退出ClassB中的methodB方法" );
		}
	}
	
	public static class ClassC{
		public synchronized void methodB(){
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + "进入ClassC中的methodB方法" );
			for (int i = 0; i < 10; i++) {
				System.out.println("i=" + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName + "退出ClassC中的methodB方法" );

		}
	}
	
}
