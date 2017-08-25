package otherObject2;

//同步代码块的弊端
public class MyObject1 {

	private String getData1;
	private String getData2;
	
	 public void doLongTimeTask(){
		try {
			System.out.println("begin task");
			Thread.sleep(3000);
			synchronized(this){
				getData1 = "长时间处理任务后从远程返回的值   该线程的名称是" + Thread.currentThread().getName();
				getData2 = "长时间处理任务后从远程返回的值  该线程的名称是" + Thread.currentThread().getName();
			}
			System.out.println(getData1);
			System.out.println(getData2);
			System.out.println("end task");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
