import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
//	Combination > nCr = n-1Cr-1 + n-1Cr
	public static void main(String[] args) throws IOException {
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
//		2. combination		
			int[][] dp = new int[30][30];
			for(int i=1; i<30; i++) {
				dp[i][0] = 1;
				dp[i][1] = i;
			}
			int answer = combination(M, N, dp);
			
			System.out.println(answer);
		}
	}

//	method > 2. combination		
	private static int combination(int n, int r, int[][] dp) {
		if(dp[n][r] != 0) return dp[n][r];
		if(n == r || r == 0) return 1;
		dp[n][r] = combination(n-1, r-1, dp) + combination(n-1, r, dp);
		return dp[n][r];
	}

}
