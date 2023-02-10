import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
//			-- Map<>
			Map<String, Integer> hm = new HashMap<>();
			for(int i=1; i<=N; i++) {
				 st = new StringTokenizer(br.readLine());
				 st.nextToken();
				 String ctg = st.nextToken();
				 hm.put(ctg, hm.getOrDefault(ctg, 0) + 1);
			}
//		2. Calculate
			int answer = 1;
			Set<String> keys = hm.keySet();
			for(String key : keys) {
				int num = hm.get(key) + 1;
				answer *= num;
			}
			sb.append(answer-1).append("\n");
		}
//		3. output
		System.out.println(sb.toString());
		
	}

}