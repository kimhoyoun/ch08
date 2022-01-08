package ch08TraningEx.org.training.ex03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex03 {
	public static void main(String[] args) {
		File file = new File("C:\\windows\\system.ini");
		FileReader reader = null;
		
		try {
			reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			String data = null;
			StringBuffer sb = new StringBuffer();
			while((data = br.readLine())!=null) {
				sb.append(data);
				sb.append('\n');
			}
			System.out.println(sb.toString().toUpperCase());
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다!");
		} catch(IOException e) {
			System.out.println();
		}
		
	}
	
}
