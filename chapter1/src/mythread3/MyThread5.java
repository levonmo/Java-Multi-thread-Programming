package mythread3;

/*
 * 暂停线程(suspend)	与
 * 
 * 	恢复线程(resume)
 */
public class MyThread5 extends Thread {

	private long i = 0;
	
	public long getI() {
		return i;
	}

	public void setI(long i) {
		this.i = i;
	}

	@Override
	public void run() {
		while(true){
			i++;
		}
	}

}
