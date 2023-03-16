
public class Number {

	public static int num1 = 0;
	public int num2 = 0;
	
}

//static은 클래스당 1개만 생성됨. 그래서 new Number1 하고 new Number2 에서 공유하는 개념임(num1)
//그래서 static의 경우는 Number.num1 로 아예 클래스에서 바로 접근도 가능.
//static 메소드는 static 변수에만 접근 가능. non-static메소드는 static 변수에는 접근 가능
//근데 static 없으면 New number1의 num2와 New number2 의 num2 는 복제본이고 서로 독립적임