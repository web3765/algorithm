import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, V;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited; 
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
	
		graph = new ArrayList<ArrayList<Integer>>();
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
			Collections.sort(graph.get(i));
		
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs();
		
		System.out.println(sb.toString());
		
	}

	private static void dfs(int start) {
		visited[V] = true;
		sb.append(start).append(" ");
		
		for(int i : graph.get(start)) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(i);
		}
	}
	
	private static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		que.offer(V);
		visited[V] = true;
		
		while(!que.isEmpty()) {
			int tmp = que.poll();
			sb.append(tmp).append(" ");
			for(int i : graph.get(tmp)) {
				if(visited[i]) continue;
				visited[i] = true;
				que.offer(i);
			}
		}
		
	}
}