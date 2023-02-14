import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		StringTokenizer st;
		for(int i = 0; i <= N; i++) 
			tree.add(new ArrayList<Integer>());
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree.get(s).add(e);
			tree.get(e).add(s);
		}		
//		2. check (BFS)
		Queue<Integer> queue = new LinkedList<>();
		int[] answer = new int[N+1];
		
		queue.offer(1);
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			for(int cur : tree.get(tmp)) {
				if(answer[cur] == 0) {
					answer[cur] = tmp;
					queue.offer(cur);
				}		
			}
		}
//		3. output
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i < N + 1; i++)
			sb.append(answer[i]).append("\n");
		
		System.out.println(sb.toString());
	}

}