import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
			
		for(int i = 0; i < M; i++) {
			if( binarySearch(nums, Integer.parseInt(st.nextToken())) >= 0 ) {
				sb.append(1).append('\n');
			} 
			else {
				sb.append(0).append('\n');
			}
		}
		
		System.out.println(sb);	
	}

	public static int binarySearch(int[] arr, int cur) {
		int lt = 0;
		int rt = arr.length - 1;
		
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			
			if(cur < arr[mid]) {
				rt = mid - 1;
			}
			
			else if(cur > arr[mid]) {
				lt = mid + 1;
			}
			
			else {
				return mid;
			}
			
		}
		
		return -1;		
	}
	
}