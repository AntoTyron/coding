package dynamic.examples;

class RegularExpressionDp{
	public static boolean matchRegex(char[] text, char[] pattern) {
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

        T[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }
        printDp(T);
        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j - 1] == '*')  {
                    T[i][j] = T[i][j - 2];
                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        //printDp(T);
        return T[text.length][pattern.length];
    }
	private static void printDp(boolean[][] dp) {
		// TODO Auto-generated method stub
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	public static void main(String args[]){
		System.out.println(matchRegex("bly".toCharArray(),"a*b.*y".toCharArray()));
	}

}

