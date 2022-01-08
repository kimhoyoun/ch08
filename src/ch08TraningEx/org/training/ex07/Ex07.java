package ch08TraningEx.org.training.ex07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex07 {
	public Ex07() {
		run();
	}

	private void run() {
		File src = new File("a.jpg");
		File dest = new File("b.jpg");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		int c;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			long cap10p = src.length()/10; // 파일의 10프로 용량
			long coping = 0; // 복사된 용량 누적
			
			System.out.println("a.jpg를 b.jpg로 복사합니다. \n10%마다 *를 출력합니다.");
			byte[] data = new byte[1024];
			
			int readData = 0;
			while(true) {
				// 읽기
				readData = bis.read(data, 0, data.length);
				if(readData == -1) {
					System.out.println("\n복사 완료!");
					break;
				}
				
				if(readData > 0) {
					// 읽은 데이터 쓰기(복사)
					bos.write(data,0,data.length);
				}
				// 복사한 데이터 값 누적
				coping += readData;
				if(coping>cap10p) { // 10퍼센트 이상 읽으면
					System.out.print("*"); // 별출력
					coping -= cap10p; // 10퍼센트만큼 감소
				}
			} 
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch(IOException e) {
			System.out.println("파일복사 오류");
		}finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
			}
		}
	}
	
	public static void main(String[] args) {
		new Ex07();
	}
	
}
