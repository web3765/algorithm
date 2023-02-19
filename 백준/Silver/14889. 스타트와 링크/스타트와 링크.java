import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, min;
	static int[][] S;
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		selected = new boolean[N];
		min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) 
				S[i][j] = Integer.parseInt(st.nextToken());
	
		}
		
		combi(0, 0);
		System.out.println(min);
	}

	private static void combi(int start, int cnt) {
		if(cnt == N/2) {
//			System.out.println(Arrays.toString(selected));
			calc();
			return;
		}
		
		for(int i=start; i<N; i++) {
			selected[i] = true;
			combi(i + 1, cnt + 1);
			selected[i] = false;
		}
		
	}

	private static void calc() {
		int team_start = 0; 
		int team_link = 0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(selected[i] == true && selected[j] == true) {
					team_start += S[i][j];
					team_start += S[j][i];
				}
				else if(selected[i] == false && selected[j] == false) {
					team_link += S[i][j];
					team_link += S[j][i];
				}
			}
		}
		int gap = Math.abs(team_start - team_link);
		
//		팀 점수 차가 0이라면 더 이상 탐색하지 않고 종료한다. 
		if(gap == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		min = Math.min(min, gap);	
	}

}