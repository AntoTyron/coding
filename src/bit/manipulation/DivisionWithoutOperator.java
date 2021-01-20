package bit.manipulation;

public class DivisionWithoutOperator {

	//Boundary condition , x<y= 0, x==y =1, x>y
	//Values of x and y if y=0  return 0
	//if x reaches the limit what should I do?
	
	//result = y<<i   , x = x- result, quotient+ = 1<<i
	
	  //12/4

		//13/2 = 2<<1, 2<<2, 2<<4, 2<<8
		// 2<<4  Come back ,Note quotient=4, Reminder= 13-(2<<4)=5
		//5/2 = Quotient=2, Reminder=1
		//1/2 – 
		// 12/4 = 4<<1, 4<<2, 4<<4 -> One step back: Reminder:4, Quotient:2
		//4/4 = 4<<1 = Reminder=0,Quoteint:1
	//(Reminder>=y)	
	//Result>=0
		public static int performDivision(int x, int y) {
			int reminder = x;
			int quotient = 0;
			if(y==0 || x==0) { 
				return 0;
			}

			while(reminder >=y) {
				int result = 1;
				int i=-1;
				while(result>0) {
					i++;
					result = reminder -(y<<i);				
				}	
				if(i==0) {
					i=1;
				}
				reminder = reminder-(y<<(i-1));
				quotient +=1<<(i-1);
			}
			return quotient;
		}
	
	public static void main(String args[]) {
		
		System.out.println(1<<7);
		System.out.println(DivisionWithoutOperator.performDivision(13, 3));
	}
}
