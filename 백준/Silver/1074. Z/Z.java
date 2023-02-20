import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, R, C, cnt;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());		
		R = Integer.parseInt(st.nextToken());		
		C = Integer.parseInt(st.nextToken());		
		
		int val = (int) Math.pow(2, N);
		cnt = 0;
		cut(0, 0, val);
		System.out.println(cnt);
	}
	private static void cut(int x, int y, int size) {
		if(x == R && y == C) 
			flag = true;

		int half = size / 2;
		if(!flag) {
			if(R >= x && R < x + size && C >= y && C < y + size) {
				cut(x, y, half);
				cut(x, y + half, half);
				cut(x + half, y, half);
				cut(x + half, y + half, half);
			} else {
				for(int i=x; i<x + size; i++) {
					for(int j=y; j<y + size; j++) {
						cnt++;
					}					
				}
			}
			
		} 
	}

}