import java.awt.GradientPaint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[N+1];
		ans = 0;
		for(int i=0; i<=N; i++) 
			list.add(new ArrayList<Integer>());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
		
			list.get(s).add(e);
			list.get(e).add(s);
		}
		
		dfs(1);
		System.out.println(ans);
		
	}

	private static void dfs(int start) {

		visited[start] = true;
		for(int i : list.get(start)) {
			if(visited[i]) continue;
			ans++;
			dfs(i);
		}
		
	}

}