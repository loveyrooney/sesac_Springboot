
import java.util.Scanner;
import java.util.ArrayList;

import test.Hello; //다른 패키지에 있는 클래스는 임포트해서 써야 된다

import java.util.Arrays;

public class Main {
	
	//메소드 선언은 메인 메소드 밖에 한다 
	public static void hello() {
		System.out.println("hello");
	}
	public static int sum(int num1, int num2) {
		return num1+num2;
	}

	public static void main(String[] args) {
		
//		hello();
//		System.out.println(sum(1,2));
		// TODO Auto-generated method stub

		
		ArrayList<Rectangle> rectangleArr = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
//		System.out.println("write your name, age, tall, marrige");
//		String name = scanner.next();
//		int age = scanner.nextInt();
//		double tall = scanner.nextDouble();
//		boolean marrige = scanner.nextBoolean();
		
		//class
//		System.out.println("사각형의 가로와 세로 길이를 띄어쓰기를 기준으로 입력해주세요");
//		int a = scanner.nextInt();
//		int b = scanner.nextInt();
		
		//class upgrade
		int m=0;
		while(m<rectangleArr.size()+1) {
			System.out.println("사각형의 가로와 세로 길이를 띄어쓰기를 기준으로 입력해주세요");
			int width = scanner.nextInt();
			int height = scanner.nextInt();
			if(width==0 && height==0) break;
			Rectangle rec_m = new Rectangle(width);
			rec_m.setHeight(height);
			Rectangle.count = m+1;
			rectangleArr.add(rec_m);
			
			m++;
		}
		
		scanner.close();
		
		//class upgrade
		for (Rectangle value : rectangleArr) {
			System.out.println("가로 길이는: " + value.getWidth());
			System.out.println("세로 길이는: " + value.getHeight());
			System.out.println("넓이는: " + value.area());
			System.out.println("--------------------");
		}
		System.out.println("인스턴스의 개수는" + Rectangle.count);
		
//		System.out.println("name " + name);
//		System.out.println("age " + age);
//		System.out.println("tall " + tall);
//		System.out.println("marrige " + marrige);
			
		
		//switch 문
//		int num = 0;
		
//		switch (num) {
//		case 0:
//			System.out.println("0");
//			break;
//		case 1:
//			System.out.println("1");
//			break;
//		default: 
//			System.out.println("0도 1도 아님");
//		break;
//		}
		
		//반복문
//		int j = 10;
//		while(j<10) {
//			System.out.println(j + " ");
//			j++;
//		}
//		int i = 10;
//		do {
//			System.out.println(i + " do");
//			i++;
//		} while(i<10);
//		System.out.println("덧셈 결과 : " + (a+b));
//		System.out.println("뺄셈 결과 : " + (a-b));
//		System.out.println("나눗셈 결과 : " + (a/b));
//		System.out.println("곱셈 결과 : " + (a*b));
		
		//class
//		Person person1 = new Person();
//		person1.myname();
//		person1.setName("rooney1");
//		System.out.println(person1.getName());
		
//		Rectangle rectangle = new Rectangle(a,b);
//		rectangle.area();
		
//		Hello hello = new Hello();
//		hello.hello();
		 
//		Number number1 = new Number();
//		Number number2 = new Number();
//		
//		number1.num1 = 1;
//		number1.num2 = 1;
//		
//		System.out.println(number2.num1);
//		System.out.println(number2.num2);
//		

	}

}
