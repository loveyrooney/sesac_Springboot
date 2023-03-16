import java.util.Scanner;

public class Exam {
	
	//메소드
	public static void sum(double a, double b) {
		System.out.println("덧셈 결과 : " + (a+b));
		System.out.println("뺄셈 결과 : " + (a-b));
		System.out.println("나눗셈 결과 : " + (a/b));
		System.out.println("곱셈 결과 : " + (a*b));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		//실습
//		System.out.println("이름을 입력하세요");
//		String name2 = scanner.next();
//		System.out.println("나이를 입력하세요");
//		int age2 = scanner.nextInt();
		
		//조건문 실습
//		System.out.println("나이를 입력하세요");
//		int age = scanner.nextInt();
		
//		System.out.println("이름을 입력하세요");
//		String name = scanner.next();
		
		//반복문
//		System.out.println("숫자를 입력하세요");
//		int num = scanner.nextInt();
		
		//메소드
		System.out.println("숫자 두 개를 입력하세요");
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		
		scanner.close();
		
		//실습
//		System.out.println("안녕하세요! " + name2 + "님(" + age2 + "세)");
		
//		if(age > 0 && age <8) {
//			System.out.println("유아");
//		} else if(age >=8 && age <14) {
//			System.out.println("초등학생");
//		} else if (age >= 14 && age<17) {
//			System.out.println("중학생");
//		} else if (age >= 17 && age<20) {
//			System.out.println("고등학생");
//		} else System.out.println("성인");
		
//		if(name.equals("홍길동")) System.out.println("남자");
//		else if (name.equals("성춘향")) System.out.println("여자");
//		else System.out.println("모르겠어요");
		
//		for (int i=0; i<=num; i++) {
//			System.out.print(i+" ");
//		}
		
		sum(a,b);
		
	}

}
