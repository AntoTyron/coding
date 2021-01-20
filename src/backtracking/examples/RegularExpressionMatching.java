package backtracking.examples;

class RegularExpressionMatching{
public static Boolean matchStr(String text, String target) {
	if( text == null || text=="") return false;
	return matchStrRec(0,0,text,target);
}
public static Boolean matchStrRec(int currPos, int targetPos, String text, String target){
	if(currPos>= text.length() && targetPos >= target.length() ) {
		return true;
	}
	else if( currPos>= text.length() && targetPos < target.length()) return false;
	char targetChar = targetPos>= target.length() ? ' ': target.charAt(targetPos);
	if(currPos +1 < text.length() && text.charAt(currPos +1) == '*'){
		if( text.charAt(currPos)== targetChar || (text.charAt(currPos)== '.' && targetPos < target.length())) {
		targetPos ++;
		}
		else {		
			currPos +=2;
		}
	}
	else if( text.charAt(currPos)== targetChar){
		currPos++; 
		targetPos++;
	}
	else if( text.charAt(currPos)== '.' && targetPos < target.length()){
			currPos++; targetPos++;
	}
	else{
		return false;
	}
	if(matchStrRec(currPos, targetPos, text, target)) return true;
	return false;
}
	public static void main(String args[]){
		System.out.println(matchStr("a*b.*y","bly"));
	}

}

