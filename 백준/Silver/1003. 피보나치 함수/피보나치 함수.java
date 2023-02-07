import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		int[] zero = new int[41];
		int[] one = new int[41];
		zero[0] = 1;
		zero[1] = 0;
		one[0] = 0;
		one[1] = 1;
		
		for(int i=2; i<zero.length; i++) {
			zero[i] = zero[i-1] + zero[i-2];
			one[i] = one[i-1] + one[i-2];
		}
		
		for(int T=0; T<tc; T++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(zero[n]);
			sb.append(" ");
			sb.append(one[n]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
			
	}
	
}
