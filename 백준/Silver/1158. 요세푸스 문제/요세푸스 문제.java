import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
//		2. Queue > LinkedList | ArrayDeque
		List<Integer> answer = new LinkedList<>();
//		Queue<Integer> Q = new LinkedList<>();
    		Queue<Integer> Q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		for(int i=1; i<=N; i++)
			Q.add(i);
		while(!Q.isEmpty()) {
			for(int i=1; i<K; i++) {
				int tmp = Q.poll();
				Q.offer(tmp);
			}
			int out = Q.poll();
			
			if(Q.isEmpty())
				sb.append(out);
			else
				sb.append(out).append(',').append(' ');
		}
//		3. output
		sb.append('>');
		System.out.println(sb.toString());
		
	}
}
