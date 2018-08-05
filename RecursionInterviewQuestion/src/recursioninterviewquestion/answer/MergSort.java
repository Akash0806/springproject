package recursioninterviewquestion.answer;

import java.util.Arrays;

public class MergSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] elementArray={2,3,1};
      getSortedArrayWithMergeSort(elementArray, 0, elementArray.length-1);
	}
	
	private static int[] getSortedArrayWithMergeSort( int [] elements,int low,int high){
		int length = elements.length;
		if(length == 1){
			System.out.println(Arrays.toString(elements));
		}
		if(length >1){
			int mid=(high+low)/2;
			/**Break Left Element*/
			int[] leftNewArray = getNewElementArray(elements, low, mid);
			System.out.println("leftNewArray ---");
			System.out.println(Arrays.toString(leftNewArray));
			getSortedArrayWithMergeSort( leftNewArray,low,mid);
			int[] rightNewArray = getNewElementArray(elements, mid+1, high);
			System.out.println("rightNewArray ---");
			System.out.println(Arrays.toString(rightNewArray));
			getSortedArrayWithMergeSort( rightNewArray,mid+1,high);
			
			
		}
		
		return elements;
	}

	public static int[] getNewElementArray(int[] elements, int low, int mid) {
		//int[] newArray=new int[mid+1];
		//System.arraycopy( elements, low, newArray, 0, mid );
		int[] newArray=Arrays.copyOfRange(elements, low, mid);
		return newArray;
	}

}
