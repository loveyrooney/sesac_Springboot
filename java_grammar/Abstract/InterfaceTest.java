package Abstract;

//인터페이스에는 변수 선언 안됨, 상수는 선언 가능
public interface InterfaceTest {
	//상수 public final int num = 1;
	public abstract void test();
	//인터페이스 안에 있는 메소드에서는 abstract를 생략해도 되지만, 추상메소드이다
	public void test1(int num);

}
