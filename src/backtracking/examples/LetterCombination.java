package backtracking.examples;

//2 - > the value
//2,3 - > abc, def  -> ad, ae,af, bd, be, bf, cd, de, cf

//split element, take first and then 
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class LetterCombination{
	static HashMap<String,String> comb = new HashMap<String,String>();
	static int count=0;
	static {
		comb.put("1",null);
		comb.put("2","abc");
		comb.put("3","def");
		comb.put("4","ghi");
		comb.put("5","jkl");
		comb.put("6","mno");
		comb.put("7","pqrs");
		comb.put("8","tuv");
		comb.put("9","wxyz");
	}
	public static List<String> splitDigits(String digit) {
		if(digit ==null || digit.isEmpty()) return null;
		String firstChar = digit.substring(0,1);
		String remChar = digit.substring(1, digit.length());
		List<String> result = splitDigits(remChar);
		char[] digitToChar = comb.get(firstChar).toCharArray();
		List<String> output =new ArrayList<String>();
		if(result == null ) {
			String[] temp = new String(digitToChar).split("");
			return Arrays.asList(temp);
		}
		else {
			
			for (int i=0; i<result.size(); i++) {
				for(int j=0; j<digitToChar.length;j++) {
					output.add(result.get(i)+digitToChar[j]);
					count++;
				}
			}
		}
		return output;

	}
	
	public static void main(String args[]) {
		
		System.out.println(splitDigits("23"));
		System.out.println(count);
	}

}

