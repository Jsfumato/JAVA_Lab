package num6;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("실행되었습니다");
		while(true){
			InputStreamReader irs = new InputStreamReader(System.in);
			try {
				int input = irs.read();
				int[] arr = null;
				Sort sort = null;
				
				if(input == 'E' || input == 'e'){
					break;
				}
				if(input == 'S' || input == 's'){
					sort = new ShellSort();
				}
				else if(input == 'Q' || input == 'q'){
					sort = new QuickSort();
				}
				else if(input == 'M' || input == 'm'){
					sort = new MergeSort();
				}else{
					System.out.println("다시 입력하세요");
					continue;
				}
				
				sort.sort(arr);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("종료되었습니다");
	}
}
