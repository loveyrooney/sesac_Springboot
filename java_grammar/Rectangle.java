public class Rectangle {
	
	public static int count = 0;
	private int width;
	private int height;
	
	public Rectangle(int width) {
		this.width = width;
		//this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height= height;
	}
	
	
	
	public int area() {
		return width*height;
	}

}


//생성자 써서 만들기 
//public class Rectangle {
//	
//	public int width;
//	public int height;
//	
//	public Rectangle(int width, int height) {
//		this.width = width;
//		this.height = height;
//	}
//	
//	public void area() {
//		System.out.println("넓이는 " + (width*height));
//	}
//
//}
