package mythread3;

//使用return和interrupt在停止线程
public class MyThread4 extends Thread {
	 
	@Override
	public void run() {
		for(int i=0; i < 5000; i++){
			if(this.interrupted()){	//interrupted()方法判断线程是否中断
				System.out.println("线程停止");
				return;
			}
			System.out.println(i+1);
		}
		System.out.println("看到这线程还没有被停止 ");
	}

}
