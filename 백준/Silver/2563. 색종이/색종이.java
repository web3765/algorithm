import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		2. calculate
		boolean[][] paper = new boolean[101][101];
		int answer = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int garo = Integer.parseInt(st.nextToken());
			int sero = Integer.parseInt(st.nextToken());
		
			for(int j=sero; j<sero+10; j++) {
				for(int k=garo; k<garo+10; k++) {
					if(!paper[j][k]) {
						answer += 1;
						paper[j][k] = true;
					}
				}
			}
	
		}	
//		3. output
		System.out.println(answer);
		
	}

}