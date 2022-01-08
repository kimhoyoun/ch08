package ch08TraningEx.org.training.ex05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ex05 {
	
	public static void main(String[] args) {
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		System.out.print("첫번째 파일 이름을 입력하세요 >> ");
		String file1 = sc.nextLine();
		System.out.print("두번째 파일 이름을 입력하세요 >> ");
		String file2 = sc.nextLine();
			
		try {
			// 
			fis1 = new FileInputStream(file1);
			fis2 = new FileInputStream(file2);
			
			System.out.printf("%s와 %s를 비교합니다.\n",file1,file2);
			if(compareFile(fis1, fis2)) {
				System.out.println("파일이 같습니다.");
			}else {
				System.out.println("파일이 다릅니다.");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean compareFile(FileInputStream fis1, FileInputStream fis2) {
		byte[] f1 = new byte[1024];
		byte[] f2 = new byte[1024];
		
		int count1 = 0, count2;
		while(true) {
			try {
				// 바이트 배열 크기만큼 읽기
				count1 = fis1.read(f1, 0, f1.length);
				count2 = fis2.read(f2, 0, f2.length);
				// 각각 읽은 바이트 수가 다르면 다른파일
				if(count1 != count2) {
					return false;
				}
				// 파일 끝
				if(count1 == -1) {
					break;
				}
				
				for(int i = 0; i<f1.length; i++) {
					// 읽어온 값 하나씩 비교
					if(f1[i] != f2[i]) {
						return false;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
}
