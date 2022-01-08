package ch08TraningEx.org.training.ex12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Ex12 {
	public Ex12() {
		run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		System.out.print("대상 파일명 입력 >> ");
		String root = sc.next();
		File file = new File(root);
		sc.nextLine();

		while (true) {

			System.out.print("검색할 단어나 문장 >> ");
			String word = sc.nextLine();
			System.out.println(word);
			if("그만".equals(word)) {
				System.out.println("프로그램 종료");
				break;
			}
			int lineNum = 1;
			FileReader fr = null;
			BufferedReader br = null;

			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String data;
				while ((data = br.readLine()) != null) {
					if (data.indexOf(word) != -1) {
						System.out.println(lineNum++ + ": " + data);
					}

					lineNum++;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

public class Ex12Main {

	public static void main(String[] args) {
		new Ex12();
	}

}
