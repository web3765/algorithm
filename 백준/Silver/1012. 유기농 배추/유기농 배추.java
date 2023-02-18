import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
	int x, y;
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int C, R, K;
	static int[] dx, dy;
	static boolean[][] selected, cabbage;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		dx = new int[]{0, 1, 0, -1};
		dy = new int[]{-1, 0, 1, 0};
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			selected = new boolean[C][R];
			cabbage = new boolean[C][R];
			
			Queue<Position> que = new LinkedList<>();
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				que.offer(new Position(a, b));
				cabbage[a][b] = true;
			}

			check(cnt, que);
		}	
		
		System.out.println(sb.toString());
	}

	private static void check(int cnt, Queue<Position> que) {
		
		while(!que.isEmpty()) {
			Position tmp = que.poll();
			if(!selected[tmp.x][tmp.y]) {
				selected[tmp.x][tmp.y] = true;
				cnt++;
			}
			spreadBug(tmp.x, tmp.y);
			
		}
		sb.append(cnt).append("\n");		
		
	}

	private static void spreadBug(int x, int y) {
		if(!cabbage[x][y]) return;		// 배추 없는 곳이면 안됨 
		for(int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < C && ny >= 0 && ny < R ) {
				if(selected[nx][ny]) continue;
				selected[nx][ny] = true;
				spreadBug(nx, ny);
				
			}		
		}
		
	}
}