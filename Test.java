package Attendance;

import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
		int q=1;
		Attendance put=new Attendance();
		do {
			HashMap<String, String> user = null;
			put.login(user);
			put.XuanZe();
		}while(true);
	}

}
