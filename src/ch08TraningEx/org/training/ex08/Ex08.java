package ch08TraningEx.org.training.ex08;

import java.io.File;

public class Ex08 {
	public Ex08() {
		run();
	}
	
	
	
	private void run() {
		File file = new File("C:\\");
		File[] list = file.listFiles();
		long max = 0;
		String name = null;
		
		for(int i =0; i<list.length; i++) {
			if(max<list[i].length()) {
				max = list[i].length();
				name = list[i].getPath();
			}
		}
		
		System.out.printf("가장 큰 파일은 %s %d바이트",name,max);
		
	}



	public static void main(String[] args) {
		new Ex08();
		
	}
}
	