package ch08TraningEx.org.training.ex06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex06 {

	public Ex06() {
		run();
	}

	public void run() {
		File file = new File("append.txt");
		Scanner sc = new Scanner(System.in);
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		System.out.print("첫번째 파일 이름을 입력하세요 >> ");
		String file1 = sc.nextLine();
		System.out.print("두번째 파일 이름을 입력하세요 >> ");
		String file2 = sc.nextLine();
		
		// 파일에서 읽은 데이터
		StringBuffer f1 = readFile(file1);
		StringBuffer f2 = readFile(file2);
		// 데이터 합치기
		f1.append(f2);
		
		// 데이터 쓰기
		writeFile(file, f1.toString());
		
	}

	public StringBuffer readFile(String src) {
		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			br = new BufferedReader(new FileReader(src));

			String s = null;
			sb = new StringBuffer();

			while ((s = br.readLine()) != null) {
				sb.append(s);
				sb.append("\n");
			}
		} catch (FileNotFoundException e) {
			System.out.printf("%s 파일이 없습니다!\n",src);
		} catch (IOException e) {

		}finally {
			try {
				br.close();
			} catch (IOException e) {}
		}
		return sb;
	}
	
	public void writeFile(File file, String src) {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(file);
			fw.write(src);
			System.out.printf("프로젝트 폴더 밑에 %s 파일에 저장하였습니다.",file.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		new Ex06();
	}
}
