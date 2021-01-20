package arrays.examples;

class RabinKarp{
	public static final int prime=101;
	public static int patternSearch(char[] text, char[] patt){
		int n=text.length;
		int m=patt.length;
		long textHash = createHash(text, m-1);
		long pattHash = createHash(patt,m-1);
		for(int i=1; i<=n-m+1; i++) {
			if(textHash == pattHash &&	checkMatch(text, i-1, i+m-2, patt,0,m-1)) {
				return i-1;
			}
			if(i<n-m+1){
				textHash = createNewHash(textHash,i-1, i+m-1, text, m-1);
			}
		}
		return 0;
	}

	public static long createHash(char[] text, int len) {
		long hash=0;
		for(int i=0; i<=len; i++) {
			hash += text[i] * Math.pow(prime,i);
		}
		return hash;
	}
	public static boolean checkMatch(char[] text, int start1, int end1, char[] patt,int start2, int end2){
		if(end1-start1 != end2-start2) {
			return false;
		}
		while(start1<end1 && start2<end2) {
			if(text[start1++] != patt[start2++]) return false;
		}
		return true;
	}
	public static long createNewHash(long oldHash, int prevChar, int newChar, char[] text, int len){
		long newHash = oldHash-text[prevChar];
		newHash = (newHash/prime);
		newHash +=text[newChar]*Math.pow(prime,len);
		return newHash;
	}
	public static void main(String args[]) {
		System.out.println(patternSearch("AntoTyron".toCharArray(), "Tyron".toCharArray()));
	}

}

