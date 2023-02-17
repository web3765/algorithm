import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] fruits = new int[N];
		for(int i=0; i<fruits.length; i++) 
			fruits[i] = Integer.parseInt(st.nextToken());		
		Arrays.sort(fruits);
        
		for(int i=0; i<fruits.length; i++) {
			if(fruits[i] <= len) 
				len++;
		}
		
		System.out.println(len);
	}

}