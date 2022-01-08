package ch08TraningEx.org.training.ex11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

class Ex11{
	public Ex11() {
		run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		File file = new File("words.txt");
		FileReader fr = null;
		BufferedReader br = null;
		
		Vector<String> v = new Vector<>();
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String data;
			while((data = br.readLine()) != null) {
				v.add(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("프로젝트 폴더 밑의 words.txt 파일을 읽었습니다 .... ");
		while(true) {
			System.out.print("단어 >> ");
			String word =sc.next();
			if("그만".equals(word)) {
				System.out.println("종료합니다.");
				break;
			}
			int count = 0;
			for(int i =0; i<v.size(); i++) {
				if(v.get(i).indexOf(word) != -1) {
					if(v.get(i).substring(0,word.length()).equals(word)){
						System.out.println(v.get(i));	
						count++;
					}
				}
			}
			if(count == 0) {
				System.out.println("발견할 수 없음!");
				continue;
			}
		}
		
		
	}
}

public class Ex11Main {
	public static void main(String[] args) {
		new Ex11();
	}
}
