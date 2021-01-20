package amazon.examples;

class MyGame{
	public static Integer pickOptimal(int[] arr) {
	int len = arr.length;
	int[][] dp = new int[len][len];
	for(int gap=0; gap<len; gap++) {
		for(int i=0,j=gap; j<len && i<len; i++, j++) {
		int x=((i+2)<=j) ? dp[i+2][j] :0;
		int y =((i+1)<=(j-1)) ? dp[i+1][j-1]:0;
		int z=(i<=(j-2)) ? dp[i][j-2]:0;
		dp[i][j] = Math.max(
				arr[i] +Math.min(x,y),
				arr[j] + Math.min(y,z)
);
		
		for(int k=0; k<dp.length;k++) {
        	for(int l=0;l<dp[0].length;l++) {
        		System.out.print(dp[k][l]+" ");
        	}
        	System.out.println();
        }
		System.out.println("---------------");
		}
	}
	return dp[0][len-1];
	}

	public static void main(String args[]) {
		int[] arr1= {1,5,3,7,10};
		System.out.println( pickOptimal(arr1));
	}
}
