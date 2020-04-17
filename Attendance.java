package Attendance;
import java.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;



public class Attendance {
	private Scanner y;
	private Scanner m;
	private Scanner m2;
	String UserName;
	String passWord;
	public void login(HashMap<String,String>user) {
		int a=3;				//最大次数
		int i = 1;					//循环次数
		HashMap<String,String>HashMap=new HashMap<>();
		HashMap.put(UserName, passWord);
		do {

			HashMap.put("10086","100");
			HashMap.put("10010","100");
			HashMap.put("110","100");
			HashMap.put("120","100");
			HashMap.put("150","100");
			Scanner ssd =new Scanner(System.in);
			System.out.println("用户名：");
			UserName =ssd.next();
			System.out.println("请输入密码：");
			passWord=ssd.next();

			if(HashMap.containsKey(UserName)){
				if(HashMap.get(UserName).equals(passWord)){

					System.out.println();
					System.out.println("签到迟到扣工资系列");
					System.out.println("(￣_,￣ )");
					break;
				}else{
					System.out.println("账号或密码输入错误");

				}
			}
			else{System.out.println("账号或密码输入错误");
			}
		}while(i<=a) ;

	}

	//上班签到
	public void check_in() {
		//获取当前时间
		//  System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		//记录签到信息，如果签到时间大于上午9时，则提示用户迟到，并记录该迟到信息到attendance+username.txt中（username指的是登录用户）。
		SimpleDateFormat dm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date d = new Date();
		int hours = d.getHours();
		if(hours >9) {
			System.out.println("签到成功，签到时间："+dm.format(new Date())+"你迟到了");

			FileOutputStream fos=null;
			String a="签到成功，签到时间："+dm.format(new Date())+"你迟到了"+"\r\n";
			File f=new File("d:\\attendance"+UserName+".txt");
			try {
				fos=new FileOutputStream(f,true);
				fos.write(a.getBytes());
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try{
					fos.close();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		else {
			System.out.println("签到成功，签到时间："+dm.format(new Date()));

			FileOutputStream fos=null;
			String a="签到成功，签到时间："+dm.format(new Date())+"\r\n";
			File f=new File("d:\\attendance"+UserName+".txt");
			try {
				fos=new FileOutputStream(f,true);
				fos.write(a.getBytes());
			} catch (FileNotFoundException e) {		
				e.printStackTrace();
			} catch (IOException e) {				
				e.printStackTrace();
			}finally{
				try{
					fos.close();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
	}

	//下班签到
	public void check_out() {
		//获取当前时间
		// System.out.println(dm.format(new Date()));// new Date()为获取当前系统时间
		//记录签出信息，如果签出时间小于下午6时，则提示用户早退，并记录该早退信息到attendance+username.txt中（username指的是登录用户）
		SimpleDateFormat dm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date d = new Date();
		int hours = d.getHours();
		if(hours>18) {
			System.out.println("签到成功，签到时间："+dm.format(new Date())+"工作辛苦了");

			FileOutputStream fos=null;
			String a="签到成功，签到时间："+dm.format(new Date())+"工作辛苦了"+"\r\n";
			File f=new File("d:\\attendance"+UserName+".txt");
			try {
				fos=new FileOutputStream(f,true);
				fos.write(a.getBytes());
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try{
					fos.close();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		else {
			System.out.println("签到成功，签到时间："+dm.format(new Date())+"你早退了");

			FileOutputStream fos=null;
			String a="签到成功，签到时间："+dm.format(new Date())+"你早退了"+"\r\n";
			File f=new File("d:\\attendance"+UserName+".txt");
			try {
				fos=new FileOutputStream(f,true);
				fos.write(a.getBytes());
			} catch (FileNotFoundException e) {		
				e.printStackTrace();
			} catch (IOException e) {				
				e.printStackTrace();
			}finally{
				try{
					fos.close();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
	}

	
		//打开attendance+username.txt
		public void da(){
			File f=new File("d:\\attendance"+UserName+".txt");
			if(f.exists()){
			//打开attendance+username.txt
			try {

				Desktop.getDesktop().open(new File("d:\\attendance"+UserName+".txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else{
				System.out.println("文件为空");
			}
			}
	
	//显示选项
	public void XuanZe(){
		SimpleDateFormat dm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date d = new Date();
		int hours = d.getHours();
		int xuanze;
		System.out.println("1--上班签到");
		System.out.println("2--下班签出");
		System.out.println("3--考勤信息查阅");
		System.out.println("4--退出");
		Scanner qiandao =new Scanner(System.in);//从键盘上获取
		xuanze=qiandao.nextInt();//从键盘上输入选择号
		switch(xuanze){
		case 1:
			check_in();break;
		case 2:
			check_out();break;
		case 3:
			da();break;
		case 4:
			//退出 回到程序头但不退出
			login(null);
			XuanZe();
			break;
		}	

	}
}