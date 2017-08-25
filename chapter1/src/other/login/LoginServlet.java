package other.login;

public class LoginServlet {
	private static String usernameREF;
	private static String passwordREF;
	
	synchronized public static void dopost(String username,String password){
		try {
			usernameREF = username;
			if(username.equals("a")){
				Thread.sleep(5000);
			}
			passwordREF = password;
			System.out.println("username=" + usernameREF + "   " + "password=" + passwordREF);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
