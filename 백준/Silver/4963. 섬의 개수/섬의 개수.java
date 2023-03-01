import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s = br.readLine();
		while(!s.equals("0 0")) {
			st = new StringTokenizer(s);
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			visited = new boolean[h][w];		
			int cnt = 0;
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(visited[i][j] || map[i][j] == 0) continue;
					visited[i][j] = true;
					dfs(i, j);
					cnt++;
				}
			}
			
			sb.append(cnt).append('\n');
			s = br.readLine();
		}
		
		System.out.println(sb.toString());
	}

	private static void dfs(int x, int y) {
		
		for(int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(outOfRange(nx, ny) || map[nx][ny] == 0 || visited[nx][ny]) continue;
			visited[nx][ny] = true;
			dfs(nx, ny);
			
		}
	}

	private static boolean outOfRange(int nx, int ny) {

		if(nx < 0 || nx >= h || ny < 0 || ny >= w)
			return true;
		
		return false;
	}

	
}