package ch08TraningEx.org.training.ex13;

import java.io.File;
import java.util.Scanner;

class Ex13{
	public Ex13() {
		run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("**** 파일 탐색기입니다. ****");
		File file = new File("C:\\");
		File[] fileList = file.listFiles();
		StringBuffer sb = new StringBuffer();
		sb.append(file.getPath());
		while(true) {
			if(fileList.length>10) {
				System.out.println("    ["+sb+"]");
				for(int i=0; i<3; i++) {
					System.out.print(fileList[i].isDirectory()? "dir\t" : "file\t");
					System.out.printf("%-13s\t",String.format("%s바이트", fileList[i].length()));
					System.out.println(fileList[i].getName());
				}
				System.out.println();
				System.out.println("------------------ 생략하였습니다. -------------------");
				System.out.println();
				
				for(int i=fileList.length-4; i<fileList.length; i++) {
					System.out.print(fileList[i].isDirectory()? "dir\t" : "file\t");
					System.out.printf("%-13s\t",String.format("%s바이트", fileList[i].length()));
					System.out.println(fileList[i].getName());
				}
			}else {
				System.out.println("    ["+sb+"]");
				for(int i=0; i<fileList.length; i++) {
					System.out.print(fileList[i].isDirectory()? "dir\t" : "file\t");
					System.out.printf("%-13s\t",String.format("%s바이트", fileList[i].length()));
					System.out.println(fileList[i].getName());
				}
			}
			
			System.out.print(">> ");
			String next = sc.next();
			if("그만".equals(next)) {
				System.out.println("프로그램 종료...");
				break;
			}
			if("...".equals(next)) {
				sb.delete(sb.length()-(file.getName().length()+1), sb.length());
			}else {
				sb.append("\\");
				sb.append(next);				
			}
			
			file = new File(sb.toString());
			fileList = file.listFiles();
		}
	}
	
	
}
public class Ex13Main {

	public static void main(String[] args) {
		new Ex13();
	}

}
