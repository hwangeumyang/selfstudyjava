package chap11.sec01;

import java.util.Arrays;

public class ArraysEx {
	public static void main(String [] args) {
		int [] arr = {0, 1, 2, 3, 4};
		int [][] arr2D = {{11, 12, 13, }, {21, 22, 23}};
		
		
		System.out.println("arr = " + Arrays.toString(arr));
		System.out.println("arr2D = " + Arrays.deepToString(arr2D));
		
		int[] arr2 = Arrays.copyOfRange(arr, 2, 5);
		
		System.out.println(Arrays.toString(arr2));
		
		int[] arrX  = new int[5];
		Arrays.fill(arrX, 9);
		System.out.println("arrX: " + Arrays.toString(arrX));
		
		Arrays.setAll(arrX,  i->(int)(Math.random()*6)+1);
		System.out.println("arrX: " + Arrays.toString(arrX));		
		for(int i : arrX) {
			char[] graph = new char[i];
			Arrays.fill(graph, '*');
			System.out.println(new String(graph)+i);
			
		}
		
		String[][] str2D = new String[][] {{"aaa","bbb"}, {"AAA", "BBB"}};
		String[][] str2D2 = new String[][] {{"aaa","bbb"}, {"AAA", "BBB"}};
		
		System.out.println(Arrays.equals(str2D,  str2D2));
		System.out.println(Arrays.deepEquals(str2D, str2D2));
		
		char[] chArr = {'A', 'D', 'C', 'B', 'E' };
		
		System.out.println("chArr = " + Arrays.toString(chArr));
		System.out.println("index of B = " + Arrays.binarySearch(chArr,  'B'));
		System.out.println("After sorting");
		Arrays.sort(chArr);;
		System.out.println("chArr=" + Arrays.toString(chArr));
		System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B'));
		
	}

}
