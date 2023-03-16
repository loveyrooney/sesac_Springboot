import java.util.Scanner;
//import java.util.ArrayList;
import java.util.InputMismatchException;

public class Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		int num1 = 5; 
//		int num2 = 1;
//		
//		try {
//			System.out.println(num1/num2);
//		} catch (ArithmeticException e) {
//			System.out.println("0으로 나눌 수 없습니다");
//		} finally {
//			System.out.println("finish");
//		}
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			int num = scanner.nextInt();
			System.out.println(num);
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해주세요");
		}
		
		scanner.close();
		
	}

}
