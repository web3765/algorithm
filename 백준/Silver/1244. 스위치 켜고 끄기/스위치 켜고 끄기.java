import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
//		1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] light = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) 
			light[i] = Integer.parseInt(st.nextToken());
			
		int students = Integer.parseInt(br.readLine());
		for(int i=1; i<=students; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
//		2. switchLight
			switchDefault(num, light);

			if(gender == 1) {
				int add = num + num;
				while(add <= N) {
					switchDefault(add, light);
					add += num;
				}
			} else {
				if(num > 0 && num < N)
					switchWm(num-1, num+1, light);
			}	
		}
//		3. output : 20개씩!!!	
		StringBuilder sb = new StringBuilder();		
		for(int i=1; i<=N; i++) {
			sb.append(light[i]).append(" ");
			if(i % 20 == 0)
				sb.append("\n");
		}
		System.out.println(sb.toString());
		
		
		
	}
//	[method 2] switch : when woman
	private static void switchWm(int left, int right, int[] light) {

		if(left <= 0 || right >= light.length)
			return;
		if(light[left] != light[right])
			return;
		else {
			switchDefault(right, light);
			switchDefault(left, light);
			switchWm(left - 1, right + 1, light);
		}	
	}
//	[method 1] switch default : 0 -> 1 , 1 -> 0
	private static void switchDefault(int num, int[] light) {
		if(light[num] == 1)
			light[num] = 0;
		else 
			light[num] = 1;
			
	}

}