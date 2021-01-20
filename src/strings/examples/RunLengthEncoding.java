
package strings.examples;

public class RunLengthEncoding {

	public static String encode(String s) {
		String result="";
		int prev=0, count=1;
		for( int i=1; i<=s.length(); i++){
			if(i==s.length() || s.charAt(prev)!=s.charAt(i)) {
				result += String.valueOf(count)+ s.charAt(prev);
				count=0;

			}
			count++;
			prev++;
		}
		return result; 
			
	}

	public static String decode(String s){
		String result="";
		int count=0;
		//4a5b
		for( int i=1; i<s.length(); i+=2){
			if(Character.isDigit(s.charAt(i-1))){
			count=Integer.parseInt(String.valueOf(s.charAt(i-1)));
			
			}
			while(count>0) {
				result += s.charAt(i);
				count--;
			}
		}
		return result;
		
	}
	
	public static void main(String args[]) {
		String s=encode("aaaaabbggga");
		System.out.println(s);
		System.out.println(decode(s));
	}

}

