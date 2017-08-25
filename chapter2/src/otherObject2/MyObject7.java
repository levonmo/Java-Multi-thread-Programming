package otherObject2;

//私有变量是线程安全
public class MyObject7 {

	public void methodA(){
		try {
			int j = 8;
			if(Thread.currentThread().getName().equals("a")){
				j = 7;
				Thread.sleep(3000);
			} else {
				j = 6;
			}
			System.out.println("由线程" + Thread.currentThread().getName() + "打印j的值为=" + j);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
