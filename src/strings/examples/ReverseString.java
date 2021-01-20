package strings.examples;

//Bob likes Alice
//Bob, likes, Alice
class ReverseString{
	public static String reverseString(String input) {
		String[] splitString = input.split(" ");
		String result="";
		if(splitString.length <=1) {
			return input;
		}
		for( int i=splitString.length-1; i>=0; --i) {
			result += i==splitString.length-1? splitString[i]: " "+ splitString[i];
		}
		return result;		
	}
	public static String reverseChar(char[] arr) {
			reverse(arr, 0, arr.length-1);
			int start=0;
			for(int i=0; i<arr.length; i++) {
				if(arr[i] == ' ' || i==arr.length-1){
					reverse(arr, start, i==arr.length-1?i:i-1);
					start = i+1;
				}
				
			}
			return new String(arr);
		
	}
	
	public static void reverse(char[] arr, int start, int end){
		while(start<end){
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		
	}
	
	public static void main(String args[]) {
		System.out.println(reverseString("Bob likes Alice"));
		System.out.println(reverseChar("Bob likes Alice.".toCharArray()));
	}
}
