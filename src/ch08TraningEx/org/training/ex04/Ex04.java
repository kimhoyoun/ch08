package ch08TraningEx.org.training.ex04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) throws FileNotFoundException {
	Scanner sc = new Scanner(new FileReader("C:\\windows\\system.ini"));
	int lineNumber = 1;
	System.out.println("C:\\windows\\system.ini 파일을 읽어 출력합니다");
	while(sc.hasNext()) {
		String line = sc.nextLine();
		System.out.printf("%4d : %s\n",lineNumber++,line);
	}
	}
}
