package other.login;

public class Blogin extends Thread {
	
	@Override
	public void run() {
		LoginServlet.dopost("b", "bb");
	}
	

}
