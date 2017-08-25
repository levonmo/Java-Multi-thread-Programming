package otherObject2;

//数据类型String的常量池特性(2):synchronized同步块的使用
public class ObjectM {

	public void methodA(String string){
		try {
			synchronized (string) {
				while(true){
					System.out.println("当前的线程名称是" + Thread.currentThread().getName());
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
