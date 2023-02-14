import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static boolean[] visited;
	static int answer, N, RANGE;
	static int[] pdt;
	
	public static void main(String[] args) throws IOException {
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			RANGE = Integer.parseInt(st.nextToken());
			answer = -1;
			pdt = new int[N];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				pdt[i] = Integer.parseInt(st.nextToken());
//		2. check(cnt, sum)	
		check(0, 0);
			
//		3. output
		sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb.toString());
		
	}

	private static void check(int cnt, int sum) {

		if(sum > RANGE) return;
		if(cnt == 2) {
			answer = Math.max(answer, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				
				visited[i] = true;
				check(cnt + 1, sum + pdt[i]);
				
				visited[i] = false;
//				check(cnt, sum);
			}
		}
		
	}

}