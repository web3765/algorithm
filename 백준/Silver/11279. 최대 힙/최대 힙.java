import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i< N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0)
				sb.append(pq.size() == 0 ? 0 : pq.poll()).append("\n");
			else
				pq.offer(num);
		}
		System.out.println(sb.toString());
	}

}