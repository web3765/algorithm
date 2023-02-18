import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		int[] ans = new int[N+1];
		int level = 1;
		
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
		
//		BFS
		que.offer(R);
		ans[R] = level;
		visited[R] = true;
		while(!que.isEmpty()) {
			int tmp = que.poll();
			ans[tmp] = level++;
			for(int i : graph.get(tmp)) {
				if(visited[i]) continue;
				que.offer(i);
				visited[i] = true;
			}
		}

		for(int i=1; i<=N; i++)
			System.out.println(ans[i]);
	}

}