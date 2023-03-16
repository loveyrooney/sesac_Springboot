import java.util.Scanner;
import java.util.ArrayList;

public class ArrayExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr2 = {1,2,3,4};
		
		for (int j=0; j<5; j++) {
			try {
				System.out.println(arr2[j]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스가 범위를 벗어났습니다");
			}
			
		}
		
		ArrayList<String> arr1 = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
//		System.out.println("5개의 정수를 입력하세요"); 이방법 아님 배열만들어서 풀것
//		int a = scanner.nextInt();
//		int b = scanner.nextInt();
//		int c = scanner.nextInt();
//		int d = scanner.nextInt();
//		int e = scanner.nextInt();
		
//		int i = 0; 
//		while(i<arr1.size()+1) {
//			System.out.println("문자를 입력하세요");
//			String str = scanner.nextLine(); //next는 공백 단위로 슬라이스함. 
//			arr1.add(str);
//			if(str.equals("exit")) break;
//			i++;
//		}
		
		scanner.close();
		
//		int result = (a+b+c+d+e)/5;
//		System.out.println("평균은" + (double)result);
		
//		for (String value : arr1) {
//			if(value.equals("exit")) System.out.print("");
//			else System.out.println(value);
//		}
		
	
	
	}

}
