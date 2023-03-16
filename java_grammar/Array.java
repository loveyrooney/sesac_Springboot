
import java.util.ArrayList;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//배열 선언 방법
//		int[] arr1 = {1,2,3};
//		int[] arr2 = new int[3];
//		
//		//배열 출력 방법
//		for (int i=0; i<arr1.length; i++) {
//			System.out.print(arr1[i]+ " ");
//		}
//		System.out.println(Arrays.toString(arr1));
//		
//		for (int value : arr1) {
//			System.out.print(value + " ");
//		}
		
		//2차원 배열 및 출력
//		int[][] arr1 = {{0,1,2},{3,4,5}};
//		int[][] arr2 = new int[2][3];
//		
//		for (int[] arr : arr1) {
//			for (int value : arr) {
//				System.out.print(value + " ");
//			}
//			System.out.println(" ");
//		}
//		
//		int num = 0;
//		for (int i=0; i<arr2[i].length; i++) {
//			for (int j=0; j<arr2[i].length; j++) {
//				arr2[i][j] = num;
//				num ++;
//			}
//		}
//		
//		for (int[] arr : arr2) {
//			for (int value : arr) {
//				System.out.print(value + " ");
//			}
//			System.out.println(" ");
//		}
		
		//ArrayList 
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		
		for (int i=1; i<6; i++) {
			arr2.add(i);
		}
		
		//맨 뒤에 2추가
		arr1.add(2);
		//0번재에 1 추가
		arr1.add(0,1);
		//arr1 뒤에 arr2 추가
		arr1.addAll(arr2);
		//1번째 인덱스 제거
		arr1.remove(1);
		//요소 모두 제거 : clear()
		
		for (int value : arr1) {
			System.out.print(value + " ");
		}
		System.out.println(" ");
		
		//length 대신 size 쓰고 대괄호 인덱스 표기 대신 get을 써야한다
		for (int i=0; i<arr1.size(); i++) {
			System.out.print(arr1.get(i) + " ");
		}
		
		System.out.println(" ");
		System.out.println("index of 2 : " + arr1.indexOf(4));

	}

}
