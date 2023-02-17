import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] arr, selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		selected = new int[7];
		for(int i=0; i<9; i++)
			arr[i] = Integer.parseInt(br.readLine());
	
		combi(0, 0, 0);	
	}

	private static void combi(int cnt, int start, int sum) {

		if(sum > 100) return;
		if(cnt == 7) {			
			if(sum == 100) {
				for(int n : selected)
					sb.append(n).append("\n");
				System.out.println(sb.toString());
			}
			return;
		}
		for(int i=start; i<arr.length; i++) { 
			selected[cnt] = arr[i];
			combi(cnt + 1, i + 1, sum + arr[i]);
		}
		
	}

}