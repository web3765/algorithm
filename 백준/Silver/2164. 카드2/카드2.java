import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> Q = new ArrayDeque<>();
		for(int i=1; i<=N; i++)
			Q.offer(i);
//		2. cycle
		while(Q.size() != 1) {
			Q.poll();
			Q.offer(Q.poll());
		}
//		3. output
		System.out.println(Q.peek());
	}

}