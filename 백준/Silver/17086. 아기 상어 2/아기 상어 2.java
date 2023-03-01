import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int x, y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> que;
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		que = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					visited[i][j] = true;
					que.offer(new Point(i, j));
				}
			}
		}
		
		System.out.println(bfs() - 1);
	}

	private static int bfs() {
		int lv = 0;
		while(!que.isEmpty()) {
			int len = que.size();
			for(int i = 0; i < len; i++) {
				Point tmp = que.poll();
//				System.out.println(lv + " ::: " + tmp.x + "," + tmp.y );
				for(int j = 0; j < dx.length; j++) {
					int nx = tmp.x + dx[j];
					int ny = tmp.y + dy[j];
					
					if(outOfRange(nx, ny) || visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					que.offer(new Point(nx, ny));
				}		
			}
			lv++;
		}
		
		return lv;
		
	}

	private static boolean outOfRange(int nx, int ny) {
		if(nx < 0 || nx >= N || ny < 0 || ny >= M)
			return true;
		return false;
	}

}