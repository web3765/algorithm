import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][N+1];
		int[][] sumRow = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sumRow[i][j] = sumRow[i][j-1] + arr[i][j];
			}
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
//			System.out.println("x1 = " + x1 + "   x2 = " + x2);
			int sum = 0;
			
			for(int range=x1; range<=x2; range++) {
				sum += (sumRow[range][y2] - sumRow[range][y1-1]);
//				System.out.print("(" + range + ", " + y2 + ") = "+ sumRow[range][y2] + " @@@@ ");
//				System.out.print("(" + range + ", " + (y1-1) + ") = "+ sumRow[range][y1-1]+ " @@@@ ");
//				System.out.println(sum);
			}
			sb.append(sum).append("\n");
			
		}
		System.out.println(sb.toString());
	}

}