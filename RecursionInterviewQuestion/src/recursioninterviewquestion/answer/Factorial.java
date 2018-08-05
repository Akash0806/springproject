package recursioninterviewquestion.answer;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=getFactOfNum(5);
      System.out.println(num);
	}
	
	public static int getFactOfNum(int num){
		
		if(num==1 ){
			return num;
		}
		return num * getFactOfNum(num-1);
	}

}
