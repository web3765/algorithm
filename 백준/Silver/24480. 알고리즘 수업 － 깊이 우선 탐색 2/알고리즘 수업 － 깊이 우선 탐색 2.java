import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ans;
	static boolean visited[];
	static int N, M, R, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<ArrayList<Integer>>();
		ans = new int[N+1];
		visited = new boolean[N+1];		
		
		for(int i=0; i<=N; i++) 
			graph.add(new ArrayList<Integer>());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(e);
			graph.get(e).add(s);
		}
		for(int i=1; i<=N; i++)
			Collections.sort(graph.get(i), Collections.reverseOrder());
		
		cnt = 1;
		dfs(R);
		for(int i=1; i<=N; i++)
			System.out.println(ans[i]);
	}

	private static void dfs(int start) {
		
		visited[start] = true;
		ans[start] = cnt++;
		for(int i : graph.get(start)) {
			if(!visited[i]) {
				dfs(i);
			}
		}	
		
	}

}