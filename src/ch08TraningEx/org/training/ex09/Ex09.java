package ch08TraningEx.org.training.ex09;

import java.io.File;

public class Ex09 {
	public Ex09() {
		run();
	}

	private void run() {
		File file = new File("C:\\temp\\green\\delete");
		File[] fileList = file.listFiles();
		int count = 0;
		System.out.println("C:\\temp\\green\\delete 디렉터리의 .txt 파일을 모두 삭제합니다...");
		for(int i =0; i<fileList.length; i++) {
			String name = fileList[i].getName();
			String txt = name.substring(name.length()-3, name.length());
			if(txt.equals("txt")) {
				System.out.println(fileList[i].getPath() +" 삭제");
				fileList[i].delete();
				count++;
			}
		}
		System.out.println("총 "+count+"개의 .txt 파일을 삭제하였습니다!");
	}

	public static void main(String[] args) {
		new Ex09();
	}

}
