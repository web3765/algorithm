import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N+1][N+1];
			
			int dr[] = {0,1,0,-1};
			int dc[] = {1,0,-1,0};
			int dir = 0;
			int r = 1, c = 1;
			for(int i=1; i<=N*N; i++) {
				map[r][c] = i;
				
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if(nr > N || nr < 1|| nc > N || nc < 1|| map[nr][nc] != 0) 
					dir = (dir + 1) % 4;

				r += dr[dir];
				c += dc[dir];
				
			}
			
			
			sb.append("#").append(tc).append("\n");
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
				
		}
			
		System.out.println(sb.toString());
	}

}