package otherObject2;

import java.util.Iterator;

public class ObjectAC extends Thread {
	
	volatile public static int count;
	private static void addCount(){
		//解决的办法就是在这里加上同步代码块
		for(int i=0; i<100; i++){
			count++;
		}
		System.out.println("count" + count);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		this.addCount();
	}

}
