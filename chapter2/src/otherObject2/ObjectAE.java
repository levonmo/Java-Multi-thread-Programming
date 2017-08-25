package otherObject2;
//synchronized代码块有volatile同步功能(1):停不下的循环
public class ObjectAE {

	private boolean isContinue = true;
	
	public void runMethod(){
		while (isContinue) {
			//这里是无限循环
//			synchronized ("锁") {
//			}
		}
		System.out.println("停下来了");
	}
	
	public void stopMethod(){
		isContinue = false;
	}
}
