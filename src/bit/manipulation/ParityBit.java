package bit.manipulation;

public class ParityBit {
	
	public static short countOfParity(long x){
		short count=0;
		
		while(x!=0){
			count ^=1;
			x &=(x-1);
			System.out.println(count +":"+x);
		}
		
		return count;
	}
	
	public static void main (String args[]){
		System.out.println(countOfParity(79));
		System.out.println(1^1);
	}

}
