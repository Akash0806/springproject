package recursioninterviewquestion.answer;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num=10;
        int result=gerFibonacciNum(num);
        //System.out.println(result);
		
	}
	
	private static int gerFibonacciNum(int num){
		int number=0;
	    //while(num!=1){
		number=getFibonacciSeries(num) + getFibonacciSeries(num-1);
		//num--;
	   // }
		 System.out.println(number);
	    return number;
		
	}
	
	private static int getFibonacciSeries(int num){
		if(num==1 || num==2){
			return 1;
		}
		return getFibonacciSeries(num-1)+getFibonacciSeries(num-2);
	}

}
