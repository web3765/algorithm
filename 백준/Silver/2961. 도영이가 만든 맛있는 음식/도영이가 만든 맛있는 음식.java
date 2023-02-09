import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int answer;
	public static void main(String[] args) throws IOException{
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
//			-- s, b 배열
		int[] sArr = new int[N];
		int[] bArr = new int[N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			sArr[i] = Integer.parseInt(st.nextToken());
			bArr[i] = Integer.parseInt(st.nextToken());
		}
//		2. 조합 : idx 기준 sour, bitter 계산
		answer = Integer.MAX_VALUE;
		cal(0, sArr, bArr, 1, 0, N);
		System.out.println(answer);
	}

	private static void cal(int idx, int[] sArr, int[] bArr, int mtp, int sum, int n) {		
		if(idx == n) {
//			공집합 제외하기
			if(sum == 0) return;
			int min = Math.abs(mtp - sum);
//			System.out.println("min = " + min);
			if(min < answer) answer = min;
			return;
		}	
		cal(idx + 1, sArr, bArr, mtp * sArr[idx], sum + bArr[idx], n);
		cal(idx + 1, sArr, bArr, mtp, sum, n);
		
	}	
}