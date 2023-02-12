import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[1000001];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int G = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			arr[X] = G;
		}
//		2. window : (K)에서 시작
		int ww = 0;
		for(int i=0; i<=(K+K); i++) {
			if(i < arr.length - 1)	ww += arr[i];
			else
				break;
		}
//		3. max
		int max = ww;
		for(int now=(K + 1); now<=arr.length -1; now++) {
			int lt = now - K - 1;
			int rt = now + K;
			if(lt >= 0) ww -= arr[lt];
			if(rt < arr.length) ww += arr[rt];
			
			if(ww > max) {
				max = ww;
//				System.out.println(max + " now = " + now + " " + (lt - 1) + " ~ " + rt );
			}
		}
		
		System.out.println(max);	
	}

}