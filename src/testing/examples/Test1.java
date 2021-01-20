package testing.examples;

public class Test1 {

		public int add(int a , int b) {
			return a+b;
		}
		
		//expected, actual
		
		public static void main(String args[]){
			Integer input = 54;
			short count=0;
			
			while(input!=0){
				count += input&1;
				input >>>=1;
				System.out.println(input);
				
			}
			
			
			System.out.println(input >>>1);
			System.out.println(input <<1);
			
		}
}
