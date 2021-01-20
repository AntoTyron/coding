package dailycodingexamples;
/** Daily Coding Problem: Problem #7 [Medium] 
 * This problem was asked by Facebook.
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
You can assume that the messages are decodable. For example, '001' is not allowed.
 */
import java.util.*;
public class DecodeStringNoWays {

	public static HashMap<String, Integer> mem = new HashMap<String,Integer>();
	public static int numOfWaysDecode(String msg){
		if(msg==null || msg.equals("") || msg.startsWith("0")) { return 0;}
		return numOfWays(msg);
	}
	
	public static int numOfWays(String msg){ //3, 12
	  int totalWays = 0;
	  if(msg==null || msg.equals("")) { return 1;}
	  if (msg.startsWith("0")) { return 0;}
	  if(mem.containsKey(msg)) { return mem.get(msg);}

	  int oneChar = Integer.parseInt(msg.substring(0,1));
	  int twoChar = 2<=msg.length()? Integer.parseInt(msg.substring(0,2)): 27;
	  String firstSplit = 1<=msg.length()? msg.substring(1):"";
	  String secSplit = 2<=msg.length()? msg.substring(2): "";
	  if(oneChar>=1) {
		  totalWays += numOfWays(firstSplit);
	  }
	  if(twoChar <=26) { 
		  totalWays +=  numOfWays(secSplit);
	  }
	  mem.put(msg, totalWays);
	  System.out.println("Recursed");
	  return totalWays;
	}
	
	public static void main(String args[]){
		System.out.println(numOfWaysDecode("10122"));
	}

}
