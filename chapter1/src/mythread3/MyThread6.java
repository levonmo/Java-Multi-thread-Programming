package mythread3;

//suspend与resume方法的缺点--独占  
public class MyThread6 extends Thread{

	 private long i = 0;
	
	@Override
	public void run() {
		while(true){
			i++;
			System.out.println(i);
		}
	}

}
