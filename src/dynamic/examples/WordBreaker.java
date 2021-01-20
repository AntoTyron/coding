package dynamic.examples;
/*
wordDict = ["cat", "cats", "and", "sand", "dog"]

		C	A	T	S	A	N	D	D	O	g
	C	F	F	T	T	T	T	T	T	T	T
	A		F	F	F	F	F	T	T	T	T
	T			F	F	F	F	T	T	T	T
	S				F	F	F	T	T	T	T
	A					F	F	T	T	T	T
	N						F	F	F	F	T
	D							F	F	F	T
	D								F	F	T
	O									F	F
	G										F
*/
/*
wordDict = ["cat", "cats", "and", "sand", "dog"]

		C	A	T	S	A	N	D	O	g
	C	F	F	T	T	T	T	T	T	T
	A		F	F	F	F	F	T	T	T
	T			F	F	F	F	T	T	T
	S				F	F	F	T	T	T
	A					F	F	T	T	T
	N						F	F	F	T
	D							F	F	T
	O								F	F
	G									F
*/
	// check as a word[i][j]
	//check and individuals of length() -1, a[i][j-1] and a[i+1[j]
import java.util.*;
class WordBreaker{

		public static Boolean checkPresent(String s, HashSet<String> wordDict) {
			int[][] dp = new int[s.length()][s.length()];
			for( int i=0; i<dp.length; i++) {
				Arrays.fill(dp[i],-1);
			}
			for( int i=0; i< s.length(); i++){
				for( int row=0, col=i; col<s.length() && row<=col; row++,col++) {
					String word = s.substring(row,col+1);
					dp[row][col] = wordDict.contains(word) ? 0: -1;
					int closeLeft = col-1,moveBottom=row+1, farLeft=row,farBottom=col;
					while(dp[row][col] ==-1 && closeLeft>0 && moveBottom<s.length()) {
						int closeBtElem = dp[moveBottom][col];
						int closeLeftElm = dp[row][closeLeft];
						int farBotElm = dp[farBottom][col];
						int farLeftElem = dp[row][farLeft];
						dp[row][col] = Math.max(Math.min(closeLeftElm,farBotElm),
								Math.min(farLeftElem,closeBtElem));
						closeLeft--;moveBottom++; farLeft++; farBottom--;
					}

				}
			}
			Arrays.stream(dp).forEach(k -> {
					Arrays.stream(k).forEach(v -> System.out.print(v+" "));
					System.out.println();
			});
			return dp[0][s.length()-1] !=-1 ? true: false;
		}
		public static void main(String args[]) {
			
			System.out.println(checkPresent("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
			System.out.println(checkPresent("pineapplepenapple", new HashSet<String>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
			System.out.println(checkPresent("catsandog", new HashSet<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));

		}

	}

