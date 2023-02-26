import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static char[][] board, WB, BB;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		WB = new char[8][8];
		BB = new char[8][8];
		ans = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
					WB[i][j] = 'W';
					BB[i][j] = 'B';
				} else {
					WB[i][j] = 'B';
					BB[i][j] = 'W';
				}
			}
		}
		
		for(int i = 0; i < N - 7; i++) {
			for(int j = 0; j < M - 7; j++) {
					checkW(i, j);	
					checkB(i, j);
			}
		}
		
		System.out.println(ans);
	}


	private static void checkB(int r, int c) {
		int cnt = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(board[i + r][j + c] == BB[i][j]) 
					continue;
				else 
					cnt++;
			}
		}
		ans = Math.min(ans, cnt);
	}


	private static void checkW(int r, int c) {
		int cnt = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(board[i + r][j + c] == WB[i][j]) 
					continue;
				else {
					cnt++;
				}
		
			}
		}
		ans = Math.min(ans, cnt);
	}

}