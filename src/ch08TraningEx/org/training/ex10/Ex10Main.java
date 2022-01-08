package ch08TraningEx.org.training.ex10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

class Ex10 {
	
	
	
	public Ex10() {
		run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> phonemap = new HashMap<>();
		
		File file = new File("C:\\temp\\green\\ex10\\phone.txt");
		FileReader fr= null;
		BufferedReader br = null;
		
			try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
				
			StringTokenizer st = new StringTokenizer(line," ");
			String key = st.nextToken();
			String tel = st.nextToken();
			phonemap.put(key, tel);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.printf("%d개의 전화번호를 읽었습니다!\n",phonemap.size());
		while(true) {
			System.out.print("이름 >> ");
			String name = sc.next();
			if("그만".equals(name)) {
				System.out.println("종료되었습니다!");
				break;
			}
			
			System.out.println(phonemap.get(name));
		}
		
	}
}

public class Ex10Main {

	public static void main(String[] args) {
		new Ex10();
	}
}
