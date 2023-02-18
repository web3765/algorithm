import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Here {
	int x, y;
	public Here(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

public class Main {

	static ArrayList<Here> chickens, homes;
	static boolean[] selected;
	static int N, M, answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		chickens = new ArrayList<>();
		homes = new ArrayList<>();
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) chickens.add(new Here(i, j));
				if(map[i][j] == 1) homes.add(new Here(i, j));
			}
		}
		
		answer = Integer.MAX_VALUE;
		selected = new boolean[chickens.size()];	
		combi(0, 0);

		System.out.println(answer);
		
	}

	private static void combi(int cnt, int start) {
		if(cnt == M) {
			calc();
			return;
		}
		for(int i=start; i<chickens.size(); i++) {
			selected[i] = true;
			combi(cnt + 1, i + 1);
			selected[i] = false;
		}
			
	}

//	집 - 치킨집 거리 계산
	private static void calc() {
		int sumDis = 0;
		for(int h=0; h<homes.size(); h++) {
			int minDis = Integer.MAX_VALUE;
			for(int c=0; c<chickens.size(); c++) {
				if(selected[c]) {
					int distance = Math.abs(homes.get(h).x - chickens.get(c).x) + Math.abs(homes.get(h).y - chickens.get(c).y);
					minDis = Math.min(minDis, distance);
				}
			}
			sumDis += minDis;
		}
		
        answer = Math.min(answer, sumDis);
	}

}