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
		int a=3;				//������
		int i = 1;					//ѭ������
		HashMap<String,String>HashMap=new HashMap<>();
		HashMap.put(UserName, passWord);
		do {

			HashMap.put("10086","100");
			HashMap.put("10010","100");
			HashMap.put("110","100");
			HashMap.put("120","100");
			HashMap.put("150","100");
			Scanner ssd =new Scanner(System.in);
			System.out.println("�û�����");
			UserName =ssd.next();
			System.out.println("���������룺");
			passWord=ssd.next();

			if(HashMap.containsKey(UserName)){
				if(HashMap.get(UserName).equals(passWord)){

					System.out.println();
					System.out.println("ǩ���ٵ��۹���ϵ��");
					System.out.println("(��_,�� )");
					break;
				}else{
					System.out.println("�˺Ż������������");

				}
			}
			else{System.out.println("�˺Ż������������");
			}
		}while(i<=a) ;

	}

	//�ϰ�ǩ��
	public void check_in() {
		//��ȡ��ǰʱ��
		//  System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		//��¼ǩ����Ϣ�����ǩ��ʱ���������9ʱ������ʾ�û��ٵ�������¼�óٵ���Ϣ��attendance+username.txt�У�usernameָ���ǵ�¼�û�����
		SimpleDateFormat dm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		Date d = new Date();
		int hours = d.getHours();
		if(hours >9) {
			System.out.println("ǩ���ɹ���ǩ��ʱ�䣺"+dm.format(new Date())+"��ٵ���");

			FileOutputStream fos=null;
			String a="ǩ���ɹ���ǩ��ʱ�䣺"+dm.format(new Date())+"��ٵ���"+"\r\n";
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
			System.out.println("ǩ���ɹ���ǩ��ʱ�䣺"+dm.format(new Date()));

			FileOutputStream fos=null;
			String a="ǩ���ɹ���ǩ��ʱ�䣺"+dm.format(new Date())+"\r\n";
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

	//�°�ǩ��
	public void check_out() {
		//��ȡ��ǰʱ��
		// System.out.println(dm.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		//��¼ǩ����Ϣ�����ǩ��ʱ��С������6ʱ������ʾ�û����ˣ�����¼��������Ϣ��attendance+username.txt�У�usernameָ���ǵ�¼�û���
		SimpleDateFormat dm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		Date d = new Date();
		int hours = d.getHours();
		if(hours>18) {
			System.out.println("ǩ���ɹ���ǩ��ʱ�䣺"+dm.format(new Date())+"����������");

			FileOutputStream fos=null;
			String a="ǩ���ɹ���ǩ��ʱ�䣺"+dm.format(new Date())+"����������"+"\r\n";
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
			System.out.println("ǩ���ɹ���ǩ��ʱ�䣺"+dm.format(new Date())+"��������");

			FileOutputStream fos=null;
			String a="ǩ���ɹ���ǩ��ʱ�䣺"+dm.format(new Date())+"��������"+"\r\n";
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

	
		//��attendance+username.txt
		public void da(){
			File f=new File("d:\\attendance"+UserName+".txt");
			if(f.exists()){
			//��attendance+username.txt
			try {

				Desktop.getDesktop().open(new File("d:\\attendance"+UserName+".txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else{
				System.out.println("�ļ�Ϊ��");
			}
			}
	
	//��ʾѡ��
	public void XuanZe(){
		SimpleDateFormat dm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		Date d = new Date();
		int hours = d.getHours();
		int xuanze;
		System.out.println("1--�ϰ�ǩ��");
		System.out.println("2--�°�ǩ��");
		System.out.println("3--������Ϣ����");
		System.out.println("4--�˳�");
		Scanner qiandao =new Scanner(System.in);//�Ӽ����ϻ�ȡ
		xuanze=qiandao.nextInt();//�Ӽ���������ѡ���
		switch(xuanze){
		case 1:
			check_in();break;
		case 2:
			check_out();break;
		case 3:
			da();break;
		case 4:
			//�˳� �ص�����ͷ�����˳�
			login(null);
			XuanZe();
			break;
		}	

	}
}