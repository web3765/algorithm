import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		int[] sumArr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sumArr[i] = sumArr[i-1] + arr[i];
		}
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); 
			int e = Integer.parseInt(st.nextToken()); 
			int answer = sumArr[e] - sumArr[s - 1];
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}