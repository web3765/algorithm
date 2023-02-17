import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int[] ans;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		visited = new boolean[N+1];
		ans = new int[N+1];

		for(int i=0; i<N+1; i++) 
			graph.add(new ArrayList<>());
			
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		for(int i=1; i<=N; i++)
			Collections.sort(graph.get(i));
//		DFS
		cnt = 1;
		dfs(R);

		for(int i=1; i<=N; i++)
			sb.append(ans[i]).append("\n");

		System.out.println(sb.toString());
	}

	private static void dfs(int next) {

		visited[next] = true;
		ans[next] = cnt++;
		for(int nx : graph.get(next)) {		
			if(!visited[nx]) 
				dfs(nx);

		}		

	}

}