package ch08TraningEx.org.training.ex14;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

class Ex14 {
	public Ex14() {
		run();
	}

	private void print(File[] fileList, StringBuffer sb) {
		if (fileList.length > 10) {
			System.out.println("    [" + sb + "]");
			for (int i = 0; i < 3; i++) {
				System.out.print(fileList[i].isDirectory() ? "dir\t" : "file\t");
				System.out.printf("%-13s\t", String.format("%s바이트", fileList[i].length()));
				System.out.println(fileList[i].getName());
			}
			System.out.println();
			System.out.println("------------------ 생략하였습니다. -------------------");
			System.out.println();

			for (int i = fileList.length - 4; i < fileList.length; i++) {
				System.out.print(fileList[i].isDirectory() ? "dir\t" : "file\t");
				System.out.printf("%-13s\t", String.format("%s바이트", fileList[i].length()));
				System.out.println(fileList[i].getName());
			}
		} else {
			System.out.println("    [" + sb + "]");
			for (int i = 0; i < fileList.length; i++) {
				System.out.print(fileList[i].isDirectory() ? "dir\t" : "file\t");
				System.out.printf("%-13s\t", String.format("%s바이트", fileList[i].length()));
				System.out.println(fileList[i].getName());
			}
		}
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("**** 파일 탐색기입니다. ****");
		File file = new File("C:\\");
		File[] fileList = file.listFiles();
		StringBuffer sb = new StringBuffer();
		sb.append(file.getPath());

		while (true) {
			print(fileList, sb);

			System.out.print(">> ");
			String command = sc.nextLine();
			StringTokenizer st = new StringTokenizer(command, " ");
			String next = st.nextToken();
			if ("그만".equals(next)) {
				System.out.println("프로그램 종료...");
				break;
			}
			
			if("mkdir".equals(next)) {
				if (st.hasMoreTokens()) {
					String name = st.nextToken();
					String path = file.getPath() + "\\" + name;
					File Folder = new File(path);
					if (!Folder.exists()) {
						try {
							Folder.mkdir();
							System.out.printf("%s 디렉터리를 생성하였습니다!\n", name);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						System.out.println("이미 폴더가 생성되어 있습니다!");
					}

				} else {
					System.out.println("생성할 폴더이름을 입력하세요!");
				}
				
				fileList = file.listFiles();
				continue;
			}
			
			if("rename".equals(next)) {
				while ("rename".equals(next) && st.countTokens() < 2) {
					System.out.println("두 개의 파일명이 주어지지 않았습니다!");
					System.out.print(">> ");
					command = sc.nextLine();
					st = new StringTokenizer(command, " ");
					next = st.nextToken();
				}
				String path1 = st.nextToken();
				String path2 = st.nextToken();
				
				File f1 = new File(file.getPath()+"\\"+path1);
				File f2 = new File(file.getPath()+"\\"+path2);
				
				f1.renameTo(f2);
				System.out.printf("%s를 %s 로 변경!\n",path1,path2);
				
				fileList = file.listFiles();
				continue;
			}
	
			if ("...".equals(next)) {
				sb.delete(sb.length() - (file.getName().length() + 1), sb.length());
			} else {
				sb.append("\\");
				sb.append(next);
			}

			file = new File(sb.toString());
			fileList = file.listFiles();
		}
	}
}

public class Ex14Main {

	public static void main(String[] args) {
		new Ex14();

	}

}
