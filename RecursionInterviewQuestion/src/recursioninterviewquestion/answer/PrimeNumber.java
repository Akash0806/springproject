package recursioninterviewquestion.answer;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      boolean primeNum=isPrimeNum(7, 2, true);
      System.out.println(primeNum);
	}
	
	private static boolean isPrimeNum(int num,int dividentNum,boolean isPrimeNum){
		
		if(num==dividentNum){
			return isPrimeNum;
		}
		
		if(num%dividentNum==0)
		return isPrimeNum=false;	
		
        return isPrimeNum(num, dividentNum+1, isPrimeNum);		
    }

}
